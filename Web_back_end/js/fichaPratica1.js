//Exercício 1
function multiply() {
    let a = Number(prompt("Qual o valor de a?"));
    let b = Number(prompt("Qual o valor de b?"));
    let resultado = a * b;
    alert("Multiplicando " + a + " por " + b + "\nResultado: " + resultado);
    console.log("Multiplicando " + a + " por " + b + "\nResultado: " + resultado);
    return resultado;
}


//Exercício 2
function isShortsWeather(temperature) {
    if (temperature > 25) {
        alert("Está calor, use shorts!");
        console.log("Está calor, use shorts!");
        return true;
    } else {
        alert("Está frio, use calças!");
        console.log("Está frio, use calças!");
        return false;
    }
}
let temp = Number(prompt("Qual a temperatura?"));
isShortsWeather(temp);


//Exercício 3
function lastElement(array) {
    if (array.length === 0) {
        return null;  
    } else {
        return array[array.length - 1];
        
    }
}
console.log(lastElement([1, 2, 3]));
console.log(lastElement([]));


//Exercício 4
function sumArray(array) {
    let sum = 0;
    for (let i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}
console.log(sumArray([1, 2, 3, 4, 5]));


//Exercício 5
function returnDay(day) {
    switch (day) {
        case 1:
            return "Segunda";
        case 2:
            return "Terça";
        case 3:
            return "Quarta";
        case 4:
            return "Quinta";
        case 5:
            return "Sexta";
        case 6:
            return "Sábado";
        case 7:
            return "Domingo";
        default:
            return null;
    }
}
console.log(returnDay(1));
console.log(returnDay(8));