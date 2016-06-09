<%-- 
    Document   : cadastrarfrequenciaalimentar1
    Created on : 24/01/2016, 12:33:54
    Author     : Bruna Nobre
--%>

<%@page import="br.com.projetoestagio.model.FrequenciaAlimentar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>${sucesso}</h2>
        <form id="alterarfrequenciaalimentar" name="alterarfrequenciaalimentar" action="AlterarFrequenciaAlimentar" method="POST">

            <input type="number" id="idFrequenciaAlimentar" name="idFrequenciaAlimentar" readonly="" value="${frequenciaalimentar.idFrequenciaAlimentar}" />



            <% FrequenciaAlimentar frequenciaalimentar = (FrequenciaAlimentar) request.getAttribute("frequenciaalimentar");%>
            <p><label> Fruta </label></p>         
            <input type="radio" id="frutafrequenciaalimentar" value="DF" name="frutaFrequenciaAlimentar" <% if (frequenciaalimentar.getFrutaFrequenciaAlimentar().equals("Diariamente")) {
                             out.print("checked");
            };%> >Diariamente<br>
            <input type="radio" id="frutafrequenciaalimentar" value="VF" name="frutaFrequenciaAlimentar" <% if (frequenciaalimentar.getFrutaFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="frutafrequenciaalimentar" value="FF" name="frutaFrequenciaAlimentar" <% if (frequenciaalimentar.getFrutaFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="frutafrequenciaalimentar" value="RF" name="frutaFrequenciaAlimentar" <% if (frequenciaalimentar.getFrutaFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Verdura </label></p>
            <input type="radio" id="verdurafrequenciaalimentar" value="DV" name="verdurasFrequenciaAlimentar" <% if (frequenciaalimentar.getVerdurasFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="verdurafrequenciaalimentar" value="VV" name="verdurasFrequenciaAlimentar" <% if (frequenciaalimentar.getVerdurasFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="verdurafrequenciaalimentar" value="FV" name="verdurasFrequenciaAlimentar" <% if (frequenciaalimentar.getVerdurasFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="verdurafrequenciaalimentar" value="RV" name="verdurasFrequenciaAlimentar" <% if (frequenciaalimentar.getVerdurasFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Legume </label></p>
            <input type="radio" id="legumefrequenciaalimentar" value="DL" name="legumesFrequenciaAlimentar" <% if (frequenciaalimentar.getLegumesFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="legumefrequenciaalimentar" value="VL" name="legumesFrequenciaAlimentar" <% if (frequenciaalimentar.getLegumesFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="legumefrequenciaalimentar" value="FL" name="legumesFrequenciaAlimentar" <% if (frequenciaalimentar.getLegumesFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="legumefrequenciaalimentar" value="RL" name="legumesFrequenciaAlimentar" <% if (frequenciaalimentar.getLegumesFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Carne Vermelha </label></p>
            <input type="radio" id="carnevermelhafrequenciaalimentar" value="DCV" name="carnevermelhaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar().equals("Diariamente")) {
                             out.print("checked");
                         };%> >Diariamente<br>
            <input type="radio" id="carnevermelhafrequenciaalimentar" value="VCV" name="carnevermelhaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="carnevermelhafrequenciaalimentar" value="FCV" name="carnevermelhaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="carnevermelhafrequenciaalimentar" value="RCV" name="carnevermelhaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Carne Branca </label></p>
            <input type="radio" id="carnebrancafrequenciaalimentar" value="DCB" name="carnebrancaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnebrancaFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="carnebrancafrequenciaalimentar" value="VCB" name="carnebrancaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnebrancaFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="carnebrancafrequenciaalimentar" value="FCB" name="carnebrancaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnebrancaFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="carnebrancafrequenciaalimentar" value="RCB" name="carnebrancaFrequenciaAlimentar" <% if (frequenciaalimentar.getCarnebrancaFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Leite </label></p>
            <input type="radio" id="leitefrequenciaalimentar" value="DLE" name="leitederivadosFrequenciaAlimentar" <% if (frequenciaalimentar.getLeitederivadosFrequenciaAlimentar().equals("Diariamente")) {
                             out.print("checked");
                         };%> >Diariamente<br>
            <input type="radio" id="leitefrequenciaalimentar" value="VLE" name="leitederivadosFrequenciaAlimentar" <% if (frequenciaalimentar.getLeitederivadosFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="leitefrequenciaalimentar" value="FLE" name="leitederivadosFrequenciaAlimentar" <% if (frequenciaalimentar.getLeitederivadosFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="leitefrequenciaalimentar" value="RLE" name="leitederivadosFrequenciaAlimentar" <% if (frequenciaalimentar.getLeitederivadosFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Ovos</label></p>
            <input type="radio" id="ovosfrequenciaalimentar" value="DO" name="ovosFrequenciaAlimentar" <% if (frequenciaalimentar.getOvosFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="ovosfrequenciaalimentar" value="VO" name="ovosFrequenciaAlimentar" <% if (frequenciaalimentar.getOvosFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="ovosfrequenciaalimentar" value="FO" name="ovosFrequenciaAlimentar" <% if (frequenciaalimentar.getOvosFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="ovosfrequenciaalimentar" value="RO" name="ovosFrequenciaAlimentar" <% if (frequenciaalimentar.getOvosFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Cereais</label></p>
            <input type="radio" id="cereaisfrequenciaalimentar" value="DC" name="cereaisFrequenciaAlimentar" <% if (frequenciaalimentar.getCereaisFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="cereaisfrequenciaalimentar" value="VC" name="cereaisFrequenciaAlimentar" <% if (frequenciaalimentar.getCereaisFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="cereaisfrequenciaalimentar" value="FC" name="cereaisFrequenciaAlimentar" <% if (frequenciaalimentar.getCereaisFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="cereaisfrequenciaalimentar" value="RC" name="cereaisFrequenciaAlimentar" <% if (frequenciaalimentar.getCereaisFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Massas </label></p>
            <input type="radio" id="massafrequenciaalimentar" value="DM" name="massasFrequenciaAlimentar" <% if (frequenciaalimentar.getMassasFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="massafrequenciaalimentar" value="VM" name="massasFrequenciaAlimentar" <% if (frequenciaalimentar.getMassasFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="massafrequenciaalimentar" value="FM" name="massasFrequenciaAlimentar" <% if (frequenciaalimentar.getMassasFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="massafrequenciaalimentar" value="RM" name="massasFrequenciaAlimentar" <% if (frequenciaalimentar.getMassasFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Leguminosos </label></p>
            <input type="radio" id="leguminosasfrequenciaalimentar" value="DLEG" name="leguminosasFrequenciaAlimentar" <% if (frequenciaalimentar.getLeguminosasFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="leguminosasfrequenciaalimentar" value="VLEG" name="leguminosasFrequenciaAlimentar" <% if (frequenciaalimentar.getLeguminosasFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="leguminosasfrequenciaalimentar" value="FLEG" name="leguminosasFrequenciaAlimentar" <% if (frequenciaalimentar.getLeguminosasFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="leguminosasfrequenciaalimentar" value="RLEG" name="leguminosasFrequenciaAlimentar" <% if (frequenciaalimentar.getMassasFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Pães </label></p>
            <input type="radio" id="paesfrequenciaalimentar" value="DP" name="paesFrequenciaAlimentar" <% if (frequenciaalimentar.getPaesFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="paesfrequenciaalimentar" value="VP" name="paesFrequenciaAlimentar" <% if (frequenciaalimentar.getPaesFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="paesfrequenciaalimentar" value="FP" name="paesFrequenciaAlimentar" <% if (frequenciaalimentar.getPaesFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="paesfrequenciaalimentar" value="RP" name="paesFrequenciaAlimentar" <% if (frequenciaalimentar.getPaesFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Doces </label></p>
            <input type="radio" id="docesfrequenciaalimentar" value="DD" name="docesFrequenciaAlimentar" <% if (frequenciaalimentar.getDocesFrequenciaAlimentar().equals("Diariamente")) {
                              out.print("checked");
                          };%> >Diariamente<br>
            <input type="radio" id="docesfrequenciaalimentar" value="VD" name="docesFrequenciaAlimentar" <% if (frequenciaalimentar.getDocesFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="docesfrequenciaalimentar" value="FD" name="docesFrequenciaAlimentar" <% if (frequenciaalimentar.getDocesFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="docesfrequenciaalimentar" value="RD" name="docesFrequenciaAlimentar" <% if (frequenciaalimentar.getDocesFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Refrigerante</label></p>
            <input type="radio" id="refrigerantefrequenciaalimentar" value="DR" name="refrigeranteFrequenciaAlimentar" <% if (frequenciaalimentar.getRefrigeranteFrequenciaAlimentar().equals("Diariamente")) {
                                     out.print("checked");
                                 };%> >Diariamente<br>
            <input type="radio" id="refrigerantefrequenciaalimentar" value="VR" name="refrigeranteFrequenciaAlimentar" <% if (frequenciaalimentar.getRefrigeranteFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="refrigerantefrequenciaalimentar" value="FR" name="refrigeranteFrequenciaAlimentar" <% if (frequenciaalimentar.getRefrigeranteFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="refrigerantefrequenciaalimentar" value="RR" name="refrigeranteFrequenciaAlimentar" <% if (frequenciaalimentar.getRefrigeranteFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Alcool </label></p>
            <input type="radio" id="alcoolfrequenciaalimentar" value="DA" name="alcoolFrequenciaAlimentar" <% if (frequenciaalimentar.getAlcoolFrequenciaAlimentar().equals("Diariamente")) {
                             out.print("checked");
                         };%> >Diariamente<br>
            <input type="radio" id="alcoolfrequenciaalimentar" value="VA" name="alcoolFrequenciaAlimentar" <% if (frequenciaalimentar.getAlcoolFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="alcoolfrequenciaalimentar" value="FA" name="alcoolFrequenciaAlimentar" <% if (frequenciaalimentar.getAlcoolFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="alcoolfrequenciaalimentar" value="RA" name="alcoolFrequenciaAlimentar" <% if (frequenciaalimentar.getAlcoolFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><label> Gordurosos </label></p>
            <input type="radio" id="gordurososfrequenciaalimentar" value="DG" name="gordurososFrequenciaAlimentar" <% if (frequenciaalimentar.getGordurososFrequenciaAlimentar().equals("Diariamente")) {
                             out.print("checked");
                         };%> >Diariamente<br>
            <input type="radio" id="gordurososfrequenciaalimentar" value="VG" name="gordurososFrequenciaAlimentar" <% if (frequenciaalimentar.getGordurososFrequenciaAlimentar().equals("3 vezes por semana")) {
                           out.print("checked");
                       };%> >3 vezes por Semana<br>
            <input type="radio" id="gordurososfrequenciaalimentar" value="FG" name="gordurososFrequenciaAlimentar" <% if (frequenciaalimentar.getGordurososFrequenciaAlimentar().equals("Final de semana")) {
                               out.print("checked");
                           };%> >Final de Semana<br>
            <input type="radio" id="gordurososfrequenciaalimentar" value="RG" name="gordurososFrequenciaAlimentar" <% if (frequenciaalimentar.getGordurososFrequenciaAlimentar().equals("Raramente")) {
                               out.print("checked");
                           };%> >Raramente<br>

            <p><input type="submit" value="Alterar"</p>
            <p><input type="reset" value="Limpar"</p>
    </body>
</html>
