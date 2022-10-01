/* pegando os elementos via ID do nosso HTML */
const letterContainer = document.getElementById("letter-container")
const optionsContainer = document.getElementById("options-container")
const userInputSection = document.getElementById("user-input-section")
const newGameContainer = document.getElementById("new-game-container")
const newGameButton = document.getElementById("new-game-button")
const canvas = document.getElementById("canvas")
const resultText = document.getElementById("result-text")


//contador
let winCount = 0; //contagem de vitorias
let count = 0; //contador
let chosenWord = "";//palavra escolhida

//exibi botoes de opções
const displayOptions = () => {
  optionsContainer.innerHTML += `<h3>Por favor selecione uma opção</h3>`;
  let buttonCon = document.createElement("div");

  for (let value in options) {
    buttonCon.innerHTML += `<button class="options" onclick="generateWord('${value}')">${value}</button>`;
  }
  optionsContainer.appendChild(buttonCon);
};


//Bloqueia todos os botões
const blocker = () => {
  let optionsButtons = document.querySelectorAll(".options");
  let letterButtons = document.querySelectorAll(".letters");
  //desabilita todas as opções
  optionsButtons.forEach((button) => {
    button.disabled = true;
  });
//desabilita todas as letras
  letterButtons.forEach((button) => {
    button.disabled.true;
  });
  newGameContainer.classList.remove("hide");
};



//Gerador de palavras
const generateWord = (optionValue) => {
  let optionsButtons = document.querySelectorAll(".options");
  //Se optionValue corresponder ao botão innerText, destaque o botão
  optionsButtons.forEach((button) => {
    if (button.innerText.toLowerCase() === optionValue) {
      button.classList.add("active");
    }
    button.disabled = true;
  });

  // inicialmente oculta as letras, limpa a palavra anterior
  letterContainer.classList.remove("hide");
  userInputSection.innerText = "";


  let optionArray = options[optionValue];
  //escolhe a palavra aleatória
  chosenWord = optionArray[Math.floor(Math.random() * optionArray.length)];
  chosenWord = chosenWord.toUpperCase();
 

  //substitui cada letra por span contendo traço
  let displayItem = chosenWord.replace(/./g, '<span class="dashes">-</span>');
  //Exibe cada elemento como span
  userInputSection.innerHTML = displayItem;
}


//Função inicial (chamada quando a página carrega/usuário pressiona novo jogo)
const initializer = () => {
  winCount = 0;
  count = 0;

//Apaga inicialmente todo o conteúdo e oculta as letras e o botão de novo jogo
  userInputSection.innerHTML = "";
  optionsContainer.innerHTML = "";
  letterContainer.classList.add("hide");
  newGameContainer.classList.add("hide");
  letterContainer.innerHTML = "";  

//Para criar botões de letras
for (let i = 65; i < 91; i++) {
  let button = document.createElement("button");
  button.classList.add("letters");
  //Número para ASCII[A-Z]
  button.innerText = String.fromCharCode(i);

  //clique no botão do caractere
  button.addEventListener("click", () => {
    let charArray = chosenWord.split("");
    let dashes = document.getElementsByClassName("dashes");
    //se o array contiver o valor click substitua o traço combinado com a letra senão dram na tela
    if (charArray.includes(button.innerText)) {
      charArray.forEach((char, index) => {
    //se o caractere no array for igual ao botão clicado
    if (char === button.innerText) {
    //substitui traço por letra
    dashes[index].innerText = char;
    //incrementa o contador
    winCount += 1;
    //se a contagem de vitórias for igual ao comprimento da palavra
    if (winCount == charArray.length) {
      resultText.innerHTML = `<h2 class='win-msg'>Você Ganhou!!</h2><p>A palavra era: <span>${chosenWord}</span></p>`;
    //bloqueia todos os botões
    blocker();
      }
    }
  });
    } else {
          //perde a conta
          count += 1;
         //para desenhar homem
          drawMan(count);
          //Contagem==6 porque cabeça, corpo, braço esquerdo, braço direito, perna esquerda, perna direita          
          if (count == 6) {
          resultText.innerHTML = `<h2 class='lose-msg'>Você perdeu!!!</h2><p>A palavra era: <span>${chosenWord}</span></p>`;
          //bloqueia todos os botões
          blocker();
        }
      }
    //desativa o botão clicado
      button.disabled = true;
    });

    letterContainer.append(button);
}
  displayOptions();//chamando a função que exibe os botões 
  //Chamada para canvasCreator (para limpar a tela anterior e criar a tela inicial)
  let { initialDrawing } = canvasCreator();
  //Desenho inicial desenharia o quadro
  initialDrawing();
};


//Novo Jogo
newGameButton.addEventListener("click", initializer);
window.onload = initializer;