package chapter02

import chapter01.Student

object Test01_Variable {

  def main(args: Array[String]): Unit = {
    // 声明一个变量，注意：声明一个变量时，必须赋初始值
    var a: Int = 10
    // 省略类型写法, 让编译器自动推断类型
    var a1 = 20

    // 在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改变
    var jack = new Student("jack", a)
    jack = new Student("mack", 33)
    jack.printInfo()
    jack.age = 34
    jack.printInfo()

    // 一个大原则：能用常量val的地方，就不要用变量var ==> 因为：函数式编程里没有变量的说法，对于函数式编程都是常量，另一个角度理解：常量的不可变属性，可以绝对保证数据安全和线程安全

    val -+/ = "abc"

    val `object` = 1
    val `if` = 1
    val `class` = 1
  }

}
