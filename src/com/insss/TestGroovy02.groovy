package com.insss

// 无类型的函数定义，必须使用def 关键字
def testFunction1(){
    println('testFunction1 --- println')
    'testFunction1 --- return' // 最后一行代码的执行结果就是本函数的返回值
}

def result = testFunction1()
println(result)

// 如果指定了函数返回类型，则可不必加def 关键字来定义函数
String testFunction2(){
    println('testFunction2 --- println')
    return 'testFunction2 --- return'
}

result = testFunction2()
println(result)

String testFunction3(name, age){ // 无需指定参数类型
    println(name + "的年龄是" + age)
}

testFunction3('张三', 18)
// 可以不加括号
testFunction3 '张三', 19