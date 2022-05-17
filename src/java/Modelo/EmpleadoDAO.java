package Modelo;

import Configuracion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */

public class EmpleadoDAO {

    ConexionBD conexion = new ConexionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    
    // Operaciones CRUD
    public ArrayList listarEmpleados(){
        String query = "SELECT * FROM Empleados";
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setAdsc(rs.getInt("adsc"));
                empleado.setTarjeta(rs.getString("tarjeta"));
                empleado.setNum_emp(rs.getInt("num_emp"));
                empleado.setNombre_empleado(rs.getString("nombre_empleado"));
                empleado.setPlaza(rs.getString("plaza"));
                empleado.setRfc(rs.getString("rfc"));
                empleado.setDesc_puesto(rs.getString("desc_puesto"));
                empleado.setNombramiento(rs.getString("nombramiento")); 
                empleado.setServicio(rs.getString("servicio"));
                empleado.setTurno(rs.getString("turno"));
                empleado.setEntrada(rs.getString("entrada")); 
                empleado.setSalida(rs.getString("salida"));
                empleado.setObservaciones(rs.getString("observaciones"));
                empleado.setFecha_ingreso(rs.getString("fecha_ingreso"));
                empleado.setFecha_baja(rs.getString("fecha_baja"));
                empleado.setHistorial_cambios(rs.getString("historial_cambios"));
                lista.add(empleado);                
            }
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.listarEmpleados() : " + e); 
        }
        return lista;
    }
    
    public boolean agregarEmpleado(Empleado empleado){
        boolean r = false;
        String query = "INSERT INTO Empleados("
                + "adsc, tarjeta, num_emp, nombre_empleado, plaza, rfc, desc_puesto, "
                + "nombramiento, servicio, turno, entrada, salida, observaciones, fecha_ingreso, "
                + "fecha_baja, historial_cambios) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setInt(1, empleado.getAdsc());
            ps.setString(2, empleado.getTarjeta());
            ps.setInt(3, empleado.getNum_emp());
            ps.setString(4, empleado.getNombre_empleado());
            ps.setString(5, empleado.getPlaza());
            ps.setString(6, empleado.getRfc());
            ps.setString(7, empleado.getDesc_puesto());
            ps.setString(8, empleado.getNombramiento());
            ps.setString(9, empleado.getServicio());
            ps.setString(10, empleado.getTurno());
            ps.setString(11, empleado.getEntrada());
            ps.setString(12, empleado.getSalida());
            ps.setString(13, empleado.getObservaciones());
            ps.setString(14, empleado.getFecha_ingreso());
            ps.setString(15, empleado.getFecha_baja());
            ps.setString(16, empleado.getHistorial_cambios());
            ps.executeUpdate();
            r=true;
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.agregarEmpleado() : " + e); 
        }
        return r;
    }
    
    public Empleado listarEmpleadoById(int id_empleado){
        Empleado empleado = new Empleado();
        String query = "SELECT * FROM Empleados WHERE id_empleado=" + id_empleado;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){                
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setAdsc(rs.getInt("adsc"));
                empleado.setTarjeta(rs.getString("tarjeta"));
                empleado.setNum_emp(rs.getInt("num_emp"));
                empleado.setNombre_empleado(rs.getString("nombre_empleado"));
                empleado.setPlaza(rs.getString("plaza"));
                empleado.setRfc(rs.getString("rfc"));
                empleado.setDesc_puesto(rs.getString("desc_puesto"));
                empleado.setNombramiento(rs.getString("nombramiento")); 
                empleado.setServicio(rs.getString("servicio"));
                empleado.setTurno(rs.getString("turno"));
                empleado.setEntrada(rs.getString("entrada")); 
                empleado.setSalida(rs.getString("salida"));
                empleado.setObservaciones(rs.getString("observaciones"));
                empleado.setFecha_ingreso(rs.getString("fecha_ingreso"));
                empleado.setFecha_baja(rs.getString("fecha_baja"));
                empleado.setHistorial_cambios(rs.getString("historial_cambios"));
            }
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.listarEmpleadoById() : " + e); 
        }
        return empleado;
    }
    
    public Empleado listarEmpleadoByNumEmp(int num_emp){
        Empleado empleado = new Empleado();
        String query = "SELECT * FROM Empleados WHERE num_emp=" + num_emp;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){                
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setAdsc(rs.getInt("adsc"));
                empleado.setTarjeta(rs.getString("tarjeta"));
                empleado.setNum_emp(rs.getInt("num_emp"));
                empleado.setNombre_empleado(rs.getString("nombre_empleado"));
                empleado.setPlaza(rs.getString("plaza"));
                empleado.setRfc(rs.getString("rfc"));
                empleado.setDesc_puesto(rs.getString("desc_puesto"));
                empleado.setNombramiento(rs.getString("nombramiento")); 
                empleado.setServicio(rs.getString("servicio"));
                empleado.setTurno(rs.getString("turno"));
                empleado.setEntrada(rs.getString("entrada")); 
                empleado.setSalida(rs.getString("salida"));
                empleado.setObservaciones(rs.getString("observaciones"));
                empleado.setFecha_ingreso(rs.getString("fecha_ingreso"));
                empleado.setFecha_baja(rs.getString("fecha_baja"));
                empleado.setHistorial_cambios(rs.getString("historial_cambios"));
            }
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.listarEmpleadoById() : " + e); 
        }
        return empleado;
    }
    
    public boolean actualizarEmpleado(Empleado empleado){
        boolean r = false;
        String query = "UPDATE Empleados SET "
                + "adsc=?, "
                + "tarjeta=?, "
                + "num_emp=?, "
                + "nombre_empleado=?, "
                + "plaza=?, "
                + "rfc=?, "
                + "desc_puesto=?, "
                + "nombramiento=?, "
                + "servicio=?, "
                + "turno=?, "
                + "entrada=?, "
                + "salida=?, "
                + "observaciones=?, "
                + "fecha_ingreso=?, "
                + "fecha_baja=? "
                + " WHERE id_empleado=?";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setInt(1, empleado.getAdsc());
            ps.setString(2, empleado.getTarjeta());
            ps.setInt(3, empleado.getNum_emp());
            ps.setString(4, empleado.getNombre_empleado());
            ps.setString(5, empleado.getPlaza());
            ps.setString(6, empleado.getRfc());
            ps.setString(7, empleado.getDesc_puesto());
            ps.setString(8, empleado.getNombramiento());
            ps.setString(9, empleado.getServicio());
            ps.setString(10, empleado.getTurno());
            ps.setString(11, empleado.getEntrada());
            ps.setString(12, empleado.getSalida());
            ps.setString(13, empleado.getObservaciones());
            ps.setString(14, empleado.getFecha_ingreso());
            ps.setString(15, empleado.getFecha_baja());
            ps.setInt(16, empleado.getId_empleado());
            ps.executeUpdate();
            r=true;
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.actualizarEmpleado() : " + e); 
        }
        return r;
    }
    
    public boolean eliminarEmpleado(int id_empleado){
        boolean r = false;
        String query = "DELETE FROM Empleados WHERE id_empleado=" + id_empleado;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            r = true;
        } catch (Exception e) {
            System.out.println("Error from EmpleadoDAO.eliminarEmpleado() : " + e); 
        }
        return r;
    }
}
