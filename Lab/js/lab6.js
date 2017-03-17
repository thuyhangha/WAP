//'use strict'

//test lab6
function test_Lab6_1() {
    x = 1;
    var a = 5;
    var b = 10;

    var c = function() {
        document.write(x);
        console.log(x);
        document.write(a);
        console.log(b);
        var f = function(a, b, c) {
            b = a;
            document.write(b);
            console.log(b);
            b = c;
            var x = 5;
        }
        f(a,b,c);
        document.write(b);
        console.log(b);
        var x = 10;
    }
    c();
    document.write(b);
    console.log(b);
    document.write(x);
    console.log(x);
}

function test_Lab6_4() {
   var x = 9;
   function myFunction() {
       document.write(x);
       return x * x;
   }
   document.write(myFunction());
   x = 9;
   document.write(myFunction());
}

function test_Lab6_5() {
    var foo = 1;
    function bar() {
        if(!foo){
            var foo = 10;
        }
        alert(foo);
    }
    bar();
}

function test_Lab6_6() {
    var method = (function(){
        let myCount = 0;
        function changeBy(val) {
            myCount += val;
        };
        return {
            add: function () {
                changeBy(1);
            },
            reset: function () {
                myCount = 0;
            },
            value: function () {
                return myCount;
            }
        }
    })();
    method.add(); method.add();
    console.log(method.value());
    method.reset();
    console.log(method.value());
}
test_Lab6_6()
function test_Lab6_8() {
    function make_add(val) {
        var privateCounter = 0;
        const myVal = val;
        return function() {
            privateCounter += myVal;
            return privateCounter;
        }
    }

    var add5 = make_add(5);
    add5();
    add5(); //add5;
    console.log(add5());

    var add7 = make_add(7);
    add7();
    add7();// add7;
    console.log(add7());
}

function test_lab6_10_revealingPartern() {
    var employee = (function () {
        var name = "";
        var  age = 0;
        var salary = 0;

        function getName() {
            return name;
        }

        function getAge() {
            return age;
        }

        function getSalary() {
            return salary;
        }
        
        function setAge(newAge) {
            age = newAge;
        }
        
        function setName(newName) {
            name = newName;
        }

        function setSalary(newSalary) {
            salary = newSalary;
        }

        function increaseSalary(percentage) {
            salary += getSalary()*percentage;
        }
        
        function increaseAge() {
            age = getAge() + 1;
        }

        return {
            age : setAge,
            setName : setName,
           // getName : getName,
            setSalary : setSalary,
            increaseSalary: increaseSalary,
            increaseAge : increaseAge
        }
    })();
}


function test_lab6_11_revealingPartern() {
    var employee = (function () {
        var name = "";
        var  age = 0;
        var salary = 0;
        var address = "";

        function getName() {
            return name;
        }

        function getAge() {
            return age;
        }

        function getSalary() {
            return salary;
        }

        function setAge(newAge) {
            age = newAge;
        }

        function setName(newName) {
            name = newName;
        }

        function setSalary(newSalary) {
            salary = newSalary;
        }

        function increaseSalary(percentage) {
            salary += getSalary()*percentage;
        }

        function increaseAge() {
            age = getAge() + 1;
        }

        function setAddress(newAddress) {
            address = newAddress;
        }

        function getAddress() {
            return address;
        }

        return {
            age : setAge,
            setName : setName,
            setSalary : setSalary,
            increaseSalary: increaseSalary,
            increaseAge : increaseAge,
            getAddress: getAddress,
            setAddress: setAddress
        }
    })();

    employee.setAddress("test");
    console.log(employee.getAddress());
}