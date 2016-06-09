/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {



    $("a[rel=modal]").click(function (ev) {
        ev.preventDefault();
        var id = $(this).attr("href");
        var alturaTela = $(document).height();
        var larguraTela = $(window).width();
        //colocando o fundo preto
        $('#mascara').css({'width': larguraTela, 'height': alturaTela});
        $('#mascara').fadeIn(1000);
        $('#mascara').fadeTo("slow", 0.8);
        var left = ($(window).width() / 2) - ($(id).width() / 2);
        var top = ($(window).height() / 6) - ($(id).height() / 6);
        $(id).css({'top': top, 'left': left});
        $(id).show();
    });
    $("#mascara").click(function () {
        $(this).hide();
        $(".window").hide();
    });
    $('.fechar').click(function (ev) {
        ev.preventDefault();
        $("#mascara").hide();
        $(".window").hide();
    });
});




$(document).ready(function () {

    $("a[rel=modal2]").click(function (ev) {
        ev.preventDefault();
        var id = $(this).attr("href");
        var alturaTela = $(document).height();
        var larguraTela = $(window).width();
        //colocando o fundo preto
        $('#mascara').css({'width': larguraTela, 'height': alturaTela});
        $('#mascara').fadeIn(1000);
        $('#mascara').fadeTo("slow", 0.8);
        var left = ($(window).width() / 0) - ($(id).width() / 0);
        var top = ($(window).height() / 0) - ($(id).height() / 0);
        $(id).css({'top': top, 'left': left});
        $(id).show();
    });
    $("#mascara").click(function () {
        $(this).hide();
        $(".window2").hide();
    });
    $('.fechar').click(function (ev) {
        ev.preventDefault();
        $("#mascara").hide();
        $(".window2").hide();
    });
});


