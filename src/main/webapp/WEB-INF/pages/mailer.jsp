<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Mailer-Form</h3>
	<form action="sendmail">
	<pre>
		To		<input type="text" name="receipient"/>
		Subject		<input type="text" name="subject"/>
		Message		<input type="text" name="message"/>
				<input type="submit" value="Send"/>
	</pre>
	</form>
</body>
</html>