package src.main.scala.chapter07

// 集合计算简单函数
object Test13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list1 = List(10, 20, 30, 40, 50)

    //（1）求和
    val sum = list1.sum
    println(sum)

    //（2）求乘积
    val product = list1.product
    println(product)

    //（3）最大值
    // 3.1 使用max()方法，直接获取最大值的元素
    val max = list1.max
    println(max)
    // 3.2 使用maxBy()方法，获取指定逻辑下的最大值元素
    val maxBy = list1.maxBy(x => x * -1)
    println(maxBy)

    //（4）最小值
    // 4.1 使用mIN()方法，直接获取最小值的元素
    val min = list1.min
    println(min)
    // 4.2 使用minBy()方法，获取指定逻辑下的最小值元素
    val minBy = list1.minBy(x => x * -1)
    println(minBy)

    //（5）排序
    // 5.1 使用sorted()方法，自然排序(即从小到大升序排序)
    val sortedList1 = List(60, 10, 20, 30, 40, 50).sorted
    println(sortedList1)
    // 从大到小倒序排序
    // 愚蠢写法：
    val reverseList = sortedList1.reverse
    println(reverseList)
    // 稍微一点优雅的写法：传入倒序排序函数
    val sortedList2 = List(60, 10, 20, 30, 40, 50).sorted(Ordering[Int].reverse)
    println(sortedList2)

    // 5.2 使用sortBy()方法，自然排序(即从小到大升序排序)
    val sortedList3 = List(60, 10, 20, 30, 40, 50).sortBy((x => x))
    println(sortedList3)
    // 从大到小倒序排序，稍微优雅写法：
    /*val sortedList4 = List(60, 10, 20, 30, 40, 50).sortBy(Ordering[Int].reverse)
    println(sortedList4)*/
    // 从大到小倒序排序，优雅写法：
    val sortedList5 = List(60, 10, 20, 30, 40, 50).sortBy((x => -x))
    println(sortedList5)
    // “最优雅”写法：简写
    val sortedList6 = List(60, 10, 20, 30, 40, 50).sortBy(-_)
    println(sortedList6)

    // 5.3 使用sortWith()方法，自然排序(即从小到大升序排序)
    val sortedList7 = List(60, 10, 20, 30, 40, 50).sortWith((a, b) => a < b)
    println(sortedList7)
    // 简写
    println(List(60, 10, 20, 30, 40, 50).sortWith(_<_))
    // 从大到小倒序排序，优雅写法：
    val sortedList8 = List(60, 10, 20, 30, 40, 50).sortWith((a, b) => a > b)
    println(sortedList8)
    // 简写
    println(List(60, 10, 20, 30, 40, 50).sortWith(_>_))
  }
}
