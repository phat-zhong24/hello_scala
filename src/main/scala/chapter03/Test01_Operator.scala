package src.main.scala.chapter03

object Test01_Operator {
  def main(args: Array[String]): Unit = {
    val str1: String = "abc"
    val str2: String = new String("abc")

    // Scala的 == 等价于 equals,都是比较对象内容
    println(str1 == str2)
    println(str1.equals(str2))

    // 在Scala里，要比较两个对象的地址值，使用eq方法
    println(str1.eq(str2))



    // Scala运算符的本质
    val i1: Int = 10;
    val i2: Int = 20;
    // 调用数值对象的+()方法
    val sum = i1.+(i2)
    // 可简化为以下操作
    val sum1 = i1 + (i2)
    // 可简化为以下操作, 得出的结论：i1 + i2 的本质就是 i1.+(i2)
    val sum2 = i1 + i2
    println(sum)
    println(sum1)
    println(sum2)
    // 同理，其他所有运算符都有对应的函数设计
    // 调用数值对象的-()方法
    val sub = i2.-(i1)
    println(sub)
    // 调用数值对象的*()方法
    val mul = i2.*(i1)
    println(mul)
    // 调用数值对象的/()方法
    val div = i2./(i1)
    println(div)
    // 运算符(包括算数运算符、逻辑运算符、赋值运算符、位运算符)函数化体现了Scala的函数式编程的设计思想

  }

}
