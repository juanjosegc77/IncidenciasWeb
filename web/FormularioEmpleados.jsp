<%-- 
    Author     : M.Sc. Juan José Guzmán Cruz
    Created on : Jan 25, 2020
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Actualizar empleados</title>
    </head>
    <body>
        <form class="needs-validation border border-secundary" novalidate action="ControladorEmpleados?menu=FormularioEmpleados" method="POST">
            <div class="form-row" style="margin-top: 20px; margin-left: 20px; margin-right: 20px;">
                <div class="col-md-1">
                    <label for="id_empleado" class="text-primary">ID</label>
                    <input name="number_id_empleado" type="number" readonly class="form-control" id="id_empleado" value="${empleado_editar.getId_empleado()}">
                </div>
                <div class="col-md-1">
                    <label for="adsc" class="text-primary">ADSC</label>
                    <input name="number_adsc" type="number" style="max:4;" class="form-control" id="adsc" value="${empleado_editar.getAdsc()}">
                </div>
                <div class="col-md-1">
                    <label for="tarjeta" class="text-primary">TARJETA</label>
                    <input name="text_tarjeta" type="text" class="form-control" id="tarjeta" style="text-transform: uppercase;" value="${empleado_editar.getTarjeta()}">
                </div>
                <div class="col-md-2">
                    <label for="num_emp" class="text-primary">NUM_EMP</label>
                    <input name="number_num_emp" type="number" class="form-control" id="num_emp" required value="${empleado_editar.getNum_emp()}">
                    <div class="invalid-feedback">
                        Campo obligatorio. Solo números son permitidos.
                    </div>
                </div>
                <div class="col-md-5">
                    <label for="nombre_empleado" class="text-primary">NOMBRE</label>
                    <input name="text_nombre_empleado" type="text" class="form-control" id="nombre_empleado" style="text-transform: uppercase;" required value="${empleado_editar.getNombre_empleado()}">
                    <div class="invalid-feedback">
                        Campo obligatorio.
                    </div>
                </div>
                <div class="col-md-2">
                    <label for="plaza" class="text-primary">PLAZA</label>
                    <input name="text_plaza" type="text" class="form-control" id="plaza" style="text-transform: uppercase;" value="${empleado_editar.getPlaza()}">
                </div>
            </div>
            <div class="form-row" style="margin-top: 20px; margin-left: 20px; margin-right: 20px;">
                <div class="col-md-2">
                    <label for="rfc" class="text-primary">RFC</label>
                    <input name="text_rfc" type="text" class="form-control" id="rfc" style="text-transform: uppercase;" value="${empleado_editar.getRfc()}">
                </div>
                <div class="col-md-6">
                    <label for="desc_puesto" class="text-primary">DESC_PUESTO</label>
                    <input name="text_desc_puesto" type="text" class="form-control" id="desc_puesto" style="text-transform: uppercase;" value="${empleado_editar.getDesc_puesto()}">
                </div>
                <div class="form-group col-md-4">
                    <label for="nombramiento" class="text-primary">NOMBRAMIENTO</label>
                    <select name="select_nombramiento" class="custom-select" required id="nombramiento" style="text-transform: uppercase;" value="${empleado_editar.getNombramiento()}">
                        <option value="">...</option>
                        <option value="BASE">BASE</option>
                        <option value="CONFIANZA">CONFIANZA</option>
                        <option value="GUARDIAS Y SUPLENCIAS">GUARDIAS Y SUPLENCIAS</option>
                        <option value="RESIDENTE">RESIDENTE</option>
                    </select>
                    <div class="invalid-feedback">Campo obligatorio. Elija una opción.</div>
                </div>
            </div>
            <div class="form-row" style="margin-top: 20px; margin-left: 20px; margin-right: 20px;">
                <div class="col-md-5">
                    <label for="servicio" class="text-primary">SERVICIO</label>
                    <input name="text_servicio" type="text" class="form-control" id="servicio" style="text-transform: uppercase;" value="${empleado_editar.getServicio()}">
                </div>
                <div class="col-md-3">
                    <label for="turno" class="text-primary">TURNO</label>
                    <input name="text_turno" type="text" class="form-control" id="turno" style="text-transform: uppercase;" value="${empleado_editar.getTurno()}">
                </div>
                <div class="col-md-2">
                    <label for="entrada" class="text-primary">ENTRADA</label>
                    <input name="time_entrada" type="time" class="form-control" id="entrada" value="${empleado_editar.getEntrada()}">
                </div>
                <div class="col-md-2">
                    <label for="salida" class="text-primary">SALIDA</label>
                    <input name="time_salida" type="time" class="form-control" id="entrada" value="${empleado_editar.getSalida()}">
                </div>
            </div>
            <div class="form-row" style="margin-top: 20px; margin-bottom: 20px; margin-left: 20px;  margin-right: 20px;">
                <div class="col-md-6">
                    <label for="observaciones" class="text-primary">OBSERVACIONES</label>
                    <input name="text_observaciones" type="text" class="form-control" id="observaciones" style="text-transform: uppercase;" value="${empleado_editar.getObservaciones()}">
                </div>
                <div class="col-md-3">
                    <label for="fecha_ingreso" class="text-primary">FECHA_INGRESO</label>
                    <input name="date_fecha_ingreso" type="date" class="form-control" id="fecha_ingreso" class="field date-field dob-field" min="1900-01-01" max="2020-01-01" value="${empleado_editar.getFecha_ingreso()}">
                </div>
                <div class="col-md-3">
                    <label for="fecha_baja" class="text-primary">FECHA_BAJA</label>
                    <input name="date_fecha_baja" type="date" class="form-control" id="fecha_baja" class="field date-field dob-field" min="1900-01-01" max="2020-01-01" value="${empleado_editar.getFecha_baja()}">
                </div>
            </div>
            <div class="form-row" style="margin-top: 20px; margin-bottom: 20px; margin-left: 20px;  margin-right: 20px;">
                <div class="col-md-6">
                    <input name="hidden_historial_cambios" type="hidden" class="form-control" id="historial_cambios" value="${empleado_editar.getHistorial_cambios()}">
                </div>
            </div>
            <div class="d-flex justify-content-around" style="margin-top: 20px; margin-bottom: 20px">
                <div class="form-row">
                    <div class="col-sm-3"  style="">
                        <input type="submit" name="accion" value="${opcion}" class="btn btn-success btn-lg">
                    </div>
                </div>
            </div>
        </form>

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

    </body>
</html>