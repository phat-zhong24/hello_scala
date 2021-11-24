package chapter07

object Test00_Range {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个Range
    // 1.1 最简单的创建方式
    val range = (1 to 100)
    // 简写：省略小括号
    val range1 = 1 to 100
    println(range1)
    println(range1.getClass)
    // for循环遍历Range
    for (elem <- range1) {
      println(elem)
    }
    // foreach遍历Range
    range1.foreach(println)

    println("-------------------------------")

    // 1.2 使用伴生对象的apply()方法创建
    val range2 = Range(1, 100)
    println(range2)
    println(range2.getClass)
    range2.foreach(println)
    // apply()方法第三个参数传步长
    val range3 = Range(1, 100, 10)
    println(range3)
    range3.foreach(println)

    // Range也属于Scala广义数据集合范畴，也可以调用常用的数据流操作函数：filter、map、flatten、flatMap、fold、reduce、min、max、sum等等

  }
}
