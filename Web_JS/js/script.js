let myFirstVar = "Olá Mundo!";
let jsIsCool = true;

console.log(jsIsCool);
jsIsCool= "aborreci-me dele";
console.log(jsIsCool);
jsIsCool= "12";
console.log(jsIsCool+1);

//código que lança uma caixa de texto ao user a questionar e coloca a resposta dentro de uma variável
// let millionDolarQuestion =  prompt('que tal a semana com feriado e apagão?');
// console.log(millionDolarQuestion);
let day1 = 'segunda';
let day2 = 'terça';
let day3 = 'quarta';

//console.log('a segunda posição é ' +day3[2]);

//arrays
let weekDays = ['segunda', 'terça', 'quarta'];
// let studentNotes = [18, 19, 20, 17];

// let ourSuperArr = ['segunda', true, 'Joana', 17];

console.log('o array na posição 1 tem ' + weekDays[1][4].toUpperCase());

//ambos têm dentro o A
//weekDays[1][4]
//let myDay = weekDays[1];
//console.log(myDay[4])

//métodos de arrays
let shoppingList = ['batatas', 'feijão', 'bananas', 'uvas'];
//let item = prompt('Qual é o item a adicionar');

//shoppingList.push(item)

// console.log(shoppingList)
// console.log(shoppingList[0]);
// console.log(shoppingList[1]);

for(let i = 0; i<shoppingList.length; i++){
    console.log('compra ' +shoppingList[i]);
}