<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/9fbd14239f.js" crossorigin="anonymous"></script>
    </head>
    <body>              
        <div class="container">
            
            <div class="row">
                <div class="col-md-12">
                    <h1>Control de personas</h1>
                </div>
            </div>
            
            <br>
            
            <div class="row justify-content-end">
                <div class="col-auto">
                    <a href="PersonaServletController?accion=insert" class="btn btn-primary"> <span class="fas fa-plus"></span> Agregar persona</a>
                </div>
            </div>
            
            <br>
            
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Id persona</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellido paterno</th>
                                <th class="text-center">Apellido materno</th>
                                <th class="text-center">Edad</th>
                                <th class="text-center">Sexo</th>                    
                                <th class="text-center">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="persona" items="${personas}">
                                <tr>
                                    <td class="text-center">
                                        <a href="PersonaServletController?accion=update&id=${persona.idPersona}" class="fas fa-edit btn btn-warning"></a>
                                    </td>
                                    <td class="text-center">${persona.idPersona}</td>
                                    <td class="text-center">${persona.nombre}</td>
                                    <td class="text-center">${persona.apellidoPaterno}</td>
                                    <td class="text-center">${persona.apellidoMaterno}</td>
                                    <td class="text-center">${persona.edad}</td>
                                    <td class="text-center">${persona.sexo}</td>
                                    <td class="text-center">
                                        <a href="PersonaServletController?accion=delete&id=${persona.idPersona}" class="fas fa-trash btn btn-danger"></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>    
                    </table>
                </div>
            </div>                      
            
        <!-- cierre de container-->   
        </div> 

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
