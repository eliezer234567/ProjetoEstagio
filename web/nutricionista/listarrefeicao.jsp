<%-- 
    Document   : listarrefeicao
    Created on : 14/07/2015, 21:38:52
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.AlimentoRefeicao"%>
<%@page import="br.com.projetoestagio.model.Refeicao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../production/css/bootstrap.min.css" rel="stylesheet">

        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">
        <link href="../production/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">
        <link href="../production/less/custom.css" rel="stylesheet" type="text/css"/>

        <script src="../production/js/jquery.min.js"></script>
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="menunutricionista.jsp" %>

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">

                        <div class="clearfix"></div>

                        <div class="row">

                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Cardápios</h2>
                                  
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <table id="example" class="table table-striped responsive-utilities jambo_table">
                                            <thead>
                                                <tr class="headings">
                                                    <th>

                                                    </th>
                                                    <th>Dia da Refeição</th>
                                                    <th>Hora</th>
                                                    <th>Tipo da Refeição</th>
                                                    <th>Alimento</th>
                                                    <th>Tipo Medida</th>
                                                    <th>Quantidade</th>
                                                    <th class=" no-link last"><span class="nobr">Mais</span></th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <%
                                                    List<AlimentoRefeicao> listarefeicao = (List<AlimentoRefeicao>) request.getAttribute("listarefeicao");
                                                    for (AlimentoRefeicao ar : listarefeicao) {
                                                %>
                                                <tr class="even pointer">
                                                    <td class="a-center ">
                                                    </td>
                                                    <td><%= ar.getRefeicao().getDiaRefeicao()%></td>
                                                    <td><%= ar.getRefeicao().getHoraRefeicao()%></td>
                                                    <td><%= ar.getRefeicao().getTipoRefeicao().getTipoRefeicao()%></td>
                                                    <td><%= ar.getAlimento().getNomeAlimento()%></td>
                                                    <td><%= ar.getTipoMedidaAlimentoRefeicao()%></td>
                                                    <td><%= ar.getQuantidadeAlimentoRefeicao()%></td>

                                                    <td><a href="#"></a>
                                                        <div class="btn-group">
                                                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button">Detalhes <span class="caret"></span> </button>
                                                            <ul class="dropdown-menu">
                                                                <%--  <li><a href="CarregarCardapio?idcardapio=<%=cardapio.getIdCardapio()%>">Alterar</a>
                                                                  </li>
                                                                  <li><a href="ListarRefeicaoPorCardapio?idcardapio=<%=cardapio.getIdCardapio()%>">Refeições</a>

                                                                </li> --%>
                                                            </ul>
                                                        </div>
                                                    </td>
                                                    <!--<a href="CarregarPaciente?idPessoa="><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button></a>-->

                                                </tr>

                                                <%
                                                    }
                                                %>


                                            </tbody>

                                        </table>


                                        <!--Inicio modal erro paciente -->
                                        <div class="modal fade bs-example-modalParaDiferenciarDeOutroModal-sm" id="erroAlterarPacienteModal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog modal-sm">
                                                <div class="modal-content">

                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                                        </button>
                                                        <h4 class="modal-title" id="myModalLabel2">Mensagem</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <h4> </h4>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <!--Fim modal erro paciente -->


                                    </div>
                                </div>
                            </div>

                            <br />
                            <br />
                            <br />

                        </div>
                    </div>
                    <!-- footer content -->
                    <footer>
                        <div class="">
                            <p class="pull-right">
                                <span class="lead">  NutriSIS</span>
                            </p>
                        </div>
                        <div class="clearfix"></div>
                    </footer>
                    <!-- /footer content -->

                </div>
                <!-- /page content -->
            </div>
        </div>

        <script src="../production/js/bootstrap.min.js"></script>

        <!-- chart js -->
        <script src="../production/js/chartjs/chart.min.js"></script>
        <!-- bootstrap progress js -->
        <script src="../production/js/progressbar/bootstrap-progressbar.min.js"></script>
        <script src="../production/js/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- icheck -->
        <script src="../production/js/icheck/icheck.min.js"></script>

        <script src="../production/js/custom.js"></script>

        <!-- Datatables -->
        <script src="../production/js/datatables/js/jquery.dataTables.js"></script>
        <script src="../production/js/datatables/tools/js/dataTables.tableTools.js"></script>
        <script>
            $(document).ready(function () {
                $('input.tableflat').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
            });

            var asInitVals = new Array();
            $(document).ready(function () {
                var oTable = $('#example').dataTable({
                    "oLanguage": {
                        "sSearch": "Procurar:"
                    },
                    "aoColumnDefs": [
                        {
                            'bSortable': false,
                            'aTargets': [0]
                        } //disables sorting for column one
                    ],
                    'iDisplayLength': 12,
                    "sPaginationType": "full_numbers",
                    "dom": 'T<"clear">lfrtip',
                    "tableTools": {
                        "sSwfPath": "<?php echo base_url('assets2/js/Datatables/tools/swf/copy_csv_xls_pdf.swf'); ?>"
                    }
                });
                $("tfoot input").keyup(function () {
                    /* Filter on the column based on the index of this element's parent <th> */
                    oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
                });
                $("tfoot input").each(function (i) {
                    asInitVals[i] = this.value;
                });
                $("tfoot input").focus(function () {
                    if (this.className == "search_init") {
                        this.className = "";
                        this.value = "";
                    }
                });
                $("tfoot input").blur(function (i) {
                    if (this.value == "") {
                        this.className = "search_init";
                        this.value = asInitVals[$("tfoot input").index(this)];
                    }
                });
            });
        </script>
        ${script}
    </body>
</html>