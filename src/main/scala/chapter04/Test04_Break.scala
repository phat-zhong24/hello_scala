package src.main.scala.chapter04

import scala.util.control.Breaks

object Test04_Break {
  def main(args: Array[String]): Unit = {

    // 1.采抛出异常的方式，退出循环
    try {
      for (i <- 1 to 10) {
        if (i == 5) throw new RuntimeException
        println(i)
      }
    } catch {
      case e: Exception => // do nothing
    }
    println("执行循环外的代码")


    println("============================")


    // Scala 内置控制结构特地去掉了 break 和 continue，是为了更好的适应函数式编程，推
    // 荐使用函数式的风格解决break和continue的功能，而不是一个关键字。Scala中使用breakable
    // 控制结构来实现 break 和 continue 功能。

    // 2.采用 Scala 自带的函数，退出循环
    Breaks.breakable(for (i <- 1 to 10) {
      println(i)
      if (i == 5) Breaks.break()
    })
    println("执行循环外的代码")
  }
}
