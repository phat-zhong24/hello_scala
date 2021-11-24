package src.main.scala.chapter07

object Test06_ImmutableSet {
  def main(args: Array[String]): Unit = {
    // 1. 创建Set （注意：无法使用new的方式创建Set）
    // 1.1 使用伴生对象的apply()方法创建
    val set1 = Set(10, 20, 20, 30, 30)
    println(set1)

    println("-------------------------------------------------------------")

    // 2. Set添加元素
    // 由于Set无序，所以不提供前插preAppend和后插append方法
    // 2.1 使用+()方法
    val set2 = set1.+(40).+(50).+(60)
    println(set2)
    // 简写：省略小括号
    val set3 = set2 + 70 + 80 + 90
    println(set3)
    // 2.2 使用incl()方法
    val set4 = set3.incl(100).incl(110).incl(120)
    println(set4)

    println("-------------------------------------------------------------")

    // 3. 合并Set
    val set5 = Set(130, 140, 150)
    // 使用++()方法，是concat()方法的隐式转换，原Set集合都不改变，返回新的合并后的Set
    val set6 = set4 ++ set5.concat(Set(160, 170, 180))
    println(set4)
    println(set5)
    println(set6)

    println("-------------------------------------------------------------")

    // 4. 删除Set元素
    // 4.1 使用-()方法，是excl()方法的隐式转换，原Set集合不改变，返回新的Set
    val set7 = set6.-(180).-(170).-(160)
    println(set6)
    println(set7)
    // 简写：省略小括号
    val set8 = set7 - 150 - 140 - 130
    println(set7)
    println(set8)
    // 4.2 使用--()方法，删除Set中在另一个set中存在的元素，原Set不改变，返回一个新的Set
    val set9 = set8.--(Set(120, 110, 100)).--(Set(99, 999, 9999))
    println(set8)
    println(set9)
    // 简写：省略小括号
    val set10 = set9 -- Set(90, 80, 70) -- Set(99, 999, 9999)
    println(set9)
    println(set10)
    // 4.3 使用removedAll()方法，删除Set中在另一个set中存在的元素，原Set不改变，返回一个新的Set
    val set11 = set10.removedAll(Set(60, 50, 40)).removedAll(Set(99, 999, 9999))
    println(set10)
    println(set11)

    println("-------------------------------------------------------------")

    // 5. Set遍历
    set11.foreach(println)

    println("-------------------------------------------------------------")

    // 6. 对整个Set运算
    // 6.1 获取最小值
    println(set11.min)
    // 6.2 获取最大值
    println(set11.max)
    // 6.3 获取和值
    println(set11.sum)
    // 6.4 归约计算
    println(set11.reduce((a, b) => a - b))
    // 归约计算 简写
    println(set11.reduce(_-_))

    println("-------------------------------------------------------------")

    val setBuildOnMap = Set(("Hello", 4), ("Scala", 3), ("Hbase", 2), ("kafka", 1))

    // 7. Set 转换成 数组
    val array = setBuildOnMap.toArray
    println(array.mkString(", "))

    // 8. Set 转换成 Map
    val map = setBuildOnMap.toMap
    println(map)

    // 9. Set 转换成 List
    val list = setBuildOnMap.toList
    println(list)
  }
}
