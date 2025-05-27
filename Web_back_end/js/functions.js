function MinhaLista() {
    let product = {
    nome: 'portátil',
    inStock: true,
    price: 1.99,
    moeda : '€',
    colors: ['red', 'blue', 'green'],
}

product.price = 2.55;

console.log(`o produto ${product.nome} custa ${product.price}${product.moeda} e a cor é ${product.colors[2]}`);
console.log(product.price);
console.log(product.colors[2]);
};

function printHeart() {
    alert('<3');
}

function rant(message) {
   for (let i = 0; i < 3; i++) {
        console.log(i + ' ' + message.toUpperCase());
        alert(i + ' ' + message.toUpperCase());
    }
}

function tellmeyourhate() {
    let hate = prompt('o que odeias?');
    rant(hate);
}

function isSnakeEyes() {
    let olho1 = prompt('Qual o valor do olho 1?');
    let olho2 = prompt('Qual o valor do olho 2?');

    if (olho1 == 1 && olho2 == 1) {
        alert('Snake Eyes!');
    } else {
        alert('Não são Snake Eyes!');
    }
}


//pp 86
const fullNames = [{first: 'Albus', last: 'Dumbledore'}, {first: 'Harry', last: 'Potter'}, 
{first: 'Hermione', last: 'Granger'}, {first: 'Ron', last: 'Weasley'}, {first: 'Rubeus', last: 
'Hagrid'}, {first: 'Minerva', last: 'McGonagall'}, {first: 'Severus', last: 'Snape'}];

//Crie um novo array chamado firstNames que nos retorne os primeiros Nomes do Array Original
// function firstNames(){
//     const fullNames = [
//         {first: 'Albus', last: 'Dumbledore'}, 
//         {first: 'Harry', last: 'Potter'}, 
//         {first: 'Hermione', last: 'Granger'}, 
//         {first: 'Ron', last: 'Weasley'}, 
//         {first: 'Rubeus', last: 'Hagrid'}, 
//         {first: 'Minerva', last: 'McGonagall'}, 
//         {first: 'Severus', last: 'Snape'}
//     ];

//     const firstNames = fullNames.map(function(name) {
//         return name.first;
//     });
//     console.log(firstNames);

//     fullNames.forEach(function(name) {
//         console.log(name.last);
//     });
// }

// pp88
//Usando as Arrow Functions, crie uma função chamada greet que receba um argumento que represente o nome de uma pessoa
let heyname = prompt('Qual é o seu nome?');

const greet = (heyname) => {
    return `Olá, ${heyname}!`;
}
console.log(greet(heyname));

//const greet = name => 'Olá, ' + name + '!';

