<%-- 
    Document   : medicamentosuplemento
    Created on : 22/07/2015, 20:50:36
    Author     : Grazy Martins
--%>

<%@page import="br.com.projetoestagio.model.MedicamentoSuplemento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>

        <h1 style="color: darkred; font-weight: bold; font-size: 40px">:D Lista de Medicamentos / Suplementos =></h1>
        <h4 style="color: blue; font-size: 20px">${sucesso}</h4>

        <table border="1" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome Medicamento ou Suplemento</th>
                    <th>Tipo do Medicamento/Suplemento</th>
                    <th>Sincronização</th>
                    <th>Status</th>
                    <th colspan="3">Editar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<MedicamentoSuplemento> medicamentos=(List<MedicamentoSuplemento>)request.getAttribute("medicamentos");
                    for(MedicamentoSuplemento medicamentosuplemento: medicamentos){           
                %>

                <tr>
                    <td><%=medicamentosuplemento.getIdMedicamentoSuplemento()%></td>
                    <td><%=medicamentosuplemento.getNomeMedicamentoSuplemento() %></td>
                    <td><%=medicamentosuplemento.getTipoMedicamentoSuplemento()%></td>
                    <td><%=medicamentosuplemento.getSincronizaMedicamentoSuplemento()%></td>
                    <td><%=medicamentosuplemento.getStatusMedicamentoSuplemento()%></td>

                    <td><a href="CarregarMedicamentoSuplemento?idmedicamentosuplemento=<%=medicamentosuplemento.getIdMedicamentoSuplemento()%>"><input type="button" value="Alterar"</a></td>
                    <td><a href="AtivarMedicamentoSuplemento?idmedicamentosuplemento=<%=medicamentosuplemento.getIdMedicamentoSuplemento() %>"><input type="button" value="Ativar"</a></td>
                    <td><a href="InativarMedicamentoSuplemento?idmedicamentosuplemento=<%=medicamentosuplemento.getIdMedicamentoSuplemento()%>"><input type="button" value="Inativar"</a></td>
                </tr>

                <% } %>
            </tbody>
        </table>

        <p><input type="button" onclick="location.href = '/ProjetoEstagio/cadastrarmedicamentosuplemento.jsp'" value="Voltar" /></p>

    </body>
</html>
