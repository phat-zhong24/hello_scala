package src.main.scala.chapter07

object Test01_ImmutableArray {
  def main(args: Array[String]): Unit = {
    // 1. 创建数组
    // 1.1 使用new的方式创建数组
    val arr1: Array[Int] = new Array[Int](5)

    // 1.2 使用apply的方式创建数组
    // val arr2: Array[String] = Array.apply("aaa", "bbb", "ccc")
    val arr2: Array[String] = Array("aaa", "bbb", "ccc")

    println("-----------------------------------------------------")

    // 2. 赋值or修改数组
    // 2.1 修改数组的某个元素
    arr2(1) = "BBB"
    // 2.2 采用方法的方式给数组赋值
    arr2.update(2, "CCC")

    println("-----------------------------------------------------")

    // 3. 遍历数组
    // 3.1 查看数组
    println(arr2(0))
    println(arr2.apply(1))
    println(arr2(2))
    println(arr2.mkString(","))
    // 3.2 普通遍历
    // 3.2.1 通过索引遍历
    for (i <- 0 until  arr2.length) {
      println(arr2(i))
    }
    // 索引获取简写
    for (i <- arr2.indices) {
      println(arr2(i))
    }
    // 省略大括号
    for (i <- arr2.indices) println(arr2(i))
    // 3.2.2 直接遍历元素
    for (elem <- arr2) {
      println(elem)
    }
    // 省略大括号
    for (elem <- arr2) println(elem)
    // 3.3 使用增强for循环简化遍历
    arr2.foreach(i => println(i))
    arr2.foreach(println(_))
    arr2.foreach(println)
    // 3.4 使用迭代器遍历
    val iterator = arr2.iterator
    while (iterator.hasNext) {
      println(iterator.next())
    }
    // 省略大括号
    while (iterator.hasNext) println(iterator.next())

    println("-----------------------------------------------------")

    // 4. 增加元素（由于创建的是不可变数组，增加元素，其实是产生新的数组）
    // :+(x) 是appended(x)方法的隐式转换, 把元素追加在数组最后。可方便连续追加无限个元素
    val arr3 = arr2.:+("ddd").:+("DDD")
    // 省略小括号()
    val arr4 = arr3 :+ "eee" :+ "EEE"
    // +:(x) 是prepended(x)方法的隐式转换, 把元素追加在数组最后。可方便连续追加无限个元素
    val arr5 = arr4.+:("fff").+:("FFF")
    // 省略小括号()。注意参数在前，调用方对象在后
    val arr6 = "GGG" +: "ggg" +: arr5
    println(arr2)
    println(arr3)
    println(arr4)
    println(arr5)
    println(arr6)
    println(arr5.mkString("-"))
    println(arr6.mkString("-"))

    // 前后开弓
    val arr7 = "000" +: "111" +: arr6 :+ "222" :+ "333"
    println(arr7.mkString("-"))
    // 对不可变数组的修改，不会生效
    arr7.appended("modify")
    println(arr7.mkString("-"))

    println("-----------------------------------------------------")

    // 5 对整个数组运算
    // 5.1 获取最小值
    println(arr7.min)
    // 5.2 获取最大值
    println(arr7.max)
    // 5.3 获取和值
    // 5.4 归约计算
    // 归约计算 简写

  }
}
