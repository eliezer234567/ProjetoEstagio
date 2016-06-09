<%-- 
    Document   : listartiporefeicao
    Created on : 02/07/2015, 10:46:49
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.TipoRefeicao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <table border="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tipo da Refeição</th>
                    <th>Sincronização</th>
                </tr>
            </thead>
            <%
             List<TipoRefeicao> trefeicao= (List<TipoRefeicao>)request.getAttribute("trefeicao");
             for(TipoRefeicao tiporefeicao: trefeicao){
            %>

            <tbody>
                <tr>     
                    <td><%=tiporefeicao.getIdTipoRefeicao() %></td>
                    <td><%=tiporefeicao.getTipoRefeicao()%></td>
                    <td><%=tiporefeicao.getSincronizaTipoRefeicao()%></td>

                </tr>

                <% } %>
            </tbody>
        </table>
    </body>
</html>
