package com.pierluigi.principal;

/**
 *
 * @author jorhak
 */
import com.pierluigi.controlador.Controlador;
import com.pierluigi.vista.Vista;
import com.pierluigi.modelo.Modelo;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, modelo);
        controlador.iniciar();
    }

}
