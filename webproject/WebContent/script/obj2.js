// obj2.js
var names = []; //new Array();
names[0] = 'hong';
names[1] = 'Shin';
names[2] = 'Park';
names[3] = 'Choi';

for (var i = 0; i < names.length; i++) {
    document.write('<h2>' + names[i] + '</h2>');
}
console.log('-----------------');
// <table border= "1"></table>
var tableTag = '<table border="1">';
tableTag += '<tr><th>이름</th><th>나이</th></tr>'; // tableTag += '<tr></tr>'
var persons = [obj, obj2, obj3];
for (var i = 0; i < persons.length; i++) {
    if (persons[i].age < 20) {
        tableTag += '<tr><td style="color: red">' + persons[i].name + '</td><td style="color: red">' + persons[i].age + '</td></tr>';
    } else {
        tableTag += '<tr><td>' + persons[i].name + '</td><td>' + persons[i].age + '</td></tr>';
    }
}

console.log('-----------------');
tableTag += '<table>';
document.write(tableTag);