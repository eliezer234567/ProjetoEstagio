<%-- 
    Document   : cadastrarfrequenciaalimentar
    Created on : 03/04/2016, 18:39:40
    Author     : Letícia
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

        <link href="../production/css/bootstrap.min.css" rel="stylesheet">

        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">
        <script src="../js/cadastraralimento.js" type="text/javascript"></script>


        <script src="../production/js/jquery.min.js"></script>

        <script src="../production/js/validator/validator.js" type="text/javascript"></script>
        <script src="../js/validacoes.js" type="text/javascript"></script>

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


                                        <form id="cadastraralimento" name="cadastraralimento" class="form-horizontal form-label-left" action="" enctype="multipart/form-data" method="POST">
                                            <input type="hidden" value="<%=request.getContextPath()%>" name="caminho"/>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tabela <span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" class="form-control" name="nometabelanutricionala" placeholder="Nome da Tabela"  size="50"  id="nometabelanutricionalalimento" minlength="2" required  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Alimento<span class="required">*</span> </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" class="form-control" id="nomealimento" name="nomea"  placeholder="Nome do Alimento"  maxlength="100" size="50" required  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Tipo<span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" class="form-control" id="tipoalimento" name="tipoa" placeholder="Tipo do Alimento" maxlength="50" size="50" required />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Espécie<span class="required">*</span>
                                                </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" id="especiealimento" class="form-control" placeholder="Espécie do Alimento" name="especiea"  maxlength="50" size="50"  required /> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Proteina</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" id="proteinaalimento" placeholder="Proteina do Alimento" step="0.01" max="1000000" min="0" name="proteinaa" class="form-control" maxlength="1000000"  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Lipideo</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" id="lipideoalimento" step="0.01" placeholder="Quantidade de Lipideo" max="1000000" min="0" name="lipideoalimento" class="form-control" maxlength="1000000"  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Carboidrato</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" id="carboidratoalimento" name="carboidratoalimento" placeholder="Quantidade de Carboidrato" step="0.01" min="0" class="form-control"  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Fibra </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="number" id="fibraalimentaralimento" name="fibraalimentaralimento" placeholder="Quantidade de Fibra Alimentar" step="0.01" min="0" class="form-control"  />

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Imagem</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <div class="form-group col-md-6" >
                                                        <input type="file" id="caminhoimagemalimento" accept="image/jpeg;image/gif;imagem/bmp;image/png" value="C:/" name="caminhoimagemalimento" class="form-control"   />
                                                    </div>


                                                </div>
                                            </div>


                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                    <button type="button" class="btn btn-primary">Cancelar</button>
                                                    <button type="submit" class="btn btn-success" onclick="enviarDados();">Adicionar</button>

                                                </div>
                                            </div>

                                            <div aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="erroAlimento" class="modal">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">                               
                                                        <div class="modal-body">
                                                            <h4>${erroAlimento}</h4>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button data-dismiss="modal" class="btn btn-group-justified" type="button">OK</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>

                                        <script>
                                            $("#cadastraralimento").validate();
                                        </script>
                                        <script>


                                            function enviarDados(event) {

                                                //form.validate();
                                                //if (form.valid() === true) {


                                                var formulario = document.getElementById("cadastraralimento");


                                                formulario.action = "..\\CadastrarAlimento?nometabelanutricionalalimento=" + formulario.nometabelanutricionalalimento.value + "&nomealimento=" +
                                                        formulario.nomealimento.value + "&tipoalimento=" + formulario.tipoalimento.value + "&especiealimento="
                                                        + formulario.especiealimento.value + "&proteinaalimento=" + formulario.proteinaalimento.value + "&lipideoalimento=" +
                                                        formulario.lipideoalimento.value + "&carboidratoalimento=" + formulario.carboidratoalimento.value + "&fibraalimentaralimento=" + formulario.fibraalimentaralimento.value;

                                                alert(formulario.action);
                                                formulario.submit();
                                                event.preventDefault();
                                                //}


                                            }
                                        </script>




                                    </div>
                                </div>
                            </div>
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
