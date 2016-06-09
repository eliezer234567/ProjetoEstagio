<%-- 
    Document   : alterarFrequenciaAlimentar
    Created on : 26/07/2015, 14:34:15
    Author     : princesinha
--%>

<%@page import="br.com.projetoestagio.model.Patologia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Alimento</title>
    </head>
    <body>
        <h2>${sucesso}</h2>
        <form id="alterarpatologia" name="alterarpatologia" action="AlterarPatologia" method="POST">

            <input type="number" id="idPatologia" name="idPatologia" readonly="" value="${patologia.idPatologia}" />

            <td>Nome: </td>
            <td><input type="text" name="nomePatologia" class="form-control" size="50" id="nomepatologia"value="${patologia.nomePatologia}" required="required" /></td>
        </tr>
        <tr>
            <td>Descrição: </td>
            <td><input type="text" name="descricaoPatologia" class="form-control" size="50" id="descricaopatologia"value="${patologia.descricaoPatologia}" required="required" /></td>
        </tr>
        <label>Historico</label>
        <input type="text"  name="historicofamiliaPatologia" class="form-control" size="50" id="historicopatologia"value="${patologia.historicofamiliaPatologia}" required="required" />


        <p><input type="submit" value="Alterar"</p>
        <p><input type="reset" value="Limpar"</p>
</body>
</html>
