<%@ page import="foro.Forum" %>



<div class="form-group ${hasErrors(bean: forumInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="forum.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="20" required="" value="${forumInstance?.name}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: forumInstance, field: 'category', 'error')} required">
    <label for="category">
        <g:message code="forum.category.label" default="Category"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="category" maxlength="15" required="" value="${forumInstance?.category}" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: forumInstance, field: 'admin', 'error')} required">
    <label for="admin">
        <g:message code="forum.admin.label" default="Admin"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="admin" name="admin.id" from="${foro.Admin.list()}" optionKey="id" required=""
              value="${forumInstance?.admin?.id}" class="many-to-one" class="form-control"/>

</div>

<div class="form-group ${hasErrors(bean: forumInstance, field: 'posts', 'error')} ">
    <label for="posts">
        <g:message code="forum.posts.label" default="Post"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${forumInstance?.posts ?}" var="p">
            <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="post" action="create"
                    params="['forum.id': forumInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
        </li>
    </ul>

</div>

