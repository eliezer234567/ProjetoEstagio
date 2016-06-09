<!DOCTYPE html>
<% if (session.getAttribute("id")!=null){
    

%>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Nutricionista </title>

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

                <%@include file="menunutricionista.jsp" %>   


                <!-- page content -->
                <div class="right_col" role="main">

                    <div class="">
                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_content">

                                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">

                                            <div class="profile_img">

                                                <!-- end of image cropping -->
                                                <div id="crop-avatar">
                                                    <!-- Current avatar -->
                                                    <div class="avatar-view" title="Change the avatar">
                                                        <% String foto = session.getAttribute("foto").toString(); %>
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
                                                                <form class="avatar-form" action="#" enctype="multipart/form-data" method="post">
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
                                                                                </div>
                                                                            </div>

                                                                            <div class="row avatar-btns">
                                                                                <div class="col-md-9">
                                                                                    <div class="btn-group">
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees">Rotate Left</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-15" type="button">-15deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-30" type="button">-30deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button">-45deg</button>
                                                                                    </div>
                                                                                    <div class="btn-group">
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees">Rotate Right</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="15" type="button">15deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="30" type="button">30deg</button>
                                                                                        <button class="btn btn-primary" data-method="rotate" data-option="45" type="button">45deg</button>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <button class="btn btn-primary btn-block avatar-save" type="submit">Done</button>
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
                                            <h3 style="text-transform: capitalize"><%= session.getAttribute("nome")%></h3>

                                            <br />

                                            
                                        </div>
                                        <div class="col-md-9 col-sm-9 col-xs-12">

                                            <div class="profile_title">
                                                <div class="col-md-6">
                                                    <h2>Meus Dados</h2>
                                                </div>
                                                
                                            </div>
                                            <!--colocar corpo aqui-->
                                            <div class="x_content">
                                        <br />
                                        <form id="alteraconsulta"  name="alteraconsulta" action="AlterarNutricionista" method="POST" data-parsley-validate class="form-horizontal form-label-left">

                                                            
                                                            <div class="modal-body">


                                                                <br />


                                                                <div class="form-group"  hidden="">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">ID Pessoa <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${nutricionista.idPessoa}"  id="idConsulta" name="idPessoa" placeholder="ID" required="required" readonly="" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group"  hidden="">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">ID Nutricionista <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${nutricionista.idNutricionista}"  id="idConsulta" name="idNutricionista" placeholder="ID" required="required" readonly="" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Nome <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" style="text-transform: capitalize" value="${nutricionista.nomePessoa}" id="dataConsulta" name="nomePessoa" placeholder="Nome" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">E-mail <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="email" value="${nutricionista.emailPessoa}" id="dataConsulta" name="emailPessoa" placeholder="E-mail" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Senha <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="password" value="${nutricionista.senhaPessoa}" id="horaConsulta" name="senhaPessoa" placeholder="Senha" required="required"  class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                    <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Telefone <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="tel" value="${nutricionista.telefonePessoa}" id="dataConsulta" name="telefonePessoa" placeholder="Telefone" required="required" class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                    <div class="form-group" hidden="">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Status <span ></span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${nutricionista.statusPessoa}"  id="condutaNutricionalConsulta" name="statusPessoa" placeholder="Ainda não há dados nesse campo"  class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                    <div class="form-group" hidden="" >
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Tipo <span></span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${nutricionista.tipoPessoa}" id="obsConsulta" name="tipoPessoa" placeholder="Ainda não há dados nesse campo"  class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                    <div class="form-group" >
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">CRN <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" value="${nutricionista.crnNutricionista}"  id="statusConsulta" name="crnNutricionista" placeholder="Ainda não há dados nesse campo" required="required"  class="form-control col-md-7 col-xs-12">
                                                                    </div>
                                                                </div>
                                                                    
                                                                
                                                                
                                                                
                                                                
                                                            </div>
                                                            <div class="modal-footer">
                                                                
                                                                <a href="<%= request.getContextPath()%>/ListarConsulta?idPessoa=<%=session.getAttribute("id")%>"<button class="btn btn-default">Listar Consultas Agendadas</button></a>
                                                                <a href=""><button type="submit" class="btn btn-primary">Alterar</button></a>
                                                            </div>

                                                        </form>
                                    </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                                                                
                                                                <!--Inicio modal erro alterar nutricionista -->
                                        <div class="modal  bs-example-modalParaDiferenciarDeOutroModal-sm" id="erroAlterarNutricionista" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog modal-sm">
                                                <div class="modal-content">

                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                                        </button>
                                                        <h4 class="modal-title" id="myModalLabel2">Mensagem</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <h4>${sucesso}</h4>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <!--Fim modal erro alterar nutricionista -->

                    <!-- footer content -->
                    <footer>
                        <div class="">
                            <p class="pull-right">
                                <span class="lead">NutriSIS</span>
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
                        "period": "Jan",
                        "Hours worked": <%%>
                    },
                    {
                        "period": "Feb",
                        "Hours worked": 125
                    },
                    {
                        "period": "Mar",
                        "Hours worked": 176
                    },
                    {
                        "period": "Apr",
                        "Hours worked": 224
                    },
                    {
                        "period": "May",
                        "Hours worked": 265
                    },
                    {
                        "period": "Jun",
                        "Hours worked": 314
                    },
                    {
                        "period": "Jul",
                        "Hours worked": 347
                    },
                    {
                        "period": "Aug",
                        "Hours worked": 287
                    },
                    {
                        "period": "Sep",
                        "Hours worked": 240
                    },
                    {
                        "period": "Oct",
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
        ${script}
    </body>

</html>
<% }else{
    response.sendRedirect(request.getContextPath()+("/index.jsp"));
}
%>