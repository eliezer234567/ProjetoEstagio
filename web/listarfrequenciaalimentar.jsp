<%-- 
    Document   : listarFrequenciaAlimentar
    Created on : 27/07/2015, 20:13:05
    Author     : princesinha
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.FrequenciaAlimentar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Frequencia Alimentar</title>
    </head>
    <body>
        <table border="4" align="center">
            <thead>
                <tr>
            <h3 align="center">Lista de Frequencia Alimentar Cadastrados</h3>
        </tr>
        <tr>
            <th>ID</th>
            <th>Fruta</th>
            <th>Verdura</th>
            <th>Legumes</th>
            <th>Carne Vermelha</th>
            <th>Carne Branca</th>
            <th>Leite</th>
            <th>Ovos</th>
            <th>Cereais</th>
            <th>Massas</th>
            <th>Leguminosas</th>
            <th>Paes</th>
            <th>Doce</th>
            <th>Refrigerante</th>
            <th>Alcool</th>
            <th>Gordurosos</th>
            <th>Status</th>
            <th colspan="2">Opção</th>

        </tr>
    </thead>
    <tbody>
        <%
            List<FrequenciaAlimentar> frequencias = (List<FrequenciaAlimentar>) request.getAttribute("frequencias");
            for (FrequenciaAlimentar frequenciaalimentar : frequencias) {
                        
        %>
        <tr>
            <td><%= frequenciaalimentar.getIdFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getFrutaFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getVerdurasFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getLegumesFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getCarnebrancaFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getLeitederivadosFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getOvosFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getCereaisFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getMassasFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getLeguminosasFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getPaesFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getDocesFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getRefrigeranteFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getAlcoolFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getGordurososFrequenciaAlimentar()%> </td>
            <td><%= frequenciaalimentar.getStatusFrequenciaAlimentar()%> </td>
            <td><a href="CarregarFrequenciaAlimentar?idFrequenciaAlimentar=<%=frequenciaalimentar.getIdFrequenciaAlimentar()%>">Alterar</a></td>
            <% 
            String statusNovo = "";
            String statusBotao = "";
            if(frequenciaalimentar.getStatusFrequenciaAlimentar().equals("A")){
                statusNovo = "I";
                statusBotao = "Inativar";
            }else if(frequenciaalimentar.getStatusFrequenciaAlimentar().equals("I")){
                statusNovo = "A";
                statusBotao = "Ativar";
            }else{
                statusBotao = "";
            }
            %>
            <td><a href="InativarFrequenciaAlimentar?idFrequenciaAlimentar=<%=frequenciaalimentar.getIdFrequenciaAlimentar()%>&status=<%=statusNovo %>"><%=statusBotao%></a></td>

        </tr>
        <%  }%>

    </tbody>

</table>
<p><input type="button" onclick="location.href = '/ProjetoEstagio/cadastrarfrequenciaalimentar.jsp'" value="Voltar" /></p>
</body>
</html>
