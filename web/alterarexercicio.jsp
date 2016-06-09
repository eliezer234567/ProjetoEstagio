<%-- 
    Document   : alterarexercicio
    Created on : 21/07/2015, 16:55:51
    Author     : Grazy Martins
--%>

<%@page import="br.com.projetoestagio.model.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Exercicio"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 980px">
            <div>
                <fieldset  style="width: 360px">
                    <legend>Informações dos Exercícios</legend>
                    <form id="alterarexercicio" class="formee" name="alterarexercicio" action="AlterarExercicio" method="post">
                        <label for="msg" style="color: red">${msg}</label>
                        <p>
                            <label>ID Exercício</label>
                            <input style="width: 30px" type="text" value="${exercicio.idExercicio}" readonly="true" name="idexercicio">
                        </p>
                        <p>
                            <label>Nome:</label>
                            <input style="width: 250px" type="text" value="${exercicio.nomeExercicio}" name="nomeexercicio" style="display: block">
                        </p>
                        <p>
                            <label>Tipo</label>
                            <input style="width: 100px" type="text" value="${exercicio.tipoExercicio}" name="tipoexercicio" style="display: block">
                        </p>
                        <p>
                            <label>Frequência</label>
                            <input style="width: 100px" type="text" value="${exercicio.frequenciaExercicio}" name="frequenciaexercicio" style="display: block">
                        </p>
                        <p>
                            <label>Total de Horas</label>
                            <input style="width: 50px" type="number" value="${exercicio.totalHorasExercicio}" name="totalhorasexercicio" style="display: block">
                        </p>
                        <p>
                            <label>Intensidade</label>
                            <input style="width: 100px" type="text" value="${exercicio.intensidadeExercicio}" name="intensidadeexercicio" style="display: block">
                        </p>
                        <p>
                            <label>Código da Avaliação</label>
                            <select name="idavaliacao">
                                <%
                                    Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
                                    List<Avaliacao> avaliacoes = (List<Avaliacao>) request.getAttribute("avaliacoes");
                                    for (Avaliacao avaliacao : avaliacoes) {
                                %>
                                <option value="<%=avaliacao.getIdAvaliacao()%>" ><%=avaliacao.getIdAvaliacao()%></option>
                                <% }%>

                            </select>
                        </p>
                        <p>
                            <button class="btn btn-primary" id="txt" onclick="myFunction()" type="submit" >Alterar</button> |
                            <input type="button" onclick="javascript:history.go(-1)" value="Voltar">
                        </p>
                    </form>
                </fieldset>                             
            </div>                       
        </div>
    </body>
</html>
