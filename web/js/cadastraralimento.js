/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function enviarDados(event) {
    var form = $("#cadastraralimento");
    form.validate();
    if (form.valid() === true) {

        console.log("teste");
        var formulario = document.getElementById("cadastraralimento");
        formulario.action = "CadastrarAlimento?nometabelanutricionalalimento=" + formulario.nometabelanutricionalalimento.value + "&nomealimento=" +
                formulario.nomealimento.value + "&tipoalimento=" + formulario.tipoalimento.value + "&especiealimento="
                + formulario.especiealimento.value + "&proteinaalimento=" + formulario.proteinaalimento.value + "&lipideoalimento=" +
                formulario.lipideoalimento.value + "&carboidratoalimento=" + formulario.carboidratoalimento.value + "&fibraalimentaralimento=" + formulario.fibraalimentaralimento.value;
        alert(formulario.action);
        formulario.submit();
        event.preventDefault();
    }
}
