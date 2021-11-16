package src.main.scala.chapter05


object Test03_Simplify {
  def main(args: Array[String]): Unit = {
    // 函数原始标准写法
    def function0(str: String): String = {
      return "result: " + str
    }

    val result0 = function0("hello")
    println(result0)


    println("=======================================================")

    // 函数至简原则：能省则省

    // （1）return 可以省略，Scala 会使用函数体的最后一行代码作为返回值
    def function1(str: String): String = {
      "result: " + str
    }

    val result1 = function1("hello")
    println(result1)

    println("=======================================================")

    // （2）如果函数体只有一行代码，可以省略花括号
    def function2(str: String): String = str

    println(function2("hello"))

    println("=======================================================")

    // （3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def function3(str: String) = str

    println(function3("hello"))

    println("=======================================================")

    // （4）如果有 return，则不能省略返回值类型，必须指定
    def function4(): String = {
      return "hello"
    }

    println(function4())

    println("=======================================================")

    // （5）如果函数明确声明 unit，那么即使函数体中使用 return 关键字也不起作用
    def function5(str: String): Unit = {
      return "result: " + str
    }

    val result5 = function5("hello")
    println(result5)

    println("=======================================================")

    // （6）Scala 如果期望是无返回值类型，可以省略等号
    def function6(str: String) {
      println("result: " + str)
      "result: " + str
    }
    println(function6("hello"))

    println("=======================================================")

    // （7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def function7() = "hello"
    val result7 = function7()
    val result77 = function7
    println(result7)
    println(result77)

    println("=======================================================")

    // （8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def function8 = "hello"
    val result8 = function8
    println(result8)

    println("=======================================================")

    // （9）使用lambda表达式实现匿名函数: 如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
    def function9 = (str: String) => str.toInt

    // 函数作为参数
    def function10(str: String, func: String => Int): Int = {
      func(str)
    }

    val result10 = function10("10", function9)
    println(result10)

    val result10_ = function10("10", (str: String) => str.toInt)
    println(result10_)

  }

}
