'use strict'
// Define a function max() that takes two numbers as arguments and returns the largest of them.
// Use the if-then-else construct available in Javascript.
function max(a, b){
    if(a > b)
        return a;
    return b;
}
// Define a function maxOfThree() that takes three numbers as arguments and returns the largest of them.
function maxOfThree(num1, num2, num3){
    var max = 0;
    if((num1 >= num2) && (num1 >= num3)){
        max = num1;
    }
    else if((num2 >= num1) && (num2 >= num3)){
        max = num2;
    }
    else{
        max = num3;
    }
    return max;
}
// Write a function isVowel() that takes a character (i.e. a string of length 1) and returns true if it is a vowel, false otherwise.
function isVowel(a) {
    if(a.length == 1){
        var lowerCaseVal = a.toLowerCase();
        if((lowerCaseVal == 'a') || (lowerCaseVal == 'e') || (lowerCaseVal == 'o') || (lowerCaseVal == 'u') || (lowerCaseVal == 'i'))
            return true;
    }
    return false;
}
// Define a function sum() and a function multiply() that sums and multiplies (respectively) all the numbers in an array of numbers.
// For example, sum([1,2,3,4]) should return 10, and multiply([1,2,3,4]) should return 24.
// call Method: sum([1,2,3,4])
function sum(...arrays) {
    var total = 0;
    if(arrays.length>0){
        for(var i=0; i < arrays[0].length; i++){
            total += arrays[0][i];
        }
    }
    return total;
}

// call Method: multiply([1,2,3,4])
function multiply() {
    var multiply = 1;
    if(arguments.length>0){
        //for(var i = 0; i < arguments[0].length; i++){
        for(const i in arguments[0]){
            multiply *= arguments[0][i];
        }
    }
    return multiply;
}

// Define a function reverse() that computes the reversal of a string.
// For example, reverse("jag testar") should return the string "ratset gaj".
// call Method: reverse("jag testar")
function reverse(x) {
    var reverseValue = "";
    for(var i = x.length - 1; i >= 0; i--){
        reverseValue += x.charAt(i);
    }
    return reverseValue;
}
// Write a function findLongestWord() that takes an array of words and returns the length of the longest one.
//call Method: findLongestWord(["test", "hello", "test"])
function findLongestWord() {
    var longestWord = arguments[0][0].length;
    for(let i = 1; i < arguments[0].length; i++){
        longestWord = max(longestWord, arguments[0][i].length)
    }
    return longestWord;
}

// Write a function filterLongWords() that takes an array of words and an integer i and returns the array
// of words that are longer than i.
//call Method: filterLongWords(["test", "hello", "test"], 4)
function filterLongWords(arr, i) {
    var arrayResult = [];
    var arrayResultIndex = 0;
    for(const val of arr){
        if(val.length > i){
            arrayResult[arrayResultIndex++] = val;
        }
    }
    return arrayResult;
}
// ​After you finish, make sure all your functions are in ONE JS file and make sure you are using ("use strict";) .


//test lab6
function test_Lab6_1() {
    x = 1;
    var a = 5;
    var b = 10;
    var c = function(a, b, c) {
        document.write(x);
        document.write(a);
        var f = function(a, b, c) {
            b = a;
            document.write(b);
            b = c;
            var x = 5;
        }
        f(a,b,c);
        document.write(b);
        var x = 10;
    }
    c(8,9,10);
    document.write(b);
    document.write(x);
}

