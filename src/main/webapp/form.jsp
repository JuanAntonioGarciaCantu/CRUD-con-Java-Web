
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/9fbd14239f.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h1>Formulario</h1>     
                    <p>Agrega o edita una persona</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr />
                </div>
            </div>

            <div class="row">

                <div class="col-md-12">
                    <form action="PersonaServletController" method="POST" name="formulario">
                        <div class="row">
                            <div class="col-md-4">
                                <input type="text" class="form-control visually-hidden" id="txtIdPersona" name="idPersona" value="${persona.idPersona}">
                                
                                <div class="mb-3">
                                    <label for="txtNombre" class="form-label">Nombre</label>
                                    <input type="text" class="form-control" id="txtNombre" name="nombre" value="${persona.nombre}">
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="mb-3">
                                    <label for="txtApellidoPaterno" class="form-label">Apellido Paterno</label>
                                    <input type="text" class="form-control" id="txtApellidoPaterno" name="apellidoPaterno" value="${persona.apellidoPaterno}">
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="mb-3">
                                    <label for="txtApellidoMaterno" class="form-label">Apellido Materno</label>
                                    <input type="text" class="form-control" id="txtApellidoMaterno" name="apellidoMaterno" value="${persona.apellidoMaterno}">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label for="txtEdad" class="form-label">Edad</label>
                                    <input type="text" class="form-control" id="txtEdad" name="edad" value="${persona.edad}">
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="">
                                    <label class="form-label mb-3">Sexo</label>  
                                    <br>
                                    <div class="form-check-inline">
                                        <input class="form-check-input" type="radio" name="sexo" id="checkMasculino" value="M">
                                        <label class="form-check-label" for="checkMasculino">
                                            Masculino
                                        </label>
                                    </div>
                                    <div class="form-check-inline">
                                        <input class="form-check-input" type="radio" name="sexo" id="checkFemenino" value="F">
                                        <label class="form-check-label" for="checkFemenino">
                                            Femenino
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>       
                        
                        <br>
                        
                        <div class="row justify-content-center">
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-success">Guardar</button>
                                <a href="PersonaServletController" class="btn btn-danger">Regresar</a>
                            </div>
                        </div>
                    </form>
                </div>

            </div>

        </div>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
