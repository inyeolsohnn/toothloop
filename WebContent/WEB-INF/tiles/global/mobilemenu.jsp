<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<li><a href="<c:url value='/j_spring_security_logout'/>"
		data-liquidslider-ref="slider-4">logout</a></li>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<li><a href="<c:url value='/login'/>"
		data-liquidslider-ref="slider-4">login</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li><a href="<c:url value='/admin'/>"
		data-liquidslider-ref="slider-4">admin</a></li>
</sec:authorize>
<li><a href="#support">Support</a></li>

