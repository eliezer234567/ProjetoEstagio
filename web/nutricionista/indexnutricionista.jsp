<%-- 
    Document   : listarpaciente
    Created on : 06/04/2016, 21:42:07
    Author     : eliez
--%>

<%@page import="br.com.projetoestagio.util.Conversoes"%>
<%@page import="br.com.projetoestagio.model.Consulta"%>
<%@page import="br.com.projetoestagio.model.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (session.getAttribute("id")!=null){
    

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nutricionista</title>
        <link href="../production/css/bootstrap.min.css" rel="stylesheet">

        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">
        <link href="../production/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">


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
                                        <h2>Consultas Agendadas</h2>
                                     
                                        <div class="clearfix"></div>
                                    </div>
                                    <!-- Scroll horizontal para tabela primeira div ---->
                                    <div style="widows: auto; overflow-x: scroll; overflow-y: hidden; white-space: nowrap" class="x_content">
                                        <table id="example" class="table table-striped responsive-utilities jambo_table">
                                            <thead>
                                                <tr class="headings">
                                                    <th>

                                                    </th>
                                                    <th>Nome Do Paciente </th>
                                                    <th>Data </th>
                                                    <th>Hora </th>
                                                    <th class=" no-link last"><span class="nobr">Status</span>
                                                    </th>
                                                    <th class=" no-link last"><span class="nobr">Mais</span>
                                                    </th>

                                                </tr>
                                            </thead>

                                            <tbody>
                                                <%
                                                    Conversoes conv = new Conversoes();
                                                    List<Consulta> lista = (List<Consulta>) request.getAttribute("lista");
                                                    for (Consulta consulta : lista) {
                                                %>
                                                <tr class="even pointer">
                                                    <td class="a-center ">
                                                    </td>
                                                    <td><%=consulta.getPaciente().getNomePessoa()%></td>
                                                    <td><%=conv.converterDataBr(consulta.getDataConsulta())%></td>
                                                    <td><%=consulta.getHoraConsulta()%></td>

                                                    <td><a href="#"></a>
                                                        <div class="btn-group">
                                                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button">Status <span class="caret"></span> </button>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="CarregarConsulta?idConsulta=<%= consulta.getIdConsulta()%>">Adiar</a>
                                                                </li>
                                                                <li><a href="AlterarStatusConsulta?idConsulta=<%=consulta.getIdConsulta()%>">Cancelar</a>
                                                                </li>
                                                                <li><a href="AlterarStatusConsultaFinalizada?idConsulta=<%=consulta.getIdConsulta()%>">Realizada</a>
                                                                </li>



                                                            </ul>
                                                        </div>
                                                    </td>
                                                    <td><a href="#"></a>
                                                        <div class="btn-group">
                                                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button">Detalhes <span class="caret"></span> </button>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="CarregarDadosConsulta?idConsulta=<%= consulta.getIdConsulta()%>">Consulta</a>
                                                                </li>
                                                              
                                                            </ul>
                                                        </div>
                                                    </td>
                                            <!--<a href="CarregarPaciente?idPessoa=<%=consulta.getIdConsulta()%>"><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button></a>-->


                                                </tr>
                                                <%
                                                    }
                                                %>


                                            </tbody>

                                        </table>


                                        <!--Inicio modal erro alterar consulta -->
                                        <div class="modal  bs-example-modalParaDiferenciarDeOutroModal-sm" id="erroAlterarConsultaModal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog modal-sm">
                                                <div class="modal-content">

                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                                        </button>
                                                        <h4 class="modal-title" id="myModalLabel2">Mensagem</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <h4>${erroAlterarConsulta}</h4>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <!--Fim modal erro alterar consulta -->


                                    </div>
                                </div>
                            </div>

                            <br />
                            <br />
                            <br />

                        </div>
                    </div>
                    <!--Inicio modal CarregarConsulta para adiar consulta -->
                    <div class="modal bs-example-modal-lg" tabindex="-1" id="ModalCarregarConsulta" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <form id="alteraconsuolta"  name="alteraconsulta" action="AlterarConsulta" method="POST" data-parsley-validate class="form-horizontal form-label-left">

                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">Agende uma nova consulta</h4>
                                    </div>
                                    <div class="modal-body">


                                        <br />

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nome do Paciente <span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" value="${consulta.getPaciente().nomePessoa}" readonly="" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Telefone do Paciente <span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" value="${consulta.getPaciente().telefonePessoa}" readonly="" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>


                                        <div class="form-group" hidden="">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">ID <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" value="${consulta.idConsulta}"  id="idConsulta" name="idConsulta" placeholder="ID" required="required" readonly="" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Data <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="date" value="${consulta.dataConsulta}" id="dataConsulta" name="dataConsulta" placeholder="Nome" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Horário <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="time" value="${consulta.horaConsulta}" id="horaConsulta" name="horaConsulta" placeholder="E-mail" required="required"  class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                        <a><button type="submit" class="btn btn-primary">Salvar</button></a>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                    <!--Fim modal CarregarConsulta para reagendar consulta -->

                    <!--Inicio modal cadastro de consulta -->
                    <div class="modal fade bs-example-modalParaDiferenciarDeOutroModal-sm" id="erroCadastro" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel2">Mensagem</h4>
                                </div>
                                <div class="modal-body">
                                    <h4>${mensagem}</h4>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!--Fim modal cadastro de consulta -->
                    <!-- footer content -->
                    <footer>
                        <div class="">
                            <p class="pull-right">
                                <span class="lead"> NutriSIS</span>
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
<% }else{
    response.sendRedirect(request.getContextPath()+("/index.jsp"));
}
%>