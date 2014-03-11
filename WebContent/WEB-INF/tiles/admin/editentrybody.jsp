<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!--newentrybody-->
<div>
	<h2 class="title">edit existing category</h2>
	<sf:form id="details"
		action="${pageContext.request.contextPath}/editexistingcategory"
		method="post" commandName="category">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input path="name" name="name" class="control"
						type="text" value="${categorytemplate.name}" /></td>
				<td>
					<div class="error"></div>
				</td>
			</tr>
			<tr>
				<td class="label">Type:</td>
				<td><sf:input path="type" name="type" class=" control"
						type="text" value="${categorytemplate.type}" /></td>
				<td>
					<div class="error"></div>
				</td>
			</tr>
			<tr>
				<td class="label">Parent:</td>
				<td><sf:input path="parent" name="parent" class="control"
						type="text" value="${categorytemplate.parent}" /></td>
				<td>
					<div class="error"></div>
				</td>
			</tr>
			<tr>
				<td class="label">Showing:</td>
				<td><sf:input path="showing" name="showing" class="control"
						type="text" value="yes" /></td>
				<td>
					<div class="error"></div>
				</td>
			</tr>
			<tr>
				<td class="label">Sort:</td>
				<td><sf:input path="sort" name="sort" class="control"
						type="text" value="${categorytemplate.sort}" /></td>
				<td>
					<div class="error"><sf:errors path="sort"></sf:errors></div>
				</td>
			</tr>
			<tr>
				<td class="label">Content:</td>

			</tr>
			<tr>
				<td colspan="3"><textarea class="myTextEditor" name="content"
						style="width: 100%">${categorytemplate.content}</textarea></td>
			</tr>
			<tr>
				<td><input class="control" value="Submit article" type="submit" />
				</td>
				<td><div>
						<sf:input path="id" name="id" class="control"
							 value="${categorytemplate.id}" />
					</div></td>
				<td>
					<div class="error"></div>
				</td>
				<td><div>
						<sf:input path="children" name="children" class="control"
							 value="${categorytemplate.children}" />
					</div></td>
				<td>
					<div class="error"></div>
				</td>
			</tr>
		</table>
	</sf:form>

</div>


