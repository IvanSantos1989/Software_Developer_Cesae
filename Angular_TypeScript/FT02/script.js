"use strict";
//A)
// let numberInt: number = 0
//
// numberInt = Number(prompt('Please enter an integer:'))
//
// if (numberInt % 2 === 0) {
//     alert("The number ${numberInt} is even.")
// } else {
//     alert("The number ${numberInt} is odd.")
// }
//B)
// let scoreWritten: number = 0.7
// let scoreOral: number = 0.3
//
// scoreWritten = Number(prompt('Please enter the written score:'))
// scoreOral = Number(prompt('Please enter the oral score:'))
//
// let finalScore: number = (scoreWritten * 0.7) + (scoreOral * 0.3)
// if (finalScore >= 10) {
//     alert("Approved")
// } else {
//     alert("Not approved")
// }
//C)
// let hoursWorked: number = 0;
// let hourlyRate: number = 7.5;
// let overtimeRate: number = 10;
// let regularHours: number = 36;
//
// hoursWorked = Number(prompt('Please enter the number of hours worked this week:'));
//
// let salary: number = 0;
// if (hoursWorked <= regularHours) {
//     salary = hoursWorked * hourlyRate;
// }
// else {
//     let overtimeHours: number = hoursWorked - regularHours;
//     salary = (regularHours * hourlyRate) + (overtimeHours * overtimeRate);
// }
//
// alert("Your salary this week is: €" + salary)
//D)
// let singleless25: number = 0
// let single25orMore: number = 0
// let marriedless34: number = 0
// let married34orMore: number = 0
// let civilstatus: number = 0
// let age: number = 0
//
// civilstatus = Number(prompt('Please enter your civil status (0 for single, 1 for married):'))
// age = Number(prompt('Please enter your age:'))
//
// if (civilstatus == 0 && age < 25) {
//     alert("You are a single person under 25 years old.")
// } else if (civilstatus == 0 && age >= 25) {
//     alert("You are a single person 25 years or older.")
// } else if (civilstatus == 1 && age < 34) {
//     alert("You are a married person under 34 years old.")
// } else if (civilstatus == 1 && age >= 34) {
//     alert("You are a married person 34 years or older.")
// } else {
//     alert("Invalid input. Please enter a valid civil status and age.")
// }
//E)
// let weekdays: [string, string, string, string, string, string, string] = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
// let dayNumber: number = 0
//
// dayNumber = Number(prompt('Please enter a number between 1 and 7:'))
// if (dayNumber >= 1 && dayNumber <= 7) {
//     alert(`The day of the week is: ${weekdays[dayNumber - 1]}`)
// }
// else {
//     alert("Invalid input. Please enter a number between 1 and 7.")
// }
//F)
// let averageBalance: number = 0
// let credit: number = 0
//
// averageBalance = Number(prompt('Please enter your average balance for the last year:'))
//
// if (averageBalance >= 0 && averageBalance <= 200) {
//     alert(`Your average balance is: €${averageBalance}. You are not eligible for any credit.`)
// }
// else if (averageBalance > 200 && averageBalance <= 400) {
//     credit = averageBalance * 0.2
//     alert(`Your average balance is: €${averageBalance}. Your credit amount is: €${credit}.`)
// }
// else if (averageBalance > 400 && averageBalance <= 600) {
//     credit = averageBalance * 0.3
//     alert(`Your average balance is: €${averageBalance}. Your credit amount is: €${credit}.`)
// }
// else if (averageBalance > 600) {
//     credit = averageBalance * 0.4
//     alert(`Your average balance is: €${averageBalance}. Your credit amount is: €${credit}.`)
// }
// else {
//     alert("Invalid input. Please enter a valid average balance.")
// }
//G)
let salary = 0;
let position = 0;
let newSalary = 0;
salary = Number(prompt('Please enter your salary:'));
position = Number(prompt('Please enter your position code (101 for Manager, 102 for Engineer, 103 for Technician):'));
if (position === 101) {
    newSalary = salary * 1.25;
    alert(`Your new salary for a Manager: €${newSalary}`);
}
else if (position === 102) {
    newSalary = salary * 1.20;
    alert(`Your new salary for an Engineer: €${newSalary}`);
}
else if (position === 103) {
    newSalary = salary * 1.15;
    alert(`Your new salary for a Technician: €${newSalary}`);
}
else {
    newSalary = salary * 1.10;
    alert(`Your new salary for an unknown position: €${newSalary}`);
}
