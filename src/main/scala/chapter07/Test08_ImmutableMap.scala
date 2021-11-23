package src.main.scala.chapter07

object Test08_ImmutableMap {
  def main(args: Array[String]): Unit = {
    // 1. 创建不可变Map（注意：无法使用new的方式创建不可变Map）
    // 1.1 使用伴生对象的apply()方法创建
    val map1: Map[String, Int] = Map("a" -> 10, "b" -> 20, "c" -> 30)
    println(map1)
    println(map1.getClass)
    // -> 符号其实是 ->()方法的简写，->()方法是一个定义二元组的方法
    // 所以，可以这样定义创建Map
    val map = Map("aaa".->(111), "bbb".->(222), "ccc".->(333))
    println(map)

    println("---------------------------------------------------------------------------")

    // 2. 遍历Map
    // 2.1 使用普通for循环遍历Map的key集合
    for (key <- map1.keys) {
      println(key)
      // 获取value值 方式一：直接原始方法
      val value = map1(key)
      println(value)
      // 获取value值 方式二：使用get()方法获取，会返回特殊类型 Option(选项):有值（Some），无值(None)
      val valueInOption = map1.get(key).get
      println(valueInOption)
    }

    // 如果目标key不存在，返回自定义默认值
    val value1 = map1.get("d").getOrElse(0)
    println(value1)
    // 简写
    val value2 = map1.getOrElse("d", 0)
    println(value2)

    // 使用普通for循环遍历Map的value集合
    for (value <- map1.values) {
      println(value)
    }

    // 2.2 使用foreach遍历Map
    // kv是Map的一个基本单位：二元组
    map1.foreach((kv: (String, Int)) => println(kv))
    // 简写
    map1.foreach(println(_))
    map1.foreach(println)

    println("---------------------------------------------------------------------------")

    // 不可变Map本身不可变，所以不提供put()、+=()、++=()、++()、remove()、-=()等修改方法.
    // 要修改Map，只能使用可变Map

  }
}
