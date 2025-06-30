//idexercise html
let img = document.getElementById("unicorn");
let myH1 = document.getElementById("mainheading");

console.log(img);
console.log(myH1);

//todos html
let doneTodos = document.querySelectorAll(".done");
console.log(doneTodos);


const checkbox = document.querySelector("input[type='checkbox']");
console.log(checkbox);

//pickles html
function changeText() {
    let mySpan = document.querySelector("span");
    mySpan.innerText = "Yack";
}


//chicken html
function changeImage() {
    let img = document.querySelector("img");
    if (img.src.includes("chicken.jpg")) {
        img.src = "https://devsprouthosting.com/images/egg.jpg";
    } else {
        img.src = "https://devsprouthosting.com/images/chicken.jpg";
    }
}


// magicalForest html
function alinhamento() {
    let texto = document.getElementById("container")
    let imagem = document.querySelector("img")

    texto.style.textAlign = "center";
    imagem.style.borderRadius = "50%";
    imagem.style.width = "150px";
}

// rainbow html
let spans = document.querySelectorAll("span");
const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];

for(let i = 0; i < spans.length; i++) {
    spans[i].style.color = colors[i];
}

// let contador = 0;
// for(let element of spans) {
//     element.style.color = colors[contador];
//     contador++;
// }

// spans.forEach((element, index) => {
//     element.style.color = colors[index];
// });


// classList html
function mudarDestaque() {
    let lista = document.querySelectorAll("li");

    for(let element of lista) {
        if (element.classList.contains("highlight")) {
            element.classList.remove("highlight");
        } else {
            element.classList.add("highlight");
        }
    }
}


// buttons html
// function createButtons() {
//     let container = document.getElementById("container");
//     for (let i = 1; i <= 100; i++) {
//         let button = document.createElement("button");
//         button.innerText = `Botão ${i}`;
//         container.appendChild(button);
//     }
// }

// createButtons();

// function createButtons(){
//     let minhaDiv = document.getElementById("container");

//     for(let i = 1; i <= 100; i++) {
//     let meubotao = document.createElement("button");
//     meubotao.innerText = "Clique aqui"+i;
//     meubotao.classList.add("meubotao");

//     minhaDiv.appendChild(meubotao);
// }
// }
// createButtons();


// hello html
window.addEventListener("DOMContentLoaded", function() {
    // Botões hello e goodbye
    let helloButton = document.getElementById("hello");
    let byeButton = document.getElementById("goodbye");

    if (helloButton) {
        helloButton.addEventListener("mouseover", function() {
            alert("olá, mundo!");
        });
    }

    if (byeButton) {
        byeButton.addEventListener("mouseover", function() {
            alert("Adeus, mundo!");
        });
    }
});


   window.addEventListener("DOMContentLoaded", function() {
    // Botão random color
    const randomBtn = document.getElementById("change-color");
    const colorText = document.getElementById("new-color");

    if (randomBtn) {
        randomBtn.addEventListener("click", function() {
            // Gera uma cor hexadecimal aleatória
            const randomColor = "#" + Math.floor(Math.random()*16777215).toString(16).padStart(6, "0");
            document.getElementById("container").style.backgroundColor = randomColor;
            if (colorText) {
                colorText.innerText = randomColor;
            }
        });
    }
});


// calculadora simples (hello html)
function calcular() {
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let operacao = document.getElementById("operação").value;
    let resultado;

    switch (operacao) {
        case "soma":
            resultado = num1 + num2;
            break;
        case "subtração":
            resultado = num1 - num2;
            break;
        case "multiplicação":
            resultado = num1 * num2;
            break;
        case "divisão":
            if (num2 !== 0) {
                resultado = num1 / num2;
            } else {
                resultado = "Erro: Divisão por zero";
            }
            break;
        default:
            resultado = "Operação inválida";
    }

    document.getElementById("resultado").innerText = `Resultado: ${resultado}`;
}

let myForm = document.querySelector('form');

// myForm.addEventListener('submit', function(e){
//   e.preventDefault()
//   console.log('cucu, faz validações e coisas de ui/ux, nomeadamente bloquear o botão');

//   const animalVal = document.querySelector('#animal').value;
//   const myList = document.querySelector('#zoo-animals');
//   const myLi = document.createElement('li');
//   myLi.textContent = animalVal;


//   myList.appendChild(myLi)

//   myForm.reset();
//   //esperamos que o servidor nos dê ok que recebeu os dados
//   //myForm.submit();
// })

// let myFormG = document.getElementById('myShoppingList');

// myFormG.addEventListener('submit', function(e){
//   e.preventDefault();
//   const formData = new FormData(this);

//   const li = document.createElement('li');
//   const myUl = document.querySelector('ul');
//   li.innerText = formData.get('product') + '-' + formData.get('qt');
//   myUl.appendChild(li)

//   myFormG.reset();
// });


//função que faz a consulta À Api, traz o resultado em json e tranforma de forma a que o JS consiga interpretar
const loadTVShow = async() => {
  const result = await fetch('https://api.tvmaze.com/singlesearch/shows?q=friends');
  const data = await result.json();
 
  return data;
}
 
//função que constrói com o resultado da api (quando ele chegar) o html
const getData = async() => {
  const result = await loadTVShow();
 
  //console log ou criar elementos, etc
  console.log(result)
}
 
getData();