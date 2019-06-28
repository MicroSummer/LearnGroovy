package com.insss

import groovy.transform.Field

def name = '张三' // run方法的局部变量
def printName(){
    println(name) // 类的成员变量，无法访问 name
}
//printName() // No such property: name for class: com.insss.TestGroovy05

age = 18 // 去掉def 或者类型，算作当前类的一个属性值，非成员变量，外界无法访问
def printAge(){
    println(age)
}
printAge() // 正常

@Field height = 185 // 真正的成员变量，外界可访问
def printHeight(){
    println(height)
}
printHeight()