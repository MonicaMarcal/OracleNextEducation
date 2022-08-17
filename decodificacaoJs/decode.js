/*metodo normalize = Ele serve para converter uma string em seu formato Unicode padrão.
Neste caso, usamos o parâmetro NFD que pode separar os acentos das letras e retornar
seus códigos Unicode.
o método substitui todas as ocorrências de caracteres diacríticos,
combinando-os na sequência Unicode \u0300 - \u036F, outra vantagem do ES6 que
foi adicionada para permitir intervalos Unicode no RegEx.
remover todos os elementos especiais (accent) usando o método replace.
https://ricardometring.com/javascript-replace-special-characters
https://www.w3schools.com/jsref/jsref_obj_regexp.asp
https://www.w3schools.com/jsref/jsref_regexp_test.asp

*/

var inputTextResult = document.querySelector("#inputTextResult");//area que recebe texto do usuario para criptografar
var outputTextResult = document.querySelector("#outputTextResult");// area que recebe texto criptografado

var buttonEncrypt = document.querySelector("#buttonEncrypt"); //botão de criptografia
var buttonDecrypt = document.querySelector("#buttonDecrypt");//botão de descriptografia
var buttonCopy = document.querySelector("#buttonCopy");//botão para copiar a criptografia

var userTextInput = /[(0-9)]/gim; // [0-9] 	Encontre qualquer caractere entre colchetes (qualquer dígito) - gim modificadores
 
function validateInput(text) {
    if (userTextInput.test(text)) {
        return "Digite apenas letras minúsculas e sem acento!";
    } else {
        return text;
    }
}

//função criptografar
function encrypt(inputTextResult) {
  encryptionResult = inputTextResult.normalize('NFD') 
   .replace(/[\u0300-\u036f]/g, "") //removendo caracteres especiais 
   .replace(/[eE]/g, "enter")
   .replace(/[iI]/g, "imes")
   .replace(/[aA]/g, "ai")
   .replace(/[oO]/g, "ober")
   .replace(/[uU]/g, "ufat").toLowerCase();

  return encryptionResult;
}

buttonEncrypt.addEventListener('click', (event) => {
  event.preventDefault();
  outputTextResult.textContent = validateInput(encrypt(inputTextResult.value));
  
  inputTextResult.value = "";

})

/*Função para descriptografar */
function decrypt(text) {
 decryptionResult = text
      .replace(/enter/g, 'e')
      .replace(/imes/g, 'i')
      .replace(/ai/g, 'a')
      .replace(/ober/g, 'o')
      .replace(/ufat/g, 'u')

  return decryptionResult;
}

buttonDecrypt.addEventListener('click', (event) => {
  event.preventDefault();

  outputTextResult.textContent = decrypt(inputTextResult.value);
  inputTextResult.value = "";
})

//função copiar a criptografia
buttonCopy.addEventListener('click', (event) => {
  event.preventDefault();
  outputTextResult.select();
  inputTextResult.value = "";
  document.execCommand("copy");
})