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

public class VacacionesDAO {

    ConexionBD conexion = new ConexionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    
    // Operaciones CRUD
    public ArrayList listarVacaciones(){
        String query = "SELECT * FROM Vacaciones";
        ArrayList<Vacaciones> lista = new ArrayList<>();
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Vacaciones vacaciones = new Vacaciones();
                vacaciones.setId_vacaciones(rs.getInt("id_vacaciones"));
                vacaciones.setId_empleado(rs.getInt("id_empleado"));
                vacaciones.setFolio(rs.getInt("folio"));
                vacaciones.setClave(rs.getInt("clave"));
                vacaciones.setPeriodo(rs.getString("periodo"));
                vacaciones.setNum_dias(rs.getInt("num_dias"));
                vacaciones.setInicio(rs.getString("inicio"));
                vacaciones.setDias(rs.getString("dias"));
                vacaciones.setNotas(rs.getString("notas")); 
                vacaciones.setFecha_captura(rs.getString("fecha_captura"));
                vacaciones.setHistorial_cambios(rs.getString("historial_cambios"));
                lista.add(vacaciones);              
            }
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.listarVacaciones() : " + e); 
        }
        return lista;
    }
    
    public boolean agregarVacaciones(Vacaciones vacaciones){
        boolean r = false;
        String query = "INSERT INTO Vacaciones("
                + "id_empleado, folio, clave, periodo, num_dias, inicio, dias, "
                + "notas, fecha_captura, historial_cambios) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setInt(1, vacaciones.getId_empleado());
            ps.setInt(2, vacaciones.getFolio());
            ps.setInt(3, vacaciones.getClave());
            ps.setString(4, vacaciones.getPeriodo());
            ps.setInt(5, vacaciones.getNum_dias());
            ps.setString(6, vacaciones.getInicio());
            ps.setString(7, vacaciones.getDias());
            ps.setString(8, vacaciones.getNotas());
            ps.setString(9, vacaciones.getFecha_captura());
            ps.setString(10, vacaciones.getHistorial_cambios());
            ps.executeUpdate();
            r=true;
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.agregarVacaciones() : " + e); 
        }
        return r;
    }
    
    public Vacaciones listarVacacionesById(int id_vacaciones){
        Vacaciones vacaciones = new Vacaciones();
        String query = "SELECT * FROM Vacaciones WHERE id_vacaciones=" + id_vacaciones;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                vacaciones.setId_vacaciones(rs.getInt("id_vacaciones"));
                vacaciones.setId_empleado(rs.getInt("id_empleado"));
                vacaciones.setFolio(rs.getInt("folio"));
                vacaciones.setClave(rs.getInt("clave"));
                vacaciones.setPeriodo(rs.getString("periodo"));
                vacaciones.setNum_dias(rs.getInt("num_dias"));
                vacaciones.setInicio(rs.getString("inicio"));
                vacaciones.setDias(rs.getString("dias"));
                vacaciones.setNotas(rs.getString("notas")); 
                vacaciones.setFecha_captura(rs.getString("fecha_captura"));
                vacaciones.setHistorial_cambios(rs.getString("historial_cambios"));
            }
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.listarVacacionesById() : " + e); 
        }
        return vacaciones;
    }
    
    public ArrayList listarVacacionesByEmpleado(int id_empleado){
        ArrayList<Vacaciones> lista = new ArrayList<>();
        String query = "SELECT * FROM Vacaciones WHERE id_empleado=" + id_empleado;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Vacaciones vacaciones = new Vacaciones();
                vacaciones.setId_vacaciones(rs.getInt("id_vacaciones"));
                vacaciones.setId_empleado(rs.getInt("id_empleado"));
                vacaciones.setFolio(rs.getInt("folio"));
                vacaciones.setClave(rs.getInt("clave"));
                vacaciones.setPeriodo(rs.getString("periodo"));
                vacaciones.setNum_dias(rs.getInt("num_dias"));
                vacaciones.setInicio(rs.getString("inicio"));
                vacaciones.setDias(rs.getString("dias"));
                vacaciones.setNotas(rs.getString("notas")); 
                vacaciones.setFecha_captura(rs.getString("fecha_captura"));
                vacaciones.setHistorial_cambios(rs.getString("historial_cambios"));
                lista.add(vacaciones);
            }
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.listarVacacionesById() : " + e); 
        }
        return lista;
    }
    
    public boolean actualizarVacaciones(Vacaciones vacaciones){
        boolean r = false;
        String query = "UPDATE Vacaciones SET "
                + "folio=?, "
                + "clave=?, "
                + "periodo=?, "
                + "num_dias=?, "
                + "inicio=?, "
                + "dias=?, "
                + "notas=?, "
                + "historial_cambios=? "
                + " WHERE id_vacaciones=?";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setInt(1, vacaciones.getFolio());
            ps.setInt(2, vacaciones.getClave());
            ps.setString(3, vacaciones.getPeriodo());
            ps.setInt(4, vacaciones.getNum_dias());
            ps.setString(5, vacaciones.getInicio());
            ps.setString(6, vacaciones.getDias());
            ps.setString(7, vacaciones.getNotas());
            ps.setString(8, vacaciones.getHistorial_cambios());
            ps.setInt(9, vacaciones.getId_vacaciones());
            ps.executeUpdate();
            r=true;
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.actualizarVacaciones() : " + e); 
        }
        return r;
    }
    
    public boolean eliminarVacaciones(int id_vacaciones){
        boolean r = false;
        String query = "DELETE FROM Vacaciones WHERE id_vacaciones=" + id_vacaciones;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            r = true;
        } catch (Exception e) {
            System.out.println("Error from VacacionesDAO.eliminarVacaciones() : " + e); 
        }
        return r;
    }
}
