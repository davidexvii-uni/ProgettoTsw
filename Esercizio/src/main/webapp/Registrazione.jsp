<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrati</title>
</head>
<body>

    <form action= RegistrazioneC method="post" id="registerForm">
    	<div id="form1">
        	<h1 id="accedi">Registrati</h1>
        	<table>
            		<tr><td><input type="email" placeholder="Email" id="emailInput" name="email" required></td></tr>
					
            		<tr><td><input type="text" placeholder="Nome" id="nome" name="nome" required></td></tr>
            		
                	<tr><td><input type="text" placeholder="Cognome" id="cognome" name="cognome" required></td></tr>
					            	
                	<tr><td><input type="text" placeholder="Indirizzo" id="indirizzo" name="indirizzo" required></td></tr>
                	
                	<tr><td><input type="text" placeholder="Citta" id="citta" name="citta" required></td></tr>
                	
                	<tr><td><input type="text" placeholder="Provincia" id="provincia" name="provincia" required></td></tr>
                	
                	<tr><td><input type="text" placeholder="Cap" id="cap" name="cap" required></td></tr>
            		
            </table>
        	<br><br>
        	<div>
            	<input type="submit" value=Registrati>
            	<input type=reset>
        	</div>
        	
        </div>
    	</form>

</body>
</html>