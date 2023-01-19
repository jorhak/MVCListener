/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.modelo;

import com.pierluigi.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carmen
 */
public class MFactura {

    private int ID;
    private String Fecha;
    private String Hora;
    private double Monto;
    private int CodigoSocio;
    private List<MDetalleFactura> DetalleFactura;

    public MFactura(int ID, String Fecha, String Hora, double Monto, int codigoSocio) {
        this.ID = ID;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Monto = Monto;
        this.CodigoSocio = codigoSocio;
        this.DetalleFactura = new LinkedList<>();
    }

    public MFactura() {
        this(0, "", "", 0.0, 0);
    }

    public void SetDato(Map<String, String> dato) {
        ID = Integer.parseInt(dato.getOrDefault("id", "0"));
        Fecha = dato.getOrDefault("fecha", "");
        Hora = dato.getOrDefault("hora", "");
        Monto = Double.parseDouble(dato.getOrDefault("monto", "0.0"));
        CodigoSocio = Integer.parseInt(dato.getOrDefault("codigoSocio", "0"));
    }

    public void SetDatoItem(Map<String, String> dato) {
        DetalleFactura.clear();
        MDetalleFactura detalle = new MDetalleFactura();
        detalle.SetDato(dato);
        DetalleFactura.add(detalle);
    }

    public void SetDatoItems(List<Map<String, String>> dato) {
        DetalleFactura.clear();
        for (int i = 0; i < dato.size(); i++) {
            MDetalleFactura detalle = new MDetalleFactura();
            detalle.SetDato(dato.get(i));
            DetalleFactura.add(detalle);
        }
    }

    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into factura (fecha, hora, monto, codigoSocio) "
                + "values (?,?,?,?);";

        String sqlUpdate = "update factura "
                + "set fecha=?, hora=?, monto=?, codigoSocio=? "
                + "where id=?;";

        String sql = ID != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, Fecha);
            statement.setString(2, Hora);
            statement.setDouble(3, Monto);
            statement.setInt(4, CodigoSocio);

            if (ID != 0) {
                statement.setInt(5, ID);
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }
        int idFactura = Integer.parseInt(getIDFactura());
        return proccessed ? Buscar("id", idFactura) : null;
    }

    public Map<String, String> RegistrarItem() {
        if (DetalleFactura.size() == 1) {
            MDetalleFactura detalle = DetalleFactura.get(0);
            return detalle.Registrar();
        }

        return null;
    }

    public List<Map<String, String>> RegistrarItems(String IdFactura) {
        List<Map<String, String>> items = new LinkedList<>();

        for (int i = 0; i < DetalleFactura.size(); i++) {
            MDetalleFactura detalle = DetalleFactura.get(i);
            detalle.SetFacturaID(IdFactura);
            items.add(detalle.Registrar());
        }

        return items;
    }

    public boolean Eliminar(String IdFactura) {
        String sql = "delete from factura where id=?;";
        return Conexion.getInstance().delete(sql, IdFactura);
    }

    public boolean EliminarItem(String IdFactura, String IdDetalle) {
        return MDetalleFactura.Eliminar(IdFactura, IdDetalle);
    }

    public boolean EliminarItems(String IdFactura) {
        List<Map<String, String>> detalle = MDetalleFactura.Listar(IdFactura);

        for (int i = 0; i < detalle.size(); i++) {
            String IdDetalle = detalle.get(i).get("id");
            if (!MDetalleFactura.Eliminar(IdFactura, IdDetalle)) {
                return false;
            }
        }
        return !detalle.isEmpty() ? true : false;
    }

    public Map<String, String> Buscar(String columnName, Object columnValue) {
        String sql = "select * from factura where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    public Map<String, String> BuscarItem(String IdFactura, String IdDetalle) {
        return MDetalleFactura.Buscar("idFactura", IdFactura, "id", IdDetalle);
    }

    public List<Map<String, String>> BuscarItems(String IdFactura) {
        return MDetalleFactura.Listar(IdFactura);
    }

    public List<Map<String, String>> Listar() {
        String sql = "select * from factura order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    public Map<String, String> ComboBox() {
        Map<String, String> factura = new LinkedHashMap<>();

        String sql = "select * from factura order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("codigo") + " " + row.get("descripcion");
            factura.put(row.get("id"), fullname);
        }
        return factura;
    }

    public String getIDFactura() {
        String sql = "select * from factura order by id desc limit 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);
        Map<String, String> row = rows.get(0);
        String id = row.get("id");

        return id;
    }

}
