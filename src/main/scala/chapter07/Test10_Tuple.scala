package src.main.scala.chapter07

// 元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。说的简单点，就是将多个无关的数据封装为一个整体，称为元组。
// 注意：元组中最大只能有 22 个元素。
// Map 中的键值对其实就是元组,只不过元组的元素个数为 2
object Test10_Tuple {
  def main(args: Array[String]): Unit = {
    // 1. 创建元组, 声明元组的方式：(元素 1，元素 2，元素 3)
    // 1.1 创建一个二元组
    val tuple1: (String, Int) = ("aaa", 111)
    println(tuple1)
    // 1.2 创建一个三元组
    val tuple2: (String, Int, Double) = ("aaa", 111, 222.0)
    println(tuple2)
    // 1.3 创建一个四元组
    val tuple3: (String, Int, Double, Boolean) = ("aaa", 111, 222.0, true)
    println(tuple3)

    // 骚操作: 创建多层嵌套二元组
    val nestTuple1 = "aaa".->(111).->(222.0).->(true).->("bbb")
    println(nestTuple1)
    // 简写：省略小括号
    val nestTuple2 ="aaa" -> 111 -> 222.0 -> true -> "bbb"
    println(nestTuple2)

    // 创建随意的多层嵌套元组
    val nestTuple3 = ("aaa", 111, (222.0, true, 333.0f, ("bbb", false)))
    println(nestTuple3)

    println("-----------------------------------------------------------")

    // 2. 访问元组
    // 2.1 通过元素的顺序进行访问，调用方式：_顺序号
    println(tuple3._1)
    println(tuple3._2)
    println(tuple3._3)
    println(tuple3._4)
    // 2.2 通过索引访问
    println(tuple3.productElement(0))
    println(tuple3.productElement(1))
    println(tuple3.productElement(2))
    println(tuple3.productElement(3))
    // 2.3 通过迭代器访问
    val iterator = tuple3.productIterator
    // while循环
    while (iterator.hasNext) {
      println(iterator.next())
    }
    // for循环
    for (elem <- tuple3.productIterator) {
      println(elem)
    }
    // foreach
    tuple3.productIterator.foreach(println)

  }
}
