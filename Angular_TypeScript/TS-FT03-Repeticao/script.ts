//A)
// let numberOfStudents: number = Number(prompt('Please enter the number of students:'))
// let totalScore: number = 0
// for (let i = 0; i < numberOfStudents; i++) {
//     let score: number = Number(prompt(`Please enter the score for student ${i + 1}:`))
//     totalScore += score;
// }
// let averageScore: number = totalScore / numberOfStudents
// alert(`The average score of the class is: ${averageScore}`)


//B)
// let numberOfStudents: number = Number(prompt('Please enter the number of students:'))
// let negativeCount: number = 0
// for (let i = 0; i < numberOfStudents; i++) {
//     let score: number = Number(prompt(`Please enter the score for student ${i + 1}:`))
//     if (score < 10) {
//         negativeCount++;
//     }
// }
// alert(`The total number of negative scores is: ${negativeCount}`)


//C)
// let x: number = Number(prompt('Please enter the first number (X):'))
// let y: number = Number(prompt('Please enter the second number (Y):'))
// let evenCount: number = 0
// for (let i = x; i <= y; i++) {
//     if (i % 2 === 0) {
//         evenCount++;
//     }
// }
// alert(`The total number of even numbers between ${x} and ${y} is: ${evenCount}`)


//D)
// let number: number = -1
// let totalSum: number = 0
// let count: number = 0
// while (number !== 0) {
//     number = Number(prompt('Please enter a number (0 to stop):'))
//     if (number !== 0) {
//         totalSum += number
//         count++
//     }
// }
// if (count > 0) {
//     let average: number = totalSum / count;
//     alert(`The total sum of the numbers is: ${totalSum}\nThe average is: ${average}`)
// }
// else {
//     alert('No numbers were entered.')
// }


//E)
// let numberOfStudents: number = Number(prompt('Please enter the number of students:'))
// let ageOver: number = Number(prompt('Please enter the age to compare:'))
// let countOver: number = 0
// for (let i = 0; i < numberOfStudents; i++) {
//     let age: number = Number(prompt(`Please enter the age of student ${i + 1}:`))
//     if (age > ageOver) {
//         countOver++
//     }
// }
// let percentage: number = (countOver / numberOfStudents) * 100;
// alert(`The percentage of students older than ${ageOver} is: ${percentage}%`)


//F)
let oddCount: number = 0
let largestEven: number = 0
let number: number
let hasEven: boolean = false

while (oddCount < 5) {
    number = Number(prompt('Please enter an integer until you enter 5 odd numbers:'))
    if (number % 2 !== 0) {
        oddCount++
    } else {
        hasEven = true;
        if (number > largestEven) {
            largestEven = number
        }
    }
}
if (hasEven) {
    alert(`The largest even number entered is: ${largestEven}`)
}
else {
    alert('No even numbers were entered.')
}