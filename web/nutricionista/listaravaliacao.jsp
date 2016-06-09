<%-- 
    Document   : cadastraravaliacao
    Created on : 22/05/2016, 16:31:05
    Author     : Grazy
--%>

<%@page import="br.com.projetoestagio.model.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nutricionista </title>

        <!-- Bootstrap core CSS -->

        <link href="../production/css/bootstrap.min.css" rel="stylesheet">

        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">


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
                            <div class="x_panel" style="height: inherit;">
                                <div class="x_title">
                                    <h2>Avaliações Cadastradas</h2>
                                    <div class="clear"></div>
                                    <label style="color: blue">${msg}</label>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Paciente</th>
                                                <th>Meta</th>
                                                <th>Peso Desej</th>
                                                <th>Colest.</th>
                                                <th>Trigle.</th>
                                                <th>Diab.</th>
                                                <th>Fuma?</th>
                                                <th>Data da Avaliação</th>
                                                <th>Status</th>
                                                <th colspan="3">#</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                                <%
                                                    List<Avaliacao> avaliacoes = (List<Avaliacao>) request.getAttribute("avaliacoes");
                                                    for (Avaliacao avaliacao : avaliacoes) {
                                                %>
                                                <tr class="even pointer">
                                                    <td class="a-center "><%=avaliacao.getIdAvaliacao()%></td>                                                    
                                                    <td><%=avaliacao.getConsulta().getPaciente().getNomePessoa() %></td>                                                    
                                                    <td><%=avaliacao.getMetaAvaliacao()%></td>
                                                    <td><%=avaliacao.getPesoDesejavelAvaliacao()%></td>
                                                    <td><%=avaliacao.getColesterol()%></td>
                                                    <td><%=avaliacao.getTrigliceridios()%></td>
                                                    <td><%=avaliacao.getDiabetes()%></td>
                                                    <td><% if(avaliacao.getFumaAvaliacao()){ out.print("Sim");}else{out.print("Não");} %></td>
                                                    <td><%=avaliacao.getDataAvaliacao() %></td>
                                                    <td><%=avaliacao.getStatusAvaliacao() %></td>
                                                    <td><a href="#"></a>
                                                        <div class="btn-group">
                                                            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle btn-sm" type="button"> ... <span class="caret"></span> </button>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="AlterarAvaliacao?idavaliacao=<%=avaliacao.getIdAvaliacao()%>">Detalhes</a>
                                                                </li>
                                                                <li><a href="InativarAvaliacao?status=I&idavaliacao=<%=avaliacao.getIdAvaliacao()%>">Inativar</a>
                                                                </li>
                                                                <li><a href="InativarAvaliacao?status=A&idavaliacao=<%=avaliacao.getIdAvaliacao()%>">Ativar</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                    </table>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Inicio modal erro paciente -->
                    <div class="modal fade bs-example-modalParaDiferenciarDeOutroModal-sm" id="erroConsulta" tabindex="-1" role="dialog" aria-hidden="true">
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
                    <!--Fim modal erro paciente -->

                    <!-- footer content -->
                    <footer>
                        <div class="">
                            <p class="pull-right">
                                <span class="lead"> <i class="fa fa-paw"></i> NutriSIS</span>
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

        <!-- image cropping -->
        <script src="../production/js/cropping/cropper.min.js"></script>
        <script src="../production/js/cropping/main.js"></script>


        <!-- daterangepicker -->
        <script type="text/javascript" src="../production/js/moment.min.js"></script>
        <script type="text/javascript" src="../production/js/datepicker/daterangepicker.js"></script>
        <!-- moris js -->
        <script src="../production/js/moris/raphael-min.js"></script>
        <script src="../production/js/moris/morris.js"></script>

        <!-- -->
        ${script}
    </body>
</html>