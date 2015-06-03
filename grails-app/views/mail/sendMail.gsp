<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Enviar un correo de prueba</title>
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


    <g:form action="sendTestMail">
        <div class="form-group">
            <label for="to">Destinatario</label>
            <input type="email" class="form-control" name="to" id="to" placeholder="Introduzca el correo de destino">
        </div>

        <button type="submit" class="btn btn-primary">Enviar</button>
    </g:form>
</div>
</body>
</html>