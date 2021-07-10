<%@page import="java.util.List, com.ssi.model.Product" %>
<%
	List<Product> products=(List<Product>)request.getAttribute("products");
%>
<html>
<body>
	<h3>Product-List</h3>
	<hr>
	<table border="1">
		<%
			for(Product product:products){
		%>	
		<tr>	
			<td><%=product.getPcode()%></td><td><%=product.getPname()%></td><tD><%=product.getPrice()%></td>
		</tr>	
		<% 		
			}
		%>
	</table>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>