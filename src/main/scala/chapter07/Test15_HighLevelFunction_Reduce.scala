package src.main.scala.chapter07

import scala.collection.mutable

object Test15_HighLevelFunction_Reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // reduce: 归约
    // 1. 归约求和
    val sum1 = list.reduce((a, b) => a + b)
    println(sum1)
    // 简写
    val sum2 = list.reduce(_ + _)
    println(sum2)

    // 使用reduceLeft()方法，数据从左往右归约，reduceLeft()是reduce()方法的底层方法
    val sum3 = list.reduceLeft((a, b) => a + b)
    println(sum3)
    val sub1 = list.reduceLeft((a, b) => a - b)  // 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 = -43
    println(sub1)

    // 使用reduceRight，数据从右往左归约
    val sum4 = list.reduceRight((a, b) => a + b)
    println(sum4)
    val sub2 = list.reduceRight((a, b) => a - b)  // 1 - (2 - (3 - (4 - (5 - (6 - (7 - (8 - 9))))))) = 5
    println(sub2)

    println("------------------------------------------------------------------------------------------")

    // fold: 折叠 (归约的一种特殊情况)
    // fold()()方法使用了函数柯里化，存在两个参数列表
    // 第一个参数列表为 ： 零值（初始值）
    // 第二个参数列表为： 简化规则
    val sumWithInit1 = list.fold(10)((a, b) => a + b)  // 10 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 55
    println(sumWithInit1)
    //  fold 底层为 foldLeft
    val sumWithInit2 = list.foldLeft(10)((a, b) => a + b)  // 10 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 55
    println(sumWithInit2)
    val subWithInit1 = list.foldLeft(10)((a, b) => a - b)  // 10 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 = -35
    println(subWithInit1)

    val subWithInit2 = list.foldRight(10)((a, b) => a - b)  // 1 - (2 - (3 - (4 - (5 - (6 - (7 - (8 - (9 - 10)))))))) = -5
    println(subWithInit2)



    println("------------------------------------------------------------------------------------------")

    // 练习：合并两个Map，key相同时，value值不覆盖，而是叠加
    val map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = mutable.Map("a" -> 111, "b" -> 2, "c" -> 333, "d" -> 444)

    val mapAfterFold = map2.foldLeft(map1)((mergeMap, kv) => {
      val k = kv._1
      val v = kv._2

      mergeMap(k) = mergeMap.getOrElse(k, 0) + v
      mergeMap
    })

    println(map1)
    println(map2)
    println(mapAfterFold)
  }
}
