package Modelo;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */

public class Empleado {

    int id_empleado;
    int adsc;
    String tarjeta;
    int num_emp;
    String nombre_empleado;
    String plaza;
    String rfc;
    String desc_puesto;
    String nombramiento;
    String servicio;
    String turno;
    String entrada;
    String salida;
    String observaciones;
    String fecha_ingreso;
    String fecha_baja;
    String historial_cambios;

    public Empleado() {
    }

    public Empleado(int id_empleado, int adsc, String tarjeta, int num_emp, String nombre_empleado, String plaza, String rfc, String desc_puesto, String nombramiento, String servicio, String turno, String entrada, String salida, String observaciones, String fecha_ingreso, String fecha_baja, String historial_cambios) {
        this.id_empleado = id_empleado;
        this.adsc = adsc;
        this.tarjeta = tarjeta;
        this.num_emp = num_emp;
        this.nombre_empleado = nombre_empleado;
        this.plaza = plaza;
        this.rfc = rfc;
        this.desc_puesto = desc_puesto;
        this.nombramiento = nombramiento;
        this.servicio = servicio;
        this.turno = turno;
        this.entrada = entrada;
        this.salida = salida;
        this.observaciones = observaciones;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_baja = fecha_baja;
        this.historial_cambios = historial_cambios;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getAdsc() {
        return adsc;
    }

    public void setAdsc(int adsc) {
        this.adsc = adsc;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getNum_emp() {
        return num_emp;
    }

    public void setNum_emp(int num_emp) {
        this.num_emp = num_emp;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDesc_puesto() {
        return desc_puesto;
    }

    public void setDesc_puesto(String desc_puesto) {
        this.desc_puesto = desc_puesto;
    }

    public String getNombramiento() {
        return nombramiento;
    }

    public void setNombramiento(String nombramiento) {
        this.nombramiento = nombramiento;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getHistorial_cambios() {
        return historial_cambios;
    }

    public void setHistorial_cambios(String historial_cambios) {
        this.historial_cambios = historial_cambios;
    }  
}