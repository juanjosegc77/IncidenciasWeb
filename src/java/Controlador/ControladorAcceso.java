package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author : M.Sc. Juan José Guzmán Cruz Created on : Jan 25, 2020
 *
 */
public class ControladorAcceso extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    String nombre_usuario;

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

        // Define la variable para recibir la acción del botón Ingresar en Acceso.jsp
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        // Si botón Ingresar en index.jsp es presionado
        if (menu.equals("Acceso")) {
            switch (accion) {
                case "Ingresar":
                    // Obtiene nombre de usuario y contraseña desde Acceso.jsp
                    //String nombre_usuario = request.getParameter("textNombreUsuario");
                    //String contraseña = request.getParameter("textPassword");            
                    String nombre_usuario = "JUAN JOSE GUZMAN CRUZ";
                    String contraseña = "a";
                    usuario = udao.validarUsuario(nombre_usuario, contraseña);
                    // Si el usuario está en la base de datos se llama al controlador
                    if (usuario.getNombre_usuario() != null) {
                        usuario.setNombre_usuario(nombre_usuario.toUpperCase());
                        request.getRequestDispatcher("ControladorAcceso?menu=Acceso&accion=Principal").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Acceso.jsp").forward(request, response);
                    }
                    break;
                case "Principal":
                    nombre_usuario = usuario.getNombre_usuario();
                    request.setAttribute("nombre_usuario", nombre_usuario);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
