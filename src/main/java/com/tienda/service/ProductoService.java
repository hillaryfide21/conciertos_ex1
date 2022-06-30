/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Hillary
 */

@Service
public class ProductoService implements IProductoService{
    
    //Inyeccion dependencias para instanciar el persona repository y poder usar sus metodos 
    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<Producto> getAllProducto(){
        return (List<Producto>)productoRepository.findAll();
    }
    
    @Override
    public Producto getProductoById (long id){
        //Si no encuentra la persona retorne nulo
        return productoRepository.findById(id).orElse(null);
    }
    
    @Override
    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }
    
    @Override
    public void delete (long id){
        productoRepository.deleteById(id);
    }
}

