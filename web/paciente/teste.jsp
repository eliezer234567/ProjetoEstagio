<%-- 
    Document   : teste
    Created on : 21/03/2016, 21:46:33
    Author     : eliez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
            function idades(data) {

                var today = new Date();
                var birthDate = new Date(data);
                var age = today.getFullYear() - birthDate.getFullYear();
                var m = today.getMonth() - birthDate.getMonth();
                if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                    age--;
                }
                document.nomeForm.txtIdade.value = age; //nomeForm voce coloca o nome da sua form !!!!
            }

        </script>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form name="nomeForm">

            <input type="date" name="txtData" onblur="idade(this.value);"> 
            <!-- Pode usar o onchanged tbm, que quando o usuario colocar a data nascimento o campo idade é
            preenchido automaticamente -->

            <input type="number" name="txtIdade" readonly><br>

        </form>
    </body>
</html>
