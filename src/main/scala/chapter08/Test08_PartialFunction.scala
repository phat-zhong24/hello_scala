package chapter08

// 偏函数: 偏函数也是函数的一种，通过偏函数我们可以方便的对输入参数做更精确的检查
//（可以理解为”偏科的函数“，即专门处理某种类型的数据，相当于把模式匹配的case分支单独拆开定义成一个个函数，主要目的是：对case分支复用）
object Test08_PartialFunction {
  def main(args: Array[String]): Unit = {
    // 需求：返回输入的 List 集合的第二个元素
    val list = List(1, "hello", 3, 5, 7)

    // 定义偏函数
    val getSecond: PartialFunction[List[Any], Option[Any]] = {
      case _ :: second :: _ => Some(second)
    }

    // 调用偏函数
    val option = getSecond(list)
    println(option.getOrElse("nothing"))

    println("➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢")

    // 偏函数的简单应用实例：求绝对值
    // 为应对不同的入参情况：正、负、0
    // 定义三个处理不同数据情况的求绝对值偏函数：
    val positiveAbs: PartialFunction[Int, Int] = {
      case x if x > 0 => x
    }

    val negativeAbs: PartialFunction[Int, Int] = {
      case x if x < 0 => -x
    }

    val zeroAbs: PartialFunction[Int, Int] = {
      case 0 => 0
    }

    // 直接调用偏函数
    println(positiveAbs(5))
    println(negativeAbs(-5))
    println(zeroAbs(0))

    // 封装一个普通函数：来有选择地复合调用偏函数
    def abs1(x: Int): Int = positiveAbs.orElse(negativeAbs.orElse(zeroAbs))(x)
    // 简写：省略小括号   positiveAbs orElse negativeAbs orElse zeroAbs 整体就是一个复合的偏函数
    def abs2(x: Int): Int = (positiveAbs orElse negativeAbs orElse zeroAbs)(x)
    println(abs1(5))
    println(abs2(-5))
    println(positiveAbs.getClass)
    println((positiveAbs orElse negativeAbs orElse zeroAbs).getClass) // OrElse类型是抽象偏函数AbstractPartialFunction的子类

    println("➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢")

    // 需求：将该 List(1,2,3,4,5,6,"test")中的 Int 类型的元素加一，并去掉字符串
    val list1 = List(1, 2, 3, 4, 5, 6, "test")
    // collect {A => B}其实就是偏函数
    val resultList = list1.collect {
      case x: Int => x + 1
    }
    println(resultList)
  }
}
