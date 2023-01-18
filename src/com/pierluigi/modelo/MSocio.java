/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.modelo;

import com.pierluigi.utilidades.Conexion;
import com.pierluigi.utilidades.IModelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carmen
 */
public class MSocio implements IModelo {

    private int Codigo;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;

    public MSocio(int codigo, String nombre, String apellido, String direccion, String telefono) {
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Direccion = direccion;
        this.Telefono = telefono;
    }

    public MSocio() {
        this(0, "", "", "", "");
    }

    @Override
    public void SetID(String id) {
        this.Codigo = Integer.parseInt(id);
    }

    @Override
    public void SetDato(Map<String, String> dato) {
        this.Codigo = Integer.parseInt(dato.getOrDefault("codigo", "0"));
        this.Nombre = dato.getOrDefault("nombre", "");
        this.Apellido = dato.getOrDefault("apellido", "");
        this.Direccion = dato.getOrDefault("direccion", "");
        this.Telefono = dato.getOrDefault("telefono", "");
    }

    @Override
    public boolean Registrar() {
        boolean proccessed = false;
        String sql = "insert into socio (nombre, apellido, direccion, telefono) "
                + "values (?,?,?,?);";

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, this.Nombre);
            statement.setString(2, this.Apellido);
            statement.setString(3, this.Direccion);
            statement.setString(4, this.Telefono);

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed;

    }

    @Override
    public boolean Modificar() {
        boolean proccessed = false;
        String sql = "update socio "
                + "set nombre=?, apellido=?, direccion=?, telefono=? "
                + "where codigo=?;";

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, this.Nombre);
            statement.setString(2, this.Apellido);
            statement.setString(3, this.Direccion);
            statement.setString(4, this.Telefono);
            statement.setInt(5, this.Codigo);

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed;

    }

    @Override
    public boolean Eliminar() {
        String sql = "delete from socio where codigo=?;";
        return Conexion.getInstance().delete(sql, this.Codigo);
    }

    @Override
    public Map<String, String> BuscarID() {
        return BuscarColumnaValor("codigo", this.Codigo);
    }

    @Override
    public Map<String, String> BuscarColumnaValor(String columnName, Object columnValue) {
        String sql = "select * from socio where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    @Override
    public List<Map<String, String>> Listar() {
        String sql = "select * from socio order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    @Override
    public Map<String, String> ComboBox() {
        Map<String, String> socio = new LinkedHashMap<>();

        String sql = "select * from socio order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("nombre") + " " + row.get("apellido");
            socio.put(row.get("codigo"), fullname);
        }
        return socio;
    }
    
    public Map<String,String> Seleccionado(int codigoSocio){
        Map<String, String> socio = new LinkedHashMap<>();

        String sql = "select * from socio where codigo='"+codigoSocio+"' order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("nombre") + " " + row.get("apellido");
            socio.put(row.get("codigo"), fullname);
        }
        return socio;
    }

}
