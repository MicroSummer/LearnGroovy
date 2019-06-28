package com.insss

def x = '10'
println x

// 单引号''中的内容严格对应Java 中的String，不对$符号进行转义
def y = 'I am $x dolloar'
println y
// 双引号""的内容则和脚本语言的处理有点像，如果字符中有$号的话，则它会$表达式先求值。
y = "I am $x dolloar"
println y
// 三个引号'''xxx'''中的字符串支持随意换行
y = '''begin
line1

line2

end
'''
println y

def int z = 100
def canonicalName = z.getClass().getCanonicalName()
println z
println canonicalName

def aList = [1, 'OK', true]
println aList.size()
println aList

def aMap = ['key1': 'Hello', 'key2': 'Groovy']
println aMap.size()
println aMap
println aMap.key1
println aMap['key2']

def aRange = 1..5
println aRange.size()
println aRange
println aRange.from
println aRange.getFrom()
println aRange.to