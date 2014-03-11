<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="liquid-slider" id="slider-4">
	<div>
		<h2 class="title">Slide 1</h2>
		<div class='pg'>
			<div class='pg-main'>
				<div class='entries'>
					<c:forEach var="row" items="${articles}">
			    email: ${row.name}<br />
			    password: ${row.category}<br />
					</c:forEach>
					<p class='preview'>Each div holding information of a category
						will show up here</p>
				</div>
			</div>
		</div>
	</div>
	<div>
		<h2 class="title">Slide 2</h2>
		// Content goes here
	</div>
	<div>
		<h2 class="title">Slide 3</h2>
		// Content goes here
	</div>
</div>


