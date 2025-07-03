//Programação servidor: Teste Final

//1 -  para que serve o JS
// Validação de formulários, Galerias de fotos,Janelas de avisos,Banners,
// Janelas de publicidade, Menuspop-up, Animações...


//2 - O elemento input será criado no html ou em JS?
// Será criado o input no HTML onde normalmente é utilizado.
// porque fica mais fácil de ler e manter o código. No JS fazemos a manipulação dos formulários, 
// mas a estrutura base é sempre criada no HTML.


// 3 - Tendo em conta o seguinte código:
let num1 = '5';
let num2 = '3';
let jsDone = true;

function helloStudent(name, age){
    console.log('olá ' + name);
    return age;
}

let hello = helloStudent('Ivan', 36);
let age = helloStudent('Ivan', 36);
num2 = 15;

//1.1 - Não
//1.2 - Não
//1.3 - Sim
//1.4 - 15
//1.5 - Não
//1.6 - num1 = 1
//1.7 - Boolean

//4 - Considere o seguinte código:
let password = [1234, 'sara1986', 2023];
let userPassword = prompt('Qual é a password?');

//4.1 -
password.push('Cesae2025@');

//4.2 - 
if (password.map(String).includes(userPassword)) {
    alert('Password correta');
} else {
    alert('Password incorreta');
}

//4.3 -
let safePasses = password.filter(function(pass) {
    return String(pass).length > 6;
});

//5 - Considere o seguinte código:
const studentGrades = [
    {
        'studentName': 'Rita',
        'grade': 16,
        nameAndGrade(){
            return `A ${this.studentName} tem nota ${this.grade}`;
        }
    },
    {
        'studentName': 'Luís',
        'grade': 20
    },
    {
        'studentName': 'João',
        'grade': 18
    },
    {
        'studentName': 'André',
        'grade': 15
    },
    {
        'studentName': 'Luísa',
        'grade': 19
    }
];

//5.1 -
studentGrades.forEach(function(student) {
    console.log(`A nota de ${student.studentName} é ${student.grade}`);
});

//5.2 - 
console.log(studentGrades[5]); // undefined, pois não existe o índice 5 no array

//5.3 - Sim
console.log(studentGrades[0].nameAndGrade());

//6 - baseado no código HTML
// 6.1 -
document.querySelector('.achievements').innerText = 'Os meus ensinamentos para a vida';

// 6.2 -
const listItems = document.querySelectorAll('#myList li');
listItems.forEach(item => {
    item.innerText += ' com sucesso!';
});

// 6.3 -
const form = document.querySelector('form[action="/final"]');
form.addEventListener('submit', function(event) {
    event.preventDefault();
    const newItem = document.querySelector('#myItem').value;
    const li = document.createElement('li');
    li.innerText = newItem;
    document.querySelector('#myList').appendChild(li);
    this.reset();
});

//7 - Grave of the Fireflies

//8 - 
document.addEventListener('keydown', function(event) {
    if (event.key === 'Escape') {
        alert('tens a certeza que queres entregar o teste?');
    }
});