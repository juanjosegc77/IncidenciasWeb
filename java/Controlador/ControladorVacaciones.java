package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Vacaciones;
import Modelo.VacacionesDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */
public class ControladorVacaciones extends HttpServlet {
   
    String nombre_usuario;
    int id_empleado;
    Empleado empleado = new Empleado();
    EmpleadoDAO empleado_dao = new EmpleadoDAO();
    Vacaciones vacaciones = new Vacaciones();
    VacacionesDAO vacaciones_dao = new VacacionesDAO();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm");  
    LocalDateTime now = LocalDateTime.now();
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
        
        if (menu.equals("Vacaciones")) {
            switch (accion) {
                case "cargar_vista":
                    nombre_usuario = request.getParameter("nombre_usuario");
                    request.setAttribute("opcion", "Guardar");
                    request.getRequestDispatcher("Vacaciones.jsp").forward(request, response);
                    break;
                case "Buscar":
                    int num_emp = Integer.parseInt(request.getParameter("num_emp"));
                    empleado = empleado_dao.listarEmpleadoByNumEmp(num_emp);
                    if(empleado.getNombre_empleado() == null ){
                        request.setAttribute("mensaje", "El registro del empleado con (NUM_EMP = " + num_emp + ") no existe. Verifique la información.");
                        request.setAttribute("menu", "Vacaciones.jsp");
                        request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                    } else {
                        id_empleado = empleado.getId_empleado();
                        request.setAttribute("accion", "cargar_datos");
                        request.getRequestDispatcher("ControladorVacaciones?menu=Vacaciones&accion=cargar_datos").forward(request, response);
                    }
                    break;
                case "cargar_datos":
                    ArrayList<Vacaciones> list_vacaciones = vacaciones_dao.listarVacacionesByEmpleado(id_empleado);
                    request.setAttribute("opcion", "Guardar");
                    request.setAttribute("empleado", empleado);
                    request.setAttribute("list_vacaciones", list_vacaciones);
                    request.getRequestDispatcher("Vacaciones.jsp").forward(request, response);
                    break;
                case "Guardar":
                    int folio = Integer.parseInt(request.getParameter("number_folio"));
                    int clave = Integer.parseInt(request.getParameter("number_clave"));
                    String periodo = request.getParameter("text_periodo").toUpperCase();
                    int num_dias = Integer.parseInt(request.getParameter("number_num_dias"));
                    String inicio = request.getParameter("date_inicio");
                    String dias = request.getParameter("text_dias").toUpperCase();
                    String notas = request.getParameter("text_notas").toUpperCase();
                    String fecha_captura = dtf.format(now);
                    String historial_cambios  = dtf.format(now) + 
                            ": ALTA DE VACACIONES HECHA POR : "
                            + nombre_usuario;
                    
                    vacaciones.setId_empleado(id_empleado);
                    vacaciones.setFolio(folio);
                    vacaciones.setClave(clave);
                    vacaciones.setPeriodo(periodo);
                    vacaciones.setNum_dias(num_dias);
                    vacaciones.setInicio(inicio);
                    vacaciones.setDias(dias);
                    vacaciones.setNotas(notas);
                    vacaciones.setFecha_captura(fecha_captura);
                    vacaciones.setHistorial_cambios(historial_cambios);

                    if(vacaciones_dao.agregarVacaciones(vacaciones))                                       
                        request.setAttribute("mensaje", "Registro ingresado correctamente");
                    else{
                        request.setAttribute("mensaje", "Error, no se ingresó el registro");
                        request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("ControladorVacaciones?menu=Vacaciones&accion=cargar_datos").forward(request, response);
                    break;
                    case "cargar_datos_actualizar":
                        int id_vacaciones_cargar = Integer.parseInt(request.getParameter("id_vacaciones"));
                        Vacaciones vacaciones_editar = vacaciones_dao.listarVacacionesById(id_vacaciones_cargar);
                        request.setAttribute("opcion", "Actualizar");
                        request.setAttribute("empleado", empleado);
                        request.setAttribute("vacaciones_editar", vacaciones_editar);                    
                        request.getRequestDispatcher("Vacaciones.jsp").forward(request, response);
                        break;
                    case "Actualizar":                    
                        int id_vacaciones_act = Integer.parseInt(request.getParameter("hidden_id_vacaciones"));
                        int folio_act = Integer.parseInt(request.getParameter("number_folio"));
                        int clave_act = Integer.parseInt(request.getParameter("number_clave"));
                        String periodo_act = request.getParameter("text_periodo").toUpperCase();
                        int num_dias_act = Integer.parseInt(request.getParameter("number_num_dias"));
                        String inicio_act = request.getParameter("date_inicio");
                        String dias_act = request.getParameter("text_dias").toUpperCase();
                        String notas_act = request.getParameter("text_notas").toUpperCase();
                        String fecha_captura_act = dtf.format(now);
                        String historial_cambios_act  = request.getParameter("hidden_historial_cambios")
                                + "\n" + dtf.format(now) + 
                                ": ACTUALIZACIÓN DE VACACIONES HECHA POR : " 
                                + nombre_usuario;

                        vacaciones.setId_vacaciones(id_vacaciones_act);
                        vacaciones.setId_empleado(id_empleado);
                        vacaciones.setFolio(folio_act);
                        vacaciones.setClave(clave_act);
                        vacaciones.setPeriodo(periodo_act);
                        vacaciones.setNum_dias(num_dias_act);
                        vacaciones.setInicio(inicio_act);
                        vacaciones.setDias(dias_act);
                        vacaciones.setNotas(notas_act);
                        vacaciones.setFecha_captura(fecha_captura_act);
                        vacaciones.setHistorial_cambios(historial_cambios_act);

                        if(vacaciones_dao.actualizarVacaciones(vacaciones))                                  
                            request.setAttribute("mensaje", "Registro ingresado correctamente");
                        else{
                            request.setAttribute("mensaje", "Error, no se actualizó el registro");
                            request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                        }

                        request.getRequestDispatcher("ControladorVacaciones?menu=Vacaciones&accion=cargar_datos").forward(request, response);
                        break;
                    case "borrar":
                        int id_vacaciones_borrar = Integer.parseInt(request.getParameter("id_vacaciones"));
                        if(vacaciones_dao.eliminarVacaciones(id_vacaciones_borrar))
                            request.setAttribute("mensaje", "Registro ingresado correctamente");
                        else{
                            request.setAttribute("mensaje", "Error, no se eliminó el registro");
                            request.getRequestDispatcher("MensajesValidacion.jsp").forward(request, response);
                        }

                        request.getRequestDispatcher("ControladorVacaciones?menu=Vacaciones&accion=cargar_datos").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
            }
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
