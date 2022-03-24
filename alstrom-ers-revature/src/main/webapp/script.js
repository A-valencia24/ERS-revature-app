	function display() {
		var name = "richard"
		for (i = 1; i <= 5; i++) {
			document.write("<h1>" + name)
		}
		document.write("<br/>");
		grade = 100
		document.write(name + "your grade is" + grade)
	}
	function addNumbers() {
		alert("Welcome in add numbers");
		var num1 = prompt("Enter number 1")
		var num2 = prompt("Enter number 2")
		result = parseInt(num1) + parseInt(num2);
		var data = confrim("Do you want to see the sum");
		if (data) {
			alert("sum of two numbers are :" + result)
		} else {
			alert("thanks for using my app")
		}
	}
	function displayName() {
		
		if(confirm("do you want to display your name?")){
		var name1 = prompt("Enter first name");
		var name2 = prompt("Enter last name");
		alert("Welcome Mr. " + (name1.charAt(0))+ " " + name2);
		}
		else {
			alert("thanks")
		}
		
	}
	
	function randNum() {
		alert(Math.floor(Math.random() * 10));
		
	}
	function lastDateCheck(){
		var today = new Date(); 
	}
	
	function disp(message){
		if(message==null) {
			message="welcome guest"
		}
		alert(message);
	}
	function lastDateCheck() {
		var today = new Date();
		var lastdate = new Date();
		lastdate.setFullYear(2022, 2, 31);//31st March 2022
		if (lastdate > today) {
			var day = 1000 * 60 * 60 * 24;
			x = (lastdate - today) / day;
			alert("Number of days left " + x);
		} else {
			alert("time up and you cannot apply for interview");
		}
	}
		
	function func1() {
		var animal1 = "lion"; //exist in lexical scope
		
		function func2() {  //inner function 
			
			var animal2 = "tiger";
			console.log(animal1);
			console.log(animal2);
			
		}
		func2(); 
		//console.log(animal2); // result error - due to it exists in function scope 
	}
	func1(); 
	
	function demo(){
		const grade = 87; 
		var marks = 100; 
		{
			let marks = 90;
			console.log("let: " +marks) //90 
		}
		console.log("Var :" +marks) //100
	}
	function printHelloWorld1() {
		console.log("Hello World 1")
	}
	//arrow function	- ES6
	var printHelloWorld2 = () => console.log("Hello World 2")
	
	
	//call the function
	printHelloWorld1();
	printHelloWorld2();
	
	//arrow function
	var sum1 = (a, b) => {
	      let result =  a + b;
	    return "Sum is" + result;
	};


	function sum2(a,b){
		let result =  a + b;
	    return "Sum is" + result;
	}
	
	console.log(sum1(5, 3));  //output: "sum is 8"
	console.log(sum2(5, 3));  //output: "sum is 8"
	
	var a = prompt("Enter number 1");
	var b = prompt("Enter number 2");
	var c = prompt("Enter number 3");
	var largestNumber = () => {return Math.max(a,b,c)};
	
	
	alert("Largest number is "+largestNumber());
