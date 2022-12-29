
package com.pierluigi.controlador;

/**
 *
 * @author jorhak
 */
import com.pierluigi.modelo.Modelo;
import com.pierluigi.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
//        Eventos que se va a ejecutar al presionar los botones
        this.vista.nuevoBoton.addActionListener(this);
        this.vista.registrarBoton.addActionListener(this);
        this.vista.actualizarBoton.addActionListener(this);
        this.vista.cancelarBoton.addActionListener(this);
        
        this.vista.buscarBoton.addActionListener(this);
        this.vista.refrescarBoton.addActionListener(this);
        this.vista.modificarBoton.addActionListener(this);
        this.vista.eliminarBoton.addActionListener(this);

        
    }
    
    public void iniciar(){
        vista.setTitle("Sistema con MVC");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        modelo.IniciarModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.nuevoBoton == e.getSource()){
            try {
                modelo.NuevoUsuario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo crear un Nuevo Usuario");
            }
            
        }
        if(vista.cancelarBoton == e.getSource()){
            try {
                modelo.IniciarModelo();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo Cancelar");
            }
            
        }
        if(vista.registrarBoton == e.getSource()){
            try {
                modelo.InsertarUsuario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario");
            }
            
        }
        if(vista.refrescarBoton == e.getSource()){
            try {
                modelo.MostrarUsuarios("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario");
            }
            
        }
        
        if(vista.buscarBoton == e.getSource()){
            try {
                modelo.MostrarUsuarios(vista.buscartxt.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario");
            }
            
        }
        
        if(vista.modificarBoton == e.getSource()){
            try {
                modelo.ConsultarUsuarios();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo consultar los usuarios");
            }
            
        }
        
        if(vista.actualizarBoton == e.getSource()){
            try {
                modelo.ActualizarUsuario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
            }
            
        }
        
        if(vista.eliminarBoton == e.getSource()){
            try {
                modelo.EliminarUsuario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
            }
            
        }
    }
    
    
}
