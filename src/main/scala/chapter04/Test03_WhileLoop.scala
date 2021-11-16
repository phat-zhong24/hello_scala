package src.main.scala.chapter04

object Test03_WhileLoop {
  def main(args: Array[String]): Unit = {
    // 注意 Scala不推荐使用while循环，而是推荐使用for循环，因为while循环必须在循环体外定义了一个局部变量，违背了Scala的函数式编程思想
    var i =1

    while ( i < 10) {
      println(i)
      i += 1
    }

    do {
      println(i)
      i += 1
    } while (i<10)

  }
}
