<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width" />
<!-- Included JS Files -->
<tiles:insertAttribute name="commonscripts"></tiles:insertAttribute>


<!-- Included stylesheets Files -->
<tiles:insertAttribute name="commonstyles"></tiles:insertAttribute>
<tiles:insertAttribute name="adminstyle"></tiles:insertAttribute>
<tiles:insertAttribute name="styleplaceholder"></tiles:insertAttribute>
<tiles:insertAttribute name="scriptplaceholder"></tiles:insertAttribute>
<title>Tooth-Loop Admin</title>
</head>
<body>

	<div class="mobile-menu">
		<a id="simple-menu" href="#sidr">Toggle menu</a>
	</div>

	<div class="liquid-slider" id="slider-4">
		<tiles:insertAttribute name="adminbody"></tiles:insertAttribute>
	</div>

	<div id="sidr">
		<ul>
			<tiles:insertAttribute name="adminmenu"></tiles:insertAttribute>
		</ul>
	</div>

</body>
</html>