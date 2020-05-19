package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author : M.Sc. Juan José Guzmán Cruz Created on : Jan 25, 2020
 *
 */
public class ControladorEmpleados extends HttpServlet {

    Usuario usuario = new Usuario();
    Empleado empleado = new Empleado();
    EmpleadoDAO empleado_dao = new EmpleadoDAO();
    String nombre_usuario;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm");
    LocalDateTime now = LocalDateTime.now();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Empleados")) {
            switch (accion) {
                case "listar":
                    ArrayList<Empleado> lista_empleados = empleado_dao.listarEmpleados();
                    request.setAttribute("empleados", lista_empleados);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
                case "nuevo_registro":
                    request.setAttribute("opcion", "Guardar");
                    request.getRequestDispatcher("FormularioEmpleados.jsp").forward(request, response);
                    break;
                case "editar_registro":
                    int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
                    Empleado empleado_editar = empleado_dao.listarEmpleadoById(id_empleado);
                    request.setAttribute("opcion", "Actualizar");
                    request.setAttribute("empleado_editar", empleado_editar);
                    request.getRequestDispatcher("FormularioEmpleados.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("FormularioEmpleados")) {
            switch (accion) {
                case "Guardar":
                    String number_adsc = request.getParameter("number_adsc");
                    int adsc_parse;
                    if (number_adsc == "") {
                        adsc_parse = 0;
                    } else {
                        adsc_parse = Integer.parseInt(number_adsc);
                    }
                    
                    int adsc = adsc_parse;
                    String tarjeta = request.getParameter("text_tarjeta").toUpperCase();
                    int num_emp = Integer.parseInt(request.getParameter("number_num_emp"));
                    String nombre_empleado = request.getParameter("text_nombre_empleado").toUpperCase();
                    String plaza = request.getParameter("text_plaza").toUpperCase();
                    String rfc = request.getParameter("text_rfc").toUpperCase();
                    String desc_puesto = request.getParameter("text_desc_puesto").toUpperCase();
                    String nombramiento = request.getParameter("select_nombramiento").toUpperCase();
                    String servicio = request.getParameter("text_servicio").toUpperCase();
                    String turno = request.getParameter("text_turno").toUpperCase();
                    String entrada = request.getParameter("time_entrada");
                    String salida = request.getParameter("time_salida");
                    String observaciones = request.getParameter("text_observaciones").toUpperCase();
                    String fecha_ingreso = request.getParameter("date_fecha_ingreso");
                    String fecha_baja = request.getParameter("date_fecha_baja");
                    String historial_cambios = dtf.format(now)
                            + ": ALTA DE EMPLEADO HECHA POR : "
                            + usuario.getNombre_usuario();

                    empleado.setAdsc(adsc);
                    empleado.setTarjeta(tarjeta);
                    empleado.setNum_emp(num_emp);
                    empleado.setNombre_empleado(nombre_empleado);
                    empleado.setPlaza(plaza);
                    empleado.setRfc(rfc);
                    empleado.setDesc_puesto(desc_puesto);
                    empleado.setNombramiento(nombramiento);
                    empleado.setServicio(servicio);
                    empleado.setTurno(turno);
                    empleado.setEntrada(entrada);
                    empleado.setSalida(salida);
                    empleado.setObservaciones(observaciones);
                    empleado.setFecha_ingreso(fecha_ingreso);
                    empleado.setHistorial_cambios(historial_cambios);

                    if (empleado_dao.agregarEmpleado(empleado)) {
                        request.setAttribute("mensaje", "Registro guardado correctamente");
                    } else {
                        request.setAttribute("mensaje", "Error, no se actualizó el registro");
                    }
                    request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                    break;
                case "cargar_datos":
                    int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
                    Empleado empleado_editar = empleado_dao.listarEmpleadoById(id_empleado);
                    request.setAttribute("opcion", "Actualizar");
                    request.setAttribute("empleado_editar", empleado_editar);
                    request.getRequestDispatcher("FormularioEmpleados.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    String number_adsc_act = request.getParameter("number_adsc");
                    int adsc_parse_act;
                    if (number_adsc_act == "") {
                        adsc_parse_act = 0;
                    } else {
                        adsc_parse_act = Integer.parseInt(number_adsc_act);
                    }

                    int id_empleado_act = Integer.parseInt(request.getParameter("number_id_empleado"));
                    int adsc_act = adsc_parse_act;
                    String tarjeta_act = request.getParameter("text_tarjeta").toUpperCase();
                    int num_emp_act = Integer.parseInt(request.getParameter("number_num_emp"));
                    String nombre_empleado_act = request.getParameter("text_nombre_empleado").toUpperCase();
                    String plaza_act = request.getParameter("text_plaza").toUpperCase();
                    String rfc_act = request.getParameter("text_rfc").toUpperCase();
                    String desc_puesto_act = request.getParameter("text_desc_puesto").toUpperCase();
                    String nombramiento_act = request.getParameter("select_nombramiento").toUpperCase();
                    String servicio_act = request.getParameter("text_servicio").toUpperCase();
                    String turno_act = request.getParameter("text_turno").toUpperCase();
                    String entrada_act = request.getParameter("time_entrada");
                    String salida_act = request.getParameter("time_salida");
                    String observaciones_act = request.getParameter("text_observaciones").toUpperCase();
                    String fecha_ingreso_act = request.getParameter("date_fecha_ingreso");
                    String fecha_baja_act = request.getParameter("date_fecha_baja");
                    String historial_cambios_act = request.getParameter("hidden_historial_cambios")
                            + "\n" + dtf.format(now)
                            + ": ACTUALIZACION DE EMPLEADO HECHA POR : "
                            + usuario.getNombre_usuario();

                    empleado.setId_empleado(id_empleado_act);
                    empleado.setAdsc(adsc_act);
                    empleado.setTarjeta(tarjeta_act);
                    empleado.setNum_emp(num_emp_act);
                    empleado.setNombre_empleado(nombre_empleado_act);
                    empleado.setPlaza(plaza_act);
                    empleado.setRfc(rfc_act);
                    empleado.setDesc_puesto(desc_puesto_act);
                    empleado.setNombramiento(nombramiento_act);
                    empleado.setServicio(servicio_act);
                    empleado.setTurno(turno_act);
                    empleado.setEntrada(entrada_act);
                    empleado.setSalida(salida_act);
                    empleado.setObservaciones(observaciones_act);
                    empleado.setFecha_ingreso(fecha_ingreso_act);
                    empleado.setHistorial_cambios(historial_cambios_act);

                    if (empleado_dao.actualizarEmpleado(empleado)) {
                        request.setAttribute("mensaje", "Registro actualizado correctamente");
                    } else {
                        request.setAttribute("mensaje", "Error, no se actualizó el registro");
                    }
                    request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                    break;
                case "borrar":
                    id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
                    empleado_dao.eliminarEmpleado(id_empleado);
                    request.getRequestDispatcher("ControladorEmpleados?menu=Empleados&accion=listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
