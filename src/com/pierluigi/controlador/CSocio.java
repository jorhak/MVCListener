/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.controlador;

import com.pierluigi.modelo.MSocio;
import com.pierluigi.utilidades.IControlador;
import com.pierluigi.vista.VSocio;
import java.awt.event.ActionEvent;
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
public class CSocio implements IControlador {

    private MSocio modelo;
    private VSocio vista;

    public CSocio(MSocio m, VSocio v) {
        this.modelo = m;
        this.vista = v;

        vista.btnNuevo.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnRefrescar.addActionListener(this);
        vista.btnObtener.addActionListener(this);


    }

    @Override
    public void Iniciar() {
        vista.setTitle("Registrar Socio de COSFAL");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.textID.setVisible(false);
        vista.Actualizar(modelo.Listar());
        
    }

    @Override
    public void Nuevo() {
        vista.textNombre.setEnabled(true);
        vista.textApellido.setEnabled(true);
        vista.textDireccion.setEnabled(true);
        vista.textTelefono.setEnabled(true);
        vista.btnRegistrar.setEnabled(true);
        vista.textNombre.requestFocusInWindow();
    }

    @Override
    public void Registrar() {
        Map<String, String> dato = new LinkedHashMap();
        dato.put("nombre", vista.textNombre.getText());
        dato.put("apellido", vista.textApellido.getText());
        dato.put("direccion", vista.textDireccion.getText());
        dato.put("telefono", vista.textTelefono.getText());
        modelo.SetDato(dato);
        modelo.Registrar();
        vista.Actualizar(modelo.Listar());
    }

    @Override
    public void Modificar() {
        
        Map<String, String> dato = new LinkedHashMap();
        dato.put("codigo", vista.textID.getText());
        dato.put("nombre", vista.textNombre.getText());
        dato.put("apellido", vista.textApellido.getText());
        dato.put("direccion", vista.textDireccion.getText());
        dato.put("telefono", vista.textTelefono.getText());
        modelo.SetDato(dato);
        modelo.Modificar();
        vista.Actualizar(modelo.Listar());
    }

    @Override
    public void Eliminar() {
        int fila = vista.tablaSocios.getSelectedRow();
        if (fila >= 0) {
            vista.textID.setText(vista.tablaSocios.getValueAt(fila, 0).toString());
            modelo.SetID(vista.textID.getText());
            modelo.Eliminar();
            vista.Actualizar(modelo.Listar());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila y no se ha eliminado al socio.");
        }
    }

    @Override
    public void Listar() {

    }

    @Override
    public void ComboBox() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnNuevo == e.getSource()){
            try {
                Nuevo();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudieron activar los text y botton>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnCancelar == e.getSource()){
            try {
                Cancelar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudieron vaciar los TextField>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnRegistrar == e.getSource()){
            try {
                Registrar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo registrar al usuario>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnModificar == e.getSource()){
            try {
                Modificar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo modificar al usuario>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnEliminar == e.getSource()){
            try {
                Eliminar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo obtener la fila>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnObtener == e.getSource()){
            try {
                Obtener();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo obtener la fila>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnBuscar == e.getSource()){
            try {
                Buscar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo encontrar al usuario>>>>"+ex.getMessage()  );
            }
        }
        if(vista.btnRefrescar == e.getSource()){
            try {
                Refrescar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo refrescar la tabla>>>>"+ex.getMessage()  );
            }
        }
    }

    @Override
    public void Cancelar() {
        vista.textID.setText("");
        vista.textNombre.setText("");
        vista.textApellido.setText("");
        vista.textDireccion.setText("");
        vista.textTelefono.setText("");
        vista.btnRegistrar.setEnabled(false);
        vista.btnModificar.setEnabled(false);
        vista.textNombre.requestFocusInWindow();
    }

    @Override
    public void Obtener() {
        Nuevo();
        vista.btnRegistrar.setEnabled(false);
        vista.btnModificar.setEnabled(true);
        int fila = vista.tablaSocios.getSelectedRow();
        if (fila >= 0) {
            vista.textID.setText(vista.tablaSocios.getValueAt(fila, 0).toString());
            vista.textNombre.setText(vista.tablaSocios.getValueAt(fila, 1).toString());
            vista.textApellido.setText(vista.tablaSocios.getValueAt(fila, 2).toString());
            vista.textDireccion.setText(vista.tablaSocios.getValueAt(fila, 3).toString());
            vista.textTelefono.setText(vista.tablaSocios.getValueAt(fila, 4).toString());

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener al socio.");
        }
    }

    @Override
    public void Buscar() {
        List<Map<String, String>> dato = new LinkedList<>();
        modelo.SetID(vista.textBuscar.getText());
        dato.add(modelo.BuscarID());
        vista.Actualizar(dato);
    }

    @Override
    public void Refrescar() {
        vista.Actualizar(modelo.Listar());
    }
    

}
