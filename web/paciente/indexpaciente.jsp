<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Paciente </title>

        <!-- Bootstrap core CSS -->

        <link href="../production/css/bootstrap.min.css" rel="stylesheet">

        <link href="../production/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="../production/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="../production/css/custom.css" rel="stylesheet">
        <link href="../production/css/icheck/flat/green.css" rel="stylesheet">


        <script src="../production/js/jquery.min.js"></script>

        <!--[if lt IE 9]>
            <script src="../production/assets/js/ie8-responsive-file-warning.js"></script>
            <![endif]-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->

    </head>


    <body class="nav-md">

        <div class="container body">


            <div class="main_container">

                <%@include file="menupaciente.jsp" %>   


                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Paciente </h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">

                                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">

                                            <div class="profile_img">

                                                <!-- end of image cropping -->
                                                <div id="crop-avatar">
                                                    <!-- Current avatar -->
                                                    <div class="avatar-view" title="Change the avatar">
                                                        <img src="<% if(foto == null || foto.equals("")){ 
                                                            out.print(request.getContextPath()+"/production/images/user.png");
                                                        } else {
                                                            out.print(request.getContextPath()+foto);
                                                        }%>" height="220px" alt="Avatar">
                                                    </div>

                                                    <!-- Cropping modal -->
                                                    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
                                                        <div class="modal-dialog modal-lg">
                                                            <div class="modal-content">
                                                                <form class="avatar-form" action="crop.php" enctype="multipart/form-data" method="post">
                                                                    <div class="modal-header">
                                                                        <button class="close" data-dismiss="modal" type="button">&times;</button>
                                                                        <h4 class="modal-title" id="avatar-modal-label">Change Avatar</h4>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <div class="avatar-body">

                                                                            <!-- Upload image and data -->
                                                                            <div class="avatar-upload">
                                                                                <input class="avatar-src" name="avatar_src" type="hidden">
                                                                                <input class="avatar-data" name="avatar_data" type="hidden">
                                                                                <label for="avatarInput">Local upload</label>
                                                                                <input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
                                                                            </div>

                                                                            <!-- Crop and preview -->
                                                                            <div class="row">
                                                                                <div class="col-md-9">
                                                                                    <div class="avatar-wrapper"></div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="avatar-preview preview-md"></div>
                                                                                    <div class="avatar-preview preview-sm"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="row avatar-btns">

                                                                                <div class="col-md-3">
                                                                                    <button class="btn btn-primary btn-block avatar-save" type="submit">Alterar</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!-- <div class="modal-footer">
                                                      <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                                    </div> -->
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- /.modal -->

                                                    <!-- Loading state -->
                                                    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                                                </div>
                                                <!-- end of image cropping -->

                                            </div>
                                            <h3><%= session.getAttribute("nome")%></h3>



                                            <a class="btn btn-success" data-toggle="modalparadiferenciar"  id="alterarDadosPacienteModal "data-target=".bs-example-modal-lg" href="<%= request.getContextPath()%>/CarregarDadosPaciente?idPessoa=<%=session.getAttribute("id")%>"  ><i class="fa fa-edit m-right-xs"></i>Editar Perfil</a>
                                            <!--inicio modal alterar paciente -->


                                            <div class="modal fade bs-example-modal-lg" tabindex="-1" id="alterarDadosPacienteModal" role="dialog" aria-hidden="true">
                                                <div class="modal-dialog modal-lg">
                                                    <div class="modal-content">

                                                        <form id="alterapaciente"  name="alterapaciente" action="AlterarPaciente" method="POST" data-parsley-validate class="form-horizontal form-label-left">

                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                                                                </button>
                                                                <h4 class="modal-title" id="myModalLabel">Dados Do Paciente</h4>
                                                            </div>
                                                            <div class="modal-body">


                                                                <br />


                                                                <div class="form-group" hidden="">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">ID <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${paciente.idPessoa}" hidden="" id="idPessoa" name="idPessoa" placeholder="ID" required="required" readonly="" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nome <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${paciente.nomePessoa}" id="nomepessoa" name="nomePessoa" placeholder="Nome" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">E-mail <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="email" value="${paciente.emailPessoa}" id="emailPessoa" name="emailPessoa" placeholder="E-mail" required="required"  class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Senha <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="password" value="${paciente.senhaPessoa}" id="senhaPessoa" name="senhaPessoa" onfocus="(this.type = 'password')"  required="required" placeholder="Senha" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Confirmar Senha <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input id="confirmarSenhaPessoa" name="confirmarSenhaPessoa" value="${paciente.senhaPessoa}" type="password" onfocus="(this.type = 'password')" required  placeholder="Repetir Senha" title="Repetir Senha" oninput="validaSenha(this)" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Idade <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="number" value="${paciente.idadePaciente}" id="idadePaciente" name="idadePaciente" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Data de nascimento <span class="required">*</span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="date" value="${paciente.dataNascimentoPaciente}" id="dataNascimentoPaciente" name="dataNascimentoPaciente" required="required" placeholder="Data" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Telefone <span class="required">*</span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="tel"  value="${paciente.telefonePessoa}" id="telefonePessoa" name="telefonePessoa"  required="required" placeholder="Telefone" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Sexo <span class="required">*</span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="tel"  value="${paciente.sexoPaciente}" id="sexoPaciente" name="sexoPaciente"  required="required" placeholder="Sexo" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                                                <a><button type="submit" class="btn btn-primary">Salvar</button></a>
                                                            </div>

                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
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


                                            <br />

                                            <!-- start skills -->
                                            <h4>Evolução</h4>
                                            <ul class="list-unstyled user_data">
                                                <li>
                                                    <p>Progresso</p>
                                                    <div class="progress progress_sm">
                                                        <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${evolucaoPaciente.pesoEvolucaoPaciente}"></div>
                                                    </div>
                                                </li>
                                            </ul>
                                            <!-- end of skills -->

                                        </div>
                                        <div class="col-md-9 col-sm-9 col-xs-12">

                                            <div class="profile_title">
                                                <div class="col-md-6">
                                                    <h2>Evolução Do Paciente</h2>
                                                </div>
                                                <div class="col-md-6">
                                                    <div id="reportrange" class="pull-right" style="margin-top: 5px; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #E6E9ED">
                                                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                                        <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- start of user-activity-graph -->
                                            <div id="graph_bar" style="width:100%; height:280px;"></div>
                                            <!-- end of user-activity-graph -->






                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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

        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
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
        <script>
                                                                            $(function () {
                                                                                var day_data = [
                                                                                    {
                                                                                        "period": "${consulta.dataConsulta}",
                                                                                        "Hours worked": 80
                                                                                    },
                                                                                    {
                                                                                        "period": "Fevereiro",
                                                                                        "Hours worked": 125
                                                                                    },
                                                                                    {
                                                                                        "period": "Março",
                                                                                        "Hours worked": 176
                                                                                    },
                                                                                    {
                                                                                        "period": "Abril",
                                                                                        "Hours worked": 224
                                                                                    },
                                                                                    {
                                                                                        "period": "Maio",
                                                                                        "Hours worked": 265
                                                                                    },
                                                                                    {
                                                                                        "period": "Junho",
                                                                                        "Hours worked": 314
                                                                                    },
                                                                                    {
                                                                                        "period": "Julho",
                                                                                        "Hours worked": 347
                                                                                    },
                                                                                    {
                                                                                        "period": "Agosto",
                                                                                        "Hours worked": 287
                                                                                    },
                                                                                    {
                                                                                        "period": "Setembro",
                                                                                        "Hours worked": 240
                                                                                    },
                                                                                    {
                                                                                        "period": "Outubro",
                                                                                        "Hours worked": 211
                                                                                    }
                                                                                ];
                                                                                Morris.Bar({
                                                                                    element: 'graph_bar',
                                                                                    data: day_data,
                                                                                    xkey: 'period',
                                                                                    hideHover: 'auto',
                                                                                    barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
                                                                                    ykeys: ['Hours worked', 'sorned'],
                                                                                    labels: ['Hours worked', 'SORN'],
                                                                                    xLabelAngle: 60
                                                                                });
                                                                            });
        </script>
        <!-- datepicker -->
        <script type="text/javascript">
            $(document).ready(function () {

                var cb = function (start, end, label) {
                    console.log(start.toISOString(), end.toISOString(), label);
                    $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                    //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
                }

                var optionSet1 = {
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment(),
                    minDate: '01/01/2012',
                    maxDate: '12/31/2015',
                    dateLimit: {
                        days: 60
                    },
                    showDropdowns: true,
                    showWeekNumbers: true,
                    timePicker: false,
                    timePickerIncrement: 1,
                    timePicker12Hour: true,
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    opens: 'left',
                    buttonClasses: ['btn btn-default'],
                    applyClass: 'btn-small btn-primary',
                    cancelClass: 'btn-small',
                    format: 'MM/DD/YYYY',
                    separator: ' to ',
                    locale: {
                        applyLabel: 'Submit',
                        cancelLabel: 'Clear',
                        fromLabel: 'From',
                        toLabel: 'To',
                        customRangeLabel: 'Custom',
                        daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                        monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                        firstDay: 1
                    }
                };
                $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
                $('#reportrange').daterangepicker(optionSet1, cb);
                $('#reportrange').on('show.daterangepicker', function () {
                    console.log("show event fired");
                });
                $('#reportrange').on('hide.daterangepicker', function () {
                    console.log("hide event fired");
                });
                $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
                    console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
                });
                $('#reportrange').on('cancel.daterangepicker', function (ev, picker) {
                    console.log("cancel event fired");
                });
                $('#options1').click(function () {
                    $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
                });
                $('#options2').click(function () {
                    $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
                });
                $('#destroy').click(function () {
                    $('#reportrange').data('daterangepicker').remove();
                });
            });
        </script>
        <!-- /datepicker -->
        <script src="../production/js/validator/validator.js"></script>
        <script>
            // initialize the validator function
            validator.message['date'] = 'not a real date';

            // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
            $('form')
                    .on('blur', 'input[required], input.optional, select.required', validator.checkField)
                    .on('change', 'select.required', validator.checkField)
                    .on('keypress', 'input[required][pattern]', validator.keypress);

            $('.multi.required')
                    .on('keyup blur', 'input', function () {
                        validator.checkField.apply($(this).siblings().last()[0]);
                    });

            // bind the validation to the form submit event
            //$('#send').click('submit');//.prop('disabled', true);

            $('form').submit(function (e) {
                e.preventDefault();
                var submit = true;
                // evaluate the form using generic validaing
                if (!validator.checkAll($(this))) {
                    submit = false;
                }

                if (submit)
                    this.submit();
                return false;
            });

            /* FOR DEMO ONLY */
            $('#vfields').change(function () {
                $('form').toggleClass('mode2');
            }).prop('checked', false);

            $('#alerts').change(function () {
                validator.defaults.alerts = (this.checked) ? false : true;
                if (this.checked)
                    $('form .alert').remove();
            }).prop('checked', false);
        </script>
    </body>
    ${script}
</html>