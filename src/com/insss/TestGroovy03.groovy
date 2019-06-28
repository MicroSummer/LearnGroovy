package com.insss

// 闭包
def aClosure = {
    String name, int age -> println(name + "的年龄是" + age) // 这个箭头很关键。箭头前面是参数定义，箭头后面是代码
}
println(aClosure) // com.insss.TestGroovy03$_run_closure1@4944252c

// 正常输出
aClosure.call('张三', 10)
aClosure('张三', 11)
aClosure '张三', 12

println(aClosure('张三', 13)) // null

aClosure = {
    String name, int age -> name + "的年龄是" + age // 这个箭头很关键。箭头前面是参数定义，箭头后面是代码
}

aClosure.call('张三', 14) // 无输出
println(aClosure.call('张三', 15)) // 正常输出

// 无参数的
aClosure = {
    '张三的年龄是16岁'
}

println(aClosure())

// 如果闭包没定义参数的话，则隐含有一个参数，这个参数名字叫it，和this 的作用类似。it 代表闭包的参数。
aClosure = {
    "张三的年龄是 $it 岁"
}

println(aClosure(17))

// 但是，如果在闭包定义时，采用下面这种写法，则表示闭包没有参数！
aClosure = {
    -> "张三的年龄是 $it 岁"
}

println(aClosure(18)) // 报错