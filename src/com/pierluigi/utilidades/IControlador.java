/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pierluigi.utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Carmen
 */
public interface IControlador extends ActionListener {
    public void Iniciar();
    public void Nuevo();
    public void Registrar();
    public void Modificar();
    public void Eliminar();
    public void Listar();
    public void ComboBox();
    public void Cancelar();
    public void Obtener();
    public void Buscar();
    public void Refrescar();
}
