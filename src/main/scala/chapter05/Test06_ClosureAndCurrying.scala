package src.main.scala.chapter05

// Scala使用函数柯里化实现函数闭包
// 概念说明
// 闭包：如果一个函数，访问到了它的外部（局部）变量的值，那么这个函数和他所处的环境，称为闭包
// 闭包的作用和达到的目的：把外部的局部变量和函数“打包”到一起作为一个对象数据，然后保存到堆内存中，取代把局部变量保存到栈内存中（因为栈内存比堆内存小得多，更为稀缺）
// c、c++、Scala都实现了闭包功能, Java并没有闭包功能

// 函数柯里化：在Scala的函数中，把一个参数列表的多个参数，变成多个参数列表
object Test06_ClosureAndCurrying {
  def main(args: Array[String]): Unit = {

    // 实现函数闭包的方式一：把外部的局部变量和内部函数，作为外部函数的返回值
    def addA(a: Int)  = {
      def addB(b: Int) = {
        a + b
      }
      // 把外部的局部变量a和addB内部函数,"打包"到一起，保存到堆内存中，然后返回
      addB _
    }
    // 使用lambda表达式进行简写 (注意：匿名函数作为返回值，类型不可被推断，所以必须指明返回的函数类型)
    def addA2(a: Int): Int => Int = {
      (b: Int) => {a + b}
    }
    // 继续简写
    def addA3(a: Int): Int => Int = {
      (b: Int) => a + b
    }
    // 继续继续简写
    def addA4(a: Int): Int => Int = {
      b => a + b
    }
    // 继续继续继续简写
    def addA5(a: Int): Int => Int = b => a + b
    // 继续继续继续继续简写 (一旦简写到使用"_"的地步，就已经不堪入目了，可读性极差，转眼自己都看不懂)
    def addA6(a: Int): Int => Int = a + _

    // 调用
    val result = addA(2)(3)
    println(result)

    // 利用函数闭包快捷构造出一个 +4的函数
    val addBy4 = addA4(4)
    // 利用函数闭包快捷构造出一个 +5的函数
    val addBy5 = addA4(5)
    println(addBy4(10) + addBy5(10))


    println("========================================================================")


    // 实现函数闭包的方式二：使用Scala提供的柯里化语法功能
    // 函数柯里化，其实就是将上面实现闭包的方式一复杂的参数逻辑变得简单化
     def add(a: Int)(b: Int) = {
       a + b
     }

    println(add(2)(3))

    // 利用Scala函数柯里化快捷构造出一个 +4的函数
    val addBy4_useCurrying = addA4(4)
    // 利用Scala函数柯里化快捷构造出一个 +5的函数
    val addBy5_useCurrying = addA4(5)
    println(addBy4_useCurrying(10) + addBy5_useCurrying(10))
  }
}
