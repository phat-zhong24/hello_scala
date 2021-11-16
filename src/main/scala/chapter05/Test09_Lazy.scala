package src.main.scala.chapter05

object Test09_Lazy {
  def main(args: Array[String]): Unit = {
    // 注意：lazy 不能修饰 var 类型的变量
    lazy val result = sum(2, 3)

    println("1.函数调用")
    println("2.result = " + result)
    println("4.result = " + result)

  }

  def sum(a: Int, b: Int) = {
    println("3.执行sum方法")
    a + b
  }

}
