<%@taglib uri="http://www.springframework.org/tags/form"  prefix="fr"%>
<html>
<body>
	<h3>Product-Entry-Form</h3>
	<hr>
		<form action="saveproduct">
		<pre>
			PCode	<input type="text" name="pcode"/> 
			PName	<input type="text" name="pname"/>
			Price	<input type="text" name="price"/>
				<input type="submit" value="Save"/>
		</pre>	
		</form>
	<hr>
		<fr:errors path="product.pcode"/><br>
		<fr:errors path="product.pname"/><br>
		<fr:errors path="product.price"/><br>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>