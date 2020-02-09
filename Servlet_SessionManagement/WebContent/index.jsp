<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Example</title>
</head>
<body>
<h4> Session tracking by using cookie</h4>
<form action="./cookiesessionmanagement">
<label>Name</label> <input type="text" id="name" name="name">
<button>Click</button>
</form>

<h4> Session tracking by using hidden form field</h4>
<form action="./hiddeformfieldsession">
<label>Name</label> <input type="text" id="name" name="name">
<button>Click</button>
</form>

<h4> Session tracking by using Http Session</h4>
<form action="./httpsessionservlet" method="post">
<label>Name</label> <input type="text" id="name" name="name">
<button>Click</button>
</form>

</body>
</html>