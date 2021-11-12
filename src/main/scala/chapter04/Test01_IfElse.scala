package src.main.scala.chapter04

import scala.io.StdIn

object Test01_IfElse {
  def main(args: Array[String]): Unit = {
    println("请输入测试年龄：")
    val age = StdIn.readInt()


    // Scala 中 if else 表达式其实是有返回值的，具体返回值取决于满足条件的代码体的最后一行内容
    // Scala 中返回值类型不一致，取它们共同的祖先类型
    val result: Any = if (age < 18) {
      "童年"
    } else if (age >= 18 && age <30) {
      "青年"
    } else if (age >= 30 && age < 50) {
      "中年"
    } else {
      "老年"
      age
    }

    println(result)

    println("=================================================")

    // Java 中的三元运算符可以用 if else 实现
    val result1: Any = if (age < 18 ) "未成年" else "成年"
    println(result1)

  }
}
