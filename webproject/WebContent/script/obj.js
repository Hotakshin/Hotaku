/**
 * 
 */
	var num1, num2, result;
		num1 = 25;
		num2 = 2;
		result = num1 / num2;
		result = num1 % num2;
		var num3 = '25';
		console.log(num1 == num3);
		console.log('결과값 : ' + result);
		
		var obj = new Object(); // == {};
		obj.name = 'Shin';
		obj.age = 29;
		obj.showInfo = function() {
			console.log('이름: ' + obj.name + '나이: ' + obj.age);
		}
		console.log(obj);
		obj.showInfo();
		
		var obj2 = {
				name : 'ShinHotak',
				age : 22,
				showInfo:function() {
					console.log('이름: ' + this.name + ', 나이 ' + this.age);
				}
		}
		obj2['name']='Shinho';
		obj2['age'] = 16;
		obj2.showInfo();
		var obj3 = {
			name: 'KiM',
			age:56
		}