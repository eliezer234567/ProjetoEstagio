<%-- 
    Document   : alterarevolucaopaciente
    Created on : 06/01/2016, 17:23:54
    Author     : Leticia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nutricionista </title>

        <!-- Bootstrap core CSS -->

        <script src="assets/js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="assets/js/validate.js" type="text/javascript"></script>
        <script src="assets/js/messages_es.js" type="text/javascript"></script>

        <script src="../assets/js/validacao.js" type="text/javascript"></script>
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
                        <div class="page-title">
                            <div class="title_left">
                                <h3></h3>
                            </div>

                            <div class="title_right">
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>

                        <div class="row">

                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel" style="height:600px;">
                                    <div class="x_title">
                                        <h2>Cadastrar Alimento</h2>
                                     
                                        <div class="clearfix"></div>

                                        <form id="alterarevolucaopaciente" name="alterarevolucaopaciente" class="form-horizontal form-label-left"  action="..\\AlterarEvolucaoPaciente" method="POST">

                                            <input type="hidden" value="">
                                          
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Id <span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" class="form-control" step="0.01" value="${evolucaopaciente.idEvolucaoPaciente }" id="idevolucaopaciente" name="idevolucaopaciente" readonly="">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Peso <span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" class="form-control" step="0.01" value="${evolucaopaciente.pesoEvolucaoPaciente}" id="pesoevolucaopaciente" name="pesoevolucaopaciente">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Altura<span class="required">*</span> </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">

                                                    <input type="number" class="form-control" value="${evolucaopaciente.alturaEvolucaoPaciente}"  step="0.01"  id="alturaevolucaopaciente" name="alturaevolucaopaciente" required="">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Circunferêcia do Punho <span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" step="0.01" class="form-control" value="${evolucaopaciente.circunCinturaEvolucaoPaciente}"   id="circunpunhoevolucaopaciente" name="circunpunhoevolucaopaciente" required="">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Circunferência da Cintura<span class="required">*</span>
                                                </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" step="0.01" class="form-control" value="${evolucaopaciente.circunPunhoEvolucaoPaciente}" id="circuncinturaevolucaopaciente" name="circuncinturaevolucaopaciente" required="">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Circunferência do Quadril</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" step="0.01" class="form-control" value="${evolucaopaciente.circunQuadrilEvolucaoPaciente}"  id="circunquadrilevolucaopaciente" name="circunquadrilevolucaopaciente" required="">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Dobras Cutaneas</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" class="form-control" step="0.01" value="${evolucaopaciente.dobrasCutaneasEvolucaoPaciente}"  id="dobrascutaneasevolucaopaciente" name="dobrascutaneasevolucaopaciente">
                                                </div>
                                            </div>



                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                    <button type="button" class="btn btn-primary">Cancelar</button>
                                                    <button type="submit" class="btn btn-success" >Adicionar</button>

                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

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

        <!-- image cropping -->
        <script src="../production/js/cropping/cropper.min.js"></script>
        <script src="../production/js/cropping/main.js"></script>


        <!-- daterangepicker -->
        <script type="text/javascript" src="../production/js/moment.min.js"></script>
        <script type="text/javascript" src="../production/js/datepicker/daterangepicker.js"></script>
        <!-- moris js -->
        <script src="../production/js/moris/raphael-min.js"></script>
        <script src="../production/js/moris/morris.js"></script>
        ${script}
    </body>
</html>