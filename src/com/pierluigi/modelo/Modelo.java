package com.pierluigi.modelo;

/**
 *
 * @author jorhak
 */
import com.pierluigi.vista.Vista;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Modelo {

    private String host = "localhost";
    private String user = "root";
    private String pass = "";
    private String database = "sistemamvc";
    private String port = "3306";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String path = "jdbc:mysql://" + host + ":" + port + "/" + database;

    private Connection con;
    private Connection c = Conexion();
    private Vista vista = new Vista();

    public Connection Conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(path, user, pass);
            System.out.println("Conexion exitosa");;
        } catch (Exception e) {
            System.out.println("Conexion FAIL!!!!!:::::" + e);
        }
        return con;
    }

    public void IniciarModelo() {
        BloquearUsuario();
        MostrarUsuarios("");
        Limpiar();
    }

    private void BloquearUsuario() {
        vista.nombretxt.setEnabled(false);
        vista.apellidotxt.setEnabled(false);
        vista.telefonotxt.setEnabled(false);
        vista.domiciliotxt.setEnabled(false);
        vista.edadtxt.setEnabled(false);
        vista.registrarBoton.setEnabled(false);
        vista.actualizarBoton.setEnabled(false);
        vista.cancelarBoton.setEnabled(false);
    }

    private void Limpiar() {
        vista.nombretxt.setText("");
        vista.apellidotxt.setText("");
        vista.telefonotxt.setText("");
        vista.domiciliotxt.setText("");
        vista.edadtxt.setText("");
        vista.buscartxt.setText("");
    }

    public void NuevoUsuario() {
        vista.nombretxt.setEnabled(true);
        vista.apellidotxt.setEnabled(true);
        vista.telefonotxt.setEnabled(true);
        vista.domiciliotxt.setEnabled(true);
        vista.edadtxt.setEnabled(true);
        vista.registrarBoton.setEnabled(true);
        vista.actualizarBoton.setEnabled(false);
        vista.cancelarBoton.setEnabled(true);
        vista.nombretxt.requestFocusInWindow();
    }

    public void InsertarUsuario() {
        try {
            String nombre = vista.nombretxt.getText();
            String apellido = vista.apellidotxt.getText();
            String telefono = vista.telefonotxt.getText();
            String domicilio = vista.domiciliotxt.getText();
            String edad = vista.edadtxt.getText();

            if (nombre.equals("") || apellido.equals("") || telefono.equals("")
                    || domicilio.equals("") || edad.equals("")) {
                JOptionPane.showMessageDialog(null, "Error, Hay campos vacios");
            } else {

                PreparedStatement ps = c.prepareStatement("INSERT INTO usuarios(nombre, apellido, telefono, domicilio, edad)"
                        + " VALUES(?,?,?,?,?)");

                ps.setString(1, vista.nombretxt.getText());
                ps.setString(2, vista.apellidotxt.getText());
                ps.setString(3, vista.telefonotxt.getText());
                ps.setString(4, vista.domiciliotxt.getText());
                ps.setString(5, vista.edadtxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Insercción Exitosa.");
                MostrarUsuarios("");
                Limpiar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insercción NO EXITOSA.");
        }
    }

    public void MostrarUsuarios(String id) {
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("número");
        mode.addColumn("nombre");
        mode.addColumn("apellido");
        mode.addColumn("telefono");
        mode.addColumn("domicilio");
        mode.addColumn("edad");
        vista.tabla.setModel(mode);

        String dato[] = new String[6];
        String sql = "";
        if (id.equals("")) {
            sql = "SELECT* FROM usuarios";
        } else {
            sql = "SELECT* FROM usuarios WHERE id= '" + id + "' ";
        }

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                dato[5] = rs.getString(6);
                mode.addRow(dato);
            }
            vista.tabla.setModel(mode);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudieron mostrar los usuarios.");

        }
    }

    public void ConsultarUsuarios() {
        NuevoUsuario();
        vista.actualizarBoton.setEnabled(true);
        vista.registrarBoton.setEnabled(false);
        int fila = vista.tabla.getSelectedRow();
        if (fila >= 0) {
            vista.buscartxt.setText(vista.tabla.getValueAt(fila, 0).toString());
            vista.nombretxt.setText(vista.tabla.getValueAt(fila, 1).toString());
            vista.apellidotxt.setText(vista.tabla.getValueAt(fila, 2).toString());
            vista.telefonotxt.setText(vista.tabla.getValueAt(fila, 3).toString());
            vista.domiciliotxt.setText(vista.tabla.getValueAt(fila, 4).toString());
            vista.edadtxt.setText(vista.tabla.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila.");
        }
    }
    
    public void ActualizarUsuario(){
        try {
            String id = vista.buscartxt.getText();
            String nombre = vista.nombretxt.getText();
            String apellido = vista.apellidotxt.getText();
            String telefono = vista.telefonotxt.getText();
            String domicilio = vista.domiciliotxt.getText();
            String edad = vista.edadtxt.getText();

            if (nombre.equals("") || apellido.equals("") || telefono.equals("")
                    || domicilio.equals("") || edad.equals("")) {
                JOptionPane.showMessageDialog(null, "Error, Hay campos vacios");
            } else {

                PreparedStatement ps = c.prepareStatement("UPDATE usuarios SET "
                        + "nombre='"+nombre+"', "
                        + "apellido='"+apellido+"', "
                        + "telefono='"+telefono+"', "
                        + " domicilio='"+domicilio+"', "
                        + "edad='"+edad+"' "
                        + " WHERE id='"+id+"' ");

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualización Exitos.");
                Limpiar();
                MostrarUsuarios("");
                BloquearUsuario();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización NO EXITOSA.");
        }
    }
    
    public void EliminarUsuario(){
        NuevoUsuario();
        vista.actualizarBoton.setEnabled(true);
        vista.registrarBoton.setEnabled(false);
        int fila = vista.tabla.getSelectedRow();
        if (fila >= 0) {
            String id = vista.tabla.getValueAt(fila, 0).toString();
            try {
                PreparedStatement ps = c.prepareStatement("DELETE FROM usuarios WHERE id='"+id+"'" );
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimido el usuario con ID: '"+id+"'.");
                Limpiar();
                MostrarUsuarios("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se elimino el usuario con ID: '"+id+"'::::"+e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado la fila.");
        }
    }
}
