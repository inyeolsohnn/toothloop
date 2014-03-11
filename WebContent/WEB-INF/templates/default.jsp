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
<title>Tooth-Loop Homepage</title>
</head>
<body>

	<div class="mobile-menu">
		<a id="simple-menu" href="#sidr">Toggle menu</a>
	</div>

	<div class="liquid-slider" id="slider-4">
		<tiles:insertAttribute name="slidecontent"></tiles:insertAttribute>
		<div>
			<h2 class="title">Slide 3</h2>
			// Content goes here
		</div>
	</div>
	
	<div id="sidr">
		<ul>
		<tiles:insertAttribute name="mobilemenu"></tiles:insertAttribute>	
		</ul>
	</div>
	
</body>
</html>