package chapter02

import chapter01.Student

object Test05_DataType {
  def main(args: Array[String]): Unit = {
    // 1.字节类型
    val b1: Byte = 10
    // 这里报红的原因是：IDEA的Scala插件对Scala支持不到位。  其实是合法操作
    val b2: Byte = 10 + 20
    println(b2)

    // 非法操作
    // val a3: Byte = b1 + 20

    // 合法操作：Int类型强转为Byte类型
    val b3: Byte = (b1 + 20).toByte
    println(b3)



    // 2.浮点类型
    // 特殊字符
    val c1: Char = '\t'   // 制表符
    val c2: Char = '\n'   // 转行符
    println("abc" + c1 + "def")
    println("abc" + c2 + "def")

    // 转义字符
    val c3 = '\\'   // 表示\本身
    val c4 = '\"'   // 表示”
    println("abc" + c3 + "def")
    println("abc" + c4 + "def")

    // Int类型强转为Char类型
    val c5 = (c4 + 1).toChar
    println(c5)



    // 3.空类型
    // 3.1 空值Unit
    def innerMethod(): Unit = {
      println("innerMethod非法被执行")
    }

    val result = innerMethod()
    println("result = " + result)

    // 3.2 空引用Null
    // val n: Int = null   // 非法操作
    var student = new Student("mike", 20)
    student = null
    println(student)

    // 3.3 Noting
    def innerMethod2(arg: Int): AnyVal = {
      if (arg == 0) {
        throw new NullPointerException
      } else {
        return arg
      }
    }

    val result1 = innerMethod2(1)
    println(result1)

    // （byte，short）和 char 之间不会相互自动转换
    // byte，short，char 他们三者可以计算，在计算时首先转换为 int 类型
    val byte: Byte = 10
    val short: Short = 999
    val char: Char = 'g'
    val sum = byte + short + char
    println(sum)

    // 强制类型转换
    val int = 1.33.toInt
    println(int)
  }
}
