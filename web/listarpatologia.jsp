<%-- 
    Document   : ListarPatologia
    Created on : 02/08/2015, 13:09:56
    Author     : princesinha
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Patologia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Patologia</title>
    </head>
    <body>
        <table border="4" align="center">
            <thead>
                <tr>
            <h3 align="center">Lista de Patologia Cadastrados</h3>
        </tr>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descricao</th>
            <th>Historico Familia</th>
            <th>Status</th>
            <th colspan="2">Opção</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Patologia> patologias = (List<Patologia>) request.getAttribute("patologias");
            for (Patologia patologia : patologias) {
                          
        %>
        <tr>
            <td><%= patologia.getIdPatologia()%> </td>
            <td><%= patologia.getNomePatologia()%> </td>
            <td><%= patologia.getDescricaoPatologia()%> </td>
            <td><%= patologia.getHistoricofamiliaPatologia()%> </td>
            <td><%= patologia.getStatusPatologia()%> </td>
            <td><a href="CarregarPatologia?idPatologia=<%=patologia.getIdPatologia()%>">Alterar</a></td>
            <% 
            String statusNovo = "";
            String statusBotao = "";
            if(patologia.getStatusPatologia().equals("A")){
                statusNovo = "I";
                statusBotao = "Inativar";
            }else if(patologia.getStatusPatologia().equals("I")){
                statusNovo = "A";
                statusBotao = "Ativar";
            }else{
                statusBotao = "";
            }
            %>
            <td><a href="InativarPatologia?idpatologia=<%=patologia.getIdPatologia()%>&status=<%=statusNovo %>"><%=statusBotao%></a></td>

        </tr>
        <%  }%>

    </tbody>
</table>
<p><input type="button" onclick="location.href = '/ProjetoEstagio/cadastrarpatologia.jsp'" value="Voltar" /></p>
</body>
</html>
