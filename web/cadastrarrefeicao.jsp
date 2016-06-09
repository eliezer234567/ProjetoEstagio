<%-- 
    Document   : cadastrarrefeicao
    Created on : 22/01/2016, 10:53:12
    Author     : Leticia
--%>

<%@page import="br.com.projetoestagio.util.Conversoes"%>
<%@page import="br.com.projetoestagio.model.TipoRefeicao"%>
<%@page import="br.com.projetoestagio.model.Alimento"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoestagio.model.Cardapio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>NutriSIS</title>
        <script type="text/javascript" src="teste/angular.min.js"></script>

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

        <script type="text/javascript">
            var demoApp = angular.module("demoApp", ["jqwidgets"]);
            demoApp.controller("demoController", function ($scope) {
                var data = new Array();


            <%
                List<Alimento> alimentos = (List<Alimento>) request.getAttribute("alimentos");

            %>
                var firstNames = [<% for (int i = 0; i < alimentos.size(); i++) {%>"<%=alimentos.get(i).getNomeAlimento()%>", <% }%>];
                        var lastNames = [<% for (int i = 0; i < alimentos.size(); i++) {%>"<%=alimentos.get(i).getIdAlimento()%>", <% }%>];
                        var imagens = [<% for (int i = 0; i < alimentos.size(); i++) {%>"<%=alimentos.get(i).getCaminhoImagemAlimento()%>", <% }%>];
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
                        var imgurl = 'images/' + label.toLowerCase() + '.png';
                        var img = '<img height="30" width="25" src="' + imgurl + '"/>';
                        var table = '<table style="color: inherit; font-size: inherit; font-style: inherit;"><tr><td style="width: 35px;">' + img + '</td><td>' + label + " " + value + '</td></tr></table>';
                        return table;
                    },
                    renderSelectedItem: function (index, item) {
                        return item.label + " " + item.value;
                    }

                };

                $scope.selectedValue = data[0];
            });
        </script>


    </head>
    <body>
        ${mensagem}
        <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->



        <form class="form-login" name="listarcardapio" action="ListarCardapio">
            <a data-toggle="modal" href="index.jsp#cadastrarrefeicao"><button class="btn btn-facebook" >Cadastrar Nova Refeição</button></a>
        </form>

        <form class="form-login" action="CadastrarRefeicao">
            <!-- Inicio formulario de cadastro Paciente-->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="cadastrarrefeicao" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Cadastrar Refeição</h4>
                        </div>
                        <div class="modal-body">
                            <label>Tipo de Refeição:</label>
                            <select name="idtiporefeicao" class="tiporefeicao">
                                <%
                                    List<TipoRefeicao> trefeicao = (List<TipoRefeicao>) request.getAttribute("trefeicao");
                                    for (TipoRefeicao tiporefeicao : trefeicao) {
                                %>
                                <option value="">Selecione</option>
                                <option value="<%=tiporefeicao.getIdTipoRefeicao()%>"><%=tiporefeicao.getTipoRefeicao()%></option><%  }%>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                        <div class="modal-body">   
                            <label>Hora:</label>
                            <input type="time" id="horarefeicao" name="horarefeicao"  />
                        </div>
                        <div class="modal-body">
                            <label>Dia da Refeição: </label>
                            <select id="diarefeicao" name="diarefeicao">
                                <option value="Domingo">Domingo</option>
                                <option value="Segunda-Feira">Segunda-Feira</option>
                                <option value="Terca-Feira">Terça-Feira</option>
                                <option value="Quarta-Feira">Quarta-Feira</option>
                                <option value="Quinta-Feira">Quinta-Feira</option>
                                <option value="Sexta-Feira">Sexta-Feira</option>
                                <option value="Sabado">Sábado</option>
                            </select>
                        </div>

                        <div ng-controller="demoController">

                            <jqx-combo-box ng-model="selectedValue" name="idalimento" id="idalimento" jqx-ng-model jqx-settings="comboBoxSettings"></jqx-combo-box>
                            <br />
                            <br />
                            <%-- Selected: {{selectedValue.label + " " + selectedValue.value}} --%>

                        </div>

                        <div class="modal-body">
                            <label>Quantidade: </label>
                            <input type="number" id="quantidadealimentorefeicao" name="quantidadealimentorefeicao" class="itens-refeicao" step="0.1" min="0.1" />
                        </div>
                        <div class="modal-body">
                            <label>Tipo de medida</label>
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

                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                            <button class="btn btn-default" type="reset">Limpar</button>
                            <button class="btn btn-theme" onclick="myFunction()" type="submit">Cadastrar</button>
                        </div>

                    </div>
                </div>
            </div>
            <!--  Fim do Formulario de cadastro paciente -->

        </form>
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!--BACKSTRETCH-->
        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
        <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    </body>
</html>




