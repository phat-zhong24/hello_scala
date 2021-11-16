package src.main.scala.chapter05

object Test05_HighOrderFunction {
  def main(args: Array[String]): Unit = {
    //1.函数作为值传递
    def foo(str: String): String = str

    // 在被调用函数 foo 后面加上 _，相当于把函数 foo 当成一个整体，传递给变量 f1
    // 注意：_前必须要有空格
    // 另外：也可以写成 foo(_)
    val f1 = foo _
    println(f1("hello"))

    // 如果明确变量类型，那么不使用下划线也可以将函数作为整体传递给变量 f2
    val f2: String => String = foo
    println(f2("hello"))


    println("=========================================================")

    // 2.函数作为函数的返回值返回
    def simpleFunction() = {
      def fun(str: String) = {
        "result: " + str
      }
      fun _
    }

    println(simpleFunction()("hello"))

  }
}
