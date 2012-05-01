
<%@ page import="gitproject.Placements" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'placements.label', default: 'Placements')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-placements" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-placements" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list placements">
			
				<g:if test="${placementsInstance?.application}">
				<li class="fieldcontain">
					<span id="application-label" class="property-label"><g:message code="placements.application.label" default="Application" /></span>
					
						<span class="property-value" aria-labelledby="application-label"><g:fieldValue bean="${placementsInstance}" field="application"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementsInstance?.companyname}">
				<li class="fieldcontain">
					<span id="companyname-label" class="property-label"><g:message code="placements.companyname.label" default="Companyname" /></span>
					
						<span class="property-value" aria-labelledby="companyname-label"><g:fieldValue bean="${placementsInstance}" field="companyname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementsInstance?.jobtitle}">
				<li class="fieldcontain">
					<span id="jobtitle-label" class="property-label"><g:message code="placements.jobtitle.label" default="Jobtitle" /></span>
					
						<span class="property-value" aria-labelledby="jobtitle-label"><g:fieldValue bean="${placementsInstance}" field="jobtitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementsInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="placements.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${placementsInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${placementsInstance?.id}" />
					<g:link class="edit" action="edit" id="${placementsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
