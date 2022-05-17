<%-- 
    Author     : M.Sc. Juan José Guzmán Cruz
    Created on : Jan 25, 2020
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Vacaciones</title>

        <style>
            @media print{
                .parte2, .btn, img, .lable, .accion, .opciones, .no_printable{ display: none; }

                .parte1, .table{ display: block !important; }

                @page { size: letter landscape; margin-top: 0.4cm; margin-bottom: 1cm}
                body  { margin: 1cm; }
            }
        </style>

    </head>
    <body>
        <form name="form_vacaciones" class="needs-validation border border-secundary noPrint" novalidate action="ControladorVacaciones?menu=Vacaciones" method="POST">

            <!-- PRIMERA PARTE. DATOS DEL EMPLEADO Y BOTON DE ACCION-->
            <div class="form-group parte1">
                <div class="d-flex justify-content-around align-items-start" style="margin-top: 20px; margin-left: 20px; margin-right: 20px;">
                    <div>
                        <input name="hidden_id_empleado" type="hidden" class="form-control" id="id_empleado" value="${empleado.getId_empleado()}">
                    </div>
                    <label for="adsc" class="text-primary no_printable" style="margin-right: 20px;">ADSC</label>
                    <div class="col-md-1 no_printable">
                        <input name="number_adsc" type="number" class="form-control" id="adsc" style="font-weight: bold;" disabled value="${empleado.getAdsc()}">
                    </div>
                    <label for="num_emp" class="text-primary" style="margin-left: 20px; margin-right: 20px;">NUM_EMP</label>
                    <div class="input-group col-mb-2">
                        <input type="number" class="form-control" id="num_emp" aria-label="num_emp" aria-describedby="button_buscar" style="font-weight: bold;" value="${empleado.getNum_emp()}">
                        <div class="input-group-append">
                            <a id="button_buscar" class="btn btn-outline-primary" rol="button" href="javascript: validate();"><img src="icons/search.svg"></a>
                        </div>
                    </div>
                    <label for="nombre" class="text-primary" style="margin-left: 20px; margin-right: 20px;">NOMBRE</label>
                    <div class="col-md-4">
                        <input name="text_nombre" type="text" class="form-control" id="nombre" style="font-weight: bold;" disabled value="${empleado.getNombre_empleado()}">
                    </div>
                    <div class=""  style="margin-right: 20px; margin-left: 40px;">
                        <input id="button_accion" type="submit" name="accion" value="${opcion}" disabled class="btn btn-success btn-lg">
                    </div>
                    <div class=""  style="margin-right: 20px; margin-left: 20px;">
                        <input id="button_imprimir" type="button" value="    " disabled class="btn btn-outline-light btn-lg" style="background:url(icons/printer.svg) no-repeat; border:none;" onclick="print()">
                    </div>
                </div>
            </div>

            <!-- SEGUNDA PARTE. DATOS DE VACACIONES -->
            <div class="form-row parte2" style="margin-top: 30px; margin-left: 20px; margin-right: 20px; margin-bottom: 20px">
                <div>
                    <input name="hidden_id_vacaciones" type="hidden" class="form-control" id="id_vacaciones" value="${vacaciones_editar.getId_vacaciones()}">
                </div>
                <div class="col-sm-1">
                    <label for="folio" class="text-primary">FOLIO</label>
                    <input name="number_folio" type="number" class="form-control" id="folio" required value="${vacaciones_editar.getFolio()}">
                    <div class="invalid-feedback">
                        Campo obligatorio. Solo números son permitidos.
                    </div>
                </div>
                <div class="col-sm-1">
                    <label for="clave" class="text-primary">CLAVE</label>
                    <input name="number_clave" type="number" style="max:4;" class="form-control" id="clave" required value="${vacaciones_editar.getClave()}">
                    <div class="invalid-feedback">
                        Campo obligatorio. Solo números son permitidos.
                    </div>
                </div>
                <div class="col-sm-1">
                    <label for="periodo" class="text-primary">PERIODO</label>
                    <input name="text_periodo" type="text" class="form-control" id="periodo" style="text-transform: uppercase;" required value="${vacaciones_editar.getPeriodo()}">
                    <div class="invalid-feedback">
                        Campo obligatorio.
                    </div>
                </div>
                <div class="col-sm-1">
                    <label for="num_dias" class="text-primary">NUM_DIAS</label>
                    <input name="number_num_dias" type="number" class="form-control" id="num_dias" required value="${vacaciones_editar.getNum_dias()}">
                    <div class="invalid-feedback">
                        Campo obligatorio. Solo números son permitidos.
                    </div>
                </div>
                <div class="col-sm-2">
                    <label for="inicio" class="text-primary">INICIO</label>
                    <div class="input-group col-mb-2">
                        <input name="date_inicio" type="date" class="form-control" id="inicio" required value="${vacaciones_editar.getInicio()}">
                        <div class="input-group-append">
                            <a id="button_reanudacion" class="btn btn-outline-secondary" rol="button" href="javascript: calcularFechaReanudacion();"><img src="icons/calculator.svg"></a>
                        </div>
                    </div>
                    <div class="invalid-feedback">
                        Campo obligatorio.
                    </div>
                </div>
                <div class="col-sm-2">
                    <label for="dias" class="text-primary">DIAS</label>
                    <input name="text_dias" type="text" class="form-control" id="dias" style="text-transform: uppercase;" value="${vacaciones_editar.getDias()}">
                </div>
                <div class="col-sm-4">
                    <label for="notas" class="text-primary">NOTAS</label>
                    <input name="text_notas" type="text" class="form-control" id="notas" style="text-transform: uppercase;" value="${vacaciones_editar.getNotas()}">
                </div>
                <div>
                    <input name="hidden_fecha_captura" type="hidden" class="form-control" id="fecha_captura" readonly value="${vacaciones_editar.getFecha_captura()}">
                </div>
                <div>
                    <input name="hidden_historial_cambios" type="hidden" class="form-control" id="historial_cambios" value="${vacaciones_editar.getHistorial_cambios()}">
                </div>
            </div>
        </form>

        <!-- TERCER PARTE. TABLA DE REGISTROS DE VACACIONES -->
        <div class="table-responsive parte3" style="max-height:280px; margin-top: 20px;">
            <table id="tabla_vacaciones" class="table table-striped" style="width:100%;">
                <thead style="position: sticky; top: 0">
                    <tr>
                        <th style="display:none;">ID</th>
                        <th>FOLIO</th>
                        <th>CLAVE</th>
                        <th>PERIODO</th>
                        <th>NUM_DIAS</th>
                        <th>INICIO</th>
                        <th>DIAS</th>
                        <th>NOTAS</th>
                        <th>FECHA_CAPTURA</th>
                        <th style="display:none;">HISTORIAL</th>
                        <th class="opciones">OPCIONES</th>
                    </tr>
                </thead>
                <tbody class="context-menu-one"> 
                    <c:forEach var="vacaciones" items="${list_vacaciones}">
                        <tr>
                            <td style="display:none;">${vacaciones.getId_vacaciones()}</td>
                            <td>${vacaciones.getFolio()}</td>
                            <td>${vacaciones.getClave()}</td>
                            <td>${vacaciones.getPeriodo()}</td>
                            <td>${vacaciones.getNum_dias()}</td>
                            <td>${vacaciones.getInicio()}</td>
                            <td>${vacaciones.getDias()}</td>
                            <td>${vacaciones.getNotas()}</td>
                            <td>${vacaciones.getFecha_captura()}</td>
                            <td style="display:none;">${vacaciones.getHistorial_cambios()}</td>
                            <td>
                                <a class="btn btn-outline-warning" href="ControladorVacaciones?menu=Vacaciones&accion=cargar_datos_actualizar&id_vacaciones=${vacaciones.getId_vacaciones()}"><img src="icons/edit.svg"></a>
                                <a class="btn btn-outline-danger" href="ControladorVacaciones?menu=Vacaciones&accion=borrar&id_vacaciones=${vacaciones.getId_vacaciones()}"><img src="icons/trash.svg"></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- JAVASCRIPT -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>        

        <script>
                            // Example starter JavaScript for disabling form submissions if there are invalid fields
                            (function () {
                                'use strict';
                                window.addEventListener('load', function () {
                                    // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                    var forms = document.getElementsByClassName('needs-validation');
                                    // Loop over them and prevent submission
                                    var validation = Array.prototype.filter.call(forms, function (form) {
                                        form.addEventListener('submit', function (event) {
                                            if (form.checkValidity() === false) {
                                                event.preventDefault();
                                                event.stopPropagation();
                                            }
                                            form.classList.add('was-validated');
                                        }, false);
                                    });
                                }, false);
                            })();
        </script>

        <!--Validar el campo num_emp-->
        <script language="JavaScript" type="text/javascript">
            function validate() {
                var num_emp = document.getElementById('num_emp').value;
                if (num_emp == "") {
                    window.alert("El valor del campo NUM_EMP es requerido. Sólo números son permitidos.");
                    window.location.href = "ControladorVacaciones?menu=Vacaciones&accion=cargar_vista";
                    num_emp.focus();
                    return false;
                }

                if (num_emp != "" && num_emp.length > 10) {
                    window.alert("El valor escrito en el campo NUM_EMP no está permitido.");
                    window.location.href = "ControladorVacaciones?menu=Vacaciones&accion=cargar_vista";
                    num_emp.focus();
                    return false;
                }
                window.location.href = 'ControladorVacaciones?menu=Vacaciones&accion=Buscar&num_emp=' + num_emp;
                num_emp.focus();
                return true;
            }</script>

        <!-- Habilitar botones al cargar Vacaciones.jsp si el campo NUM_EMP tiene un valor -->
        <script language="JavaScript" type="text/javascript">
            window.onload = function () {
                var num_emp = document.getElementById('num_emp').value;
                if (num_emp == "") {
                    document.getElementById('num_emp').focus();
                } else {
                    document.getElementById('folio').focus();
                    document.getElementById('button_accion').disabled = false;
                    document.getElementById('button_imprimir').disabled = false;
                }
            };
        </script>

        <!-- Calcula la fecha de reanudación de labores y la muestra en el campo NOTAS -->
        <script language="JavaScript" type="text/javascript">
            function calcularFechaReanudacion() {
                var num_dias = document.getElementById('num_dias').value;
                var inicio = document.getElementById('inicio').value;
                var d = new Date(inicio);
                d.setDate(d.getDate() + parseInt(num_dias) + 1);
                var dd = d.getDate();
                var mm = d.getMonth() + 1;
                var yyyy = d.getFullYear();
                var fecha_reanudacion = "FECHA DE REANUDACION " + dd + "/" + mm + "/" + yyyy;
                document.getElementById('notas').value = fecha_reanudacion;
                //window.alert(fecha_reanudacion);
                //onkeyup="calcularFechaReanudacion();"
            }
        </script>
    </body>
</html>
