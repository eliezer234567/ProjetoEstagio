/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// validando senha paciente
function validaSenhaPaciente(input) {
    if (input.value != document.getElementById('senhaPessoa').value) {
        input.setCustomValidity('Repita a senha corretamente');
    } else {
        input.setCustomValidity('');
    }
}
// validando senha nutricionista
function validaSenhaNutricionista(input) {
    if (input.value != document.getElementById('senhaPessoa1').value) {
        input.setCustomValidity('Repita a senha corretamente');
    } else {
        input.setCustomValidity('');
    }
}
// validando idade
function myFuncction() {
    var x, text;

    // Get the value of the input field with id="numb"
    x = document.getElementById("idadePaciente").value;

    // If x is Not a Number or less than one or greater than 10
    if (isNaN(x) || x < 18 || x > 65) {
        window.alert('Idade não permitida');

        document.getElementById("dataNascimentoPaciente").focus();
    } else {
        text = "";
    }
    document.getElementById("demo").innerHTML = text;
}

function idade(data) {

    var today = new Date();
    var birthDate = new Date(data);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    document.cadastropacientes.txtIdade.value = age; //nomeForm voce coloca o nome da sua form !!!!
}


function idade(data) {

    var today = new Date();
    var birthDate = new Date(data);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    document.getElementById("idadePaciente").value = age; //nomeForm voce coloca o nome da sua form !!!!
}


