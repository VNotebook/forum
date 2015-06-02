<%@ page import="foro.Admin" %>



<div class="form-group ${hasErrors(bean: adminInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="admin.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${adminInstance?.name}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'lastname', 'error')} required">
	<label for="lastname">
		<g:message code="admin.lastname.label" default="Lastname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastname" maxlength="50" required="" value="${adminInstance?.lastname}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="admin.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="age" type="number" min="13" value="${adminInstance.age}" required="" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="admin.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${adminInstance?.username}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="admin.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${adminInstance?.password}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="admin.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="level" from="${1..5}" class="range form-control" required="" value="${fieldValue(bean: adminInstance, field: 'level')}"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="admin.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="rating" from="${0..100}" class="range form-control" required="" value="${fieldValue(bean: adminInstance, field: 'rating')}"/>

</div>

<div class="form-group ${hasErrors(bean: adminInstance, field: 'forums', 'error')} ">
	<label for="forums">
		<g:message code="admin.forums.label" default="Forums" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${adminInstance?.forums?}" var="f">
    <li><g:link controller="forum" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="forum" action="create" params="['admin.id': adminInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'forum.label', default: 'Forum')])}</g:link>
</li>
</ul>


</div>

