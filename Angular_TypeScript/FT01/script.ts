//alert('Hello, World!');

//A)
// let number1: number = 0
// let number2: number = 0
// let total: number = 0
//
// number1 = Number(prompt('Please enter the first number:'))
// number2 = Number(prompt('Please enter the second number:'))
//
// total = number1 + number2;
//
// alert(`The total of ${number1} and ${number2} is: ${total}`)


//B)
// let Num1: number = 0
// let Num2: number = 0
// let Num3: number = 0
// let median: number = 0
//
// Num1 = Number(prompt('Please enter the first number:'))
// Num2 = Number(prompt('Please enter the second number:'))
// Num3 = Number(prompt('Please enter the third number:'))
//
// median = (Num1 + Num2 + Num3) / 3;
//
// alert(`The median of ${Num1}, ${Num2}, and ${Num3} is: ${median}`)


//C)
// let number1: number = 0
// let number2: number = 0
// let division: number = 0
//
// number1 = Number(prompt('Please enter the first number:'))
// number2 = Number(prompt('Please enter the second number:'))
//
// division = number1 / number2;
//
// alert(`The result of dividing ${number1} by ${number2} is: ${division}`)


//D)
// let number: number = 0;
//
// number = Number(prompt('Please enter a number:'));
// alert ('number before ${number - 1} and after ${number + 1}`);


//E) Obter a área de um triângulo.
// let base: number = 0;
// let height: number = 0;
//
// base = Number(prompt('Please enter the base of the triangle:'));
// height = Number(prompt('Please enter the height of the triangle:'));
// let area: number = (base * height) / 2;
//
// alert(`The area of the triangle with base ${base} and height ${height} is: ${area}`);


//F)
// let productPrice: number = 0
// let iva: number = 0.25
//
// productPrice = Number(prompt('Please enter the product price:'))
//
// let totalPrice: number = productPrice + productPrice * iva
//
// alert (`The total price of the product with iva included is: ${totalPrice}`)


//G)
let Totalbill: number = 0
let tipPercentage: number = 0.10
let moneyGiven: number = 0


moneyGiven = Number(prompt('How much money did you give?'))
Totalbill = Number(prompt('What is the total bill?'))

let change: number = moneyGiven - Totalbill

let tip: number = change * tipPercentage

alert(`Your tip is: ${tip}`)
