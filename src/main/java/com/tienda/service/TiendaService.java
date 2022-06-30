/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Tienda;
import com.tienda.repository.TiendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Hillary
 */
@Service
public class TiendaService implements ITiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;
    
    @Override
    public List<Tienda> listStore(){
        return (List<Tienda>)tiendaRepository.findAll();
    }
    
    //Test Estos serian los metodos para guardar la tienda 

    @Override
    public Tienda getTiendaById(long id) {
        return tiendaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTienda(Tienda tienda) {
        tiendaRepository.save(tienda);
    }
}


    