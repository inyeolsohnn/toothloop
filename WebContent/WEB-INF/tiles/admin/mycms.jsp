<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	/*
	 dev note
	 category variables
	 private int id;
	 private int parent;
	 private String name;
	 private String showing;
	 private int order;
	 private String children;	 
	 <ul>
		<li><span>${cmscategory.id}</span></li>
		<li><span>${cmscategory.parent}</span></li>
		<li><span>${cmscategory.name}</span></li>
		<li><span>${cmscategory.showing}</span></li>
		<li><span>${cmscategory.order}</span></li>
		<li><span>${cmscategory.children}</span></li>
		<li><span>${cmscategory.heritage }</span></li>
	</ul>
	
	<sf:form id="details" method="post"
	action="${pageContext.request.contextPath}/createarticle"
	commandName="article">
	<sf:input class="control" path="category" name="category" type="hidden" />
	<table class="formtable">
		<tr>
			<td class="label">Title:</td>
			<td><sf:input class=" control" path="title" name="title"
					type="text" /></td>
			<td>
				<div class="error">
					<sf:errors path="title" cssClass="error"></sf:errors>
				</div>
			</td>
		</tr>
		<tr>
			<td class="label">Ordering:</td>
			<td><sf:input class=" control" path="order" name="order"
					type="text" /></td>
			<td>
				<div class="error">
					<sf:errors path="order" cssClass="error"></sf:errors>
				</div>
			</td>
		</tr>
		<tr>
			<td class="label">Category:</td>
			<td><sf:input class="control" path="category" name="category"
					type="text" />
			<td>
				<div class="error">
					<sf:errors path="category" cssClass="error"></sf:errors>
				</div>
			</td>
		</tr>
		<tr>
			<td class="label">Content:</td>
			<td><div></div></td>
			<td>
				<div class="error">
					<sf:errors path="content" cssClass="error"></sf:errors>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="3"><textarea class="control " name="content"
					style="width: 100%"></textarea></td>
		</tr>
		<tr>
			<td><input class="control" value="Submit article" type="submit" />
			</td>
		</tr>
	</table>
	</sf:form>
	 
	 */
%>
<div>
	<h2 class="title">My CMS</h2>
	<div class="categorylist">

		<table class="formtable">
			<tr>			
				<td>type</td>
			
				<td>name</td>
				<td>showing</td>
				<td>order</td>
			</tr>

			<c:forEach items="${cmscategory}" var="cmscategory">

				<tr>
				
					<td><span>${cmscategory.type }</span></td>
				

					<td><sf:form class="cmssubform" method="post"
							action="${pageContext.request.contextPath}/editcategory"
							type="hidden" commandName="category">

							<sf:input path="id" class="subforminput"
								value="${cmscategory.id}" type="hidden" />
							<sf:input path="type" class="subforminput"
								value="${cmscategory.type}" type="hidden" />
							<input class="cmssubformbutton" value="<c:forEach begin="0" end="${cmscategory.heritage}">-&nbsp; </c:forEach>${cmscategory.name}"
								type="submit" />
						</sf:form></td>

					<td><span>${cmscategory.showing}</span></td>
					<td><span>${cmscategory.sort}</span></td>
					<td><sf:form class="cmssubform" method="post"
							action="${pageContext.request.contextPath}/newcategory"
							type="hidden" commandName="category">
							<sf:input path="parent" class="subforminput" name="parent"
								type="hidden" value="${cmscategory.id}" />
							<input class="cmssubformbutton" value="create subcategory"
								type="submit" />
						</sf:form> <sf:form class="cmssubform" method="post"
							action="${pageContext.request.contextPath}/deletecategory"
							commandName="category">
							<sf:input path="id" class="subforminput" name="id" type="hidden"
								value="${cmscategory.id}" />
							<sf:input path="parent" class="subforminput" name="parent"
								type="hidden" value="${cmscategory.parent}" />
							<input class="cmssubformbutton" value="delete" type="submit" />
						</sf:form></td>

				</tr>

			</c:forEach>


		</table>


	</div>

</div>