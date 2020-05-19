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

public class UsuarioDAO {
    ConexionBD conexion = new ConexionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    
    /**
     * Get usuario and contraseña from index.jsp and looking for them into database.
     * @param nombre_usuario Nombre del usuario
     * @param contraseña Contraseña del usuario
     * @return Data obtained from database, could be null.
     */
    public Usuario validarUsuario(String nombre_usuario, String contraseña){
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM Usuarios WHERE nombre_usuario=? AND contraseña=?";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setString(1, nombre_usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setContraseña("contraseña");
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setFecha_alta(rs.getString("fecha_alta"));
                usuario.setFecha_baja(rs.getString("fecha_baja"));
            }
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.validarUsuario() : " + e); 
        }
        return usuario;
    }
    
    // Operaciones CRUD
    public ArrayList listarUsuarios(){
        String query = "SELECT * FROM Usuarios";
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setContraseña("contraseña");
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setFecha_alta(rs.getString("fecha_alta"));
                usuario.setFecha_baja(rs.getString("fecha_baja"));              
                lista.add(usuario);                
            }
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.listarUsuarios() : " + e); 
        }
        return lista;
    }
    
    public int agregarUsuario(Usuario usuario){
        String query = "INSERT INTO Usuarios("
                + "nombre_usuario, contraseña, perfil, fecha_alta, fecha_baja) "
                + "VALUES(?,?,?,?,?)";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getPerfil());
            ps.setString(4, usuario.getFecha_alta());
            ps.setString(5, usuario.getFecha_baja());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.agregarUsuario() : " + e); 
        }
        return resultado;
    }
    
    public Usuario listarUsuarioById(int id_usuario){
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM Usuarios WHERE id_usuario=" + id_usuario;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){                
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setContraseña("contraseña");   
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setFecha_alta(rs.getString("fecha_alta"));
                usuario.setFecha_baja(rs.getString("fecha_baja")); 
            }
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.listarUsuarioById() : " + e); 
        }
        return usuario;
    }
    
    public int actualizarUsuario(Usuario usuario){
        String query = "UPDATE usuario SET "
                + "nombre_usuario=?, contraseña=?, fecha_alta=?, fecha_baja=?"
                + " WHERE id_usuario=?";
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getPerfil());
            ps.setString(4, usuario.getFecha_alta());
            ps.setString(5, usuario.getFecha_baja());
            ps.setInt(6, usuario.getId_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.actualizarUsuario() : " + e); 
        }
        return resultado;
    }
    
    public boolean eliminarUsuario(int id_usuario){
        boolean r = false;
        String query = "DELETE FROM Usuarios WHERE id_usuario=" + id_usuario;
        try {
            conn = conexion.Conectar();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            r = true;
        } catch (Exception e) {
            System.out.println("Error from UsuarioDAO.eliminarUsuario() : " + e); 
        }
        return r;
    }
}
