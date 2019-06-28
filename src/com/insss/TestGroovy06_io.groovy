package com.insss

import groovy.util.slurpersupport.GPathResult

// 读取A01文件
// 1、读该文件中的每一行
def a01 = new File('A01')
a01.eachLine {
    print it + " "
}
println()

// 2、直接得到文件内容
println a01.getBytes()

// 3、使用InputStream.InputStream
def ism = a01.newInputStream()
ism.close()

// 4、使用闭包操作InputStream，以后在Gradle 里会常看到这种搞法
a01.withInputStream {
    // 操作ism. 不用close。Groovy 会自动替你close
}

// 写文件
// copy A01 到 A02
def a02 = new File('A02')
a02.withOutputStream {
    os ->
        a01.withInputStream {
            os << it // 利用OutputStream 的<<操作符重载，完成从InputStream 到OutputStream
        }
}

// 操作xml
GPathResult gPathResult = new XmlSlurper().parse("A03.xml")

// 打印第一个person的city的值
println gPathResult.person[0].city

// 打印所有的person的city
println gPathResult.person*.city

// 打印第一个person的age
println gPathResult.person[0].@age
println gPathResult.person[0]['@age']

// 打印name="xiao3"的rel
gPathResult.person.find {
    if (it.@name == 'xiao3') {
        println it.link.@rel
    }
}

// 访问命名空间
def root = new XmlSlurper().parse("A04.xml")
println root.entry.image_thumbnail.@type
println root.entry.entry_status*.@type
root.declareNamespace("pris":"http://www.163.com/pris/1.0")
println root.entry."image_thumbnail".@type

// 处理AndroidManifest.xml
root = new XmlSlurper().parse("AndroidManifest.xml")
// 获取package
println root.@package
// 获取所有的权限
root['uses-permission'].find{
    println it['@android:name']
}
// 获取所有的activity
root['application']['activity'].find {
    println it['@android:name']
}