<!DOCTYPE html>
<html lang="PT-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

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



        <title>NutriSIS</title>
        <!-- Bootstrap core CSS -->
        <link href="assets/css/estilo-login.css" rel="stylesheet">

        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="css/modal_foto.css" rel="stylesheet" type="text/css"/>
        <script src="js/foto.js" type="text/javascript"></script>
        <script src="js/validacoes.js" type="text/javascript"></script>  
        <script src="js/submetendo formularios.js" type="text/javascript"></script>
        <script src="js/mascara_telefone.js" type="text/javascript"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    

    <body style="height: auto; overflow-y: scroll;">


        <!-- ****************************************z******************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->

        <div id="login-page">
            <div class="container">
                <form class="form-login" name="logarusuario" action="LogarUsuario" method="POST">
                    <h2 class="form-login-heading">Entrar</h2>
                    <div class="login-wrap">
                        <input type="email" class="form-control" name="email" placeholder="Email" autofocus>
                        <br>
                        <input type="password" class="form-control" name="senha" placeholder="Senha">
                        <label class="checkbox">
                            
                        </label>
                        <button class="btn btn-twitter btn-block"  name="logar" type="submit"><i class="fa fa-lock"></i> Entrar</button>
                        <input type="hidden" name="acao" value="logar" />
                        <hr>

                        <div class="login-social-link centered">
                            <p>Cadastro De Usuários</p>
                            <label><a data-toggle="modal" href="index.jsp#cadastropaciente"<button class="btn btn-facebook" ><i></i> Cadastrar Paciente</button></a></label>
                            <a  data-toggle="modal" href="index.jsp#cadastronutricionista"<button class="btn btn-twitter" > Cadastrar Nutricionista</button></a>

                        </div>
                        <div class="registration">
                            Baixe o aplicativo<br/>
                            <a class="" href="#">
                                App NutriSIS
                            </a>
                        </div>

                    </div>

                    <!-- Esqueceu a senha?-->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h2 class="modal-title">Esqueceu a senha ?</h2>
                                </div>
                                <div class="modal-body">
                                    <p>Digite seu endereço de e-mail para recuperar sua senha.</p>
                                    <input type="email" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                                    <button class="btn btn-theme" type="button">Enviar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fim Esquece a senha -->

                    <!-- Inicio modal erro-->
                    <div aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="mensagemModal" class="modal">
                        <div class="modal-dialog">
                            <div class="modal-content">                               
                                <div class="modal-body">
                                    <h4>${mensagem}</h4>
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-group-justified" type="button">OK</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fim modal erro -->

                    <!-- Inicio modal erro Nutricionista-->
                    <div aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="erroNutricionista" class="modal">
                        <div class="modal-dialog">
                            <div class="modal-content">                               
                                <div class="modal-body">
                                    <h4>${erroNutricionista}</h4>
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-group-justified" type="button">OK</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fim modal erro Nutricionista-->

                    <!-- Inicio modal erro Paciente-->
                    <div aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="erroPaciente" class="modal">
                        <div class="modal-dialog">
                            <div class="modal-content">                               
                                <div class="modal-body">
                                    <h4>${erroPaciente}</h4>
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-group-justified" type="button">OK</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fim modal erro Paciente-->

                </form>
                <form class="form-login" name="form-login" id="cadastropacientes" name="cadastropacientes" action="" enctype="multipart/form-data" method="POST">
                    <!-- Inicio formulario de cadastro Paciente-->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="cadastropaciente" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Cadastro De Paciente</h4>
                                </div>
                                <div class="modal-body">
                                    <input style="text-transform: capitalize" type="text" id="nomePessoa" name="nomePessoa" placeholder="Nome *" autocomplete="off" class="form-control placeholder-no-fix" autofocus="" required="">

                                </div>
                                <div class="modal-body">

                                    <input type="email" id="emailPessoa" name="emailPessoa" placeholder="Email *" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>

                                <div class="modal-body">

                                    <input type="password" id="senhaPessoa" name="senhaPessoa"  placeholder="Senha *" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body">

                                    <input type="password" id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" placeholder="Confirme a Senha *" oninput="validaSenhaPaciente(this)" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>

                                <div class="modal-body">

                                    <input type="text" placeholder="Data de Nascimento *" onchange="idade(this.value);" onfocus="(this.type = 'date')" id="dataNascimentoPaciente" autocomplete="off" class="form-control placeholder-no-fix" name="dataNascimentoPaciente" required="">
                                    <!--<input type="date" name="txtData" onblur="idade(this.value);">--> 
                                </div>

                                <div class="modal-body">

                                    <input type="number" id="idadePaciente" name="idadePaciente" placeholder="Idade *" onfocus="myFuncction(this)" autocomplete="off" class="form-control placeholder-no-fix" readonly  required="" max="65" min="18" maxlength="2">
                                    <!--<input type="text" name="txtIdade"><br>-->
                                </div>

                                <div class="modal-body">

                                    <input type="tel" id="telefonePessoa" name="telefonePessoa" placeholder="Telefone *" autocomplete="off" onfocus="myFuncction(this)" class="form-control placeholder-no-fix" onkeyup="mascara(this, mtel)" required="" maxlength="15">

                                </div>
                                <div class="modal-body">

                                    <select autocomplete="off" class="form-control placeholder-no-fix" name="sexoPaciente" required>
                                        <option value="">Sexo *</option>
                                        <option value="M">Masculino</option>
                                        <option value="F">Feminino</option>
                                    </select>

                                </div>

                                <div class="modal-body" href="#collapseTwo">
                                    Selecione uma foto <input type="file"  name="foto_pessoa" id="arquivo">
                                    <!-- <a  data-toggle="modal" href="index.jsp#botaofoto"<button class="btn btn-primary" id="headingTwo" alt="Avatar" type="button" > Escolher foto</button></a>-->
                                </div>

                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                                    <button class="btn btn-default" type="reset">Limpar</button>
                                    <button class="btn btn-theme" onclick="enviarDadosPaciente();" type="submit">Cadastrar</button>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!--  Fim do Formulario de cadastro paciente -->

                </form>
            </div>
        </div>
        <!--começo pagina login -->
        <div id="login-page">
            <div class="container">
                <!-- Inicio formulario de cadastro nutricionista-->
                <form class="form-login" id="cadastronutricionistas" action="" enctype="multipart/form-data" method="POST">                                                 
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="cadastronutricionista" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Cadastro de Nutricionista</h4>
                                </div>

                                <div class="modal-body">
                                    <input type="text" id="nomepessoa" placeholder="Nome" name="nomePessoa" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body">
                                    <input type="email" id="emailpessoa" placeholder="E-mail" name="emailPessoa" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body">

                                    <input type="password" id="senhaPessoa1" name="senhaPessoa"  placeholder="Senha" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body">

                                    <input type="password" id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" placeholder="Confirme a Senha" oninput="validaSenhaNutricionista(this)" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body">

                                    <input type="tel" id="telefonePessoa" name="telefonePessoa" onkeyup="mascara(this, mtel)"placeholder="Telefone *" autocomplete="off" class="form-control placeholder-no-fix" required="" maxlength="15">

                                </div>

                                <div class="modal-body">

                                    <input type="text" id="crnNutricionista" placeholder="CRN" name="crnNutricionista" autocomplete="off" class="form-control placeholder-no-fix" required="">

                                </div>
                                <div class="modal-body" href="#collapseTwo">
                                    Selecione uma foto <input type="file"  name="foto_pessoa" id="arquivo">
                                    <!-- <a  data-toggle="modal" href="index.jsp#botaofoto"<button class="btn btn-primary" id="headingTwo" alt="Avatar" type="button" > Escolher foto</button></a>-->
                                </div>

                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                                    <button class="btn btn-default" type="reset">Limpar</button>
                                    <button class="btn btn-theme" onclick="enviarDadosNutricionista();" type="submit">Cadastrar</button>
                                </div>

                            </div>
                        </div>
                    </div>		
                </form>	  	
                <!--  Fim do Formulario de cadastro Nutricionista -->
            </div>
        </div>
        <!--fim pagina login -->



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!--BACKSTRETCH-->
        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
        <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
        <script>
                                        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
        </script>
        ${script}


    </body>
</html>



