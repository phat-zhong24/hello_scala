package src.main.scala.chapter07

import scala.collection.MapView

// 复杂 WordCount 案例：二元组第二个元素是字符串的数量
object Test17_practice_ComplexWordCount {
  def main(args: Array[String]): Unit = {

    // 方式一：普通常规思路：先把已经带预统计的原始字符串数据，展开为最原始的字符串数据。（缺点：丢弃了原始字符串数据的预统计成果，自己再重新统计一遍，耗时大增）
    /*val startTime = System.currentTimeMillis()

    val tupleList = List(("Hello Scala Spark World", 400000), ("Hello Scala Spark", 300000), ("Hello Scala", 200000), ("Hello", 100000))

    val wordCountList = tupleList
      .map(t => (t._1 + " ") * t._2)
      .flatMap(_.split(" "))
      .groupBy(word => word)
      .map(t => (t._1, t._2.size))
      .toList
      .sortBy(-_._2)
      .take(3)

    println(wordCountList)

    val endTime = System.currentTimeMillis()
    println(s"耗时：${endTime - startTime}ms")  // 耗时：1079ms
    */






    // 方式二：直接基于预统计结果进行转换，效率更改，耗时更少
    val startTime = System.currentTimeMillis()

    val tuples = List(("Hello Scala Spark World", 400000), ("Hello Scala Spark", 300000), ("Hello Scala", 200000), ("Hello", 100000))
    //println(tuples)
    // (Hello,4),(Scala,4),(Spark,4),(World,4)
    // (Hello,3),(Scala,3),(Spark,3)
    // (Hello,2),(Scala,2)
    // (Hello,1)

    val wordToCountList: List[(String, Int)] = tuples.flatMap {
      t => {
        val strings: Array[String] = t._1.split(" ")
        strings.map(word => (word, t._2))
      }
    }
    //println(wordToCountList)

    val wordToTupleMap: Map[String, List[(String, Int)]] = wordToCountList.groupBy(t => t._1)
    //println(wordToTupleMap)
    // Hello, List((Hello,4), (Hello,3), (Hello,2), (Hello,1))
    // Scala, List((Scala,4), (Scala,3), (Scala,2)
    // Spark, List((Spark,4), (Spark,3)
    // Word, List((Word,4))

    /*val wordToCountMap: Map[String, List[Int]] = wordToTupleMap.map {
      t => {
        (t._1, t._2.map(t1 => t1._2))
      }
    }
    //println(wordToCountMap)

    val wordToTotalCountMap: Map[String, Int] = wordToCountMap.map(t => (t._1, t._2.sum))
    //println(wordToTotalCountMap)*/

    // 使用Map的mapValues()方法，简化上面代码
    val wordToTotalCountMap: MapView[String, Int] = wordToTupleMap.mapValues(tupleList => tupleList.map(tuple => tuple._2).sum)
    println(wordToTotalCountMap.mkString(", "))

    val finalResultList = wordToTotalCountMap.toList.sortWith((leftTuple, rightTuple) => leftTuple._2 > rightTuple._2).take(3)
    println(finalResultList)

    val endTime = System.currentTimeMillis()

    println(s"耗时：${endTime - startTime}ms") // 耗时：207ms

  }
}
