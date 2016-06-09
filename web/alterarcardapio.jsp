<%-- 
    Document   : alterarcardapio
    Created on : 30/06/2015, 12:40:42
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.Cardapio"%>
<%@page import="br.com.projetoestagio.model.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <h3>${sucesso}</h3>
        <form id="alterarcardapio" class="contact-form row" name="alterarcardapio" action="AlterarCardapio" method="POST">


            <div class="form-group col-md-6">
                <label> Código
                    <input type="text" name="idcardapio" class="form-control" id="idcardapio" size="5" value="${cardapio.idCardapio}" readonly  required="required" /><br><br>
                </label>
            </div>



            <div class="form-group col-md-6">
                <label> Tipo do Cardápio
                    <input type="text" name="tipocardapio" class="form-control" id="tipocardapio"  size="5" value="${cardapio.tipoCardapio}"   required="required" placeholder="Tipo do cardapio" /><br><br>
                </label>
            </div>
            <div class="form-group col-md-6">
                <label> Nome do Cardápio
                    <input type="text" id="nomecardapio" name="nomecardapio" class="form-control" size="5" value="${cardapio.nomeCardapio}" required="required" placeholder="Nome cardapio" /><br><br>
                </label>
            </div>


            <div class="form-group col-md-6" >
                <label>Observação do Cardápio
                    <input type="text" id="observacaocardapio" name="observacaocardapio" size="5" value="${cardapio.observacaoCardapio}" class="form-control" required="required" placeholder="Observações sobre cardápio"><br>
                </label>
            </div><br>


            <div class="form-group col-md-6">
                <label>Data do Inicio do Cardápio
                    <input type="date" id="datainiciocardapio" value="${cardapio.dataInicioCardapio}" name="datainiciocardapio" class="form-control" required="required"  /><br><br>
                </label>
            </div>

            <div class="form-group col-md-6">
                <label>Data Final do Cardápio
                    <input type="date" id="datafinalcardapio" value="${cardapio.dataFinalCardapio}"  name="datafinalcardapio" class="form-control"  required="required" /><br><br>
                </label>
            </div>

            <%Cardapio cardapio = (Cardapio) request.getAttribute("cardapio");%> 

            <label>Status<input type="checkbox" id="statuscardapio" name="statuscardapio" <% if (cardapio.getStatusCardapio().equals("A")) {
                    out.print("checked");
            }; %>> Ativo</label></br><br>

            Nome do Paciente:<select name="idpaciente">
                <%
                    List<Paciente> lista = (List<Paciente>) request.getAttribute("lista");
                    for (Paciente paciente : lista) {
                %>
                <option value= "<%= paciente.getIdPaciente()%>" <% if (cardapio.getPaciente().getIdPaciente() == paciente.getIdPaciente()) {%>selected <%}%>> <%=paciente.getNomePessoa()%></option><%}%>


            </select><br><br>


            <input type="submit" id="txt" class="btn btn-primary" value="Alterar"> &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" id="txt" class="btn btn-primary" value="Limpar"> 


        </form>



    </body>
</html>
