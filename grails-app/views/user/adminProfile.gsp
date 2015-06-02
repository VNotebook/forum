<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Mi perfil</title>
</head>

<body>
    <dl class="dl-horizontal">
        <dt>Tipo de usuario</dt>
        <dd>Administrador</dd>

        <dt>Nivel</dt>
        <dd>${user.level}</dd>

        <dt>Rating</dt>
        <dd>${user.rating}</dd>
    </dl>
</body>
</html>