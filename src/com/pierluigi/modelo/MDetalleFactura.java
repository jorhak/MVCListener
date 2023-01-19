/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pierluigi.modelo;

import com.pierluigi.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carmen
 */
public class MDetalleFactura {

    private int IDFactura;
    private int ID;
    private double Precio;
    private int IDConsumo;

    public void SetDato(Map<String, String> dato) {
        IDFactura = Integer.parseInt(dato.getOrDefault("idFactura", "0"));
        ID = Integer.parseInt(dato.getOrDefault("id", "0"));
        Precio = Double.parseDouble(dato.getOrDefault("precio", "0.0"));
        IDConsumo = Integer.parseInt(dato.getOrDefault("idConsumo", ""));
    }

    public void SetFacturaID(String idFactura) {
        this.IDFactura = Integer.parseInt(idFactura);
    }

    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into detalle_factura (idFactura, precio, idConsumo) "
                + "values (?,?,?);";

        String sqlUpdate = "update detalle_factura "
                + "set precio=?, idConsumo=? "
                + "where id=?;";

        String sql = ID != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setDouble(1, IDFactura);
            statement.setDouble(2, Precio);
            statement.setInt(3, IDConsumo);
;

            if (ID != 0) {
                statement.setInt(3, ID);
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed ? Buscar("idFactura", IDFactura, "id", ID) : null;
    }

    public static boolean Eliminar(String IdFactura, String Id) {
        String sql = "delete from detalle_factura where idFactura=? and id=?;";
        return Conexion.getInstance().delete(sql, IdFactura, Id);
    }

    public static Map<String, String> Buscar(String columnName0, Object value0, String columnName1, Object value1) {
        String sql = "select * from detalle_factura where %s='%s' and %s='%s' limit 1;";
        sql = String.format(sql, columnName0, value0, columnName1, value1);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    public static List<Map<String, String>> Listar(String IDFactura) {
        String sql = "select * from detalle_factura where idFactura='%s';";
        sql = String.format(sql, IDFactura);
        return Conexion.getInstance().executeSQLResultList(sql);
    }

}
