/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validacaoAlimentoNomeT() {
    var msg = "";

    if (document.cadastraralimento.nometabelanutricionalalimento.value === "") {
        msg = "Informe o nome da tabela nutricional !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (msg === "") {
        return true;
    } else {
//        var form = $(this).closest(".contact-form row");
//        form.find("label:hidden");
        console.log(msg);
        return false;

    }
}

function validacaoAlimentoNomeA() {
    var msg = "";

    if (document.cadastraralimento.nomealimento.value === "") {
        msg = "Informe o nome do Alimento !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (msg === "") {
        return true;
    } else {
//        var form = $(this).closest(".contact-form row");
//        form.find("label:hidden");
//        document.cadastraralimento.validacaoalimento.value = "teste";
        document.cadastraralimento.validacaoalimento.hiddan = "false";
//        
//        document.write(msg);
        console.log(msg);
        return false;

    }
}

function validacaoAlimentoTipoA() {
    var msg = "";

    if (document.cadastraralimento.nomealimento.value === "") {
        msg = "Informe o tipo do alimento !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (msg === "") {
        return true;
    } else {
//        var form = $(this).closest(".contact-form row");
//        form.find("label:hidden");
        console.log(msg);
        return false;

    }
}

function validacaoAlimentoEspecieA() {
    var msg = "";

    if (document.cadastraralimento.especiealimento.value === "") {
        msg = "Informe espécie do alimento !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (msg === "") {
        return true;
    } else {
//        var form = $(this).closest(".contact-form row");
//        form.find("label:hidden");
        console.log(msg);
        return false;

    }
}



function validacaoAlimento() {

    var msg = "";

    if (document.cadastraralimento.nometabelanutricionalalimento.value === "") {
        msg = "Informe o nome da tabela nutricional !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (document.cadastraralimento.nomealimento.value === "") {
        msg += "Informe o nome do alimento !\n";
        //document.form.nometabelanutricionalalimento.focus();
    }
    if (document.cadastraralimento.tipoalimento.value === "") {
        msg += "Informe o tipo do alimento !\n";

    }
    if (document.cadastraralimento.especiealimento.value === "") {
        msg += "Informe especie do alimento !\n";

    }
//    if (document.cadastraralimento.proteinaalimento.value === "") {
//        msg += "Informe a proteina do alimento !\n";
//  
//    }
//    if (document.cadastraralimento.lipideoalimento.value === "") {
//        msg += "Informe o lipideo do alimento !\n";
//      
//    }
//    if (document.cadastraralimento.carboidratoalimento.value === "") {
//        msg += "Informe o carboidrato do alimento !\n";
//      
//    }
//    if (document.cadastraralimento.fibraalimentaralimento.value === "") {
//        msg += "Informe a fibra alimentar !\n";
//      
//    }
    if (msg === "") {
        return true;
    } else {
        alert(msg);
        return false;
    }
}


function validacaoCardapioTipo() {
    var msg = "";

    if (document.cadastrarcardapio.tipocardapio.value === "") {
        msg = "Informe o nome da tabela nutricional !\n";
    }
    if (msg === "") {
        return true;
    } else {
        console.log(msg);
        return false;

    }
}

function validacaoCardapioNome() {
    var msg = "";

    if (document.cadastrarcardapio.nomecardapio.value === "") {
        msg = "Informe o nome do cardápio !\n";
    }
    if (msg === "") {
        return true;
    } else {
        console.log(msg);
        return false;

    }
}

function validacaoCardapioDataI() {
    var msg = "";

    if (document.cadastrarcardapio.datainiciocardapio.value === "") {
        msg = "Informe o data de início!\n";
    }
    if (msg === "") {
        return true;
    } else {
        console.log(msg);
        return false;

    }
}

function validacaoCardapioDataF() {
    var msg = "";

    if (document.cadastrarcardapio.datafinalcardapio.value === "") {
        msg = "Informe o data de final!\n";
    }
    if (msg === "") {
        return true;
    } else {
        console.log(msg);
        return false;

    }
}


function validacaoEvolucaoPaciente() {
    if (document.cadastrarevolucaopaciente.pesoevolucaopaciente.value === "") {
        alert("Por favor, preecha o campo peso ");
        document.form.pesoevolucaopaciente.focus();
        return false;
    }
}



