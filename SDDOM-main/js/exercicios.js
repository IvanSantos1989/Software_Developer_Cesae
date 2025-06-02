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

// let mySpan = document.getElementById("span");
// mySpan.innerText = "Yack";

//chicken html
function changeImage() {
    let img = document.querySelector("img");
    if (img.src.includes("chicken.jpg")) {
        img.src = "https://devsprouthosting.com/images/egg.jpg";
    } else {
        img.src = "https://devsprouthosting.com/images/chicken.jpg";
    }
}