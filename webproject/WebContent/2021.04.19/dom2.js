var names = [];
names[0] = '유정모';
names.push('구자혁'); //마지막 위치 추가.
names.push('석정원');
names.pop();//마지막 위치 제거.
delete names[0];//요소정보 삭제.
names.shift(); //처음위치제거.
names.unshift('김이담');
names.push('공도현');
names.push('소국진');
names.push('전형민');

var returnVal = names.map(function(val,idx,ary){
    var person = {};
    person.name = val;
    person.age = idx;
    
    return person;
});

var returnFil = returnVal.filter(function(val, idx, ary) {
    return idx % 2 == 0;
});

console.log(returnFil);

var show = document.getElementById('show');
var ulTag = document.createElement('ul');
show.appendChild(ulTag);

names.forEach(function(val,idx,ary) {
    // console.log(`names 요소 : ${a},${b},${c}`);
    var liTag = document.createElement('li');
    liTag.innerHTML = val; // <li>김이담</li>
    ulTag.appendChild(liTag);

});

console.log(names);