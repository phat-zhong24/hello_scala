package src.main.scala.chapter05

object Test08_ControlAbstraction {
  // 传名参数 （即是把一块代码块作为参数传递传入）: 每使用一次参数a, 传入的代码块就执行一次
  def foo(a: => Int) = {
    // 这里使用了2次a, 所以代码块执行两次
    println("a = " + a)
    println("a = " + a)
  }

  def main(args: Array[String]): Unit = {
    def func = (a: Int) => {
      println("执行func函数")
      a
    }
    foo(func(10))

    println("================================================================")

    // 所以，传名参数可以这样传：直接传一个代码块
    // 这是真的骚
    foo({
      println("执行func函数")
      10
    })

    println("--------------------")

    // 简化：省略掉小括号
    foo{
      println("执行func函数")
      10
    }

    println("================================================================")

    var i = 1
    myWhile({i <= 10})({
      println(i)
      i += 1
    })
    println("--------------------")
    // 简化
    var j = 1
    myWhile(j <= 10){
      println(j)
      j += 1
    }

  }


  // 综合使用 柯里化、递归、传名参数 来实现一个自定义的while循环
  def myWhile(condition: => Boolean)(operation: => Unit): Unit = {
    if (condition) {
      operation
      myWhile(condition)(operation)
    }
  }

}
