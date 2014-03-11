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
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.js"/>"></script>

<script type="text/JavaScript"
	src="<c:url value= "http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.easing.1.3.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.touchSwipe.min.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.liquid-slider.min.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.sidr.min.js"/>"></script>
<!-- Included stylesheets Files -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/stylesheets/jquery.sidr.dark.css" /> ">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/stylesheets/animate.css" /> ">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/stylesheets/liquid-slider.css" /> ">
<script>
	/* If installing in the footer, you won't need $(function() {} */
	$(function() {
		$('#slider-4').liquidSlider({
			hashLinking : true,
			crossLinks : true,
			firstPanelToLoad : 2
		});
	});
	$(document).ready(function() {
		$('#simple-menu').sidr();
	});
</script>


<title>Insert title here</title>
</head>
<body>
</body>
</html>