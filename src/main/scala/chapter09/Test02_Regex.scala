package chapter09

import scala.util.matching.Regex

// Scala 的正则表达式继承了 Java 的语法规则，Java 则大部分使用了 Perl 语言的规则
// https://www.runoob.com/scala/scala-regular-expressions.html
object Test02_Regex {
  def main(args: Array[String]): Unit = {
    // 1. 声明正则表达式
    // 1.1 使用new的方式创建
    val pattern1 = new Regex("(S|s)cala")  // 首字母可以是大写 S 或小写 s
    val pattern2 = "Scala".r

    val str = "Scala is Scalable and cool"

    // 2. 使用正则表达式
    println(pattern1.findFirstIn(str))
    println(pattern1.findAllIn(str))
    println(pattern2.findFirstIn(str))
    println(pattern2.findAllIn(str))
    println(pattern1.replaceFirstIn(str, "Java"))

    // 简写
    println(pattern1 findFirstIn str)
    println(pattern1 findAllIn str)
  }
}
