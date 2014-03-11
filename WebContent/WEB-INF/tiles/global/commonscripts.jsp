<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.easing.1.3.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.touchSwipe.min.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.liquid-slider.min.js"/>"></script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.sidr.min.js"/>"></script>
<script>
<script type="text/JavaScript"
	src="<c:url value= "/static/javascripts/jquery.sidr.min.js"/>"></script>
<script>
	/* If installing in the footer, you won't need $(function() {} */
	$(function() {
		$('#slider-4').liquidSlider({
			hashLinking : false,
			crossLinks : true,
			firstPanelToLoad : 1,
			dynamicTabs : false,
			minHeight : 850,
			dynamicArrows : false
		});
	});
	$(document).ready(function() {
		$('#simple-menu').sidr();
	});
</script>