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
        <title>Acceso</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card" col-sm-10>
                <div class="card-body">
                    <form class="form-sign" action="ControladorAcceso?menu=Acceso" method="POST">
                        <div class="form-group text-center">
                            <h3>Control de incidencias V1.0</h3>
                            <img src="imagenes/user.png" alt="100" width="100"/>
                            <br>
                            <br>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="textNombreUsuario" class="form-control" style="text-transform: uppercase;">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="textPassword" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>