package com.pierluigi.principal;

/**
 *
 * @author jorhak
 */
import com.pierluigi.controlador.CConsumo;
import com.pierluigi.controlador.CFactura;
import com.pierluigi.controlador.CSocio;
import com.pierluigi.controlador.Controlador;
import com.pierluigi.modelo.MConsumo;
import com.pierluigi.modelo.MFactura;
import com.pierluigi.modelo.MSocio;
import com.pierluigi.vista.Vista;
import com.pierluigi.modelo.Modelo;
import com.pierluigi.vista.VConsumo;
import com.pierluigi.vista.VFactura;
import com.pierluigi.vista.VSocio;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
//        Modelo modelo = new Modelo();
//        Vista vista = new Vista();
//        Controlador controlador = new Controlador(vista, modelo);
//        controlador.iniciar();

//Caso de uso basico
//          MSocio modelo = new MSocio();
//          VSocio vista = new VSocio();
//          CSocio controlador = new CSocio(modelo, vista);
//          controlador.Iniciar();


//Caso de uso complejo
//          MConsumo modelo = new MConsumo();
//          VConsumo vista = new VConsumo();
//          CConsumo controlador = new CConsumo(modelo,vista);
//          controlador.Iniciar();
          
//Caso de uso transaccional
          MFactura modelo = new MFactura();
          VFactura vista = new VFactura();
          CFactura controlador = new CFactura(modelo,vista);
          controlador.Iniciar();
    }

}
