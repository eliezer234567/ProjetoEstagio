<%-- 
    Document   : alterarnutricionista
    Created on : 25/06/2015, 23:44:28
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nutricionista</h1>
        <h3>${sucesso}</h3>
        <form id="alteranutricionista" name="alteranutricionista" action="AlterarNutricionista" method="POST"> 
            <p><label>ID:</label><br>
                <input type="text" value="${nutricionista.idPessoa}" readonly="" id="idPessoa" name="idPessoa"/></p>
            <p><label>Nome: </label><br>
                <input type="text" value="${nutricionista.nomePessoa}" id="nomePessoa" name="nomePessoa" /></p>
            <p><label>Telefone: </label><br>
                <input type="tel" value="${nutricionista.telefonePessoa}" id="telefonePessoa" name="telefonePessoa" /></p>
            <p><label>E-mail: </label><br>
                <input type="email" value="${nutricionista.emailPessoa}" id="emailPessoa" name="emailPessoa" /></p>
            <p><label>Senha: </label><br>
                <input type="text" value="${nutricionista.senhaPessoa}" id="senhaPessoa" onfocus="(this.type = 'password')" name="senhaPessoa" /></p>
            <p><label for="confirmarSenhaPessoa"><input id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" value="${nutricionista.senhaPessoa}" type="text" onfocus="(this.type = 'password')" required  placeholder="Repetir Senha" title="Repetir Senha" oninput="validaSenha(this)" /></label></p>
            <p><label>CRN: </label><br>
                <input type="text" value="${nutricionista.crnNutricionista}" id="crnNutricionista" name="crnNutricionista"/></p><br><br>
            <button class="btn btn-primary" id="txt" type="submit" >Alterar</button>
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
