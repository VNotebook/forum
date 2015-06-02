<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Mis posts</title>
</head>

<body>
<ul>
    <g:if test="${posts}">
        <g:each in="${posts}" var="post">
            <li>${post.topic}</li>
        </g:each>
    </g:if>
    <g:else>
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>

            No tiene publicaciones disponibles
        </div>
    </g:else>
</ul>
</body>
</html>