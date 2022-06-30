/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Hillary
 */

@Entity
@Table(name="tiendas")
public class Tienda implements Serializable{
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY) 
    private long id;
    private String tienda;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getTienda() {
        return tienda;
    }
    
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
}
