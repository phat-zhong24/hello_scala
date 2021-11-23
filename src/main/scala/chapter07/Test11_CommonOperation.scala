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



    // 4. 集合计算高级函数
    //（1）过滤：遍历一个集合并从中获取满足指定条件的元素组成一个新的集合
    //（2）转化/映射（map）：将集合中的每一个元素映射到某一个函数
    //（3）扁平化
    //（4）扁平化+映射 注意：flatMap 相当于先进行 map 操作，在进行 flatten 操作集合中的每个元素的子元素映射到某个函数并返回新集合
    //（5）分组(group)：按照指定的规则对集合的元素进行分组
    //（6）简化（归约）
    //（7）折叠
  }
}
