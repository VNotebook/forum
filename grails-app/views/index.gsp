<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Forum 2.0</title>
	</head>
	<body>
		<div id="page-body" role="main">
			<div>
				Bienvenido a la aplicación Forum 2.0

				<br/><br/>
				Consultar:
				<ul>
					<li><g:link controller="forum">Foros</g:link></li>
					<li><g:link controller="user">Usuarios</g:link> </li>
					<li><g:link controller="post">Entradas (Post)</g:link></li>
					<li><g:link controller="file">Archivos</g:link></li>
				</ul>
			</div>

			<div>
				Últimas entradas (Posts)
				<ul>
				<g:each in="${lastPosts}" var="post">
					<li>${post.topic}</li>
				</g:each>
				</ul>
			</div>

			<div>
				Foros con más entradas
				<ul>
					<g:each in="${topForums}" var="forum">
						<li>${forum.name}</li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
