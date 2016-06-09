/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// submetendo formulario paciente
function enviarDadosPaciente() {

    var formulario = document.getElementById("cadastropacientes");
    var nome = formulario.nomePessoa.value;
    var email = formulario.emailPessoa.value;
    var senha = formulario.senhaPessoa.value;
    var confirmarSenhaPessoa = formulario.confirmarSenhaPessoa.value;
    var telefone = formulario.telefonePessoa.value;
    var idade = formulario.idadePaciente.value;
    var dataNascimento = formulario.dataNascimentoPaciente.value;
    var sexo = formulario.sexoPaciente.value;

    if (nome === "" || email === "" || senha === "" || confirmarSenhaPessoa === "" || confirmarSenhaPessoa !== senha || telefone === "" || idade === "" || dataNascimento === "" || sexo === "") {
        //alert("Preencha todos os campos");
        return;

    } else {
        formulario.action = "CadastrarPaciente?idadePaciente=" + formulario.idadePaciente.value +
                "&dataNascimentoPaciente=" + formulario.dataNascimentoPaciente.value +
                "&sexoPaciente=" + formulario.sexoPaciente.value +
                "&nomePessoa=" + formulario.nomePessoa.value +
                "&senhaPessoa=" + formulario.senhaPessoa.value +
                "&emailPessoa=" + formulario.emailPessoa.value +
                "&telefonePessoa=" + formulario.telefonePessoa.value;



        //alert(formulario.action);
        //alert ("Paciente cadastrado com sucesso");

        formulario.submit();

    }

}


// submetendo formulaio nutricionista
function enviarDadosNutricionista() {

    var formulario = document.getElementById("cadastronutricionistas");
    var email = formulario.emailPessoa.value;
    var nome = formulario.nomePessoa.value;
    var senha = formulario.senhaPessoa.value;
    var confirmarSenhaPessoa = formulario.confirmarSenhaPessoa.value;
    var telefone = formulario.telefonePessoa.value;
    var crn = formulario.crnNutricionista.value;

    //alert("Nome: "+nome+ " Email: "+email+ " Senha: "+senha+" Telefone: "+telefone+" CRN: "+crn);
    if (nome === "" || email === "" || senha === "" || telefone === "" || crn === "" || confirmarSenhaPessoa !== senha || confirmarSenhaPessoa === null) {
        //alert("nulos");
        //window.location.href = "index.jsp";
        return;
    } else {
        formulario.action = "CadastrarNutricionista?crnNutricionista=" + formulario.crnNutricionista.value +
                "&nomePessoa=" + formulario.nomePessoa.value +
                "&senhaPessoa=" + formulario.senhaPessoa.value +
                "&emailPessoa=" + formulario.emailPessoa.value +
                "&telefonePessoa=" + formulario.telefonePessoa.value;



        //alert(formulario.action);
        //alert("Nutricionista cadastrado com sucesso");

        formulario.submit();
    }


}



//submetendo formulario paciente atraves do nutricionista
function NutricionistaEnviaDadosPaciente() {

    var formulario = document.getElementById("cadastropacientes");
    var nome = formulario.nomePessoa.value;
    var email = formulario.emailPessoa.value;
    var senha = formulario.senhaPessoa.value;
    var confirmarSenhaPessoa = formulario.confirmarSenhaPessoa.value;
    var telefone = formulario.telefonePessoa.value;
    var idade = formulario.idadePaciente.value;
    var dataNascimento = formulario.dataNascimentoPaciente.value;
    var sexo = formulario.sexoPaciente.value;

    if (nome === "" || email === "" || senha === "" || confirmarSenhaPessoa === "" || confirmarSenhaPessoa !== senha || telefone === "" || idade === "" || dataNascimento === "" || sexo === "") {
        //alert("Preencha todos os campos");
        return;

    } else {
        formulario.action = "../NutricionistaCadastraPaciente?idadePaciente=" + formulario.idadePaciente.value +
                "&dataNascimentoPaciente=" + formulario.dataNascimentoPaciente.value +
                "&sexoPaciente=" + formulario.sexoPaciente.value +
                "&nomePessoa=" + formulario.nomePessoa.value +
                "&senhaPessoa=" + formulario.senhaPessoa.value +
                "&emailPessoa=" + formulario.emailPessoa.value +
                "&telefonePessoa=" + formulario.telefonePessoa.value;



        //alert(formulario.action);
        //alert ("Paciente cadastrado com sucesso");

        formulario.submit();

    }

}

