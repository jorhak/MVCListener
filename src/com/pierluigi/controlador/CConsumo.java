/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.controlador;

import com.pierluigi.modelo.MConsumo;
import com.pierluigi.modelo.MSocio;
import com.pierluigi.utilidades.IControlador;
import com.pierluigi.vista.VConsumo;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carmen
 */
public class CConsumo implements IControlador {

    private MConsumo modelo;
    private VConsumo vista;
    private MSocio mSocio;

    public CConsumo(MConsumo m, VConsumo v) {
        this.modelo = m;
        this.vista = v;
        this.mSocio = new MSocio();

        vista.btnNuevo.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnRefrescar.addActionListener(this);
        vista.btnObtener.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }

    @Override
    public void Iniciar() {
        vista.setTitle("Registrar Consumo del socio");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.textID.setVisible(false);
        Listar();
    }

    @Override
    public void Nuevo() {
        vista.textCantidad.setEnabled(true);
        vista.comboSocio.setEnabled(true);
        vista.btnRegistrar.setEnabled(true);
        vista.textCantidad.requestFocusInWindow();
    }

    @Override
    public void Registrar() {
        String combo = (String) vista.comboSocio.getSelectedItem();
        String[] codigoSocio = combo.split(" ");

        Map<String, String> dato = new LinkedHashMap();
        dato.put("fecha", getFecha());
        dato.put("hora", getHora());
        dato.put("cantidad", vista.textCantidad.getText());
        dato.put("codigoSocio", codigoSocio[0]);
        modelo.SetDato(dato);
        modelo.Registrar();
        Listar();
    }

    @Override
    public void Modificar() {
        Map<String, String> dato = new LinkedHashMap();
        dato.put("id", vista.textID.getText());
        dato.put("cantidad", vista.textCantidad.getText());
        modelo.SetDato(dato);
        modelo.Modificar();
        Listar();
    }

    @Override
    public void Eliminar() {
        int fila = vista.tablaConsumo.getSelectedRow();
        if (fila >= 0) {
            vista.textID.setText(vista.tablaConsumo.getValueAt(fila, 0).toString());
            modelo.SetID(vista.textID.getText());
            modelo.Eliminar();
            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila y no se ha eliminado el consumo.");
        }
    }

    @Override
    public void Listar() {
        vista.ActualizarConCombo(modelo.Listar(), mSocio.ComboBox(), "");
    }

    @Override
    public void ComboBox() {

    }

    @Override
    public void Cancelar() {
        vista.textCantidad.setText("");
        vista.comboSocio.setSelectedIndex(0);
        vista.btnRegistrar.setEnabled(false);
        vista.btnModificar.setEnabled(false);
    }

    @Override
    public void Obtener() {
        Nuevo();
        vista.btnRegistrar.setEnabled(false);
        vista.btnModificar.setEnabled(true);
        int fila = vista.tablaConsumo.getSelectedRow();
        Map<String, String> seleccionado = new LinkedHashMap<>();
        if (fila >= 0) {
            vista.textID.setText(vista.tablaConsumo.getValueAt(fila, 0).toString());
            vista.textCantidad.setText(vista.tablaConsumo.getValueAt(fila, 3).toString());
            String codigoSocio = vista.tablaConsumo.getValueAt(fila, 4).toString();
            seleccionado = mSocio.Seleccionado(Integer.parseInt(codigoSocio));
            for (String clave : seleccionado.keySet()) {
                String valor = clave + " " + seleccionado.get(clave);
                vista.comboSocio.setSelectedItem(valor);

            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener el comsumo.");
        }
    }

    @Override
    public void Buscar() {
        List<Map<String, String>> dato = new LinkedList<>();
        modelo.SetID(vista.textBuscar.getText());
        dato.add(modelo.BuscarID());
        Listar();
    }

    @Override
    public void Refrescar() {
        Listar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnNuevo == e.getSource()) {
            try {
                Nuevo();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudieron activar los text y botton>>>>" + ex.getMessage());
            }
        }
        if (vista.btnCancelar == e.getSource()) {
            try {
                Cancelar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudieron vaciar los TextField>>>>" + ex.getMessage());
            }
        }
        if (vista.btnRegistrar == e.getSource()) {
            try {
                Registrar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar al usuario>>>>" + ex.getMessage());
            }
        }
        if (vista.btnModificar == e.getSource()) {
            try {
                Modificar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo modificar al usuario>>>>" + ex.getMessage());
            }
        }
        if (vista.btnEliminar == e.getSource()) {
            try {
                Eliminar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo obtener la fila>>>>" + ex.getMessage());
            }
        }
        if (vista.btnObtener == e.getSource()) {
            try {
                Obtener();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo obtener la fila>>>>" + ex.getMessage());
            }
        }
        if (vista.btnBuscar == e.getSource()) {
            try {
                Buscar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar al usuario>>>>" + ex.getMessage());
            }
        }
        if (vista.btnRefrescar == e.getSource()) {
            try {
                Refrescar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo refrescar la tabla>>>>" + ex.getMessage());
            }
        }
    }

    private String getHora() {
        Date hora = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        return formatoHora.format(hora);
    }

    private String getFecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("dd-MM-yyyy");
        return formatoHora.format(fecha);
    }

}
