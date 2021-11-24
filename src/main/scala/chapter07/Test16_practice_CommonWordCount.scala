package src.main.scala.chapter07

// 普通 WordCount 案例
// 需求：
// 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
object Test16_practice_CommonWordCount {
  def main(args: Array[String]): Unit = {
    val stringList = List(
      "Hello Scala Hbase kafka",
      "Hello Scala Hbase",
      "Hello Scala",
      "Hello"
    )

    // 1. 使用flatMap，将每一个字符串转换成一个一个单词
    val listAfterFlatMap = stringList.flatMap(wordString => wordString.split(" "))
    println(listAfterFlatMap)

    // 2. 使用groupBy，将相同的单词放置在一起
    val listAfterGroupBy = listAfterFlatMap.groupBy(word => word)
    println(listAfterGroupBy)

    // 3. 使用map，对相同的单词进行计数
    val mapAfterMap1 = listAfterGroupBy.map(kv => kv._1 -> kv._2.size)
    println(mapAfterMap1)
    // 简写
    val mapAfterMap2 = listAfterGroupBy.map(kv => (kv._1, kv._2.size))
    println(mapAfterMap2)

    // 4. 使用sortBy or sortWith，对计数完成后的结果进行排序（降序）
    val listAfterSort1 = mapAfterMap1.toList.sortBy(map => -map._2)
    val listAfterSort2 = mapAfterMap1.toList.sortWith((left, right) => left._2 > right._2)
    println(listAfterSort1)
    println(listAfterSort2)

    // 5. 使用take，对排序后的结果取前 3 名
    val finalResultList = listAfterSort2.take(3)
    println(finalResultList)

  }
}
