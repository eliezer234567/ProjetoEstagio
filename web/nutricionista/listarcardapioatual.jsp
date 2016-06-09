<%-- 
    Document   : listarcardapioatual
    Created on : 18/04/2016, 18:46:34
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.AlimentoRefeicao"%>
<%@page import="br.com.projetoestagio.model.Refeicao"%>
<%@page import="br.com.projetoestagio.model.TipoRefeicao"%>
<%@page import="br.com.projetoestagio.model.Alimento"%>
<%@page import="br.com.projetoestagio.model.Cardapio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html ng-app="demoApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>


        <script src="production/js/jquery.min.js" type="text/javascript"></script>
        <script src="assets/js/angular.min.js" type="text/javascript"></script>
        <link href="../production/css/bootstrap.min.css" rel="stylesheet">
        <script src="../assets/js/modal-refeicao.js" type="text/javascript"></script>
        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">



        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">
        <link href="../production/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">
        <link href="../production/less/custom.css" rel="stylesheet" type="text/css"/>

        <style>
            #myModal .modal-content
            {
                height:600px;
                overflow:auto;
            }
        </style>




        <script src="../production/js/jquery.min.js"></script>
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="menunutricionista.jsp" %>

                <!-- page content -->
                <div class="right_col" role="main">

                    <div class="col-md-12 col-sm-12 col-xs-12">


                        <form name="" action="DadosCadastro" >
                            <table class="table table-striped responsive-utilities jambo_table">
                                <thead>
                                    <tr>
                                        <th>Dia Refeicao</th>
                                        <th>Hora</th>
                                        <th>Tipo de Refeição</th>
                                        <th>Alimento</th>
                                        <th>Quantidade</th>
                                        <th>Medida</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Refeicao> listaRefeicao = (List<Refeicao>) session.getAttribute("refeicao");
                                        if (listaRefeicao != null) {
                                            for (int i = 1; i <= 7; i++) {
                                                String dia = "";
                                                switch (i) {
                                                    case 1:
                                                        dia = "DOMINGO";
                                                        break;
                                                    case 2:
                                                        dia = "SEGUNDA-FEIRA";
                                                        break;
                                                    case 3:
                                                        dia = "TERCA-FEIRA";
                                                        break;
                                                    case 4:
                                                        dia = "QUARTA-FEIRA";
                                                        break;
                                                    case 5:
                                                        dia = "QUINTA-FEIRA";
                                                        break;
                                                    case 6:
                                                        dia = "SEXTA-FEIRA";
                                                        break;
                                                    case 7:
                                                        dia = "SABADO";
                                                        break;
                                                    default:
                                                        System.out.println("Este não é um dia válido!");
                                                }
                                    %>
                                    <tr>
                                        <td><%=dia%></td>
                                    </tr>
                                    <%
                                        for (Refeicao refeicao : listaRefeicao) {
                                            List<AlimentoRefeicao> listaAlimentos = (List<AlimentoRefeicao>) session.getAttribute("alimentorefeicao");
                                            if (listaAlimentos != null) {

                                                for (AlimentoRefeicao alimentoRefeicao : listaAlimentos) {
                                                    if (refeicao.getDiaRefeicao().equals(dia)) {
                                                        if (refeicao.getIdRefeicao() == alimentoRefeicao.getIdAlimentoRefeicao()) {


                                    %>


                                    <tr>
                                        <td></td>
                                        <td><%=refeicao.getHoraRefeicao()%></td>
                                        <td><%=refeicao.getTipoRefeicao().getTipoRefeicao()%> </td>
                                        <td><%=alimentoRefeicao.getAlimento().getNomeAlimento()%></td>
                                        <td><%=alimentoRefeicao.getQuantidadeAlimentoRefeicao()%></td>
                                        <td><%=alimentoRefeicao.getTipoMedidaAlimentoRefeicao()%></td>
                                    </tr>

                                    <%
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }%>
                                </tbody>
                            </table>

                            <button type="submit" class="btn btn-primary"  >Cadastrar Cardápio</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Nova Refeição</button>
                        </form>


                        <form id="cadastrarcardapio" name="cadastrarcardapio" action="DadosRefeicao" method="POST" class="form-horizontal form-label-left">


                        </form>




                        <!-- modals -->
                        <!-- Large modal -->

                        <form  data-parsley-validate class="form-horizontal form-label-left"  action="ListarCardapioAtual" method="POST">
                            <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">

                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel">Refeição</h4>
                                        </div>





                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tipo de Refeição <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <select name="idtiporefeicao" id="idtiporefeicao" class="tiporefeicao form-control placeholder-no-fix" required="">
                                                        <option value="">Selecione</option>
                                                        <%
                                                            List<TipoRefeicao> trefeicao = (List<TipoRefeicao>) request.getAttribute("trefeicao");
                                                            for (TipoRefeicao tiporefeicao : trefeicao) {
                                                        %>
                                                        <option value="<%=tiporefeicao.getIdTipoRefeicao()%>"><%=tiporefeicao.getTipoRefeicao()%></option><%  }%>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-body">
                                            <div >
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Dias <span class="required">*</span></label>
                                                <div >
                                                    <ul style="list-style-type: none; padding-left:  232px">

                                                        <li>

                                                            <label style="padding-right: 38px" >
                                                                <input type="checkbox" class="flat"  name="diarefeicao" id="dom" value="Domingo" >
                                                                Domingo</label>

                                                            <label style="padding-right: 15px">
                                                                <input type="checkbox" name="diarefeicao" class="flat" id="seg" value="Segunda-Feira" >
                                                                Segunda-Feira</label>

                                                            <label style="padding-right: 20px">
                                                                <input type="checkbox" name="diarefeicao"  class="flat"  id="ter" value="Terca-Feira" >
                                                                Terça-Feira</label> 

                                                            <label style="padding-right: 20px">
                                                                <input type="checkbox" name="diarefeicao"  class="flat"  id="qua" value="Quarta-Feira" >
                                                                Quarta-Feira</label>
                                                        </li>
                                                    </ul>
                                                    <ul style="list-style-type: none; padding-left:  232px" ><li>
                                                            <label style="padding-right: 20px">
                                                                <input type="checkbox" name="diarefeicao"  class="flat"  id="qui" value="Quinta-Feira" >
                                                                Quinta-Feira</label>
                                                            <label style="padding-right: 35px">
                                                                <input type="checkbox" name="diarefeicao"  class="flat"  id="sex" value="Sexta-Feira" >
                                                                Sexta-Feira</label>
                                                            <label style="padding-right: 20px">
                                                                <input type="checkbox" name="diarefeicao"  class="flat"  id="sab" value="Sabado" >
                                                                Sabado</label>
                                                        </li>

                                                    </ul>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Hora <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="time" id="horarefeicao" name="horarefeicao"  />                          
                                                </div>
                                            </div>
                                        </div><br/>

                                        <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

                                        <div class="area">
                                            <div class="duplicados">
                                                <div class="adicionar" >

                                                    <label>Clonar</label>

                                                    <div ng-controller="demoController" >
                                                        <jqx-combo-box ng-model="selectedValue" class="form-control" name="idalimento" id="idalimento" jqx-ng-model jqx-settings="comboBoxSettings"></jqx-combo-box>
                                                        <br />
                                                        <br />

                                                        <%-- Selected: {{selectedValue.label + " " + selectedValue.value}}  --%> 
                                                    </div>


                                                    <div id="lista">
                                                        <input type="number" id="quantidadealimentorefeicao" class="form-control" name="quantidadealimentorefeicao" class="itens-refeicao" step="0.1" min="0.1" />

                                                        <select class="form-control" id="tipomedidaalimentorefeicao" class="itens-refeicao" name="tipomedidaalimentorefeicao">
                                                            <option value="">Selecione</option>
                                                            <option value="Colher Arroz">Colher(es) de Arroz </option>
                                                            <option value="Colher Café">Colher(es) de Café</option>
                                                            <option value="Colher Cha">Colher(es) de Chá</option>
                                                            <option value="Colher Sobremesa">Colher(es) de Sobremesa</option>
                                                            <option value="Colher Sopa">Colher(es) de Sopa</option>
                                                            <option value="Concha">Concha(s) </option>
                                                            <option value="Copo Grande">Copo(s) Grande</option>
                                                            <option value="Copo Médio">Copo(s) Médio</option>
                                                            <option value="Copo Pequeno">Copo(s) Pequeno</option>
                                                            <option value="Fatia">Fatia(s) </option>
                                                            <option value="litro">Litro(s)</option>
                                                            <option value="Unidade">Unidade(s)</option>
                                                            <option value="Xícara">Xícara(s)</option>
                                                        </select>     
                                                        <button id="btn2">Adicionar</button>

                                                    </div>




                                                    <button type="button" id="add">+</button>

                                                    <script>
                                                        $(document).ready(function () {
                                                            $("#btn2").click(function () {
                                                                $('#lista  option:selected').each(function () {
                                                                    $('#resultado').append("<tr> <td><option value='" + $(this).val() + "'>" + $(this).text() + "</option></td>  <td>" + $("#test").val() + "</td> <td><input type='button' id='field' value='Remover' /></td> </tr>");

                                                                })
                                                            })
                                                        })


                                                        $(document).ready(function () {
                                                            $("#add").click(function () {
                                                                $(".adicionar").prepend()

                                                            })
                                                        })

                                                    </script>


                                                </div>
                                            </div>
                                        </div>


                                        <%--
                                                                                <div class="container">
                                                                                    <div class="row clearfix">
                                                                                        <div class="col-md-12 table-responsive">
                                                                                            <table class="table table-bordered table-hover table-sortable" id="tab_logic">
                                                                                                <thead>
                                                                                                    <tr >
                                                                                                        <th class="text-center">
                                                                                                            Alimento
                                                                                                        </th>
                                                                                                        <th class="text-center">
                                                                                                            Quantidade
                                                                                                        </th>
                                                                                                        <th class="text-center">
                                                                                                            Medida
                                                                                                        </th>
                                                                                                        <th class="text-center" style="border-top: 1px solid #ffffff; border-right: 1px solid #ffffff;">
                                                                                                        </th>
                                                                                                    </tr>
                                                                                                </thead>
                                                                                                <tbody>
                                                                                                    <tr id='addr0' data-id="0" class="hidden">
                                                                                                        <td data-name="alimento">
                                                                                                            <div ng-controller="demoController" >
                                                                                                                <jqx-combo-box ng-model="selectedValue" class="form-control" name="idalimento" id="idalimento" jqx-ng-model jqx-settings="comboBoxSettings"></jqx-combo-box>
                                                                                                                <br />
                                                                                                                <br />
                                        <%-- Selected: {{selectedValue.label + " " + selectedValue.value}}  --%> 
                                        <%--  </div>


                                                                </td>
                                                                <td data-name="quantidade">
                                                                    <input type="number" id="quantidadealimentorefeicao" class="form-control" name="quantidadealimentorefeicao" class="itens-refeicao" step="0.1" min="0.1" />
                                                                </td>
                                                                <td data-name="medida">
                                                                    <select class="form-control" id="tipomedidaalimentorefeicao" class="itens-refeicao" name="tipomedidaalimentorefeicao">
                                                                        <option value="">Selecione</option>
                                                                        <option value="Colher Arroz">Colher(es) de Arroz </option>
                                                                        <option value="Colher Café">Colher(es) de Café</option>
                                                                        <option value="Colher Cha">Colher(es) de Chá</option>
                                                                        <option value="Colher Sobremesa">Colher(es) de Sobremesa</option>
                                                                        <option value="Colher Sopa">Colher(es) de Sopa</option>
                                                                        <option value="Concha">Concha(s) </option>
                                                                        <option value="Copo Grande">Copo(s) Grande</option>
                                                                        <option value="Copo Médio">Copo(s) Médio</option>
                                                                        <option value="Copo Pequeno">Copo(s) Pequeno</option>
                                                                        <option value="Fatia">Fatia(s) </option>
                                                                        <option value="litro">Litro(s)</option>
                                                                        <option value="Unidade">Unidade(s)</option>
                                                                        <option value="Xícara">Xícara(s)</option>
                                                                    </select>          

                                                                </td>

                                                                <td data-name="del">
                                                                    <button name="del0" class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <a id="add_row" class="btn btn-default pull-right">Novo Item</a>
                                        </div>
                                        --%>


                                        <div class="modal-footer">
                                            <button class="btn btn-default" type="reset">Limpar</button>
                                            <button class="btn btn-theme" onclick="enviarDadosPaciente();" type="submit">Cadastrar</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>













                        <!--fim modal alterar paciente --> 
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
                                        <h4>${erroAlterarPaciente}</h4>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!--Fim modal erro paciente -->





                        <link href="production/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
                        <link href="production/fonts/css/font-awesome.css" rel="stylesheet" type="text/css"/>
                        <link href="production/css/animate.min.css" rel="stylesheet" type="text/css"/>
                        <link href="production/css/custom.css" rel="stylesheet" type="text/css"/>
                        <link href="production/css/icheck/flat/green.css" rel="stylesheet" type="text/css"/>



                        <script src="teste/jquery-1.11.1.min.js" type="text/javascript"></script>
                        <link href="teste/jqx.base.css" rel="stylesheet" type="text/css"/>
                        <script src="teste/jqxcore.js" type="text/javascript"></script>
                        <script src="teste/jqxdata.js" type="text/javascript"></script>
                        <script src="teste/jqxbuttons.js" type="text/javascript"></script>
                        <script src="teste/jqxscrollbar.js" type="text/javascript"></script>
                        <script src="teste/jqxlistbox.js" type="text/javascript"></script>
                        <script src="teste/jqxcombobox.js" type="text/javascript"></script>
                        <script src="teste/jqxcombobox.js" type="text/javascript"></script>
                        <script src="teste/jqxangular.js" type="text/javascript"></script>
                        <script src="teste/demos.js" type="text/javascript"></script>


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

                        <script language="JavaScript">

                                                jQuery(function ($) {
                                                    $('.area').each(function () {
                                                        var $duplicar = $('.duplicados', this);
                                                        $(".add", $(this)).click(function (e) {
                                                            $('.duplicar:first-child', $duplicar).clone(true).appendTo($duplicar).find('input').val('').focus();
                                                        });
                                                        $('.duplicar .remove', $duplicar).click(function () {
                                                            if ($('.duplicar', $duplicar).length > 1)
                                                                $(this).parent('.duplicar').remove();
                                                        });
                                                    });
                                                });

                        </script>

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

                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var demoApp = angular.module("demoApp", ["jqwidgets"]);
            demoApp.controller("demoController", function ($scope) {
                var data = new Array();

            <%
                List<Alimento> alimentos = (List< Alimento>) request.getAttribute("alimentos");
            %>
                var listAlimentos = [<% for (int i = 0; i < alimentos.size(); i++) {%>"<%=alimentos.get(i).getNomeAlimento()%>", <% }%>];
                        var id = [<% for (int i = 0; i < alimentos.size(); i++) {%>"<%=alimentos.get(i).getIdAlimento()%>", <% }%>];
            <%--   var imagens = [<% for (int i = 0; i < lista.size(); i++) { %>"<%=lista.get(i).getImagemPessoa()%>", <% }%>];  --%>


                for (var i = 0; i < listAlimentos.length; i++) {
                    var row = {};
                    row["label"] = listAlimentos[i];
                    row["value"] = id[i];
                    data[i] = row;
                }

                $scope.comboBoxSettings = {
                    source: data, itemHeight: 50, height: 25, width: 220,
                    renderer: function (index, label, value) {
                        var datarecord = data[index];
                        //var imgurl = 'images/' + label.toLowerCase() + '.png';
                        //var img = '<img height="30" width="25" src="' + imgurl + '"/>';
                        var table = '<table style="color: inherit; font-size: inherit; font-style: inherit;"><tr><td>' + label + " " + value + '</td></tr></table>';
                        return table;
                    },
                    renderSelectedItem: function (index, item) {
                        return item.label + " " + item.value;
                    }

                };

                $scope.selectedValue = data[0];
            });
        </script> 
    </body>
</html>










<%--

<!DOCTYPE html>
<html ng-app="demoApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NutriSIS</title>
        <meta charset="utf-8">
        <script src="teste/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="assets/js/clone.js" type="text/javascript"></script>
        <script type="text/javascript" src="teste/angular.min.js"></script>
        
        <link href="production/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="production/fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/animate.min.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/custom.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/icheck/flat/green.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/editor/index.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/editor/external/google-code-prettify/prettify.css" rel="stylesheet" type="text/css"/>
        <link href="production/css/select/select2.min.css" rel="stylesheet" type="text/css"/>
        <script src="production/js/jquery.min.js" type="text/javascript"></script>
   
        <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
        <link href="production/css/switchery/switchery.min.css" rel="stylesheet" type="text/css"/>
  





        <link rel="stylesheet" type="text/css" href="teste/jqx.base.css" />
        <script type="text/javascript" src="teste/jqxcore.js"></script>
        <script type="text/javascript" src="teste/jqxdata.js"></script>
        <script type="text/javascript" src="teste/jqxbuttons.js"></script>
        <script type="text/javascript" src="teste/jqxscrollbar.js"></script>
        <script type="text/javascript" src="teste/jqxlistbox.js"></script>
        <script type="text/javascript" src="teste/jqxcombobox.js"></script>
        <script type="text/javascript" src="teste/jqxcombobox.js"></script>
        <script type="text/javascript" src="teste/jqxangular.js"></script>
        <script type="text/javascript" src="teste/demos.js"></script>
        <!-- Bootstrap core CSS -->
        <link href="assets/css/estilo-login.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    </head>
    <body>
        <form  name="" action="DadosCadastro" >
            <table border="1" >
                <thead>
                    <tr>
                        <th>Tipo do Cardápio</th>
                        <th>Nome do Cardápio</th>
                        <th>Data de Início do Cardápio</th>
                        <th>Data Final do Cardápio</th>
                        <th>Observações do Cardápio</th>
                        <th>Nome do Paciente</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Cardapio cardapio = new Cardapio();
                        cardapio = (Cardapio) session.getAttribute("cardapio");;
                    %>

                    <tr>
                        <td><%=cardapio.getTipoCardapio()%></td>
                        <td><%=cardapio.getNomeCardapio()%></td>
                        <td><%=cardapio.getDataInicioCardapio()%></td>
                        <td><%=cardapio.getDataFinalCardapio()%></td>
                        <td><%=cardapio.getObservacaoCardapio()%></td>
                        <td><%=cardapio.getPaciente().getNomePessoa()%> </td>
                    </tr>
                </tbody>
            </table>

            <table border="1" >
                <thead>
                    <tr>
                        <th>Dia Refeicao</th>
                        <th>Hora</th>
                        <th>Tipo de Refeição</th>
                        <th>Alimento</th>
                        <th>Quantidade</th>
                        <th>Medida</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Refeicao> listaRefeicao = (List<Refeicao>) session.getAttribute("refeicao");
                        if (listaRefeicao != null) {
                            for (int i = 1; i <= 7; i++) {
                                String dia = "";
                                switch (i) {
                                    case 1:
                                        dia = "DOMINGO";
                                        break;
                                    case 2:
                                        dia = "SEGUNDA-FEIRA";
                                        break;
                                    case 3:
                                        dia = "TERCA-FEIRA";
                                        break;
                                    case 4:
                                        dia = "QUARTA-FEIRA";
                                        break;
                                    case 5:
                                        dia = "QUINTA-FEIRA";
                                        break;
                                    case 6:
                                        dia = "SEXTA-FEIRA";
                                        break;
                                    case 7:
                                        dia = "SABADO";
                                        break;
                                    default:
                                        System.out.println("Este não é um dia válido!");
                                }
                    %>
                    <tr>
                        <td><%=dia%></td>
                    </tr>
                    <%
                        for (Refeicao refeicao : listaRefeicao) {
                            List<AlimentoRefeicao> listaAlimentos = (List<AlimentoRefeicao>) session.getAttribute("alimentorefeicao");
                            if (listaAlimentos != null) {

                                for (AlimentoRefeicao alimentoRefeicao : listaAlimentos) {
                                    if (refeicao.getDiaRefeicao().equals(dia)) {
                                        if (refeicao.getIdRefeicao() == alimentoRefeicao.getIdAlimentoRefeicao()) {


                    %>


                    <tr>
                        <td><%=refeicao.getHoraRefeicao()%></td>
                        <td><%=refeicao.getTipoRefeicao().getTipoRefeicao()%> </td>
                        <td><%=alimentoRefeicao.getAlimento().getNomeAlimento()%></td>
                        <td><%=alimentoRefeicao.getQuantidadeAlimentoRefeicao()%></td>
                        <td><%=alimentoRefeicao.getTipoMedidaAlimentoRefeicao()%></td>
                    </tr>

                    <%}
                                            }
                                        }
                                    }
                                }
                            }
                        }%>
                </tbody>
            </table>
            <input type="submit" value="Cadastrar" >
        </form>

        <form id="cadastrarcardapio" name="cadastrarcardapio" action="DadosRefeicao" method="POST" class="form-horizontal form-label-left">


        </form>




        <form class="form-login" name="listarcardapio" >
            <a data-toggle="modal" href="index.jsp#cadastrarrefeicao"><button class="btn btn-facebook" >Cadastrar Nova Refeição</button></a>


        </form>

        <form class="form-login" action="ListarCardapioAtual" method="POST">
            <!-- Inicio formulario de cadastro Paciente-->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="cadastrarrefeicao" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Cadastrar Refeição</h4>
                        </div>
                        <div class="form-group">
                            <div class="modal-body">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tipo de Refeição <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="idtiporefeicao" id="idtiporefeicao" class="tiporefeicao">
                                        <%
                                            List<TipoRefeicao> trefeicao = (List<TipoRefeicao>) request.getAttribute("trefeicao");
                                            for (TipoRefeicao tiporefeicao : trefeicao) {
                                        %>
                                        <option value="<%=tiporefeicao.getIdTipoRefeicao()%>"><%=tiporefeicao.getTipoRefeicao()%></option><%  }%>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="modal-body">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" >Hora <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="time" id="horarefeicao" name="horarefeicao"  />                          
                                </div>
                            </div></div>
                        <div class="modal-body">
                            <div class="form-group">

                                <label  class="control-label col-md-3 col-sm-3 col-xs-12">Dias<span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">

                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" class="flat"  name="diarefeicao" id="dom" value="Domingo" >
                                            Domingo</label>
                                    </div>

                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="diarefeicao" class="flat" id="seg" value="Segunda-Feira" >
                                            Segunda-Feira</label>
                                    </div>

                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="diarefeicao"  class="flat"  id="ter" value="Terca-Feira" >
                                            Terça-Feira</label>
                                    </div>

                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="diarefeicao"  class="flat"  id="qua" value="Quarta-Feira" >
                                            Quarta-Feira</label>
                                    </div>
                                    <div class="checkbox"><label>
                                            <input type="checkbox" name="diarefeicao"  class="flat"  id="qui" value="Quinta-Feira" >
                                            Quinta-Feira</label>
                                    </div>
                                    <div class="checkbox">
                                        <label>

                                            <input type="checkbox" name="diarefeicao"  class="flat"  id="sex" value="Sexta-Feira" >
                                            Sexta-Feira</label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="diarefeicao"  class="flat"  id="sab" value="Sabado" >
                                            Sabado</label>
                                    </div>


                                </div>
                            </div>
                        </div>
                        <div id="multi">
                            <div class="form-group">
                                <div class="modal-body">
                                    <label  class="control-label col-md-3 col-sm-3 col-xs-12">Alimento<span class="required">*</span></label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" name="country" id="autocomplete-custom-append" class="form-control col-md-10" style="float: left;" />
                                        <div id="autocomplete-container" style="position: relative; float: left; width: 400px; margin: 10px;"></div>
                                    </div>
                                </div>
                            </div><br/><br/>

                            <script src="production/js/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>

                            <%
                                List<Alimento> alimentos = (List<Alimento>) request.getAttribute("alimentos");
                            %>
                            <script>
                                var countries = {<% for (int i = 0; i < alimentos.size(); i++) {%> <%=alimentos.get(i).getIdAlimento()%>:"<%=alimentos.get(i).getNomeAlimento()%>",<%}%>};
                                console.log(countries);
                            </script>

                            <script>
                                $(function () {
                                    'use strict';
                                    var countriesArray = $.map(countries, function (value, key) {
                                        return {
                                            value: value,
                                            data: key
                                        };
                                    });
                                    // Initialize autocomplete with custom appendTo:
                                    $('#autocomplete-custom-append').autocomplete({
                                        lookup: countriesArray,
                                        appendTo: '#autocomplete-container'
                                    });
                                });
                            </script>

                            <div class="form-group">
                                <div class="modal-body">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Quantidade<span class="required">*</span></label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" id="quantidadealimentorefeicao" name="quantidadealimentorefeicao" class="itens-refeicao" step="0.1" min="0.1" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="modal-body">
                                    <label for="intervalocardapio" class="control-label col-md-3 col-sm-3 col-xs-12">Tipo de Medida</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="modal-body">
                                            <select id="tipomedidaalimentorefeicao" class="itens-refeicao" name="tipomedidaalimentorefeicao">
                                                <option value="">Selecione</option>
                                                <option value="Colher Arroz">Colher(es) de Arroz </option>
                                                <option value="Colher Café">Colher(es) de Café</option>
                                                <option value="Colher Cha">Colher(es) de Chá</option>
                                                <option value="Colher Sobremesa">Colher(es) de Sobremesa</option>
                                                <option value="Colher Sopa">Colher(es) de Sopa</option>
                                                <option value="Concha">Concha(s) </option>
                                                <option value="Copo Grande">Copo(s) Grande</option>
                                                <option value="Copo Médio">Copo(s) Médio</option>
                                                <option value="Copo Pequeno">Copo(s) Pequeno</option>
                                                <option value="Fatia">Fatia(s) </option>
                                                <option value="litro">Litro(s)</option>
                                                <option value="Unidade">Unidade(s)</option>
                                                <option value="Xícara">Xícara(s)</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                request.setAttribute("idcardapio", session.getAttribute("idcardapio"));
                            %>
                            <a href="#" class="remover" data-action="excluir" >Remover Item</a>
                        </div>
                        <a href="#" data-action="adicionar"  id="btnAdiciona" class="adicionar-refeicao"  >Novo Item</a> 
                        <div class="respContent"></div>
                        <div id="console"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                    <button class="btn btn-default" type="reset">Limpar</button>
                    <button class="btn btn-theme" onclick="adicionarAlimento();" type="submit">Adicionar</button>
                </div>
            </div>

            <!--  Fim do Formulario de cadastro paciente -->

        </form>

        <script>
            function adicionarAlimento() {
                var idtipo = document.getElementById("idtiporefeicao").value;
                var horarefeicao = document.getElementById("horarefeicao").value;
                var diasrefeicao = [];
                if (document.getElementById("dom").checked)
                    diasrefeicao.push("Domingo");
                if (document.getElementById("seg").checked)
                    diasrefeicao.push("Segunda-Feira");
                if (document.getElementById("ter").checked)
                    diasrefeicao.push("Terça-Feira");
                if (document.getElementById("qua").checked)
                    diasrefeicao.push("Quarta-Feira");
                if (document.getElementById("qui").checked)
                    diasrefeicao.push("Quinta-Feira");
                if (document.getElementById("sex").checked)
                    diasrefeicao.push("Sexta-Feira");
                if (document.getElementById("sab").checked)
                    diasrefeicao.push("Sabado");
                var idalimento = document.getElementById("idalimento").value;
                var quantidadealimentorefeicao = document.getElementById("quantidadealimentorefeicao");
                var tipomedidaalimentorefeicao = document.getElementById("tipomedidaalimentorefeicao");
            }
        </script>


        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>


        <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    </body>
</html>
--%>