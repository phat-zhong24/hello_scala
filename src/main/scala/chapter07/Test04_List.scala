package src.main.scala.chapter07

object Test04_List {
  def main(args: Array[String]): Unit = {
    // 1. 创建List, List默认为不可变集合
    // val list = new List[Int]()  // error: List是一个抽象类，不能使用new的方式创建
    // 1.1 使用伴生对象的apply方法创建
    val list1 = List(1, 3, 5, 5, 5, 7)
    // 1.2 使用空集合Nil调用::方法创建（倒序创建），::的运算规则从右向左
    val list2 = Nil.::(10).::(20).::(30)
    // 简写（正序创建）
    val list3 = 10::20::30::Nil
    println(list1)
    println(list2)
    println(list3)

    println("-----------------------------------------------------------------")

    // 2. List添加数据 （不可边List添加元素后，返回一个新的不可变List）
    // 2.1 使用+:()方法，即prepended()方法，从List头部添加
    val list4 = list3.+:(40).+:(50).+:(60)
    // 省略小括号
    val list5= 90 +: 80 +: 70 +: list4
    // 2.2 使用:+()方法，即appended()方法，从List尾部添加
    val list6 = list5.:+(100).:+(110).:+(120)
    // 省略小括号
    val list7 = list6 :+ 130 :+ 140 :+ 150
    // 2.3 使用::()方法，从List头部添加
    val list8: List[Int] = list7.::(160).::(170).::(180)
    // 2.4 使用::()方法，从List尾部添加
    val list9: List[Any] = 190 :: 200 :: 210 :: list8
    println(list4)
    println(list5)
    println(list6)
    println(list7)
    println(list8)
    println(list9)

    // 3. 不可变List删除数据
    // 3.1 使用drop()方法，删除List前n个元素，原List不发生修改，返回一个新的List
    // 注意：当 n > List长度，不会抛异常，会把List所有元素删除
    val listAfterDrop = list9.drop(5)
    println(list9)
    println(listAfterDrop)
    // 3.2 使用dropRight()方法，删除List后n个元素，原List不发生修改，返回一个新的List
    val listAfterDropRight = list9.dropRight(5)
    println(list9)
    println(listAfterDropRight)
    // 3.2 使用dropWhile()方法，删除List中符合指定条件的元素，原List不发生修改，返回一个新的List
    // 注意：如果第一个元素就不符合条件，就终止执行，剩余存在符合条件的元素也不会被删除
    val newList = List(1, 3, 5, 5, 5, 7, 8, 9)
    val listAfterDropWhile1 = newList.dropWhile(x => x>=1)
    val listAfterDropWhile2 = newList.dropWhile(x=>{x % 3 == 0})
    println(newList)
    println(listAfterDropWhile1)
    println(listAfterDropWhile2)

    println("-----------------------------------------------------------------")

    // 3. 集合间合并：将一个整体拆成一个一个的个体，称为扁平化
    // 3.1 使用List的:::()方法
    val list10 = list8 ::: list8
    val list11 = list8 ::: list9
    val list12 = list7 ::: list8 ::: list9
    println(list10)
    println(list11)
    println(list12)
    // 3.2 使用Iterable的++()方法
    val list13 = list8 ++ list9
    println(list13)
    // 3.3 使用List的appendedAll()方法
    val list14 = list1.appendedAll(list3)
    println(list14)

    println("-----------------------------------------------------------------")

    // 4. List遍历
    println(list14.foreach(println(_)))

    println("-----------------------------------------------------------------")

    // 5 对整个List运算
    // 5.1 获取最小值
    println(list14.min)
    // 5.2 获取最大值
    println(list14.max)
    // 5.3 获取和值
    println(list14.sum)
    // 5.4 归约计算
    println(list14.reduce((a, b) => a - b))
    // 归约计算 简写
    println(list14.reduce(_-_))

  }
}
