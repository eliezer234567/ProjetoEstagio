<%-- 
    Document   : CadastrarPatologia
    Created on : 02/08/2015, 13:03:01
    Author     : princesinha
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Patologia</title> 
    </head>
    <body>
        <h2>${sucesso}</h2>
        <form id="cadastrarpatologia" name="cadastrarpatologia" action="CadastrarPatologia" method="POST">



            <p><label>Nome</label>
                <input type="text" id="nomepatologia" name="nomePatologia" class="form-control" maxlength="100" size="50" required="required" /></p>

            <p><label> Descrição </label>
                <input type="text" id="descricaopatologia" name="descricaoPatologia"  class="form-control" maxlength="100" size="50" required="required" /></p>

            <p><label>Historico</label>
                <input type="text" id="historicofamiliapatologia" name="historicofamiliaPatologia"  class="form-control" maxlength="100" size="50" required="required" /></p>

            <p>     
            <p><input type="submit" value="Cadastrar"</p>
            <p><input type="reset" value="Limpar"</p>
        </p>

    </form>
</body>

</html>