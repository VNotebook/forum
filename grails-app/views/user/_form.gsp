<%@ page import="foro.User" %>



<div class="form-group ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="user.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${userInstance?.name}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: userInstance, field: 'lastname', 'error')} required">
    <label for="lastname">
        <g:message code="user.lastname.label" default="Lastname"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="lastname" maxlength="50" required="" value="${userInstance?.lastname}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: userInstance, field: 'age', 'error')} required">
    <label for="age">
        <g:message code="user.age.label" default="Age"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="age" type="number" min="13" value="${userInstance.age}" required="" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
    <label for="username">
        <g:message code="user.username.label" default="Username"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="username" required="" value="${userInstance?.username}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
    <label for="password">
        <g:message code="user.password.label" default="Password"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="password" required="" value="${userInstance?.password}" class="form-control"/>

</div>

