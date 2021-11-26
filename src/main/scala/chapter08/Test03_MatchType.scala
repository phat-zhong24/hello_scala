package chapter08

object Test03_MatchType {
  def main(args: Array[String]): Unit = {
    // 1.匹配常量
    def describeConst(x: Any) = x match {
      case 1 => "Int one"
      case "hello" => "String hello"
      case true => "Boolean true"
      case '+' => "Char +"
      case _ => "other..."
    }

    println(describeConst(1))
    println(describeConst("hello"))
    println(describeConst(true))
    println(describeConst('+'))
    println(describeConst(999))

    println("----------------------------------------------------")

    // 3. 匹配类型
    def describeType(x: Any) = x match {
      case i: Int => "Int"
      case s: String => "String"
      case a: Array[Int] => "Array[Int]"
      case l: List[_] => "List"
      case otherThing => "other type: " + otherThing
    }

    println(describeType(1))
    println(describeType("haha"))
    println(describeType(Array(1, 3, 5)))
    println(describeType(List(1, 3, 5)))
    println(describeType(Map(1 -> "one", 3 -> "there", 5 -> "five")))

    println("----------------------------------------------------")

    // 3. 匹配数组
    for (arr <- List(
      Array(0),
      Array(1, 2),
      Array(2, 3, 4),
      Array(0, 4, 5, 6),
      Array("hello", 4, 5, 6)
    )) {
      val result = arr match {
        case Array(0) => "0" // 匹配 Array(0) 这个数组
        case Array(x, y) => x + "," + y // 匹配有两个元素的数组，然后将将元素值赋给对应的 x,y
        case Array(0, _*) => "以0开头的数组" // 匹配以 0 开头的数组
        case Array(x, 3, y) => "第二个元素为3的三元素数组" + x + y
        case _ => "something else..."
      }
      println(result)
    }

    println("----------------------------------------------------")

    // 4. 匹配列表
    // 4.1 方式一
    for (list <- List(
      List(0),
      List(1, 0),
      List(0, 0, 0),
      List(1, 0, 0),
      List(88)
    )) {
      val result = list match {
        case List(0) => "0" //匹配 List(0)
        case List(x, y) => x + "," + y //匹配有两个元素的 List
        case List(0, _*) => "以0开头的List" // 匹配以 0 开头的 List
        case _ => "something else..."
      }
      println(result)
    }

    // 4.2 方式二：双冒号::
    for (list <- List(
      List(0),
      List(1, 0),
      List(0, 0, 0),
      List(1, 0, 0, 99),
      List(88)
    )) {
      list match {
        case first :: second :: rest => println(first + ", " + second + ", " + rest)
        case otherList => println("otherList: " + otherList)
      }
    }

    println("----------------------------------------------------")

    // 5. 匹配元组
    for (tuple <- List(
      (0, 1),
      (0, 2, "hello"),
      (1, 0),
      (1, 1),
      (1, 0, 2)
    )) {
      val result = tuple match {
        case (0, _) => "0 ..." // 匹配第一个元素是 0 的二元组
        case (x, 0) => "" + x + "," + "0" // 匹配后一个元素是 0 的对偶元组
        case (a, b) => "" + a + "," +b
        case (x, 0, y) => "第二个元素为3的三元组" + x + y
        case _ => "something else..."
      }
      println(result)
    }
  }
}
