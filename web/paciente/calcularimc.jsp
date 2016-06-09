<%-- 
    Document   : calcularimc
    Created on : 10/04/2016, 18:55:20
    Author     : eliez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="calcularimc" name="calcularimc" action="../CalcularIMC" method="POST">
            <p><label>Peso: <br><input type="text" placeholder="0,00" size="12" maxlength="6" name="peso"</label></p>
            <p><label>Altura: <br><input type="text" placeholder="00,00" size="12" maxlength="5"  name="altura" </label></p>
            <input type="radio" class="flat"   value="M" required="" name="sexo"> Masculino
            <input type="radio" class="flat"  value="F" required="" name="sexo"> Feminino
            <input type="submit" value="Calcular">
        </form>
    </body>
</script>


</html>
