<%-- 
    Document   : cadastrarmedicamentosuplemento
    Created on : 22/07/2015, 20:07:37
    Author     : Grazy Martins
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>${sucesso}</h2>
        <div class="row">  	
            <div class="col-sm-8">
                <div class="contact-form">
                    <h2 class="title text-center">Cadastro de Medicamentos e Suplementos</h2>

                    <div class="status alert alert-success" style="display: none"></div>

                    <form id="cadastrarmedicamentosuplemento" class="contact-form row" name="cadastrarmedicamentosuplemento" action="CadastrarMedicamentoSuplemento" method="POST">
                        <div class="form-group col-md-6">
                            <input type="text" name="nomemedicamentosuplemento" class="form-control" id="nomemedicamentosuplemento" required="required" placeholder="Nome do Medicamento/Suplemento"><br><br>
                        </div>
                        <div class="form-group col-md-6">
                            <input type="text" id="tipomedicamentosuplemento" name="tipomedicamentosuplemento" class="form-control" required="required" placeholder="Tipo do Medicamneto/Suplemento"><br><br>
                        </div>


                        <p><input type="submit" value="Cadastrar" name="cadastrar" />&nbsp;&nbsp;           
                            <input type="reset" value="limpar" name="limpar" />&nbsp;&nbsp;
                        <ul><li><a href="ListarMedicamentoSuplemento">Listar Medicamento/Suplemento</a></li></ul>&nbsp;&nbsp;
                        <input type="button" onclick="location.href = '/ProjetoEstagio'" value="Voltar" />
                        </P>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
