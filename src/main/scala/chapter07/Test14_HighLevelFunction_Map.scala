package src.main.scala.chapter07

object Test14_HighLevelFunction_Map {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 1. filter: 过滤
    val listAfterFilter = list.filter((elem: Int) => {
      elem % 2 == 0
    })
    println(listAfterFilter)
    // 简写
    println(list.filter(_ % 2 != 0))

    println("------------------------------------------------------------------------")

    // 2. map: 转化/映射
    val listAfterMap1 = list.map(x => x * x)
    val listAfterMap2 = list.map((_.toString))
    println(listAfterMap1)
    println(listAfterMap2)
    println(listAfterMap2.head.getClass)

    println("------------------------------------------------------------------------")

    // 3. flatten: (打散)扁平化  简称：打平
    val nestList: List[(List[Int])] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    // 愚蠢费力的写法
    val flatList = nestList(0) ::: nestList(1) ::: nestList(2)
    println(flatList)
    // 优雅省力的写法
    val listAfterFlatten: List[Int] = nestList.flatten
    println(listAfterFlatten)

    println("------------------------------------------------------------------------")

    // 4. flatMap: 映射 + 扁平化
    val wordList1: List[String] = List("hello world", "hello Java", "hello Scala")
    val listAfterFlatMap = wordList1.flatMap(x => x.split(" "))
    println(listAfterFlatMap)

    println("------------------------------------------------------------------------")

    // 5. group: 分组
    // 分成奇偶数两组
    val listAfterGroupBy1: Map[Int, List[Int]] = list.groupBy(x => x % 2)
    println(listAfterGroupBy1)
    val listAfterGroupBy2: Map[String, List[Int]] = list.groupBy(x => {
      if (x % 2 == 0) {
        "ouShu"
      } else {
        "jiShu"
      }
    })
    println(listAfterGroupBy2)
    // 给定一组词汇，按照单词的首字母进行分组
    val wordList2 = List("filter", "map", "flatten", "flatmap", "groupBy", "reduce", "fold")
    val listAfterGroupBy3 = wordList2.groupBy(x => x.charAt(0))
    println(listAfterGroupBy3)

  }
}
