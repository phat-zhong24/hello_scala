package chapter08

object Test01_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    // 1. 模式匹配基本定义语法
    val x: Int = 4

    val result = x match {
      case 1 => "吃饭"
      case 2 => "上班"
      case 3 => "睡觉"
      case _ => "其他"  // 注意：兜底匹配_可以写成其他任意变量，并不强制只能写成_。如果要获取对应被匹配数据内容，就不能使用_，要使用其他变量名称
    }

    println(result)

    println("==============================================================================")

    // 简单应用：用模式匹配实现简单的二元运算
    val a = 18
    val b = 34

    def matchDualOp(op: Char) = op match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegal"
    }

    println(matchDualOp('*'))
  }
}

// 1）说明
//（1）如果所有 case 都不匹配，那么会执行 case _ 分支，类似于 Java 中 default 语句，若此时没有 case _ 分支，那么会抛出 MatchError。
//（2）每个 case 中，不需要使用 break 语句，自动中断 case。
//（3）match case 语句可以匹配任何类型，而不只是字面量。
//（4）=> 后面的代码块，直到下一个 case 语句之前的代码是作为一个整体执行，可以使用{}括起来，也可以不括。
