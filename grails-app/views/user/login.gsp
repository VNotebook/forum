<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Ingresar</title>
</head>

<body>
    <div style="width: 400px" class="center-block">
        <g:if test="${error}">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
                <span class="sr-only">Error:</span>

                ${error}
            </div>
        </g:if>


        <g:form action="doLogin">
            <div class="form-group">
                <label for="username">Nombre de usuario</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Introduzca su nombre de usuario">
            </div>
            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Introduzca su contraseña">
            </div>

            <button type="submit" class="btn btn-primary">Ingresar</button>
        </g:form>
    </div>
</body>
</html>