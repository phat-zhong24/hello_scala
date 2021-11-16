package src.main.scala.chapter04

import scala.math.BigDecimal.double2bigDecimal

object Test02_ForLoop {
  def main(args: Array[String]): Unit = {
    // 1.范围遍历 to 前后闭合 (本质是调用了数值类型的to()方法)
    for (i <- 1 to 10) {
      println(i)
    }
    // 等价于
    for (i <- 1.to(10)) {
      println(i)
    }

    println("============================")

    // 2.范围遍历 until 前闭合后开
    for (i <- 1 until 10) {
      println(i)
    }
    // 等价于
    for (i <- 1.until(10)) {
      println(i)
    }
    // 等价于
    for (i <- Range(1, 10)) {
      println(i)
    }

    println("============================")

    // 3.集合遍历
    for (i <- Array(12, 33, 43, 66)) {
      println(i)
    }

    println("============================")

    // 4.循环守卫
    for (i <- 1 to 3 if i != 2) {
      println(i)
    }

    println("============================")

    // 5.循环步长
    for (i <- 1 to 10 by 2) { // 这种写法更符合人的语义理解
      println(i)
    }
    // 等价于
    for (i <- 1.to(10).by(2)) {
      println(i)
    }

    // 倒序遍历
    for (i <- 10 to 1 by -1) {
      println(i)
    }
    // 等价于，更自然的写法
    for (i <- 1 to 10 reverse) {
      println(i)
    }

    // 小数步长
    for (i <- 1.0 to 10.0 by 0.5) {
      println(i)
    }
    // Java写法
    /*for (double i = 0.0; i < 10.0; i+=0.5) {
      System.out.println(i);
    }*/


    println("============================")

    // 6.嵌套循环
    // for 推导式一行中有多个表达式时，所以要加 ; 来隔断逻辑
    // for 推导式有一个不成文的约定：当 for 推导式仅包含单一表达式时使用圆括号，当包含多个表达式时，一般每行一个表达式，并用花括号代替圆括号
    for (i <- 1 to 3; j <- 1 to 3) {
      println("i = " + i + ", j = " + j)
    }
    // 等价于
    for {i <- 1 to 3
         j <- 1 to 3
         } {
      println("i = " + i + ", j = " + j)
    }
    // 等价于
    for (i <- 1 to 3) {
      for (j <- 1 to 3) {
        println("i = " + i + ", j = " + j)
      }
    }

    println("============================")


    // 7.引入变量
    for {i <- 1 to 10
         j = i + 2}
    {
      println("i == " + i + ", j == " + j)
    }

    // 等价于
    for (i <- 1 to 10){
      val j = i + 2
      println("i == " + i + ", j == " + j)
    }


    println("============================")

    // 练习：打印等腰三角形
    for (i <- 1 to 9){
      println((" ") * (9 -i) + ("*" * (2 * i -1)))
    }
    // 简写
     for {i <- 1 to 9
          spaces = 9 - i
          stars = 2 * i - 1} {
       println((" ") * spaces + ("*" * stars))
     }

    println("============================")

    // 8.循环返回值
    // Scala for循环的返回值默认是 Uint 空
    val unit: Unit = for (i <- 1 to 10) {
      println(i)
    }
    println(unit)


    // 将遍历过程中处理的结果返回到一个新 Vector 集合中，使用 yield 关键字
    val result = for (i <- 1 to 10) yield {
      i
    }
    println(result)
    // 等价于
    val result1 = for (i <- 1 to 10) yield i
    println(result1)

  }
}
