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