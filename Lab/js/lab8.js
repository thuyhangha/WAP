'use strict'

/*
Question 1:
Create an object called Teacher derived from the Person function constructor, and implement a method called
teach which receives a string called subject, and prints out:
    [teacher's name] is now teaching [subject]
*/

function lab8_1() {
    function Person() {
        this.teacherName = "Assad";
        this.subject = "WAP";
    }
    var Teacher = new Person();
    Person.prototype.teach = function () {
        return this.teacherName + " is now teaching " + this.subject;
    }

    Teacher.teach();

    console.log(Teacher.teach());
}

lab8_1();
/*
Question 2:
Define a filter function on the String object. The function accepts an array of strings that specifies a list of
banned words. The function returns the string after removing all the banned words.
    Example: console.log("This house is not nice!".filter('not'));
Output: "This house is nice!"
*/
function lab8_2() {
    String.prototype.filter = function (arrays) {
        var arraysResult = [];
        var myString = this.valueOf();

        for(const item of arrays){
            if(myString.indexOf(item) > 0)
                myString = myString.replace(" " +item, "");
        }
        return myString;
    };
    console.log("This house is not nice!".filter(["not", "is"]));
}
lab8_2();

/*
Question 3:
Write a Bubble Sort algorithm in JavaScript. Bubble sort is a simple sorting algorithm that works by repeatedly
stepping through the list to be sorted,
    Example: [6,4,0, 3,-2,1].bubbleSort();
Output : [-2, 0, 1, 3, 4, 6]
*/
/*
procedure bubbleSort( A : list of sortable items )
    n = length(A)
    repeat
        newn = 0
        for i = 1 to n-1 inclusive do
            if A[i-1] > A[i] then
                swap(A[i-1], A[i])
                newn = i
            end if
        end for
        n = newn
    until n = 0
end procedure*/
function lab8_3() {
    Array.prototype.bubbleSort = function () {
        let A = this.valueOf();

        let n = A.length;
        do{
            let newn = 0;
            for(let i=1; i<= n-1; i++){
                if(A[i-1] > A[i]){
                    let temp = A[i];
                    A[i] = A[i-1];
                    A[i-1] = temp;
                    newn = i;
                }
            }
            n = newn;
        }
        while (n!=0);
        return A;
    }

    console.log([6,4,0, 3,-2,1]);
    console.log([6,4,0, 3,-2,1].bubbleSort());
}
lab8_3() ;