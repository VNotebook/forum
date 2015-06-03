<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Forum 2.0</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <link rel="stylesheet" href="/Foro/css/bootstrap.min.css">
    <link rel="stylesheet" href="/Foro/css/forum.css">
    <asset:javascript src="application.js"/>

    <g:layoutHead/>
</head>

<body>
<div class="container">

    <div style="width: 100%; height: 100px">
        <a href="/Foro/"><img src="/Foro/images/logo.png" style="height:95px;"> <span class="h1">Forum</span></a>

    </div>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <g:if test="${session.authStatus == 'logged'}">
                <p class="navbar-text navbar-left">Bienvenido ${session.userName}</p>
                <ul class="nav navbar-nav navbar-right">
                    <li><g:link resource="user" action="myProfile">Mi perfil</g:link></li>
                    <li><g:link resource="post" action="myPosts">Mis post</g:link></li>
                    <li><g:link resource="user" action="logout">Salir</g:link></li>
                </ul>
            </g:if>
            <g:else>
                <ul class="nav navbar-nav navbar-right">
                    <li><g:link resource="user" action="login">Login</g:link></li>
                </ul>
            </g:else>
        </div><!-- /.container-fluid -->
    </nav>

    <g:layoutBody/>

    <br>

    <div class="panel panel-default">
        <div class="panel-body text-center">
            Aplicación hecha por VNotebook team
        </div>
    </div>

    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt"
                                                                       default="Loading&hellip;"/></div>
</div>
</body>
</html>
