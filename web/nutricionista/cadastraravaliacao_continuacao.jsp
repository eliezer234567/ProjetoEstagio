<%-- 
    Document   : cadastraravaliacao
    Created on : 22/05/2016, 16:31:05
    Author     : Grazy
--%>

<%@page import="br.com.projetoestagio.model.Patologia"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.MedicamentoSuplemento"%>
<%@page import="br.com.projetoestagio.model.Exercicio"%>
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
                            <div class="x_panel" style="height:600px;">
                                <div class="x_title">
                                    <h2>Cadastro De Avaliação - Continuação</h2>
                               
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form data-parsley-validate class="form-horizontal form-label-left" id="" name="" action="/ListarAvaliacao">
                                        <h2>Quase terminando...</h2>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Faz exercicios?</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="exericios" value="1"> Sim 
                                                        </label>
                                                        <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="exercicios" value="0" checked=""> Não
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group" id="exercicios" style="display: none">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12 text-info" for=""></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <select id="selExercicio" name="pratica_exercicio_avaliacao" class="form-control col-md-7 col-xs-12">
                                                        <option value="">Adiconar exercicio</option>
                                                        <% List<Exercicio> exercicios = (List<Exercicio>) request.getAttribute("listexercicio");
                                                            for (Exercicio exercicio : exercicios) {
                                                        %>
                                                        <option value="<%=exercicio.getIdExercicio()%>"><%=exercicio.getIdExercicio()%></option>
                                                        <% } %>
                                                    </select>
                                                </div>
                                                <div class="clearfix"></div>
                                                <div id="contenerExercicio">
                                                    <%--aqui entrara os dados exercicioavaliacao --%>
                                                </div>
                                            </div>
                                            <hr />
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Usa Medicamento / Suplemento?</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label onclick="$(this).ativaMedicamentos();" class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="medicamentos" value="1"> Sim 
                                                        </label>
                                                        <label onclick="$(this).desativaMedicamentos();" class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="medicamentos" value="0" checked=""> Não 
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>        

                                            <div class="form-group" id="medicamentos" style="display: none">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12 text-info" for=""></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12" id="divSelMedicamento">
                                                    <select id="selMedicamento" name="idmedicamento"  class="form-control col-md-7 col-xs-12">
                                                        <option>Selecione o Medicamento:</option>
                                                        <%
                                                            List<MedicamentoSuplemento> medicamentos = (List<MedicamentoSuplemento>) request.getAttribute("listmedicamento");
                                                            for (MedicamentoSuplemento medicamento : medicamentos) {
                                                        %>
                                                        <option value="<%=medicamento.getIdMedicamentoSuplemento()%>"><%=medicamento.getNomeMedicamentoSuplemento()%></option>
                                                        <% } %>
                                                    </select>
                                                </div>
                                                <div class="clearfix"></div>
                                                <div id="preCadastroMedicamento" style="display: none">
                                                    <label id="lblMedicamento" class="control-label col-md-3 col-sm-3 col-xs-12 red"></label>
                                                    <div class="col-md-3 col-sm-6 col-xs-12 form-group ">
                                                        <input id="dosemedicamento" type="text" class="form-control" id="inputSuccess2" placeholder="Informe as doses.">
                                                        <span class="fa " aria-hidden="true"></span>
                                                    </div>

                                                    <div class="col-md-3 col-sm-6 col-xs-12 form-group has-feedback">
                                                        <input id="frequenciamedicamento" type="text" class="form-control" id="inputSuccess3" placeholder="Informe a frequencia.">
                                                        <span class="fa " aria-hidden="true"></span>
                                                    </div>
                                                    <button type="button" onclick="$(this).cadastrarItensMedicamento()" class="btn btn-info btn-sm">Adicionar</button>
                                                    <button type="button" onclick="$(this).cancelarCadastroMedicamento()" class="btn btn-warning btn-sm">Cancelar</button>
                                                </div>
                                                <div id="contenerMedicamento" >
                                                    <%--aqui entrara os dados exerciciomedicamento --%>
                                                </div>
                                            </div>
                                            <hr />
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Patologia?</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label onclick="$(this).ativaPatologias();" class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="patologias" value="1"> Sim 
                                                        </label>
                                                        <label onclick="$(this).desativaPatologias();" class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input type="radio" name="patologias" value="0" checked=""> Não 
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group" id="patologias" style="display: none">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12 text-info" for="">Selecione a patologia: <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <select id="selPatologia" name="patologia" class="form-control col-md-7 col-xs-12" >
                                                        <option>Selecione a Patologia</option>
                                                        <%
                                                            List<Patologia> patologias = (List<Patologia>) request.getAttribute("listpatologia");
                                                            for (Patologia patologia : patologias) {
                                                        %>
                                                        <option value="<%=patologia.getIdPatologia()%>"><%=patologia.getNomePatologia()%></option>
                                                        <% }%>
                                                    </select>
                                                </div>
                                                <div class="clearfix"></div>
                                                <div id="contenerPatologia" style="display: none">
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                    <button type="submit" class="btn btn-primary">Finalizar</button>
                                                    <span id="idavaliacao" style="display: none">${idAvaliacao}</span>
                                                    <span id="spnidmedicamento" style="display: none">0</span>
                                                    <span id="spnidpatologia" style="display: none">0</span>
                                                </div>
                                            </div>

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
        <script src="../js/ajax/avaliacao/cadastraravaliacao_continuacao.js"></script>

    </body>
</html>
