package src.main.scala.chapter07

object Test03_MulArray {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个长度为3的一维数组
    Array.ofDim[Int](3)

    // 2. 创建一个包含3个长度为2的一维数组的二维数组
    val twoDimensionalArray = Array.ofDim[Int](2, 3)
    // 2.1 二维数组元素赋值
    twoDimensionalArray(0)(1) = 99
    twoDimensionalArray(1)(2) = 100
    // 2.2 二维数组遍历
    // 2.2.1 费力的普通遍历
    for (array <- twoDimensionalArray) {
      for (elem <- array) {
        println(elem)
      }
    }
    // 省略大括号
    for (array <- twoDimensionalArray) for (elem <- array) println(elem)
    // 省力优雅的普通遍历
    for (i <- twoDimensionalArray.indices; j <- twoDimensionalArray(i).indices) {
      println(twoDimensionalArray(i)(j))
    }
    // 2.2.2 省力的foreach遍历
    twoDimensionalArray.foreach(_.foreach(println))

    // 3. 为二维数组遍历赋值
    var n = 1
    for (i <- twoDimensionalArray.indices) {
      for (j <- twoDimensionalArray(i).indices) {
        twoDimensionalArray(i)(j) = n
        n += 1
      }
    }
    twoDimensionalArray.foreach(_.foreach(println))
    // 嵌套for循环简写
    for (i <- twoDimensionalArray.indices; j <- twoDimensionalArray(i).indices) {
      twoDimensionalArray(i)(j) = n
      n += 1
    }
    // 遍历打印优雅输出
    twoDimensionalArray.foreach(
      array => {
        println()
        array.foreach( elem => print(elem + "\t"))
      }
    )
  }
}
