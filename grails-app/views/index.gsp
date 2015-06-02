<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Forum 2.0</title>
</head>

<body>
<div id="page-body" role="main">
    <div class="row row-eq-height">
        <div class="col-xs-6">
            <div class="panel panel-default full-height">
                <div class="panel-body">
                    Bienvenido a la aplicación Forum 2.0

                    <br/><br/>
                    Consultar:
                    <ul>
                        <li><g:link controller="forum">Foros</g:link></li>
                        <li>Usuarios</li>
                        <ul>
                            <li><g:link controller="admin">Administradores</g:link></li>
                            <li><g:link controller="regular">Usuarios regulares</g:link></li>
                        </ul>
                        <li><g:link controller="post">Entradas (Post)</g:link></li>
                        <li><g:link controller="file">Archivos</g:link></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-xs-3">
            <div class="panel panel-default full-height">
                <div class="panel-body">
                    Últimas entradas (Posts)
                    <ul>
                        <g:each in="${lastPosts}" var="post">
                            <li>${post.topic}</li>
                        </g:each>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-xs-3">
            <div class="panel panel-default full-height">
                <div class="panel-body">
                    Foros con más entradas
                    <ul>
                        <g:each in="${topForums}" var="forum">
                            <li>${forum.name}</li>
                        </g:each>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
