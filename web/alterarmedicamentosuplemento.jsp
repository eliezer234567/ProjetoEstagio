<%-- 
    Document   : medicamentosuplemento
    Created on : 23/07/2015, 20:59:07
    Author     : Grazy Martins
--%>

<%@page import="br.com.projetoestagio.model.MedicamentoSuplemento"%>
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
                    <legend>Informações dos Medicamentos/Suplementos</legend>
                    <form id="alterarmedicamentosuplemento" class="formee" name="alterarmedicamentosuplemento" action="AlterarMedicamentoSuplemento" method="post">
                        <label for="sucesso" style="color: red">${sucesso}</label>
                        <p>
                            <label>ID</label>
                            <input style="width: 30px" type="text" value="${medicamentosuplemento.idMedicamentoSuplemento}" readonly="true" name="idmedicamentosuplemento">
                        </p>
                        <p>
                            <label>Nome:</label>
                            <input style="width: 250px" type="text" value="${medicamentosuplemento.nomeMedicamentoSuplemento}" name="nomemedicamentosuplemento" style="display: block">
                        </p>
                        <p>
                            <label>Tipo</label>
                            <input style="width: 100px" type="text" value="${medicamentosuplemento.tipoMedicamentoSuplemento}" name="tipomedicamentosuplemento" style="display: block">
                        </p>

                        <% MedicamentoSuplemento medicamentosuplemento = (MedicamentoSuplemento) request.getAttribute("medicamentosuplemento");%>

                        <label><input type="checkbox" id="statusmedicamentosuplemento" name="statusmedicamentosuplemento" <% if (medicamentosuplemento.getStatusMedicamentoSuplemento().equals("A")) {
                                out.print("checked");
                            }; %> >Ativo</label>


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
