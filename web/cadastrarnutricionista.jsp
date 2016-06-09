<%-- 
    Document   : cadastrarnutricionista
    Created on : 27/05/2015, 11:31:57
    Author     : Leticia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Nutricionista</title>
    </head>
    <body>       
        <h1>Cadastrar Nutricionista!</h1>
        <h3>${sucesso}</h3>
        <form id="cadastrarnutricionista" name="cadastrarnutricionista" action="CadastrarNutricionista" method="POST"> 

            <p><label><input type="text" id="nomepessoa" placeholder="Nome" name="nomePessoa" /></label></p>
            <p><label><input type="tel" id="telefonepessoa" placeholder="Telefone" name="telefonePessoa" /></label></p>
            <p><label><input type="email" id="emailpessoa" placeholder="E-mail" name="emailPessoa" /></label></p>
            <p><label for="senhaPessoa"><input id="senhaPessoa" name="senhaPessoa" type="password" required placeholder="Senha" title="Senha" /></label></p>
            <p><label for="confirmarSenhaPessoa"><input id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" type="password" required  placeholder="Repetir Senha" title="Repetir Senha" oninput="validaSenha(this)" /></label></p>
            <p><label><input type="text" id="crnNutricionista" placeholder="CRN" name="crnNutricionista"/></label><br><br>
                <input type="submit" id="cadastrar" name="cadastrar" value="Cadastrar" />
                <a <button href="ListarNutricionista">Listar Nutricionista</button></a>



        </form>
    </body>
</html>
<script>
    function validaSenha(input) {
        if (input.value != document.getElementById('senhaPessoa').value) {
            input.setCustomValidity('Repita a senha corretamente');
        } else {
            input.setCustomValidity('');
        }
    }
</script>

