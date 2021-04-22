/*
 * domEX.js
 */

// title 함수 만들기
function createTitle() {
    console.log(arguments); // 코드 하단에 createTitle()의
    // () 안에 있는 arguments들을 확인.

    var tr = document.createElement('tr');
    for (var i = 0; i < arguments.length; i++) {
        var th = document.createElement('th');
        th.innerHTML = arguments[i];
        tr.appendChild(th);
    }

    tbl.appendChild(tr);
}

var td1 = document.createElement('td'); // button이 들어갈 새로운 td추가
var buttons = document.createElement('button'); // button 생성
buttons.innerHTML = "삭제"; // button Label 넣어주기
buttons.onclick = deleteRow; // button 클릭 시 삭제

td1.appendChild(buttons); // td1에 button 넣어주기
tr.appendChild(td1); // tr에 td1 추가
tbl.appendChild(tr);


// 세부 function들
function mouseOverFunc() {
    this.style.backgroundColor = 'lavender';
}

function mouseOutFunc() {
    this.style.backgroundColor = '';
}

function deleteRow() {
    this.parentNode.parentNode.remove();
}

function modifyFunc() {
    console.log(this);
    var idVal = this.innerHTML; // id를 this로 기준
    var nameVal = this.previousSibling.firstChild.innerHTML; //id 앞의 name(previousSibling.firstChild)의 값(.innerHTML) 받아옴
    var scoreVal = this.nextSibling.innerHTML; // id 뒤의 score(nextSibling)의 값(.innerHTML) 받아옴
    var genderVal = this.parentNode.childNodes[3].innerHTML; // id의 부모노드(tr)의 3번째 자식(gender)의 값(.innerHTML) 받아옴
    console.log(this.parentNode);
    console.log(idVal, nameVal, scoreVal, genderVal);

    document.getElementById('name').value = nameVal; // 위에 만든 input의 name에 nameVal 값을 리턴.
    document.getElementById('id').value = idVal;
    document.getElementById('score').value = scoreVal;
    var genders = document.querySelectorAll('input[name="gender"]');
    for (var i = 0; i < genders.length; i++) {
        if (genders[i].value == genderVal) {
            genders[i].checked = true;
        }
    }
    console.log(genders);
}

function saveBtnFnc() {
    var iName = document.getElementById('name');
    var iId = document.querySelector('input[name="id"]');
    var iScore = document.getElementsByTagName('input')[2];
    var iGender = document.querySelector('input[name="gender"]:checked');
    // console.log(iGender.value);

    // 마우스 over/out function 호출
    var tr = document.createElement('tr');
    tr.setAttribute('align', 'center');
    tr.onmouseover = mouseOverFunc;
    tr.onmouseout = mouseOutFunc;

    // name
    var td = document.createElement('td');
    td.innerHTML = iName.value;
    tr.appendChild(td);

    // id
    var td = document.createElement('td');
    td.innerHTML = iId.value;
    tr.appendChild(td);

    // score
    var td = document.createElement('td');
    td.innerHTML = iScore.value;
    tr.appendChild(td);


}

function modifyBtnFunc() {
    var id = document.getElementById('id').value;
    // 시용자가 변경한 값을 반영
    var name = document.getElementById('name').value;
    var score = document.getElementById('score').value;
    var gender = document.querySelector('input[name="gender"]:checked').value;

    var targetTr = document.getElementById(id); // id로 tr을 찾아옴

    targetTr.children[0].innerHTML = '<a href ="dom.jsp?name=' + name + '&id=' + id + '&score=' + score + '&gender=' + gender + '">' + name + '</a>';
    // <a href = 'dom.js?name=?&id=?score=?&gender=?'>
    targetTr.children[2].innerHTML = score;
    targetTr.children[3].innerHTML = gender;
}