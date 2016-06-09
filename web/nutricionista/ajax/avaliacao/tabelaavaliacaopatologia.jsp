
<%@page import="br.com.projetoestagio.model.AvaliacaoPatologia"%>
<%@page import="java.util.List"%>
<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Medicamentos adicionados:</label>
<div class=" col-md-6 col-sm-6 col-xs-12">
    <table class="table">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Excluir</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<AvaliacaoPatologia> avaliacaopatologias = (List<AvaliacaoPatologia>) request.getAttribute("avaliacaopatologias");
                for (AvaliacaoPatologia avaliacaopatologia : avaliacaopatologias) {
            %>
            <tr id="trPat<%=avaliacaopatologia.getId_avaliacao_patologia() %>" class="even pointer">
                <td><%=avaliacaopatologia.getPatologia().getNomePatologia()%></td>
                <td><%=avaliacaopatologia.getPatologia().getDescricaoPatologia() %></td>
                <td style="text-align: center"><a href="javascript:$(this).excluirAvaliacaoPatologia('<%=avaliacaopatologia.getId_avaliacao_patologia() %>')">X</a></td>
            </tr>
            <%
                }
            %>


        </tbody>
    </table>
</div>