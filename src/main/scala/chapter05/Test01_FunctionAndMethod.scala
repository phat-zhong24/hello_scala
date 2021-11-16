package src.main.scala.chapter05

object Test01_FunctionAndMethod {
  def main(args: Array[String]): Unit = {
    // 调用函数
    hello()

    // 定义函数
    def hello(): Unit = {
      println("hello")
    }

    // 调用对象方法
    // 1.使用对象直接调用
    Test01_FunctionAndMethod.hello()
    // 2.使用this关键字调用
    this.hello()
  }

    // 调用对象的方法
  def hello(): Unit = {
    println("hello--------")
  }
}
