let myLuckyNumber = 2025;
let myName = "Ivan";
alert(myName + " " + myLuckyNumber);
console.log("O meu nome é " + myName + " e meu número da sorte é " + myLuckyNumber);

console.log(`O meu nome é ${myName} e meu número da sorte é ${myLuckyNumber}`);

const MESSAGE = " TASTE THE RAINBOW! ";

console.log(MESSAGE);

let whisper = MESSAGE.toLowerCase().trim();
console.log(whisper);

const WORD = "skateboard";
let facialHair = WORD.slice(5).replace("o", "e");
console.log(facialHair);

let nome = prompt("Qual é o seu primeiro nome?");
let sobrenome = prompt("Qual é o seu último nome?");
alert(`Olá ${nome} ${sobrenome}, seja bem-vindo(a) ao nosso site!`);

//validação dia da semana e senha
let diaSemana = prompt("Qual é o dia da semana?").toLowerCase().trim();

if (diaSemana == "sexta") {
    alert("yay, sobrevivemos a mais uma semana!");

} else if (["segunda", "terça", "quarta", "quinta", "sábado", "domingo"].includes(diaSemana)) {
    alert("Mais um dia normal de trabalho!");

} else {
    alert("Dia inválido! Tente novamente.");
}

let senha = prompt("Digite a senha de 6 caracteres: ");

if (senha.length >= 6) {
    alert("Senha válida!");

}else {
    alert("Senha inválida! Tente novamente.");
}

// swich case
let diaSemanaV2 = prompt("Qual é o dia da semana?");
switch (diaSemanaV2) {
    case "segunda":
        alert("Mais um dia normal de trabalho!");
        break;
    case "terça":
        alert("Mais um dia normal de trabalho!");
        break;
    case "quarta":
        alert("Mais um dia normal de trabalho!");
        break;
    case "quinta":
        alert("Mais um dia normal de trabalho!");
        break;
    case "sexta":
        alert("yay, sobrevivemos a mais uma semana!");
        break;
    case "sábado":
        alert("Mais um dia normal de trabalho!");
        break;
    case "domingo":
        alert("Mais um dia normal de trabalho!");
        break;
    default:
        alert("Dia inválido! Tente novamente.");
}