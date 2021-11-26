package chapter08

object Test02_MatchGuard {
  def main(args: Array[String]): Unit = {
    // 模式守卫
    // 简单应用：求一个整数的绝对值
    def abs(i: Int) = i match {
      case i: Int if i >= 0 => i
      case i: Int if i < 0 => -i
      case _ => "type illegal"
    }

    println(abs(2))
    println(abs(-3))
  }
}

// 1）说明
// 如果想要表达匹配某个范围的数据，就需要在模式匹配中增加条件守卫。