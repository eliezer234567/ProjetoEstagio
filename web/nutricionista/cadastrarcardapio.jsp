<%-- 
    Document   : cadastrarcardapio
    Created on : 22/01/2016, 10:52:21
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.model.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="demoApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nutricionista </title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="assets/js/validate.js" type="text/javascript"></script>
        <script src="assets/js/messages_es.js" type="text/javascript"></script>
        <script src="assets/js/jquery-2.1.1.min.js" type="text/javascript"></script>

        <script src="production/js/jquery.min.js" type="text/javascript"></script>
        <script src="assets/js/angular.min.js" type="text/javascript"></script>

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
                                        <h2>Cardápio</h2>

                                        <div class="clearfix"></div>

                                        <form id="cadastrarcardapio" name="cadastrarcardapio" action="DadosRefeicao" method="POST" class="form-horizontal form-label-left">

                                            <%--  <div class="form-group">
                                                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Paciente<span class="required">*</span></label>
                                                  <div class="col-md-9 col-sm-9 col-xs-12">
                                            <%-- <select class="select2_single form-control" tabindex="-1" name="idpaciente" id="idpaciente" >
                                                 <%
                                                     List<Paciente> lista = (List<Paciente>) request.getAttribute("lista");
                                                     for (Paciente paciente : lista) {
                                                 %>
                                                 <option value="<%=paciente.getIdPaciente()%>"><%=paciente.getNomePessoa()%></option><%  }%>
                                             </select> --%>
                                            <%--   <div ng-controller="demoController">
                                                   <jqx-combo-box ng-model="selectedValue" name="idpaciente" id="idpaciente" jqx-ng-model jqx-settings="comboBoxSettings"></jqx-combo-box>
                                                   <br />
                                                   <br />
                                            <%-- Selected: {{selectedValue.label + " " + selectedValue.value}}   
                                        </div>
                                    </div>
                                </div>  --%>

                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Paciente<span class="required">*</span></label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <%-- <select class="select2_single form-control" tabindex="-1" name="idpaciente" id="idpaciente" >
                                                         <%
                                                             List<Paciente> lista = (List<Paciente>) request.getAttribute("lista");
                                                             for (Paciente paciente : lista) {
                                                         %>
                                                         <option value="<%=paciente.getIdPaciente()%>"><%=paciente.getNomePessoa()%></option><%  }%>
                                                     </select> --%>
                                                    <div ng-controller="demoController">
                                                        <jqx-combo-box ng-model="selectedValue" name="idpaciente" id="idpaciente" jqx-ng-model jqx-settings="comboBoxSettings"></jqx-combo-box>
                                                        <br />
                                                        <br />
                                                        <%-- Selected: {{selectedValue.label + " " + selectedValue.value}}  --%> 
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tipocardapio">Tipo do Cardápio <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="text"  name="tipocardapio" class="form-control col-md-7 col-xs-12"   maxlength="30" size="30"  id="tipocardapio"  />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nomecardapio">Nome do Cardápio <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="text" id="nomecardapio" class="form-control col-md-7 col-xs-12" name="nomecardapio" maxlength="30" size="30"   />                            
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="datainiciocardapio" class="control-label col-md-3 col-sm-3 col-xs-12">Data de Inicio do Cardápio<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="date" id="datainiciocardapio" class="form-control col-md-7 col-xs-12" name="datainiciocardapio"  required="required" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="datafinalcardapio" class="control-label col-md-3 col-sm-3 col-xs-12">Data de Final do Cardápio<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="date" id="datafinalcardapio"  name="datafinalcardapio" class="form-control col-md-7 col-xs-12"  required="required" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="intervalocardapio" class="control-label col-md-3 col-sm-3 col-xs-12">Intervalo do Cardápio</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="time" id="intervalocardapio"  name="intervalocardapio" class="form-control col-md-7 col-xs-12" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Observação do Cardápio</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea  id="observacaocardapio" name="observacaocardapio" cols="30" rows="5" class="form-control col-md-7 col-xs-12" required="required" > </textarea>                
                                                </div>
                                            </div>

                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                    <button type="submit" class="btn btn-primary">Cancel</button>
                                                    <button type="submit" class="btn btn-success">Próximo</button>
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

        <script type="text/javascript">
            var demoApp = angular.module("demoApp", ["jqwidgets"]);
            demoApp.controller("demoController", function ($scope) {
                var data = new Array();

            <%
                List< Paciente> lista = (List< Paciente>) request.getAttribute("lista");
            %>
                var firstNames = [<% for (int i = 0; i < lista.size(); i++) {%>"<%=lista.get(i).getNomePessoa()%>", <% }%>];
                        var lastNames = [<% for (int i = 0; i < lista.size(); i++) {%>"<%=lista.get(i).getIdPaciente()%>", <% }%>];
            <%--   var imagens = [<% for (int i = 0; i < lista.size(); i++) { %>"<%=lista.get(i).getImagemPessoa()%>", <% }%>];  --%>


                for (var i = 0; i < firstNames.length; i++) {
                    var row = {};
                    row["label"] = firstNames[i];
                    row["value"] = lastNames[i];
                    data[i] = row;
                }

//var firstNames = ["Nancy", "Andrew", "Janet", "Margaret", "Steven", "Michael", "Robert", "Laura", "Anne"];
//var lastNames = ["Davolio", "Fuller", "Leverling", "Peacock", "Buchanan", "Suyama", "King", "Callahan", "Dodsworth"];

                $scope.comboBoxSettings = {
                    source: data, itemHeight: 50, height: 25, width: 220,
                    renderer: function (index, label, value) {
                        var datarecord = data[index];
                        //  var imgurl = 'images/' + label.toLowerCase() + '.png';
                        //  var img = '<img height="30" width="25" src="' + imgurl + '"/>';
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
