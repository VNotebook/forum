<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Mi perfil</title>
</head>

<body>
<dl class="dl-horizontal">
    <dt>Tipo de usuario</dt>
    <dd>Regular</dd>

    <dt>Vistas de post</dt>
    <dd>${user.postViews}</dd>

    <dt>Strikes</dt>
    <dd>${user.strikesNumber}</dd>

    <dt>Estrellas</dt>
    <dd>${user.starsNumber}</dd>
</dl>
</body>
</html>