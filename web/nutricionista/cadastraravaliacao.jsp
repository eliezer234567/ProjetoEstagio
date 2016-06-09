<%-- 
    Document   : cadastraravaliacao
    Created on : 22/05/2016, 16:31:05
    Author     : Grazy
--%>

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
        <script src="../js/foto.js" type="text/javascript"></script>
        <script src="../js/validacoes.js" type="text/javascript"></script>  
        <script src="../js/submetendo formularios.js" type="text/javascript"></script>
        <script src="../js/mascara_telefone.js" type="text/javascript"></script>


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
                            <div class="x_panel" style="height:600px;">
                                <div class="x_title">
                                    <h2>Cadastro De Avaliação</h2>
                                   
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <p>
                                    <form data-parsley-validate class="form-horizontal form-label-left" id="cadastraravaliacao" name="cadastraravaliacao" action="../CadastrarAvaliacao" method="POST">

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" >Data da Avaliação <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" onfocus="(this.type = 'date')" class="form-control col-md-7 col-xs-12" id="data_avaliacao" name="data_avaliacao" placeholder="Insira a data da avaliação">
                                                    </div>
                                        </div>
                                       <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Meta Avaliação <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="meta_avaliacao" name="meta_avaliacao" placeholder="Insira a meta da avaliação">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Peso Desejavel<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="meta_avaliacao" name="peso_desejavel_avaliacao" placeholder="Peso Desejavel">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Colesterol<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="colesterol" name="colesterol" placeholder="Colesterol">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Triglicerideos <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="triglicerideos" name="triglicerideos" placeholder="Triglicerideos">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Diabetes <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="diabetes" name="diabetes" placeholder="Diabetes">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Acomp Avaliação <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <div id="gender" class="btn-group" data-toggle="buttons">
                                                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                <input type="radio" name="acompan_avaliacao" value="1"> &nbsp; Sim &nbsp;
                                                            </label>
                                                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                <input type="radio" name="acompan_avaliacao" value="0" checked=""> Não
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Quantidade Agua <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="qtd_agua_avaliacao" name="qtd_agua_avaliacao" placeholder="Quantidade Agua">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Fuma?</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <div id="gender" class="btn-group" data-toggle="buttons">
                                                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                <input type="radio" name="fuma" value="1"> &nbsp; Sim &nbsp;
                                                            </label>
                                                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                <input type="radio" name="fuma" value="1" checked=""> Não
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Funcionamento Instestino <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="func_intestino_avaliacao" name="func_intestino_avaliacao" placeholder="Funcionamento Instestino?">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Urina<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="urina_avaliacao" name="urina_avaliacao" placeholder="Avaliação Urina">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">local_alim_avaliacao <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" required="required" class="form-control col-md-7 col-xs-12" id="local_alim_avaliacao" name="local_alim_avaliacao" placeholder="local_alim_avaliacao?">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Objetivo Avalicação</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <textarea id="objetivo_avaliacao" name="objetivo_avaliacao"  placeholder="Opcional" class="form-control col-md-7 col-xs-12" ></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Conduta Adotada</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <textarea type="tel" id="conduta_adotada_avaliacao" name="conduta_adotada_avaliacao" placeholder="Opcional" required="" class="form-control col-md-7 col-xs-12"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Observações Importantes</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <textarea type="tel" id="observacao_importante_avaliacao" name="observacao_importante_avaliacao" placeholder="Opcional" required="" class="form-control col-md-7 col-xs-12"></textarea>
                                                    </div>
                                                </div>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <button type="reset" class="btn btn-default">Limpar</button>
                                                        <button type="submit" class="btn btn-primary">Continuar</button>
                                                        <input type="hidden" value="${idconsulta}" name="id_consulta" />
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>                                            
                                        </form>
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

        <!-- -->
        ${script}
    </body>
</html>