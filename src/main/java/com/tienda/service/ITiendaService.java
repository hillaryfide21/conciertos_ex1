/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import java.util.List;
import com.tienda.entity.Tienda;
/**
 *
 * @author Hillary
 */
public interface ITiendaService {
    public List<Tienda> listStore();
    
    //test Aca creo los metodos para guardar la tienda nueva
    public Tienda getTiendaById (long id);
    public void saveTienda (Tienda tienda);
}
