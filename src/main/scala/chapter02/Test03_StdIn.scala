package chapter02

import scala.io.StdIn

object Test03_StdIn {
  def main(args: Array[String]): Unit = {
    // 输入信息
    println("请输入你的名字： ")
    val name: String = StdIn.readLine()
    println("请输入你的年龄： ")
    val age: Int = StdIn.readInt()

    // 控制台打印输出
    println(s"你的个人信息 名字:${name} 年龄:${age} 符合申请条件")

    println(s"""
       |你的个人信息
       |   名字:${name}
       |   年龄:${age}
       |符合申请条件
       |""".stripMargin)
  }
}
