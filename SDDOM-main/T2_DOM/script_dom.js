//  ex1 para mudar a cor de fundo de um elemento
function mudarCor(elemento, cor) {
  elemento.style.backgroundColor = cor;
}

// ex2 criar array com nome e preço menor que 20
let christmasGifts = [
  {
    name: "perfume",
    price: 40,
  },
  {
    name: "vinho",
    price: 10,
  },
  {
    name: "creme",
    price: 10,
  },
];

let cheapGifts = christmasGifts
  .filter((gift) => gift.price < 20)
  .map((gift) => ({ name: gift.name, price: gift.price }));
console.log(cheapGifts);

// ex3 transformar array de objetos em texto
const users = [
  { nome: "Rafaela", idade: 22, curso: "JS Avançado" },
  { nome: "Bruno", idade: 30, curso: "UI/UX Design" },
  { nome: "Ana", idade: 25, curso: "AWS" },
];

const userDescriptions = users
  .map((user) => {
    return `${user.nome} tem ${user.idade} anos e está inscrito(a) no curso de ${user.curso}`;
  })
  .join("\n");
console.log(userDescriptions);

// ex4 adicionar um paragrafo de texto no html
function adicionarParagrafo() {
  const p = document.createElement("p");
  p.innerText =
    "É só mais um esforço para tirar o curso de Software Developer e serei um grande programador.";
  document.body.appendChild(p);

  // ex5 adicionar dois novos botões para cada paragrafo anterior
  const botaoMaior = document.createElement("button");
  botaoMaior.innerText = "Aumentar Fonte";
  botaoMaior.onclick = function () {
    p.style.fontSize = parseInt(p.style.fontSize || "16px") + 5 + "px";
    p.style.textAlign = "center"; // ex6 alinha ao centro ao aumentar
  };
  document.body.appendChild(botaoMaior);
  const botaoMenor = document.createElement("button");
  botaoMenor.innerText = "Diminuir Fonte";
  botaoMenor.onclick = function () {
    p.style.fontSize = parseInt(p.style.fontSize || "16px") - 5 + "px";
    p.style.textAlign = "right"; // ex6 alinha à direita ao diminuir
  };
  document.body.appendChild(botaoMenor);
}


// ex7 mostrar e esconder botão
function toggleParagrafo() {
  const p = document.getElementById("EsconderMostrar");
  if (p.style.display === "none") {
    p.style.display = "block";
  } else {
    p.style.display = "none";
  }
}


// ex8 fazer um contador com dois botões e mais um para zerar
let contagem = 0;

function atualizarContador(valor) {
  if (valor === 0) {
    contagem = 0;
  } else {
    contagem += valor;
  }
  document.getElementById("contador").innerText = contagem;
}

function setupTeclado() {
  document.addEventListener("keydown", function (e) {
    if (e.key === "ArrowUp") {
      atualizarContador(1);
    } else if (e.key === "ArrowDown") {
      atualizarContador(-1);
    }
  });
}
window.onload = setupTeclado;


// ex9 fazer uma lista com o que eu já aprendi com JS
function marcarAprendido() {
  const itens = document.querySelectorAll("#lista-js li");
  itens.forEach(function (item) {
    if (!item.innerText.endsWith("- aprendido")) {
      item.innerText += " - aprendido";
    }
  });
}


// ex10 fazer um prompt que pergunta o que mais aprendeu com JS e add na lista do "marcarAprendido"
function adicionarAprendido() {
  const novo = prompt("O que mais você aprendeu em JS?");
  if (novo && novo.trim() !== "") {
    const ul = document.getElementById("lista-js");
    const li = document.createElement("li");
    li.innerText = novo;
    ul.appendChild(li);
  }
}