<%@ page import="gitproject.Placements" %>



<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'coursecode', 'error')} ">
	<label for="coursecode">
		<g:message code="placements.coursecode.label" default="Coursecode" />
		
	</label>
	<g:textField name="coursecode" value="${placementsInstance?.coursecode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementsInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="placements.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${placementsInstance?.name}"/>
</div>

