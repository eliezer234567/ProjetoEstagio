/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function verificarUsuario() {
    var logarusuario = document.getElementById("logarusuario");
    var email = logarusuario.emails.value; //emails não pode ser alterado
    var senha = logarusuario.senha.value;
    //alert("Seu e-mail:" + email + " " +"sua senha:" + senha);

    if (email === "" && senha !== "") {
        alert("Insira um e-mail");
    } else if (senha === "" && email !== "") {
        alert("Insira uma senha");
    } else if (senha === "" && email === "") {
        alert("Insira um e-mail e senha");
    }
}

