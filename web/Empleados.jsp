<%-- 
    Author     : M.Sc. Juan José Guzmán Cruz
    Created on : Jan 25, 2020
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Empleados</title>
    </head>
    <body>         
        <div>
            <form style="margin-top: 20px; margin-bottom: 20px; margin-left: 20px; margin-top: 20px;">
                <div class="form-group">
                    <div class="d-flex flex-row align-items-center">                      
                        <div class="p-2">
                            <input 
                                type="text" 
                                id="filter" 
                                name="textBuscarEmpleado" 
                                class="form-control" 
                                style="width: 200%; text-transform: uppercase;"
                                placeholder="Buscar por TARJETA, NOMBRE o NUM_EMP..."
                                onkeyup="filterTable()">
                        </div>
                        <div class="ml-auto p-2">
                            <a class="btn btn-primary btn-lg" href="ControladorEmpleados?menu=Empleados&accion=nuevo_registro">Nuevo registro</a>
                            ${requestScope.Response}
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="table-responsive"  style="height: 600px; margin-top: 20px;">
            <table id="empleados" class="table table-striped" style="width:100%;">
                <thead style="position: sticky; top: 0">
                    <tr>
                        <th>OPCIONES</th>
                        <th>ID</th>
                        <th>ADSC</th>
                        <th>TARJETA</th>
                        <th>NUM_EMP</th>
                        <th>NOMBRE</th>
                        <th>PLAZA</th>
                        <th>RFC</th>
                        <th>DESC_PUESTO</th>
                        <th>NOMBRAMIENTO</th>
                        <th>SERVICIO</th>
                        <th>TURNO</th>
                        <th>ENTRADA</th>
                        <th>SALIDA</th>
                        <th>OBSERVACIONES</th>
                        <th>F_INGRESO</th>
                        <th>F_BAJA</th>
                        <th style="display:none;">HISTORIAL</th>
                        
                    </tr>
                </thead>
                <tbody class="context-menu-one"> 
                    <c:forEach var="empleado" items="${empleados}">
                        
                        <tr>
                            <td>
                                <a class="btn btn-outline-warning" href="ControladorEmpleados?menu=Empleados&accion=editar_registro&id_empleado=${empleado.getId_empleado()}"><img src="icons/edit.svg"></a>
                                <a class="btn btn-outline-danger" href="ControladorEmpleados?menu=FormularioEmpleados&accion=borrar&id_empleado=${empleado.getId_empleado()}"><img src="icons/trash.svg"></a>
                            </td>
                            
                            <td>${empleado.getId_empleado()}</td>
                            <td>${empleado.getAdsc()}</td>
                            <td>${empleado.getTarjeta()}</td>
                            <td>${empleado.getNum_emp()}</td>
                            <td>${empleado.getNombre_empleado()}</td>
                            <td>${empleado.getPlaza()}</td>
                            <td>${empleado.getRfc()}</td>
                            <td>${empleado.getDesc_puesto()}</td>
                            <td>${empleado.getNombramiento()}</td>
                            <td>${empleado.getServicio()}</td>
                            <td>${empleado.getTurno()}</td>
                            <td>${empleado.getEntrada()}</td>
                            <td>${empleado.getSalida()}</td>
                            <td>${empleado.getObservaciones()}</td>
                            <td>${empleado.getFecha_ingreso()}</td>
                            <td>${empleado.getFecha_baja()}</td>
                            <td style="display:none;">${empleado.getHistorial_cambios()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        
        <!-- JAVASCRIPT -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>        

        <!-- Elementos necesarios para el filtrado de la tabla -->
        <script>
            function filterTable(event) {
                var filter = event.target.value.toUpperCase();
                var rows = document.querySelector("#empleados tbody").rows;
                for (var i = 0; i < rows.length; i++) {
                    var filter_tarjeta = rows[i].cells[3].textContent.toUpperCase();
                    var filter_num_emp = rows[i].cells[4].textContent.toUpperCase();
                    var filter_nombre = rows[i].cells[5].textContent.toUpperCase();
                    if (filter_tarjeta.indexOf(filter) > -1 || 
                            filter_num_emp.indexOf(filter) > -1 ||
                            filter_nombre.indexOf(filter) > -1) {
                        rows[i].style.display = "";
                    } else {
                        rows[i].style.display = "none";
                    }      
                }
            }
            document.querySelector('#filter').addEventListener('keyup', filterTable, false);
        </script>
    </body>
</html>