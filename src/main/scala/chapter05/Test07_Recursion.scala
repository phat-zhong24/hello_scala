package src.main.scala.chapter05

import scala.annotation.tailrec

object Test07_Recursion {
  def main(args: Array[String]): Unit = {
    // 阶乘
    // 递归算法
    // 1) 方法调用自身
    // 2) 方法必须要有跳出的逻辑
    // 3) 方法调用自身时，传递的参数应该有规律
    // 4) scala 中的递归必须声明函数返回值类型  <- 注意：这是容易遗漏的点
    def fact(n: Int): Int = {
      if (n == 0) return 1
      fact(n - 1) * n
    }

    println(fact(10))

    // 结论：所有语言的for循环本质都是递归，即就算不提供for语法，使用递归一样可以实现for循环功能
    //      递归的缺点：不断添加栈帧，对栈内存压力很大。如果递归层数较深，容易造成栈内存溢出

    println("======================================================================")

    // 使用尾递归实现阶乘->更加节省栈内存
    def tailFact(n: Int): Int = {
      @tailrec // 添加尾递归注解，来检查尾递归代码的正确性
      def loop(n: Int, currentResult: Int): Int = {
        if (n == 0) return currentResult
        loop(n - 1, currentResult * n)
      }

      loop(n, 1)
    }

    println(tailFact(10))
  }
}
