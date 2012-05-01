<%@ page import="gitproject.Placements" %>



<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'application', 'error')} ">
	<label for="application">
		<g:message code="placements.application.label" default="Application" />
		
	</label>
	<g:textField name="application" value="${placementsInstance?.application}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'companyname', 'error')} ">
	<label for="companyname">
		<g:message code="placements.companyname.label" default="Companyname" />
		
	</label>
	<g:textField name="companyname" value="${placementsInstance?.companyname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'jobtitle', 'error')} ">
	<label for="jobtitle">
		<g:message code="placements.jobtitle.label" default="Jobtitle" />
		
	</label>
	<g:textField name="jobtitle" value="${placementsInstance?.jobtitle}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="placements.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${placementsInstance?.status}"/>
</div>

