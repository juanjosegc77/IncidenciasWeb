package Modelo;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */

public class Licencias {

    int id_vacaciones;
    int id_empleado;
    int folio;
    int clave;
    String periodo;
    int num_dias;
    String inicio;
    String dias;
    String notas;
    String fecha_captura;
    String historial_cambios;

    public Licencias() {
    }

    public Licencias(int id_vacaciones, int id_empleado, int folio, int clave, String periodo, int num_dias, String inicio, String dias, String notas, String fecha_captura, String historial_cambios) {
        this.id_vacaciones = id_vacaciones;
        this.id_empleado = id_empleado;
        this.folio = folio;
        this.clave = clave;
        this.periodo = periodo;
        this.num_dias = num_dias;
        this.inicio = inicio;
        this.dias = dias;
        this.notas = notas;
        this.fecha_captura = fecha_captura;
        this.historial_cambios = historial_cambios;
    }

    public int getId_vacaciones() {
        return id_vacaciones;
    }

    public void setId_vacaciones(int id_vacaciones) {
        this.id_vacaciones = id_vacaciones;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getNum_dias() {
        return num_dias;
    }

    public void setNum_dias(int num_dias) {
        this.num_dias = num_dias;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getFecha_captura() {
        return fecha_captura;
    }

    public void setFecha_captura(String fecha_captura) {
        this.fecha_captura = fecha_captura;
    }

    public String getHistorial_cambios() {
        return historial_cambios;
    }

    public void setHistorial_cambios(String historial_cambios) {
        this.historial_cambios = historial_cambios;
    }   
}