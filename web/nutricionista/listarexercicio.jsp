<%-- 
    Document   : listarexercicio
    Created on : 20/07/2015, 20:06:25
    Author     : Grazy Martins
--%>

<%@page import="br.com.projetoestagio.model.Exercicio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>   
        
        <h1 style="color: darkred; font-weight: bold; font-size: 40px">:D Lista de Exercícios =></h1>
        <h4 style="color: blue; font-size: 20px">${sucesso}</h4>
        
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome do Exercício</th>
                    <th>Tipo do Exercício</th>  
                    <th>Frequência do Exercício</th>
                    <th>Total de Horas</th>
                    <th>Intensidade do Exercício</th>
                    <th>Status</th>
                    <th>Número Avaliação</th>
                    <th colspan="2">Editar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Exercicio> exercicios=(List<Exercicio>)request.getAttribute("exercicios");
                    for(Exercicio exercicio: exercicios){           
                %>

                <tr>
                    <td><%=exercicio.getIdExercicio()%></td>
                    <td><%=exercicio.getNomeExercicio() %></td>
                    <td><%=exercicio.getTipoExercicio()%></td>
                    <td><%=exercicio.getFrequenciaExercicio()%></td>
                    <td><%=exercicio.getTotalHorasExercicio()%></td>
                    <td><%=exercicio.getIntensidadeExercicio()%></td>
                    <td><%=exercicio.getStatusExercicio() %> </td>
                    <td><%=exercicio.getAvaliacao().getIdAvaliacao()%></td>
                    
                    <td><a href="CarregarExercicio?idexercicio=<%=exercicio.getIdExercicio()%>"><input type="button" value="Alterar" /></a></td>
                    <% if(exercicio.getStatusExercicio().equals("I")){ %>
                    <td><a href="AtivarExercicio?idexercicio=<%=exercicio.getIdExercicio()%>"><input style="width: 60px" type="button" value="Ativar" /></a></td>
                    <% } else if(exercicio.getStatusExercicio().equals("A")){ %>
                    <td><a href="InativarExercicio?idexercicio=<%=exercicio.getIdExercicio()%>"><input style="width: 60px" type="button" value="Inativar" /></a></td>
                    <% } %>
                </tr>
                
                <% } %>
            </tbody>
        </table>
        
            <p><input type="button" onclick="location.href = '/ProjetoEstagio/DadosExercicio'" value="Voltar" /></p>
         
    </body>
</html>
