var num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var returnVal = num.filter(function(val,idx) {
    return val % 2 == 0
});
var evenVal = returnVal.map(function(val,idx){
    return val * 3
});
console.log(returnVal);
console.log(evenVal);
/////////////////////////////////////////////////
var ps = document.querySelectorAll('div>p');
console.log(ps);
ps.forEach(function (val) {
    console.log(val);
    val.innerHTML = '<h1>hello</h1>';
  //  val.innerText = '<h1>hello</h1>'; 텍스트형식으로 출력
  //  val.textContent = '<h1>hello</h1>'; 
    val.style.backgroundColor = 'green';
});
// numbers => 1 ~ 10
// filter, map, forEach => 짝수만 걸러내도록 => evenVal;
// evenVal => n * 3; => mapVal;
// mapVal => console.log(각각 출력;)