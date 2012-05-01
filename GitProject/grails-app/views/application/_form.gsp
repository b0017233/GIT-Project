<%@ page import="gitproject.Application" %>



<div class="fieldcontain ${hasErrors(bean: applicationInstance, field: 'placements', 'error')} required">
	<label for="placements">
		<g:message code="application.placements.label" default="Placements" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="placements" name="placements.id" from="${gitproject.Placements.list()}" optionKey="id" required="" value="${applicationInstance?.placements?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: applicationInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="application.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="status" name="status.id" from="${gitproject.Status.list()}" optionKey="id" required="" value="${applicationInstance?.status?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: applicationInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="application.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${gitproject.Student.list()}" optionKey="id" required="" value="${applicationInstance?.student?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: applicationInstance, field: 'timestamp', 'error')} ">
	<label for="timestamp">
		<g:message code="application.timestamp.label" default="Timestamp" />
		
	</label>
	<g:textField name="timestamp" value="${applicationInstance?.timestamp}"/>
</div>

