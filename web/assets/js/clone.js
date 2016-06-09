//$.fn.enumerar = function(){
//    var num = 1;
//    this.each(function(){
//        $(this).children('.numeracao').text(num);
//        num++;
//    });
//    return this;
//};

var clonedRow = $('tbody').clone();
clonedRow.find('jqx-combo-box').val('');
$(this).prev().find($('table tbody')).append(clonedRow);


//
//$(document).ready(function () {
//    $("#btnAdiciona").click(function (e) {
//        e.preventDefault();
//        var htmlBox = $("#multi:first").html();
//        var $newResp = $("<div />");
//        //var ultNum = Number($(".respContent").children(':last-child').children('.numeraco').text()) + 1;
//        $newResp.html(htmlBox);
//        //$newResp.children('.numeracao').text(ultNum);
//
////        if ($(".respContent").html() === '') {
////            $newResp.children('.numeracao').text(1);
////        }
//        $(".respContent").append($newResp);
//    });
//
//    $(".respContent").on('click', '.remover', function (e) {
//        e.preventDefault();
//        var $box = $(this).closest('.respContent');
//        $(this).parent().remove().fadeOut();
//
//    });
//});
//
//
//
//$(document).ready(function () {
//    $("#btnAdicionaRefeicao").click(function (e) {
//        e.preventDefault();
//        var htmlBox = $("#geral:first").html();
//        // var htmlBox1 = $("#geral:first").html();
//        //$(this).html(htmlBox);
//        var $newResp = $("<div/>");
//
//
//        //var ultNum = Number($(".respContentRefeicao").children(':last-child').children('.numeraco').text()) + 1;
//        $newResp.html(htmlBox);
//        //$newResp.children('.numeracao').text(ultNum);
//
////        if ($(".respContentRefeicao").html() === '') {
////            $newResp.children('.numeracao').text(1);
////        }
//        $(".respContentRefeicao").append($newResp);
//
//
//    });
//
//    $(".respContentRefeicao").on('click', '.removerRefeicao', function (e) {
//        e.preventDefault();
//        var $box = $(this).closest('.respContentRefeicao');
//        $(this).parent().remove();
//
//    });
//});


//jQuery(function($) {
//
//    var multiTags = $("#geral");
//
//    function handler(e) {
//        var jqEl = $(e.currentTarget);
//        var tag = jqEl.parent();
//        switch (jqEl.attr("data-action")) {
//        case "adicionar":
//            tag.after(tag.clone().find("select").val("").end());
//            break;
//        case "excluir":
//            tag.remove();
//            break;
//        }
//        return false;
//    }
//
//    multiTags.find("a").live("click", handler);    
//});








