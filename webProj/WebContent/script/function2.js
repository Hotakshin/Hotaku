//function2.js

var names = ['구자혁','유정모','소국진','전형민'];

function makeList(nameAry) {
    var ulTag = '<ul>';
    // for(String str : strAry){} 와 같은 문법
    for(str of nameAry){
        ulTag += '<li>' + str + '</li>';
    }
    ulTag += '</ul>';
    return ulTag;
}

console.log(makeList(names));
document.write(makeList(names));