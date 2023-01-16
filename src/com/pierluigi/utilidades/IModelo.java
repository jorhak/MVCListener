/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pierluigi.utilidades;


import java.util.List;
import java.util.Map;

/**
 *
 * @author Carmen
 */
public interface IModelo {
    public void SetID(String id);
    public void SetDato(Map<String,String> dato);
    public boolean Registrar();
    public boolean Modificar();
    public boolean Eliminar();
    public Map<String, String> BuscarID();
    public Map<String, String> BuscarColumnaValor(String columnName, Object columnValue);
    public List<Map<String, String>> Listar();
    public Map<String, String> ComboBox();
    
}
