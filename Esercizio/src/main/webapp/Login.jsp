<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

	<body>

	    <form id="loginForm" method="post" action="Login">
	        <h1 id="accedi">Accedi</h1>
	        <div>
	            <div>
	                <input type="text" placeholder="Username" id="username" name="username">
	                
	            </div>	   
	        </div>
	        

	        <div>
	        	<button type="submit" id="loginButton">Login</button><br>
	            <a href="Registrazione.jsp">Registrati</a> <br>
	            
	        </div>
	    </form>
</html>