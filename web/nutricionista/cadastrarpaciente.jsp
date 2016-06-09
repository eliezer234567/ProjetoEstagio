<%-- 
    Document   : cadastrarpaciente
    Created on : 17/04/2016, 12:52:34
    Author     : eliez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (session.getAttribute("id")!=null){
    

%>
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
        
        <script>
            function myFuncction() {
        var x, text;

        // Get the value of the input field with id="numb"
        x = document.getElementById("idadePaciente").value;

        // If x is Not a Number or less than one or greater than 10
        if (isNaN(x) || x < 18 || x > 65) {
            window.alert('Idade não permitida');

            document.getElementById("idadePaciente").focus();
        } else {
            text = "";
        }
        document.getElementById("demo").innerHTML = text;
    }

        </script>
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
                                    <h2>Cadastro De Pacientes</h2>
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
                                    <br />
                                    <form data-parsley-validate class="form-horizontal form-label-left" id="cadastropacientes" name="cadastropacientes" action="" enctype="multipart/form-data" method="POST">

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nome <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" required="required" autofocus="" class="form-control col-md-7 col-xs-12" id="nomePessoa" name="nomePessoa" placeholder="Insira o Nome">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">E-mail <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="email" id="emailPessoa" name="emailPessoa" placeholder="Insira o E-mail" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Senha</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="password" id="senhaPessoa" name="senhaPessoa"  placeholder="Insira a senha" class="form-control col-md-7 col-xs-12" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Confirme a senha</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="password" id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" placeholder="Confirme a Senha" oninput="validaSenhaPaciente(this)" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Data De Nascimento</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" placeholder="Insira a Data de Nascimento" onchange="idade(this.value);" onfocus="(this.type = 'date')" id="dataNascimentoPaciente" name="dataNascimentoPaciente" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Idade</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="number" id="idadePaciente" name="idadePaciente" placeholder="Insira a Idade" onfocus="myFuncction(this)" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Telefone</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="tel" id="telefonePessoa" name="telefonePessoa" placeholder="Insira o Telefone" onfocus="myFuncction(this)" onkeyup="mascara( this, mtel )" required="" maxlength="15"  class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Sexo</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select autocomplete="off" class="form-control placeholder-no-fix" name="sexoPaciente" required>
                                        <option value="">Sexo *</option>
                                        <option value="M">Masculino</option>
                                        <option value="F">Feminino</option>
                                    </select>
                                            </div>
                                        </div>
                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <button type="reset" class="btn btn-default">Limpar</button>
                                                <button type="submit" class="btn btn-primary" onclick="NutricionistaEnviaDadosPaciente();">Cadastrar</button>
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
<% }else{
    response.sendRedirect(request.getContextPath()+("/index.jsp"));
}
%>
