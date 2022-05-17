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
        <title>Principal</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">           
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">               
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none; font-size: 1.2em" class="btn btn-outline-light" href="ControladorEmpleados?menu=Empleados&accion=listar" target="myFrame">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none; font-size: 1.2em" class="btn btn-outline-light" href="ControladorVacaciones?menu=Vacaciones&accion=cargar_vista&nombre_usuario=${nombre_usuario}" target="myFrame">Vacaciones</a>
                    </li>
                </ul>                
            </div>
            <div class="dropdown">                
                <button style="margin-right: 10px; border: none; font-size: 1.2em" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${nombre_usuario}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" style="margin-right: 10px; border: none; font-size: 1.2em" href="ValidarAcceso?accion=Salir">Salir</a>
                </div>
            </div>
        </nav>
        
        <div class="embed-responsives m-4" style="height: 700px; allowfullscreen">
            <iframe class="embed-responsive-item" name="myFrame" scrolling="no" style="height: 100%; width: 100%; border:navy;"></iframe>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>