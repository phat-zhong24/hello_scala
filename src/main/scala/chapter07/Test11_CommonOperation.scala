package src.main.scala.chapter07

// 基本属性和常用操作
object Test11_CommonOperation {
  def main(args: Array[String]): Unit = {
    val list = List(10, 20, 30, 40, 50)
    val set = Set(10, 20, 30, 40, 50)

    //（1）获取集合长度
    println(list.length)
    // Set不能通过length获取长度

    //（2）获取集合大小
    println(list.size)
    println(set.size)

    //（3）循环遍历
    for (elem <- list) println(elem)
    set.foreach(println(_))

    //（4）迭代器
    val iterator = list.iterator
    for (elem <- iterator) {
      println(elem)
    }
    while (iterator.hasNext) {
      println(iterator.next())
    }

    //（5）生成字符串
    val listStr = list.mkString("--")
    val setStr = set.mkString("--")
    println(listStr)
    println(setStr)

    //（6）是否包含
    val bool1 = list.contains(10)
    val bool2 = set.contains(100)
    println(bool1)
    println(bool2)

    //（7）是否为空
    val isEmpty = list.isEmpty
    println(isEmpty)

  }
}
