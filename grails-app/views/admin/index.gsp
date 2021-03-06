
<%@ page import="foro.Admin" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-admin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-admin" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'admin.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="lastname" title="${message(code: 'admin.lastname.label', default: 'Lastname')}" />
					
						<g:sortableColumn property="age" title="${message(code: 'admin.age.label', default: 'Age')}" />
					
						<g:sortableColumn property="username" title="${message(code: 'admin.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'admin.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="level" title="${message(code: 'admin.level.label', default: 'Level')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${adminInstanceList}" status="i" var="adminInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${adminInstance.id}">${fieldValue(bean: adminInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: adminInstance, field: "lastname")}</td>
					
						<td>${fieldValue(bean: adminInstance, field: "age")}</td>
					
						<td>${fieldValue(bean: adminInstance, field: "username")}</td>
					
						<td>${fieldValue(bean: adminInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: adminInstance, field: "level")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${adminInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
