package src.main.scala.chapter05

object Test04_Lambda {
  def main(args: Array[String]): Unit = {
    // 匿名函数，赋值给一个常量，这个常量的类型是函数类型
    val printName: String => Unit = (name: String) => {
      println(name)
    }
    // 调用匿名函数
    printName("Tom")

    // 简写匿名函数
    val printName_ = (name: String) => println(name)
    printName_("Jerry")

    println("==========================================================================================")

    // 以上都不是匿名函数的常用形态，匿名函数更多直接以参数的形式存在

    // 定义一个函数，以函数作为参数输入
    def operation(arr: Array[Double], func: Double => Int) = {
      for (element <- arr) yield func(element)
    }

    val ints = operation(Array(1.0, 3.0, 5.0), (d: Double) => {
      d.toInt
    })
    println(ints.mkString(","))

    println("---------------------------------")

    // 传递匿名函数至简原则：
    // （1）参数的类型可以省略，会根据形参进行自动的推导
    val result1 = operation(Array(1.0, 3.0, 5.0), (d) => {
      d.toInt
    })
    println(result1.mkString(","))

    println("---------------------------------")

    // （2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过 1 的永远不能省略圆括号
    val result2 = operation(Array(1.0, 3.0, 5.0), d => {
      d.toInt
    })
    println(result2.mkString(","))

    println("---------------------------------")

    // （3）匿名函数如果只有一行，则大括号也可以省略
    val result3 = operation(Array(1.0, 3.0, 5.0), d => d.toInt)
    println(result3.mkString(","))

    println("---------------------------------")

    // （4）如果参数只出现一次，则参数省略且后面参数可以用_代替
    // 个人认为使用_使得代码逻辑过分抽象，可读性严重下降了，最后不要使用
    val result4 = operation(Array(1.0, 3.0, 5.0), _.toInt)
    println(result4.mkString(","))

    // 打个比喻：上面就是一个卸妆的过程，

    println("==========================================================================================")

    // 传递的函数有两个参数
    def sumCalculator(a: Int, b: Int, func: (Int, Int) => Int): Int = {
      func(a, b)
    }

    // （1）标准版
    println(sumCalculator(2, 3, (x: Int, y: Int) => {
      x + y
    }))
    // （2）如果只有一行，则大括号也可以省略
    println(sumCalculator(2, 3, (x: Int, y: Int) => x + y))
    // （3）参数的类型可以省略，会根据形参进行自动的推导
    println(sumCalculator(2, 3, (x, y) => x + y))
    // （4）如果参数只出现一次，则参数省略且后面参数可以用_代替
    println(sumCalculator(2, 3, _ + _))
  }
}
