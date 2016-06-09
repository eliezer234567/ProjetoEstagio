<%@page import="br.com.projetoestagio.model.Avaliacao"%>
<%@page import="java.util.List"%>
<label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Medicamentos adicionados:</label>
<div class=" col-md-6 col-sm-6 col-xs-12">
    <table class="table">
        <thead>
            <tr>
                <th>Descrição</th>
                <th>Status</th>
                <th>Excluir</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Avaliacao> avaliacoes = (List<Avaliacao>) request.getAttribute("medicamentos");
                for (Avaliacao avaliacao : avaliacoes) {
            %>
            <tr class="even pointer">
                <td><%=avaliacao.getMedicamentoSuplemento().getNomeMedicamentoSuplemento() %></td>
                <td><%=avaliacao.getMedicamentoSuplemento().getTipoMedicamentoSuplemento()%></td>
                <td><a href="#">X</a></td>
            </tr>
            <%
                }
            %>


        </tbody>
    </table>
</div>