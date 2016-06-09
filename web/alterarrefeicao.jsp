<%-- 
    Document   : alterarrefeicao
    Created on : 16/07/2015, 09:35:25
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.TipoRefeicao"%>
<%@page import="br.com.projetoestagio.model.Cardapio"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Refeicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <form id="alterarrefeicao" class="contact-form row" name="alterarrefeicao" action="AlterarRefeicao" method="POST">


            <%Refeicao refeicao = (Refeicao) request.getAttribute("refeicao");%> 

            <label> Código </label>
            <input type="text" name="idrefeicao" id="idrefeicao" value="${refeicao.idRefeicao}" readonly  /><br><br>

            <div class="form-group col-md-6"><label> Dia da Refeicao
                    <select id="diarefeicao" name="diarefeicao" >
                        <option value="Domingo" <% if (refeicao.getDiaRefeicao().equals("Domingo")) { %> selected <% } %> >Domingo</option>
                        <option value="Segunda-Feira" <% if (refeicao.getDiaRefeicao().equals("Segunda-Feira")) { %> selected <% } %>  >Segunda-Feira</option>
                        <option value="Terca-Feira" <% if (refeicao.getDiaRefeicao().equals("Terca-Feira")) { %> selected <% } %> >Terça-Feira</option>
                        <option value="Quarta-Feira" <% if (refeicao.getDiaRefeicao().equals("Quarta-Feira")) { %> selected <% } %>  >Quarta-Feira</option>
                        <option value="Quinta-Feira" <% if (refeicao.getDiaRefeicao().equals("Quinta-Feira")) { %> selected  <% } %>  >Quinta-Feira</option>
                        <option value="Sexta-Feira" <% if (refeicao.getDiaRefeicao().equals("Sexta-Feira")) { %> selected <% } %> >Sexta-Feira</option>
                        <option value="Sabado" <% if (refeicao.getDiaRefeicao().equals("Sabado")) { %> selected <% } %>  >Sábado</option>
                    </select>
                </label>

            </div><br>

            <div>
                <label>Status
                    <input type="checkbox" id="statusrefeicao" name="statusrefeicao" <% if (refeicao.getStatusRefeicao().equals("A")) {
                            out.print("checked");
                        };%>>Ativo </label> <br>

            </div>

            <p>

                Cardápio:<select name="idcardapio">
                    <%
                        List<Cardapio> cardapios = (List<Cardapio>) request.getAttribute("cardapios");
                        for (Cardapio cardapio : cardapios) {
                    %>
                    <option value="<%=cardapio.getIdCardapio()%>" <%if (refeicao.getCardapio().getIdCardapio() == cardapio.getIdCardapio()) { %> selected <% }%> > <%=cardapio.getNomeCardapio()%></option><%}%>

                </select>

            </p>

            <p>
                Tipo de Refeicao:<select name="idtiporefeicao">
                    <%
                        List<TipoRefeicao> trefeicao = (List<TipoRefeicao>) request.getAttribute("trefeicao");
                        for (TipoRefeicao tiporefeicao : trefeicao) {
                    %>
                    <option value= " <%= tiporefeicao.getIdTipoRefeicao()%> " <%if (refeicao.getTipoRefeicao().getIdTipoRefeicao() == tiporefeicao.getIdTipoRefeicao()) { %> selected <% }%> > <%=tiporefeicao.getTipoRefeicao()%></option><%  }%>

                </select>  
            </p>



            <input type="submit" id="txt" class="btn btn-primary" value="Alterar"> &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" id="txt" class="btn btn-primary" value="Limpar"> 
        </form>
    </body>
</html>
