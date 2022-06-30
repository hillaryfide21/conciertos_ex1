/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Tienda;
import com.tienda.entity.Producto;
import com.tienda.service.ITiendaService;
import com.tienda.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Hillary
 */
@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
   @Autowired
    private ITiendaService tiendaService;

    @GetMapping("/producto")

    //model permite enviar variables al HTML y que los valores sean de la BD
    public String index(Model model) {
        List<Producto> listaProducto = productoService.getAllProducto();

        //Cada titulo se va a sustituir con eso 
        model.addAttribute("titulo", "Tabla Productos");
        model.addAttribute("productos", listaProducto);
        return "productos";
    }
    
    @GetMapping("/productoN")
    
    public String crearProducto(Model model) {
      
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", new Producto());
        model.addAttribute("tiendas", listaTiendas);
        return "crear";
    }
    
    
   @PostMapping("/save") 
    public String guardarProducto (@ModelAttribute Producto producto){ 
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }
    
    //Test aca supuestamente es donde voy a agregar y guardar la nueva tienda 
    @GetMapping("/tiendaN")
    
    public String crearTienda(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "crearTienda";
    }
    
    
   @PostMapping("/saveTienda") 
    public String guardarTienda (@ModelAttribute Tienda tienda){ 
        tiendaService.saveTienda(tienda);
        return "redirect:/producto";
    }
    //Test Fin
    
    
    @GetMapping("/editProducto/{id}")
    public String editarProducto (@PathVariable("id") Long idProducto, Model model){ //permite pasar variable al html
        Producto producto = productoService.getProductoById(idProducto);
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", producto);
        model.addAttribute("tiendas",listaTiendas);
        return "crear";
    }
    
    
    
    @GetMapping("/delete/{id}") //url como se comunica controller con servicio
    public String editarProducto (@PathVariable("id") Long idProducto){ //permite pasar variable al html
        productoService.delete(idProducto);
        return "redirect:/producto";
    }
}
