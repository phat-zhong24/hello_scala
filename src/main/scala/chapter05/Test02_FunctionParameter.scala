package src.main.scala.chapter05

object Test02_FunctionParameter {
  def main(args: Array[String]): Unit = {
    // （1）可变参数
    def function1(str: String*): Unit = {
      println(str.length)
      println(str)
    }
    function1("aaa", "bbb", "ccc")


    println("==========================================")


    // （2）如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def function2(str1: String, str2: String*): Unit = {
      println(str2.length)
      println(str1)
      println(str2)
      println(str1 + " " + str2)
    }
    function2("aaa", "bbb", "ccc")


    println("==========================================")


    // （3）参数默认值，一般将有默认值的参数放置在参数列表的后面
    def function3(str1: String, str2: String = "bbb", str3: String = "ccc"): Unit = {
      println(str1 + " " + str2 + " " + str3)
    }
    function3("aaa")
    function3("aaa", "bbbbb")
    function3("aaa", "bbbbb", "ccccc")


    println("==========================================")


    // （4）带名参数
    def function4(name: String = "defaultName", age: Int): Unit = {
      println(s"${name}今年${age}岁")
    }
    function4(age = 18, name = "Tom")
    // 常用的场景：大部分函数参数有默认值，只需为少数参数传值
    function4(age = 18)

  }
}
