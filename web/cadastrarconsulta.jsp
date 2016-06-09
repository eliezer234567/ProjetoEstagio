<%-- 
    Document   : cadastrarconsulta
    Created on : 29/06/2015, 21:13:32
    Author     : Eliezer.L
--%>

<%@page import="br.com.projetoestagio.model.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Nutricionista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Consulta</h1>
        <h3>${sucesso}</h3>
        <form id="cadastroconsulta" name="cadastroconsulta" action="CadastrarConsulta" method="POST">
            <p><input type="text" placeholder="Data da Consulta" onfocus="(this.type = 'date')" id="dataConsulta" name="dataConsulta"  required="required" ></p>
            <p><input type="text" placeholder="Hora da Consulta" onfocus="(this.type = 'time')" id="dataConsulta" name="horaConsulta"  required="required" ></p>
            <p><label>Conduta Nutricional<br><textarea name="condutaNutricionalConsulta" rows="6" cols="60" id="condutaNutricionalConsulta"></textarea></label>
            <p><label>Observação<br><textarea name="obsConsulta" rows="6" cols="60" id="obsConsulta"></textarea></label>            
            <header>Paciente</header>
            <select name="idPaciente" > 
                <option>Selecione</option>
                <%
                    List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
                    for (Paciente paciente : pacientes) {
                %>
                <option value = "<%= paciente.getIdPaciente()%>"><%=paciente.getNomePessoa()%></option> 
                <%}%>
            </select> <br><br>

            <header>Nutricionista</header>
            <select name="idNutricionista" > 
                <option>Selecione</option>
                <%
                    List<Nutricionista> nutricionistas = (List<Nutricionista>) request.getAttribute("nutricionistas");
                    for (Nutricionista nutricionista : nutricionistas) {
                %>
                <option value = "<%= nutricionista.getIdNutricionista()%>"><%=nutricionista.getNomePessoa()%></option> 
                <%}%>
            </select> <br><br>

            <input type="submit" value="Cadastrar" name="cadastrar" />
            <input type="reset" value="Limpar" name="limpar" />   

        </form>
    </body>
</html>

