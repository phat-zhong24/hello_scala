package chapter08

import scala.collection.mutable.ListBuffer

// 匹配元组拓展
object Test05_MatchTupleExtend {
  def main(args: Array[String]): Unit = {
    // 需求：遍历获取元组第一个元素，并打印输出

    // 0. 常规遍历写法：
    for (elem <- Array(("a", 1), ("b", 2), ("c", 3))) {
      println(elem._1)
    }

    // 1. 在for循环推导式中使用模式匹配的写法：
    // 1.1 第一种写法
    for ((word, count) <- Array(("a", 1), ("b", 2), ("c", 3))) {
      println(word)
    }
    // 1.2 第二种写法，更优雅：不考虑某个位置的变量，就使用_代替
    for ((word, _) <- Array(("a", 1), ("b", 2), ("c", 3))) {
      println(word)
    }

    println("=================================================")

    // 需求：遍历过滤获取元组指定第一个元素的第二个元素，并打印输出

    // 0. 常规遍历 + if判断条件守卫 写法：
    for (elem <- Array(("a", 1), ("b", 2), ("c", 3)); if elem._1 == "a") {
      println(elem._2)
    }

    // 2. 在for循环推导式中使用模式匹配的写法：
    for (("a", count) <- Array(("a", 1), ("b", 2), ("c", 3))) {
      println(count)
    }

    println("=================================================")

    // 需求：给集合中的元组第二个元素count * 2
    val tupleList = List(("a", 1), ("b", 2), ("c", 3))

    // 0. 常规map写法：
    val resultList1 = tupleList.map(tuple => (tuple._1, tuple._2 * 2))
    println(resultList1)

    // 2. 在map方法中使用模式匹配的写法：
    val resultList2 = tupleList.map { // 为啥这里的map方法后只能使用{}，而不能使用() ？？？
      case (word, count) => (word, count * 2)
    }
    println(resultList2)
    // 原因是：
             tupleList.map(
               tuple => {
                 tuple match {
                   case (word, count) => (word, count * 2)
                 }
               }
             )
             // 可简写成：
                       tupleList.map(
                         {
                           case (word, count) => (word, count * 2)
                         }
                       )
                       // 可省略小括号简写成：
                                          tupleList.map {
                                              case (word, count) => (word, count * 2)
                                          }
                                          // 其实map {case A => B} 可以看做一个偏函数了

    // 如果是嵌套元组
    val nestTupleList = List(("a", ("a", 1)), ("b", ("b", 2)), ("c", ("c", 3)))
    val resultList3 = nestTupleList.map {
      case (groupKey, (word, count)) => (word, count * 2)
    }
    println(nestTupleList)
    println(resultList3)

    println("=================================================")

    // 同理，Map在for循环中也有模式匹配操作
    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for ((k, v) <- map) { // 直接将 map 中的 k-v 遍历出来
      println(k + " -> " + v) //3 个
    }
    println("----------------------")
    // 遍历 value=0 的 k-v ,如果 v 不是 0,过滤
    for ((k, 0) <- map) {
      println(k + " --> " + 0) // B->0
    }
    println("----------------------")
    // if v == 0 是一个过滤的条件
    for ((k, v) <- map if v >= 1) {
      println(k + " ---> " + v) // A->1 和 c->33
    }

  }
}
