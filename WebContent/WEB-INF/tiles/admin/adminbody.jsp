<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div>
	<h2 class="title">File Management</h2>
	
	<a href="<c:url value='/newarticle'/>"
		 data-liquidslider-ref="slider-4">Create Article</a><br />
		 <a href="<c:url value='/mycms'/>"
		 data-liquidslider-ref="slider-4">show categories</a><br />
		 
    <a href="<c:url value='/uploadfile'/>"
	 	 data-liquidslider-ref="slider-4">Upload File</a><br /> 
	 	  <a href="<c:url value='/showusers'/>"
	 	 data-liquidslider-ref="slider-4">usermanagement</a><br /> 
</div>

