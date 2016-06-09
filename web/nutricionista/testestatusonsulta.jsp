<%-- 
    Document   : testestatusonsulta
    Created on : 01/05/2016, 20:33:06
    Author     : eliez
--%>

<%@page import="br.com.projetoestagio.model.Consulta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table id="example" class="table table-striped responsive-utilities jambo_table">
            <thead>
                <tr class="headings">
                    <th>

                    </th>
                    <th>Nome Do Paciente </th>
                    <th>Data </th>
                    <th>Hora </th>
                    <th class=" no-link last"><span class="nobr">Status</span>
                    </th>
                    <th class=" no-link last"><span class="nobr">Mais</span>
                    </th>

                </tr>
            </thead>

            <tbody>
                <%
                    List<Consulta> lista = (List<Consulta>) request.getAttribute("lista");
                    for (Consulta consulta : lista) {
                %>
                <tr class="even pointer">
                    <td class="a-center ">
                    </td>
                    <td><%=consulta.getPaciente().getNomePessoa()%></td>
                    <td><%=consulta.getDataConsulta()%></td>
                    <td><%=consulta.getHoraConsulta()%></td>
                    <td><a href="#"></a>
                        <div class="btn-group">
                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button">Status <span class="caret"></span> </button>
                            <ul class="dropdown-menu">
                                <li><a href="AlterarStatusConsulta?idPessoa=<%= consulta.getPaciente().getIdPessoa()%>">Adiar</a>
                                </li>
                                <li value="C"><a href="AlterarStatusConsulta?idConsulta=<%=consulta.getIdConsulta()%>">Cancelar</a>
                                </li>
                                <li value="F"><a href="AlterarStatusConsulta?idConsulta=<%=consulta.getIdConsulta()%>">Finalizar</a>
                                </li>



                            </ul>
                        </div>
                    </td>
                    <td><a href="#"></a>
                        <div class="btn-group">
                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button">Detalhes <span class="caret"></span> </button>
                            <ul class="dropdown-menu">
                                <li><a href="CarregarConsulta?idConsulta=<%=consulta.getIdConsulta()%>">Alterar</a>
                                </li>
                                <li><a href="#">Dropdown link 2</a>
                                </li>
                                <li><a href="#">Dropdown link 3</a>
                                </li>
                            </ul>
                        </div>
                    </td>
            <!--<a href="CarregarPaciente?idPessoa=<%=consulta.getIdConsulta()%>"><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button></a>-->


                </tr>
                <%
                    }
                %>


            </tbody>

        </table>
    </body>
</html>
