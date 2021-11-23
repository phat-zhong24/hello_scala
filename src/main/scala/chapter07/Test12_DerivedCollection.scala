package src.main.scala.chapter07

// 衍生出另一个集合
object Test12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(10, 20, 30, 40, 50)
    val list2 = List(11, 20, 33, 40, 55, 99)
    val set1 = Set(10, 20, 30, 40, 50)
    val set2 = Set(11, 20, 33, 40, 55)

    //（1）获取集合的头
    val head = list1.head
    println(head)

    //（2）获取集合的尾（不是头的就是尾）
    // 2.1 使用tail方法
    val tail1 = list2.tail
    println(tail1) // List(20, 33, 40, 55)
    // 2.2 使用drop()方法
    val tail2 = list1.drop(1)
    println(tail2) // List(20, 33, 40, 55)

    //（3）集合最后一个数据
    // 3.1 使用last方法
    val last1 = list1.last
    println(last1)
    // 3.2 使用drop()方法
    val last2 = list1.drop(list1.length-1)
    println(last2(0))
    // 3.3 使用takeRight()方法
    println(list1.takeRight(1).head)

    //（4）集合初始数据（不包含最后一个）
    val list3 = list1.init
    println(list3)

    //（5）反转
    val list4 = list1.reverse
    println(list4)

    //（6）取前（后）n 个元素
    // 6.1 取前n个元素
    val list5 = list1.take(3)
    println(list5)
    // 6.2 取后n个元素
    val list6 = list1.takeRight(3)
    println(list6)

    //（7）去掉前（后）n 个元素
    // 7.1 去掉前n个元素
    val list7 = list1.drop(3)
    println(list7)
    // 7.2 去掉后n个元素
    val list8 = list1.dropRight(3)
    println(list8)

    //（8）并集
    // 8.1 使用union()方法
    val list9 = list7.union(list8)
    println(list9)
    // 8.2 使用:::()方法
    val list10 = list7 ::: list8
    println(list10)
    // 如果是Set做并集操作，会去重
    val set3 = set1.union(set2)
    println(set3)

    //（9）交集
    val list11 = list8.intersect(list9)
    println(list11)

    //（10）差集
    val diff1 = list1.diff(list2)
    println(diff1)
    val diff2 = list2.diff(list1)
    println(diff2)

    //（11）拉链 (即是两个集合配对成一个以二元组为元素的新集合)
    val zip1 = list1.zip(list2)
    println(zip1)
    val zip2 = list2.zip(list1)
    println(zip2)

    //（12）滑窗 (这个方法功能有点牛逼)
    val slid1: Iterator[List[Int]] = list1.sliding(3)
    for (elem <- slid1) {
      println(elem)
    }

    // 加上滑动步长 参数，进行翻页式滑动
    val slid2: Iterator[List[Int]] = list1.sliding(2, 2)
    for (elem <- slid2) {
      println(elem)
    }

  }
}
