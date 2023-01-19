/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.controlador;

import com.pierluigi.modelo.MConsumo;
import com.pierluigi.modelo.MFactura;
import com.pierluigi.modelo.MSocio;
import com.pierluigi.utilidades.Fecha;

import com.pierluigi.utilidades.IControlador;

import com.pierluigi.vista.VFactura;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carmen
 */
public class CFactura implements IControlador {

    private MFactura modelo;
    private VFactura vista;
    private MConsumo mConsumo;
    private MSocio mSocio;
    private boolean isDetalle;

    public CFactura(MFactura m, VFactura v) {
        this.modelo = m;
        this.vista = v;
        this.mConsumo = new MConsumo();
        this.mSocio = new MSocio();
        this.isDetalle = true;
        vista.btnBuscar.addActionListener(this);
        vista.btnAgregar.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);
        vista.btnQuitar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnObtener.addActionListener(this);
        Listar();
    }

    @Override
    public void Iniciar() {
        vista.setTitle("Registrar Factura");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void Nuevo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Registrar() {
        Map<String, String> cabecera = Cabecera();
        List<Map<String, String>> cuerpo = Cuerpo();

        modelo.SetDato(cabecera);
        modelo.SetDatoItems(cuerpo);

        Map<String, String> factura = modelo.Registrar();
        if (factura != null) {
            List<Map<String, String>> items = modelo.RegistrarItems(factura.get("id"));
        }
        Listar();
    }

    @Override
    public void Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar() {
        int fila = vista.tablaFactura.getSelectedRow();
        Map<String, String> detalle = new LinkedHashMap<>();
        if (fila >= 0) {
            String idFactura = vista.tablaFactura.getValueAt(fila, 0).toString();
            if (modelo.EliminarItems(idFactura)) {
                modelo.Eliminar(idFactura);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para borrar la factura.");
        }
        Listar();
    }

    @Override
    public void Listar() {
        vista.Actualizar(modelo.Listar());
    }

    @Override
    public void ComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Cancelar() {
        int fila = vista.tablaDetalle.getSelectedRow();
        Map<String, String> detalle = new LinkedHashMap<>();
        if (fila >= 0) {
            String idConsumo = vista.tablaDetalle.getValueAt(fila, 0).toString();
            String precio = vista.tablaDetalle.getValueAt(fila, 1).toString();
            double valor = Double.parseDouble(precio);
            detalle.put("idConsumo", idConsumo);
            detalle.put("precio", String.valueOf(valor));

            double total = Double.parseDouble(vista.labelTotal.getText());
            total -= valor;
            vista.labelTotal.setText(String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para quitar el detalle.");
        }

        tDetalle.removeRow(fila);

        double valor = Double.parseDouble(vista.labelTotal.getText());
        BigDecimal bd = new BigDecimal(valor).setScale(1, RoundingMode.HALF_UP);

        vista.textMonto.setText(String.valueOf(bd));
    }

    @Override
    public void Obtener() {
        int fila = vista.tablaFactura.getSelectedRow();
        if (fila >= 0) {

            vista.textMonto.setText(vista.tablaFactura.getValueAt(fila, 3).toString());
            mSocio.SetID(vista.tablaFactura.getValueAt(fila, 4).toString());
            Map<String, String> socio = mSocio.BuscarID();
            vista.textSocio.setText(socio.getOrDefault("nombre", "") + " " + socio.getOrDefault("apellido", ""));
            

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener la factura.");
        }
    }

    @Override
    public void Buscar() {
        isDetalle = true;
        LimpiarTablaDetalle();
        String codigoSocio = vista.textCodigoSocio.getText();
        List<Map<String, String>> datos = mConsumo.BuscarConsumo("codigoSocio", codigoSocio);

        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("ID");
        mode.addColumn("Fecha");
        mode.addColumn("Hora");
        mode.addColumn("Cantidad");
        mode.addColumn("Codigo Socio");
        vista.tablaConsumo.setModel(mode);

        String dato[] = new String[5];

        for (int i = 0; i < datos.size(); i++) {
            Map<String, String> row = datos.get(i);

            dato[0] = row.getOrDefault("id", "0");
            dato[1] = row.getOrDefault("fecha", "");
            dato[2] = row.getOrDefault("hora", "");
            dato[3] = row.getOrDefault("cantidad", "");
            dato[4] = row.getOrDefault("codigoSocio", "0");
            mode.addRow(dato);

        }

        mSocio.SetID(vista.textCodigoSocio.getText());
        Map<String, String> socio = mSocio.BuscarID();
        vista.textSocio.setText(socio.getOrDefault("nombre", "") + " " + socio.getOrDefault("apellido", ""));

//        jola.setColumnCount(0);
//        jola.setRowCount(0);
//        jola.addColumn("Precio");
//        jola.addColumn("ID Consumo");
//
//        vista.tablaDetalle.setModel(jola);
    }

    @Override
    public void Refrescar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    DefaultTableModel tDetalle = new DefaultTableModel();

    public void Agregar() {
        int fila = vista.tablaConsumo.getSelectedRow();
        Map<String, String> detalle = new LinkedHashMap<>();
        if (fila >= 0) {
            String id = vista.tablaConsumo.getValueAt(fila, 0).toString();
            String cantidad = vista.tablaConsumo.getValueAt(fila, 3).toString();
            double precio = Double.parseDouble(cantidad) * 0.68;
            detalle.put("id", id);
            detalle.put("precio", String.valueOf(precio));

            double total = Double.parseDouble(vista.labelTotal.getText());
            total += precio;
            vista.labelTotal.setText(String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila para obtener el comsumo.");
        }

        if (isDetalle) {
            tDetalle.addColumn("ID");
            tDetalle.addColumn("Precio");
            vista.tablaDetalle.setModel(tDetalle);
            isDetalle = false;
        }

        String dato[] = new String[2];

        dato[0] = detalle.getOrDefault("id", "0");
        dato[1] = detalle.getOrDefault("precio", "");

        tDetalle.addRow(dato);

        double valor = Double.parseDouble(vista.labelTotal.getText());
        BigDecimal bd = new BigDecimal(valor).setScale(1, RoundingMode.HALF_UP);

        vista.textMonto.setText(String.valueOf(bd));

    }

    private void LimpiarTablaDetalle() {
        tDetalle.setRowCount(0);
        tDetalle.setColumnCount(0);
        vista.labelTotal.setText("0");
    }

    private Map<String, String> Cabecera() {
        Map<String, String> dato = new LinkedHashMap();
        dato.put("fecha", Fecha.getFecha());
        dato.put("hora", Fecha.getHora());
        dato.put("monto", vista.textMonto.getText());
        dato.put("codigoSocio", vista.textCodigoSocio.getText());
        return dato;
    }

    private List<Map<String, String>> Cuerpo() {
        List<Map<String, String>> lista = new LinkedList<>();
        for (int i = 0; i < vista.tablaDetalle.getRowCount(); i++) {
            Map<String, String> dato = new LinkedHashMap<>();
            dato.put("idConsumo", vista.tablaDetalle.getValueAt(i, 0).toString());
            dato.put("precio", vista.tablaDetalle.getValueAt(i, 1).toString());
            lista.add(dato);
        }
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnBuscar == e.getSource()) {
            try {
                Buscar();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar al usuario>>>>" + ex.getMessage());
            }
        }
        if (vista.btnAgregar == e.getSource()) {
            try {
                Agregar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el consumo>>>>" + ex.getMessage());
            }
        }
        if (vista.btnRegistrar == e.getSource()) {
            try {
                Registrar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la factura>>>>" + ex.getMessage());
            }
        }
        if (vista.btnQuitar == e.getSource()) {
            try {
                Cancelar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la factura>>>>" + ex.getMessage());
            }
        }
        if (vista.btnEliminar == e.getSource()) {
            try {
                Eliminar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la factura>>>>" + ex.getMessage());
            }
        }
        if (vista.btnObtener == e.getSource()) {
            try {
                Obtener();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la factura>>>>" + ex.getMessage());
            }
        }
    }

}
