<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<!--newentryscripts-->
<script type="text/JavaScript"
	src="//tinymce.cachefly.net/4.0/tinymce.min.js"></script>
<script type="text/javascript">
	tinymce.init({
		mode : "specific_textareas",
        editor_selector : "myTextEditor",
		height : 500,
		 resize: false
	});
</script>
