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
public interface IVista {
    public void Actualizar(List<Map<String,String>> datos);
    public void ActualizarConCombo(List<Map<String,String>> datos, Map<String,String> combo, String seleccion);
}
