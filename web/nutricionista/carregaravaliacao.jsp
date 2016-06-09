<%-- 
    Document   : alteraravaliacao
    Created on : 22/05/2016, 16:31:05
    Author     : Grazy
--%>

<%@page import="br.com.projetoestagio.model.AvaliacaoPatologia"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Avaliacao"%>
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
        <%
            Avaliacao bool = (Avaliacao) request.getAttribute("avaliacao");
        %>
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
                                        <h2>Cadastro De Avaliação</h2>
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
                                        <p>
                                        <form data-parsley-validate class="form-horizontal form-label-left" id="alteraravaliacao" name="alteraravaliacao" action="AlterarAvaliacao" method="POST" >

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Paciente: <i>${avaliacao.consulta.paciente.nomePessoa}</i></label>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Data da Avaliação <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.dataAvaliacao}" type="text" required="required" onfocus="(this.type = 'date')" class="form-control col-md-7 col-xs-12" id="data_avaliacao" name="data_avaliacao" placeholder="Insira a data da avaliação">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Meta Avaliação <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.metaAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="meta_avaliacao" name="meta_avaliacao" placeholder="Insira a meta da avaliação">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Peso Desejavel<span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.pesoDesejavelAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="meta_avaliacao" name="peso_desejavel_avaliacao" placeholder="Peso Desejavel">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Colesterol<span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.colesterol}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="colesterol" name="colesterol" placeholder="Colesterol">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Triglicerideos <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.trigliceridios}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="triglicerideos" name="triglicerideos" placeholder="Triglicerideos">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Diabetes <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.diabetes}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="diabetes" name="diabetes" placeholder="Diabetes">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Quantidade Agua <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.qtdAguaAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="qtd_agua_avaliacao" name="qtd_agua_avaliacao" placeholder="Quantidade Agua">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Acomp Avaliação <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label onclick="$(this).radioAcompanha('t');" class="btn btn-default <% if (bool.getAcompanAvaliacao() == true) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdoacompanhatrue" <% if (bool.getAcompanAvaliacao() == true) {
                                                                    out.print("checked='checked'");
                                                                }%> type="radio" name="acompan_avaliacao" value="true"> &nbsp; Sim &nbsp;
                                                        </label>
                                                        <label onclick="$(this).radioAcompanha('f');" class="btn btn-default <% if (bool.getAcompanAvaliacao() == false) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdoacompanhafalse" <% if (bool.getAcompanAvaliacao() == false) {
                                                                    out.print("checked='checked'");
                                                                }%>type="radio" name="acompan_avaliacao" value="false" > Não
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Fuma?</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label onclick="$(this).radioFuma('t');" class="btn btn-default <% if (bool.getFumaAvaliacao() == true) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdofumatrue" type="radio" name="fuma" value="true" <% if (bool.getFumaAvaliacao() == true) {
                                                                    out.print("checked='checked'");
                                                                }%>> &nbsp; Sim &nbsp;
                                                        </label>
                                                        <label onclick="$(this).radioFuma('f');" class="btn btn-default <% if (bool.getFumaAvaliacao() == false) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdofumafalse" type="radio" name="fuma" value="false" <% if (bool.getFumaAvaliacao() == false) {
                                                                    out.print("checked='checked'");
                                                                }%>> Não
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Pratica exercício?</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                        <label onclick="$(this).radioExercicio('t');" class="btn btn-default <% if (bool.getPraticaExercicioAvaliacao()== true) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdoexerciciotrue" type="radio" name="praticaexercicio" value="true" <% if (bool.getPraticaExercicioAvaliacao() == true) {
                                                                    out.print("checked='checked'");
                                                                }%>> &nbsp; Sim &nbsp;
                                                        </label>
                                                        <label onclick="$(this).radioExercicio('f');" class="btn btn-default <% if (bool.getPraticaExercicioAvaliacao() == false) {
                                                                out.print("active");
                                                            }%>" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                            <input id="rdoexerciciofalse" type="radio" name="praticaexercicio" value="false" <% if (bool.getPraticaExercicioAvaliacao() == false) {
                                                                    out.print("checked='checked'");
                                                                }%>> Não
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Funcionamento Instestino <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.funcIntestinoAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="func_intestino_avaliacao" name="func_intestino_avaliacao" placeholder="Funcionamento Instestino?">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">Avaliação Urina<span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.urinaAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="urina_avaliacao" name="urina_avaliacao" placeholder="Avaliação Urina">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">local_alim_avaliacao <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input value="${avaliacao.localAlimAvaliacao}" type="text" required="required" class="form-control col-md-7 col-xs-12" id="local_alim_avaliacao" name="local_alim_avaliacao" placeholder="local_alim_avaliacao?">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Objetivo Avalicação</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea id="objetivo_avaliacao" name="objetivo_avaliacao"  placeholder="Opcional" class="form-control col-md-7 col-xs-12" >${avaliacao.objetivoAvaliacao}</textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Conduta Adotada</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea type="tel" id="conduta_adotada_avaliacao" name="conduta_adotada_avaliacao" placeholder="Opcional" required="" class="form-control col-md-7 col-xs-12">${avaliacao.condutaAdotadaAvaliacao}</textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Observações Importantes</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea type="tel" id="observacao_importante_avaliacao" name="observacao_importante_avaliacao" placeholder="Opcional" required="" class="form-control col-md-7 col-xs-12">${avaliacao.observaoImportanteAvaliacao}</textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Patologias adicionados:</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
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
                                                            <tr class="even pointer">
                                                                <td><%=avaliacaopatologia.getPatologia().getNomePatologia()%></td>
                                                                <td><%=avaliacaopatologia.getPatologia().getDescricaoPatologia()%></td>
                                                                <td style="text-align: center"><a href="javascript:inativar('<%=avaliacaopatologia.getPatologia().getIdPatologia()%>','<%=avaliacaopatologia.getAvaliacao().getIdAvaliacao()%>')">X</a></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>


                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Medicamentos adicionados:</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
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
                                                                <td><%=avaliacao.getMedicamentoSuplemento().getNomeMedicamentoSuplemento()%></td>
                                                                <td><%=avaliacao.getMedicamentoSuplemento().getTipoMedicamentoSuplemento()%></td>
                                                                <td><a href="#">X</a></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>


                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                    <button type="button" onclick="javascript:history.go(-1)" class="btn btn-default">Voltar</button>
                                                    <button name="acao" value="alterar" type="submit" class="btn btn-primary">Alterar</button>
                                                    <input type="hidden" value="${avaliacao.idAvaliacao}" name="idavaliacao" />
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
<script type="text/javascript">
    $(document).ready(function () {
        $.fn.radioAcompanha = function (cond) {
        if(cond==='t'){
            $('#rdoacompanhatrue').attr("checked","true");
            $('#rdoacompanhafalse').removeAttr("checked");
        }else if(cond==='f'){
            $('#rdoacompanhatrue').removeAttr("checked");
            $('#rdoacompanhafalse').attr("checked","true");
        }
    };
    //--------------------------------------------
    $.fn.radioFuma = function (cond) {
        if(cond==='t'){
            $('#rdofumatrue').attr("checked","true");
            $('#rdofumafalse').removeAttr("checked");
        }else if(cond==='f'){
            $('#rdofumatrue').removeAttr("checked");
            $('#rdofumafalse').attr("checked","true");
        }
    };
    //--------------------------------------------
    $.fn.radioExercicio = function (cond) {
        if(cond==='t'){
            $('#rdoexerciciotrue').attr("checked","true");
            $('#rdoexerciciofalse').removeAttr("checked");
        }else if(cond==='f'){
            $('#rdoexerciciotrue').removeAttr("checked");
            $('#rdoxerciciofalse').attr("checked","true");
        }
    };
    //--------------------------------------------
        
    });
</script>