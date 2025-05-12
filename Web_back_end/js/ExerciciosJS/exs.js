//ex 17
let myLuckyNumber = 16;
let myName = 'Sara';


//sintaxe tradicional 
console.log("o meu nome é "+myName+ " e o meu número preferido é "+myLuckyNumber);

//sintaxe simplificada 
console.log(`o meu nome é ${myName} e o meu número preferido ${myLuckyNumber}`);


//ex pp 28
const MESSAGE = " TASTE THE RAINBOW ";
console.log(MESSAGE)
let whisper = MESSAGE.toLowerCase().trim();
console.log(whisper)

//pp30
const WORD = "skateboard";
let facialHair = WORD.slice(5).replace("o", "e")
console.log(facialHair);

let myVar;

console.log(myVar)

//ex pp 35
// let myFirstVar = prompt('Qual é o teu primeiro nome?');
// let surname = prompt('Qual é o teu primeiro apelido?');

// alert(`Olá ${myFirstVar} ${surname}`);
// console.log(`Olá ${myFirstVar} ${surname}`);

//ex pp 39
// let userWeekDay = prompt('que dia da semana é?');

// if(userWeekDay.toLowerCase().trim() == 'sexta'){
//     console.log('yay, sobrevivemos a mais uma semana');
// }else{
//     console.log('força nisso');
// }

// let userPass = prompt('Qual é a sua pass?');

// if(userPass.length < 6){
//     console.log('a pass tem que ter pelo menos 6 caracteres');
// }else{
//     console.log('pass ok');
// }

//pp 43
// let planets = ['Mercúrio', 'Vénus', 'Terra', 'Mart', 'Jupiter', 'Saturno', 'Urano', 'Neptuno', 'Plutão'];
// let oldPlanets = planets;
// planets[3] = 'Marte';
// planets.pop();
// planets.unshift('novoPlaneta');
// console.log(planets)

//pp 55
// for(let i =0; i<6; i++){
//     console.log(i+ ' Da ba dee da ba daa');
// }

// for(let i = 25 ; i>=5 ; i-=5){
//     console.log(i);
// }


// const people = ["Scooby", "Velma", "Fred", "Daphne", "Shaggy", "Fred"];
// for (let p = 0; p < people.length; p++) {
//     console.log(people[p].toUpperCase());
// }


let listaCompras = [];
let codigo = "fim";

while (true) {
    let itemLista = prompt("Digite um produto para adicionar ou 'apagar' para remover um item (ou 'fim' para sair):").toLowerCase();

    if (itemLista === codigo) break;

    if (itemLista === "apagar") {
        if (listaCompras.length === 0) {
            alert("A lista está vazia. Nada para apagar!");
        } else {
            let itemParaApagar = prompt("Digite o nome do item que deseja apagar:");
            let index = listaCompras.indexOf(itemParaApagar);

            if (index !== -1) {
                listaCompras.splice(index, 1);
                alert(`O item "${itemParaApagar}" foi removido. Lista atualizada!`);
            } else {
                alert(`O item "${itemParaApagar}" não foi encontrado na lista.`);
            }
        }
    } else {
        listaCompras.push(itemLista);
    }
}

console.log(listaCompras);