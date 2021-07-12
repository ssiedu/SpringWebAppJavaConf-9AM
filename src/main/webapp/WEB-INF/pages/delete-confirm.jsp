<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Product-Removed-Successfully</h3>
	<h4>Following Details Removed : </h4>
	<hr>
		<pre>
			PCode	${product.pcode}
			PName	${product.pname}
			Price	${product.price}
		</pre>
	<hr>
	<a href="allproducts">Back-To-List</a><br>
	<a href="index.jsp">Home</a><br>
</body>
</html>