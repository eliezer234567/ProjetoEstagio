<%-- 
    Document   : cadastrarexercicio
    Created on : 19/07/2015, 19:21:51
    Author     : Grazy Martins
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Avaliacao"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Exercício!</h1>

        <h3>${sucesso}</h3>

        <form name="cadastrarexercicio" id="cadastrarexercicio" action="CadastrarExercicio" method="POST">

            <p><label></p>
            <p><label>Nome:<input type="text" name="nomeexercicio" id="nomeexercicio" placeholder="Digite o nome..." required/>
                    <p><label>Tipo:<input type="text" name="tipoexercicio" id="tipoexercicio" placeholder="Digite o tipo..." required/>
                            <p><label>Frequência:<input type="text" name="frequenciaexercicio" id="frequenciaexercicio" placeholder="Informe a frequência..." required/>
                                    <p><label>Total Horas:<input type="number" name="totalhorasexercicio" id="totalhorasexercicio" required/>
                                            <p><label>Intensidade:<input type="text" name="intensidadeexercicio" id="intensidadeexercicio" placeholder="Digite a intensidade..." required/>             


                                                    <p>
                                                        Avaliação:
                                                        <select name="idavaliacao">
                                                            <%
                                                                List<Avaliacao> avaliacoes = (List<Avaliacao>) request.getAttribute("avaliacoes");
                                                                for (Avaliacao avaliacao : avaliacoes) {
                                                            %>
                                                            <option value="<%=avaliacao.getIdAvaliacao()%>"><%=avaliacao.getIdAvaliacao()%></option>
                                                            <% } %>
                                                        </select>
                                                    </p>

                                                    <p><input type="submit" value="Cadastrar" name="cadastrar" />&nbsp;&nbsp;           
                                                        <input type="reset" value="limpar" name="limpar" />&nbsp;&nbsp;
                                                    <ul><li><a href="ListarExercicio">Listar Exercício</a></li></ul>&nbsp;&nbsp;
                                                <input type="button" onclick="location.href = '/ProjetoEstagio'" value="Voltar" /></p>
                                    </p>
                                    </form>

                                    </body>
                                    </html>
