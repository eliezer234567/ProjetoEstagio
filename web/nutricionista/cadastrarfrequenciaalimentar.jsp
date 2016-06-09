<!DOCTYPE html>
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
            <script src="../assets/js/ie8-responsive-file-warning.js"></script>
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


                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('#birthday').daterangepicker({
                                singleDatePicker: true,
                                calender_style: "picker_4"
                            }, function (start, end, label) {
                                console.log(start.toISOString(), end.toISOString(), label);
                            });
                        });
                    </script>


                    <div class="row">
                        <form id="demo-form" data-parsley-validate id="cadastrarfrequenciaalimentar" name="cadastrarfrequenciaalimentar" action="../CadastrarFrequenciaAlimentar" method="POST">
                            <div class="col-md-6 col-xs-12">

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Cadastro De Frequencia Alimentar </h2>

                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">

                                        <!-- start form for validation -->


                                        <label>Frutas </label>
                                        <p>
                                            <input type="radio" class="flat"  id="frutafrequenciaalimentar" name="frutaFrequenciaAlimentar" value="DF" required=""> Diariamente
                                            <input type="radio" class="flat"  id="frutafrequenciaalimentar" name="frutaFrequenciaAlimentar" value="VF" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat"  id="frutafrequenciaalimentar" name="frutaFrequenciaAlimentar"  value="FF" required=""> Final de Semana
                                            <input type="radio" class="flat"  id="frutafrequenciaalimentar" name="frutaFrequenciaAlimentar"  value="RF" required=""> Raramente
                                        </p>
                                        <label>Verduras </label>
                                        <p> 
                                            <input type="radio" class="flat" id="verdurafrequenciaalimentar" name="verdurasFrequenciaAlimentar" value="DV" required=""> Diariamente
                                            <input type="radio" class="flat" id="verdurafrequenciaalimentar" name="verdurasFrequenciaAlimentar" value="VV" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="verdurafrequenciaalimentar" name="verdurasFrequenciaAlimentar"  value="FV" required=""> Final de Semana
                                            <input type="radio" class="flat" id="verdurafrequenciaalimentar" name="verdurasFrequenciaAlimentar"  value="RV" required=""> Raramente
                                        </p>
                                        <label>Legumes </label>
                                        <p>
                                            <input type="radio" class="flat"  id="legumefrequenciaalimentar" name="legumesFrequenciaAlimentar" value="DL" required=""> Diariamente
                                            <input type="radio" class="flat"  id="legumefrequenciaalimentar" name="legumesFrequenciaAlimentar" value="VL" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat"  id="legumefrequenciaalimentar" name="legumesFrequenciaAlimentar"  value="FL" required=""> Final de Semana
                                            <input type="radio" class="flat"  id="legumefrequenciaalimentar" name="legumesFrequenciaAlimentar"  value="RL" required=""> Raramente
                                        </p>
                                        <label>Carne Vermelha </label>
                                        <p>
                                            <input type="radio" class="flat" id="carnevermelhafrequenciaalimentar" name="carnevermelhaFrequenciaAlimentar" value="DCV" required=""> Diariamente
                                            <input type="radio" class="flat" id="carnevermelhafrequenciaalimentar" name="carnevermelhaFrequenciaAlimentar" value="VCV" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="carnevermelhafrequenciaalimentar" name="carnevermelhaFrequenciaAlimentar"  value="FCV" required=""> Final de Semana
                                            <input type="radio" class="flat" id="carnevermelhafrequenciaalimentar" name="carnevermelhaFrequenciaAlimentar"  value="RCV" required=""> Raramente
                                        </p>
                                        <label>Carne Branca </label>
                                        <p>
                                            <input type="radio" class="flat" id="carnebrancafrequenciaalimentar" name="carnebrancaFrequenciaAlimentar" value="DCB" required=""> Diariamente
                                            <input type="radio" class="flat" id="carnebrancafrequenciaalimentar" name="carnebrancaFrequenciaAlimentar" value="VCB" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="carnebrancafrequenciaalimentar" name="carnebrancaFrequenciaAlimentar"  value="FCB" required=""> Final de Semana
                                            <input type="radio" class="flat" id="carnebrancafrequenciaalimentar" name="carnebrancaFrequenciaAlimentar"  value="RCB" required=""> Raramente
                                        </p>
                                        <label>Leite </label>
                                        <p>
                                            <input type="radio" class="flat" id="leitefrequenciaalimentar" name="leitederivadosFrequenciaAlimentar" value="DLE" required=""> Diariamente
                                            <input type="radio" class="flat" id="leitefrequenciaalimentar" name="leitederivadosFrequenciaAlimentar" value="VLE" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="leitefrequenciaalimentar" name="leitederivadosFrequenciaAlimentar"  value="FLE" required=""> Final de Semana
                                            <input type="radio" class="flat" id="leitefrequenciaalimentar" name="leitederivadosFrequenciaAlimentar"  value="RLE" required=""> Raramente
                                        </p>
                                        <label>Ovos </label>
                                        <p>
                                            <input type="radio" class="flat" id="ovosfrequenciaalimentar" name="ovosFrequenciaAlimentar" value="DO" required=""> Diariamente
                                            <input type="radio" class="flat" id="ovosfrequenciaalimentar" name="ovosFrequenciaAlimentar" value="VO" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="ovosfrequenciaalimentar" name="ovosFrequenciaAlimentar"  value="FO" required=""> Final de Semana
                                            <input type="radio" class="flat" id="ovosfrequenciaalimentar" name="ovosFrequenciaAlimentar"  value="RO" required=""> Raramente
                                        </p>
                                        <label>Cereais </label>
                                        <p>
                                            <input type="radio" class="flat" id="cereaisfrequenciaalimentar" name="cereaisFrequenciaAlimentar" value="DC" required=""> Diariamente
                                            <input type="radio" class="flat" id="cereaisfrequenciaalimentar" name="cereaisFrequenciaAlimentar" value="VC" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="cereaisfrequenciaalimentar" name="cereaisFrequenciaAlimentar"  value="FC" required=""> Final de Semana
                                            <input type="radio" class="flat" id="cereaisfrequenciaalimentar" name="cereaisFrequenciaAlimentar"  value="RC" required=""> Raramente
                                        </p>

                                    </div>

                                </div>



                            </div>


                            <!-- inicio modal erro -->
                            <div class="modal fade bs-example-modal-sm" tabindex="-1" id="mensagemModal" role="dialog" aria-hidden="true">
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
                                            <button type="button" autofocus="" class="btn btn-group-justified btn-primary" data-dismiss="modal">OK</button>
                                            <!--<button type="button" class="btn btn-primary">Save changes</button>-->
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- final modal erro  -->


                            <div class="col-md-6 col-xs-12">
                                <div class="x_panel">
                                    <!--                                <div class="x_title">
                                                                        <h2>Cadastro De Frequencia Alimentar </h2>
                                    
                                                                        <div class="clearfix"></div>
                                                                    </div>-->
                                    <div class="x_content">
                                        <!--<form id="demo-form" data-parsley-validate id="cadastrarfrequenciaalimentar" name="cadastrarfrequenciaalimentar" action="../CadastrarFrequenciaAlimentar" method="POST">-->
                                        <label>Massas </label>
                                        <p>
                                            <input type="radio" class="flat" id="massafrequenciaalimentar" name="massasFrequenciaAlimentar" value="DM" required=""> Diariamente
                                            <input type="radio" class="flat" id="massafrequenciaalimentar" name="massasFrequenciaAlimentar" value="VM" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="massafrequenciaalimentar" name="massasFrequenciaAlimentar"  value="FM" required=""> Final de Semana
                                            <input type="radio" class="flat" id="massafrequenciaalimentar" name="massasFrequenciaAlimentar"  value="RM" required=""> Raramente
                                        </p>
                                        <label>Leguminosas </label>
                                        <p>
                                            <input type="radio" class="flat" id="leguminosasfrequenciaalimentar" name="leguminosasFrequenciaAlimentar" value="DLEG" required=""> Diariamente
                                            <input type="radio" class="flat" id="leguminosasfrequenciaalimentar" name="leguminosasFrequenciaAlimentar" value="VLEG" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="leguminosasfrequenciaalimentar" name="leguminosasFrequenciaAlimentar"  value="FLEG" required=""> Final de Semana
                                            <input type="radio" class="flat" id="leguminosasfrequenciaalimentar" name="leguminosasFrequenciaAlimentar"  value="RLEG" required=""> Raramente
                                        </p>
                                        <label>Pães </label>
                                        <p>
                                            <input type="radio" class="flat" id="paesfrequenciaalimentar" name="paesFrequenciaAlimentar" value="DP" required=""> Diariamente
                                            <input type="radio" class="flat" id="paesfrequenciaalimentar" name="paesFrequenciaAlimentar" value="VP" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="paesfrequenciaalimentar" name="paesFrequenciaAlimentar"  value="FP" required=""> Final de Semana
                                            <input type="radio" class="flat" id="paesfrequenciaalimentar" name="paesFrequenciaAlimentar"  value="RP" required=""> Raramente
                                        </p>
                                        <label>Doces </label>
                                        <p>
                                            <input type="radio" class="flat" id="docesfrequenciaalimentar" name="docesFrequenciaAlimentar" value="DD" required=""> Diariamente
                                            <input type="radio" class="flat" id="docesfrequenciaalimentar" name="docesFrequenciaAlimentar" value="VD" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="docesfrequenciaalimentar" name="docesFrequenciaAlimentar"  value="FD" required=""> Final de Semana
                                            <input type="radio" class="flat" id="docesfrequenciaalimentar" name="docesFrequenciaAlimentar"  value="RD" required=""> Raramente
                                        </p>
                                        <label>Refrigerante </label>
                                        <p>
                                            <input type="radio" class="flat" id="refrigerantefrequenciaalimentar" name="refrigeranteFrequenciaAlimentar" value="DR" required=""> Diariamente
                                            <input type="radio" class="flat" id="refrigerantefrequenciaalimentar" name="refrigeranteFrequenciaAlimentar" value="VR" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="refrigerantefrequenciaalimentar" name="refrigeranteFrequenciaAlimentar"  value="FR" required=""> Final de Semana
                                            <input type="radio" class="flat" id="refrigerantefrequenciaalimentar" name="refrigeranteFrequenciaAlimentar"  value="RR" required=""> Raramente
                                        </p>
                                        <label>Bebidas Alcoolicas </label>
                                        <p>
                                            <input type="radio" class="flat" id="alcoolfrequenciaalimentar" name="alcoolFrequenciaAlimentar" value="DA" required=""> Diariamente
                                            <input type="radio" class="flat" id="alcoolfrequenciaalimentar" name="alcoolFrequenciaAlimentar" value="VA" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="alcoolfrequenciaalimentar" name="alcoolFrequenciaAlimentar"  value="FA" required=""> Final de Semana
                                            <input type="radio" class="flat" id="alcoolfrequenciaalimentar" name="alcoolFrequenciaAlimentar"  value="RA" required=""> Raramente
                                        </p>
                                        <label>Gordurosos </label>
                                        <p>
                                            <input type="radio" class="flat" id="gordurososfrequenciaalimentar" name="gordurososFrequenciaAlimentar" value="DG" required=""> Diariamente
                                            <input type="radio" class="flat" id="gordurososfrequenciaalimentar" name="gordurososFrequenciaAlimentar" value="VG" required=""> 3 vezes por Semana
                                            <input type="radio" class="flat" id="gordurososfrequenciaalimentar" name="gordurososFrequenciaAlimentar"  value="FG" required=""> Final de Semana
                                            <input type="radio" class="flat" id="gordurososfrequenciaalimentar" name="gordurososFrequenciaAlimentar"  value="RG" required=""> Raramente
                                        </p>
                                        <!--</form>-->
                                    </div>
                                </div>
                            </div> 
                            <div class="col-md-6 col-xs-12">
                                <div class="x_panel">
                                    <!--<button type="reset" class="btn btn-default">Cancelar</button>-->
                                    <button type="submit" class="btn btn-primary">Cadastrar</button>

                                </div></div>
                        </form>
                    </div>
                </div>
                <!-- /page content -->

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
    <script type="text/javascript">
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
    <script src="js/custom.js"></script>


    <!-- select2 -->
    <script>
                        $(document).ready(function () {
                            $(".select2_single").select2({
                                placeholder: "Select a state",
                                allowClear: true
                            });
                            $(".select2_group").select2({});
                            $(".select2_multiple").select2({
                                maximumSelectionLength: 4,
                                placeholder: "With Max Selection limit 4",
                                allowClear: true
                            });
                        });
    </script>
    <!-- /select2 -->
    <!-- input tags -->
    <script>
        function onAddTag(tag) {
            alert("Added a tag: " + tag);
        }

        function onRemoveTag(tag) {
            alert("Removed a tag: " + tag);
        }

        function onChangeTag(input, tag) {
            alert("Changed a tag: " + tag);
        }

        $(function () {
            $('#tags_1').tagsInput({
                width: 'auto'
            });
        });
    </script>
    <!-- /input tags -->
    <!-- form validation -->
    <script type="text/javascript">
        $(document).ready(function () {
            $.listen('parsley:field:validate', function () {
                validateFront();
            });
            $('#demo-form .btn').on('click', function () {
                $('#demo-form').parsley().validate();
                validateFront();
            });
            var validateFront = function () {
                if (true === $('#demo-form').parsley().isValid()) {
                    $('.bs-callout-info').removeClass('hidden');
                    $('.bs-callout-warning').addClass('hidden');
                } else {
                    $('.bs-callout-info').addClass('hidden');
                    $('.bs-callout-warning').removeClass('hidden');
                }
            };
        });

        $(document).ready(function () {
            $.listen('parsley:field:validate', function () {
                validateFront();
            });
            $('#demo-form2 .btn').on('click', function () {
                $('#demo-form2').parsley().validate();
                validateFront();
            });
            var validateFront = function () {
                if (true === $('#demo-form2').parsley().isValid()) {
                    $('.bs-callout-info').removeClass('hidden');
                    $('.bs-callout-warning').addClass('hidden');
                } else {
                    $('.bs-callout-info').addClass('hidden');
                    $('.bs-callout-warning').removeClass('hidden');
                }
            };
        });
        try {
            hljs.initHighlightingOnLoad();
        } catch (err) {
        }
    </script>
    <!-- /form validation -->
    <!-- editor -->
    <script>
        $(document).ready(function () {
            $('.xcxc').click(function () {
                $('#descr').val($('#editor').html());
            });
        });

        $(function () {
            function initToolbarBootstrapBindings() {
                var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                    'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                    'Times New Roman', 'Verdana'],
                        fontTarget = $('[title=Font]').siblings('.dropdown-menu');
                $.each(fonts, function (idx, fontName) {
                    fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
                });
                $('a[title]').tooltip({
                    container: 'body'
                });
                $('.dropdown-menu input').click(function () {
                    return false;
                })
                        .change(function () {
                            $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
                        })
                        .keydown('esc', function () {
                            this.value = '';
                            $(this).change();
                        });

                $('[data-role=magic-overlay]').each(function () {
                    var overlay = $(this),
                            target = $(overlay.data('target'));
                    overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
                });
                if ("onwebkitspeechchange" in document.createElement("input")) {
                    var editorOffset = $('#editor').offset();
                    $('#voiceBtn').css('position', 'absolute').offset({
                        top: editorOffset.top,
                        left: editorOffset.left + $('#editor').innerWidth() - 35
                    });
                } else {
                    $('#voiceBtn').hide();
                }
            }
            ;

            function showErrorAlert(reason, detail) {
                var msg = '';
                if (reason === 'unsupported-file-type') {
                    msg = "Unsupported format " + detail;
                } else {
                    console.log("error uploading file", reason, detail);
                }
                $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
            }
            ;
            initToolbarBootstrapBindings();
            $('#editor').wysiwyg({
                fileUploadError: showErrorAlert
            });
            window.prettyPrint && prettyPrint();
        });
    </script>
    <!-- /editor -->

    ${script}
</body>

</html>