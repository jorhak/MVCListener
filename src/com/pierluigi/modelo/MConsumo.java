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
public class MConsumo implements IModelo{
    private int ID;
    private String Fecha;
    private String Hora;
    private double Cantidad;
    private int CodigoSocio;

    public MConsumo(int id, String fecha, String hora, double cantidad, int codigoSocio) {
        this.ID = id;
        this.Fecha = fecha;
        this.Hora = hora;
        this.Cantidad = cantidad;
        this.CodigoSocio = codigoSocio;
    }

    public MConsumo() {
        this(0,"","",0.0,0);
    }

    @Override
    public void SetID(String id) {
        this.ID = Integer.parseInt(id);
    }

    @Override
    public void SetDato(Map<String, String> dato) {
        this.ID = Integer.parseInt(dato.getOrDefault("id", "0"));
        this.Fecha = dato.getOrDefault("fecha", "");
        this.Hora = dato.getOrDefault("hora", "");
        this.Cantidad = Double.parseDouble(dato.getOrDefault("cantidad", "0.0"));
        this.CodigoSocio = Integer.parseInt(dato.getOrDefault("codigoSocio", "0"));
    }

    @Override
    public boolean Registrar() {
        boolean proccessed = false;
        String sql = "insert into consumo (fecha, hora, cantidad, codigoSocio) "
                + "values (?,?,?,?);";

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, this.Fecha);
            statement.setString(2, this.Hora);
            statement.setDouble(3, this.Cantidad);
            statement.setInt(4, this.CodigoSocio);

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed;
    }

    @Override
    public boolean Modificar() {
        boolean proccessed = false;
        String sql = "update consumo "
                + "set cantidad=? "
                + "where id=?;";

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setDouble(1, this.Cantidad);
            statement.setInt(2, this.ID);

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed;
    }

    @Override
    public boolean Eliminar() {
        String sql = "delete from consumo where id=?;";
        return Conexion.getInstance().delete(sql, this.ID);
    }

    @Override
    public Map<String, String> BuscarID() {
        return BuscarColumnaValor("id", this.ID);
    }

    @Override
    public Map<String, String> BuscarColumnaValor(String columnName, Object columnValue) {
        String sql = "select * from consumo where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    @Override
    public List<Map<String, String>> Listar() {
        String sql = "select * from consumo order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    @Override
    public Map<String, String> ComboBox() {
        Map<String, String> socio = new LinkedHashMap<>();

        String sql = "select * from consumo order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("fecha") + " " + row.get("cantidad") +" "+ row.get("codigoSocio");
            socio.put(row.get("id"), fullname);
        }
        return socio;
    }
    
    public List<Map<String,String>> BuscarConsumo(String columnName, Object columnValue){
        String sql = "select * from consumo where %s='%s' ;";
        sql = String.format(sql, columnName, columnValue);

        return Conexion.getInstance().executeSQLResultList(sql);
    }
    
    
}
