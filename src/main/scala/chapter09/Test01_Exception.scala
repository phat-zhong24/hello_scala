package chapter09

object Test01_Exception {
  def main(args: Array[String]): Unit = {
    try {
      val v = 1 / 0
    } catch {
      case ex: ArithmeticException => {
        println("算术异常：" + ex.getMessage)
      }
      case ex: Exception => {
        println("一般异常：" + ex.getMessage)
      }
    } finally {
      println("程序运行结束")
    }
  }

  println("------------------------------")

  // 使用throw关键字，主动抛出异常
  def func1(x: Int)= {
    if (x <= 0) {
      throw new Exception
    }
    // do something
  }

  func1(-5)

  println("------------------------------")

  func2()

  // 使用@throws注解对方法主动声明异常
  @throws(classOf[NumberFormatException])
  def func2(): Unit = {
    "abc".toInt
  }
}


// 1. Scala 的异常的工作机制和 Java 一样，但是 Scala 没有“checked（编译期）”异常， 即 Scala 没有编译异常这个概念，异常都是在运行的时候捕获处理
// 2. 用 throw 关键字，抛出一个异常对象。所有异常都是 Throwable 的子类型。throw 表达式是有类型的，就是 Nothing，因为 Nothing 是所有类型的子类型，所以 throw 表达式可以用在需要类型的地方
// 3. 在 Scala 中，可以使用 throws 注解来声明异常