package com.insss

def aList = [1, '张三', true]
aList.each { // Gradle中常用的写法，省略括号
//    println(it)
    println it // 这也能省个括号，哈哈
}
// 上面的写法是省略了括号，each参数为闭包Closure closure
aList.each({
    println(it)
})

// 分开写
def p = {
    def item -> println(item)
}
aList.each(p)
// 对于each 所需要的Closure，它的参数是什么？有多少个参数？返回值是什么？
// 只有去查API