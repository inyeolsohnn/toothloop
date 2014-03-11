<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

	<div>
		<h2 class="title">Create New Account</h2>
		<sf:form id="details" method="post"
			action="${pageContext.request.contextPath}/createaccount"
			commandName="user">
			<table class="formtable">
				<tr>
					<td class="label">Username:</td>
					<td><sf:input class=" control" path="username" name="username"
							type="text" /> <br />
						<div class="error">
							<sf:errors path="username" cssClass="error"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="label">Email:</td>
					<td><sf:input class="control" path="email" name="email"
							type="text" /><br />
						<div class="error">
							<sf:errors path="email" cssClass="error"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><sf:input class="control" id="password" path="password"
							name="password" type="password" /><br />
						<div class="error">
							<sf:errors path="password" cssClass="error"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="label">Confirm Password:</td>
					<td><input class="control" name="confirmpass" id="confirmpass"
						type="password" /><br />
						<div id="matchpass"></div></td>
				</tr>
				<tr>
					<td class="label"></td>
					<td><input class="control" value="Create account"
						type="submit" /></td>
				</tr>
			</table>
		</sf:form>
	</div>



