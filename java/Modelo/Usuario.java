package Modelo;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */

public class Usuario {
    int id_usuario;
    String nombre_usuario;
    String contraseña;
    String perfil;
    String fecha_alta;
    String fecha_baja;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String contraseña, String perfil, String fecha_alta, String fecha_baja) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.perfil = perfil;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }
}