//import Foundation
//mport Glibc
print("hello world");
var name: String="Aryan"
name="Rohit"
let a: Int=5
let b: Int=9
print(a)
print("value of name is \(name) and the number is \(a)")
print("the sum is \(a+b),the product is \(a*b)")

if(a<b)
{
    print("\(a) is less than b")
}
else{
    print("\(a) is greater than b")
}

let arr=[56,7,-4,67]
var sum=0
for num in arr {
    sum+=num
}
print("the sum is \(sum)")

for x in 34..<89{
    print(x)
}

for _ in 1...100{
    print("Hello World")
}

for i in UnicodeScalar("a").value...UnicodeScalar("z").value {
    print(UnicodeScalar(i)!)
}

func helloWorld(name:String) {
   print("hello \(name)") 
}

func add(a: Int, b: Int) -> Int {
    return (a+b)
}

helloWorld(name:"Rajesh")
print(add(a:3, b:4))

func myadd(_ num: Int...) -> Int {
    var result=0
    for x in num {
        result += x
    }
    return result
}

func factorial(num: Int) -> Int {
    var result=1
    for x in 2...num {
        result *= x
    }
    return result
}
print(myadd(3, 5, 6, 6))
print(factorial(num: 5))