/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
//    $.fn.ativaExercicios = function () {
//        $('#exercicios').css("display", "");
//    };
//    //--------------------------------------------
//    $.fn.desativaExercicios = function () {
//        $('#exercicios').css("display", "none");
//    };
    //--------------------------------------------
    $.fn.ativaMedicamentos = function () {
        $('#medicamentos').css("display", "");
        $(this).atualizaMedicamentos();
    };
    $.fn.desativaMedicamentos = function () {
        $('#medicamentos').css("display", "none");
    };
    //--------------------------------------------
    $.fn.ativaPatologias = function () {
        $('#patologias').css("display", "");
    };
    $.fn.desativaPatologias = function () {
        $('#patologias').css("display", "none");
    };
    //--------------------------------------------
    //usando ajax para inserir e atualizar
    $('#selExercicio').change(function () {
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {acao: "listaravaliacaoexercicio"}
        })
                .done(function (msg) {
                    alert(msg);
                });
        $('#selExercicio').prop('selectedIndex', 0);
    });
    //--------------------------------------------
    //-----------Atualizar Tabela---------------------------------
    $.fn.atualizaMedicamentos = function () {
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {
                acao: "tabelalistaravaliacaomedicamento",
                idmedicamento: $('#spnidmedicamento').text(),
                idavaliacao: $('#idavaliacao').text(),
                idpatologia: 0
            }
        })
                .done(function (rs) {
                    $('#contenerMedicamento').css("display", "");
                    $('#contenerMedicamento').html(rs);
                });
    };
    $.fn.atualizaPatologias = function () {
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {
                acao: "listarTabelaAvaliacaoPatologia",
                idavaliacao: $('#idavaliacao').text(),
                idmedicamento: $('#spnidmedicamento').text(),
                idpatologia: $('#spnidpatologia').text()
            }
        })
                .done(function (rs) {
                    $('#contenerPatologia').css("display", "");
                    $('#contenerPatologia').html(rs);
                });
    };
    //exbir inputs para cadastrar
    $.fn.preCadastroMedicamento = function () {
        $('#lblMedicamento').css("display", "");
        $('#lblMedicamento').text($('#selMedicamento option:selected').text());
        $('#preCadastroMedicamento').css("display", "");
        $('#contenerMedicamento').css("display", "none");
        $('#divSelMedicamento').css("display", "none");
    };
    //inserir no banco de dados
    $.fn.cadastrarItensMedicamento = function () {
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {
                acao: "cadastrarMedicamentoAvaliacao",
                dose: $('#dosemedicamento').val(),
                frequencia: $('#frequenciamedicamento').val(),
                idmedicamento: $('#spnidmedicamento').text(),
                idavaliacao: $('#idavaliacao').text(),
                idpatologia: 0
            }
        })
            .done(function () {
                $(this).cancelarCadastroMedicamento();
                $(this).atualizaMedicamentos();
            });
    };
    $('#selPatologia').change(function () {
        $('#spnidpatologia').text($('#selPatologia').val());
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {acao: "cadastrarPatologiaAvaliacao",idavaliacao: $('#idavaliacao').text(),idpatologia: $('#spnidpatologia').text(),idmedicamento: $('#spnidmedicamento').text()}
        })
                .done(function (msg) {
                    //alert(msg);
            $(this).atualizaPatologias();
                });
        $('#selExercicio').prop('selectedIndex', 0);
    });
    //cancelar...
    $.fn.cancelarCadastroMedicamento = function () {
        $('#lblMedicamento').css("display", "none");
        $('#preCadastroMedicamento').css("display", "none");
        $('#contenerMedicamento').css("display", "none");
        $('#divSelMedicamento').css("display", "");
        $('#dosemedicamento').val("");
        $('#frequenciamedicamento').val("");
    };
    //------------Evento ao mudar select--------------------------------
    $('#selMedicamento').change(function () {
        $(this).preCadastroMedicamento();
        $('#spnidmedicamento').text($('#selMedicamento').val());
        $('#selMedicamento').prop('selectedIndex', 0);
    });
    //--------------------------------------------
    //Excluir no banco de dados
    $.fn.excluirAvaliacaoPatologia = function (id) {
        $('#trPat'+id).remove();
        $.ajax({
            method: "POST",
            url: "AjaxAvaliacao",
            data: {
                acao: "excluirItensPatologia",
                id: id,
                idmedicamento: 0,
                idavaliacao: 0,
                idpatologia: 0
            }
        })
            .done(function () {
                $(this).cancelarCadastroMedicamento();
                $(this).atualizaMedicamentos();
            });
    };

    //------------FIM DOCMENT READY--------------------
});