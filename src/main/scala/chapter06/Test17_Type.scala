package src.main.scala.chapter06

object Test17_Type {
  def main(args: Array[String]): Unit = {
    // 使用 type 关键字可以定义新的数据数据类型名称，本质上就是类型的一个别名
    type Integer = Int

    var a: Integer = 2
    var b: Integer = 3
    println(a + b)
  }
}


