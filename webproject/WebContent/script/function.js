// function.js


function sum(num3, num4) {

    var num1 = 10;
    var num2 = 20;
    console.log(num1 + num2 + num3 + num4);
    return num1 + num2 + num3 + num4;
  
}
// var result = sum(30, 40);
var numAry = [3,5,1,8,7];
function arySum(ary){

    var sum = 0;
    for(var i = 1; i <ary.length; i=i+2){
        sum += ary[i];
    }
    return sum;
}
var result = arySum(numAry);
document.write('결과값은 : ' + result);