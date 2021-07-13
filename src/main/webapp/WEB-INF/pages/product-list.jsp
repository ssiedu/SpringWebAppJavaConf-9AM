<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@page import="java.util.List, com.ssi.model.Product" %>
<%@page isELIgnored="false" %>

<html>
<body>
	<h3>Product-List-Using-JSTL</h3>
	<hr>
	<table border="1">
		<tr><th>Code</th><th>Name</th><th>Price</th></tr>
		<jstl:forEach var="product" items="${products}">
			<tr>
			<td>${product.pcode}</td>
			<td>${product.pname}</td>
			<td>${product.price}</td>
			<td><a href="remove?code=${product.pcode}">delete</a></td>
			<td><a href="update?code=${product.pcode}">modify</a></td>
			</tr>
		</jstl:forEach>
	</table>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>