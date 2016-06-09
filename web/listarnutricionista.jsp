<%-- 
    Document   : listarnutricionista
    Created on : 25/06/2015, 23:37:09
    Author     : usuario
--%>

<%@page import="br.com.projetoestagio.model.Nutricionista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Nutricionista</h1>
        <h2>${sucesso}</h2>
        <table>
            <thead>
                <tr>
                    <th>Id Pessoa</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>Telefone</th>
                    <th>Id Nutricionista</th>
                    <th>CRN</th>
                    <th>Status</th>
                    <th colspan="2">Editar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Nutricionista> lista = (List<Nutricionista>) request.getAttribute("lista");
                    for (Nutricionista nutricionista : lista) {
                %>
                <tr>
                    <td><%=nutricionista.getIdPessoa()%></td>
                    <td><%=nutricionista.getNomePessoa()%></td>
                    <td><%=nutricionista.getEmailPessoa()%></td>
                    <td><%=nutricionista.getSenhaPessoa()%></td>
                    <td><%=nutricionista.getTelefonePessoa()%></td>
                    <td><%=nutricionista.getIdNutricionista()%></td>
                    <td><%=nutricionista.getCrnNutricionista()%></td>
                    <td><%=nutricionista.getStatusPessoa()%></td>
                    <td><a href="AtivarNutricionista?idPessoa=<%=nutricionista.getIdPessoa()%>"><input type="button" value="Ativar"</a></td>
                    <td><a href="InativarNutricionista?idPessoa=<%=nutricionista.getIdPessoa()%>"><input type="button" value="Inativar"></a></td> 
                    <td><a href="CarregarNutricionista?idPessoa=<%=nutricionista.getIdPessoa()%>">Alterar</a></td>

                </tr>
                <%
                    }
                %>
            </tbody>           
            <a <button href="cadastrarnutricionista.jsp">Cadastrar novo Nutricionista</button></a> &nbsp;&nbsp;&nbsp;&nbsp;
        </table>
    </body>
</html>
