"use strict";
function getInput() {
    var fs = require('fs');
    return fs.readFileSync(__dirname + '/input').toString().split("\n");
}
function partOne() {
    var calories = getInput();
    var maxCalories = 0;
    var temp = 0;
    for (let calorie of calories) {
        calorie = calorie.trim();
        if (calorie == "") {
            if (temp > maxCalories) {
                maxCalories = temp;
            }
            temp = 0;
            continue;
        }
        temp += parseInt(calorie);
    }
    return maxCalories;
}
function partTwo() {
    var tempSum = 0;
    var elfSummedCalories = [];
    var calories = getInput();
    for (let calorie of calories) {
        calorie = calorie.trim();
        if (calorie == "") {
            elfSummedCalories.push(tempSum);
            tempSum = 0;
            continue;
        }
        tempSum += parseInt(calorie);
    }
    /*   var sortedArray: number[] = elfSummedCalories.sort((n1,n2) => n1 - n2);
      var last3 : number[] = sortedArray.slice(-3);
    
      var num = 0;
      for (let n of last3) {
        num += n;
      } */
    return tempSum;
}
function main() {
    //console.log(partOne()); //68802
    console.log(partTwo()); //205370
}
main();
//# sourceMappingURL=day1.js.map