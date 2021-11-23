package src.main.scala.chapter07

import scala.collection.mutable.ListBuffer

object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    // 1. 创建可变列表List
    // 1.1 使用new的方式创建
    val listBuffer1 = new ListBuffer[Int]()
    // 1.2 使用伴生对象的apply()方法创建
    val listBuffer2 = ListBuffer(10, 20, 30)
    println(listBuffer1)
    println(listBuffer2)

    println("-------------------------------------------------------")

    // 2. 可变List添加数据   Scala集合操作原则：不可变集合使用符号方法了，可变集合使用符号方法对应的隐式字符串方法
    // 2.1 使用append()方法，即addAll()隐式方法，从List头部添加
    listBuffer2.append(30, 40, 50)
    // 2.2 使用prepend()方法，即prependAll()隐式方法，从List尾部添加
    listBuffer2.prepend(60, 70, 80)
    println(listBuffer2)
    listBuffer2.prepend(90).append(100).prepend(110)
    println(listBuffer2)
    // 2.2 使用insert()方法，从List指定索引位置添加一个元素
    listBuffer2.insert(0, 120)
    println(listBuffer2)
    // 2.3 使用insertAll()方法，从List指定索引位置添加另一个List
    listBuffer2.insertAll(0, ListBuffer(130, 140, 150))
    println(listBuffer2)
    // 2.4 使用+=(x)方法，即是addOne(x)方法的隐式转换，对可变List增加元素，在末尾添加
    listBuffer2 += 160
    println(listBuffer2)
    listBuffer2 += 170 += 180 += 190
    println(listBuffer2)
    // 2.5 +=:(x)是Buffer.prepend(x)方法的隐式转换，对可变列表List增加元素，在头部添加
    listBuffer2.+=:(200).+=:(210).+=:(220)
    println(listBuffer2)
    // 简写：省略小括号
    230 +=: 240 +=: 250 +=: listBuffer2
    println(listBuffer2)

    println("-------------------------------------------------------")

    // 3. 合并List
    // 3.1 使用++()方法合并两个可变list，原来的被合并的list都不改变，只会产生一个新的合并后的list
    val listBuffer3 = ListBuffer(260, 270, 280)
    val listBuffer4 = listBuffer2 ++ listBuffer3
    println(listBuffer2)
    println(listBuffer3)
    println(listBuffer4)
    // 3.2 使用++=(x)方法（是addAll(x)方法的隐式转换）合并两个可变list，调用++=(x)方法的list发生改变，被++=(x)方法调用的list不改变，并且会产生一个新的合并后的list
    val listBuffer5 = listBuffer2 ++= listBuffer3
    println(listBuffer2)
    println(listBuffer3)
    println(listBuffer5)
    // 3.3 使用++=:(x)方法（是prependAll(x)方法的隐式转换）合并两个可变list，调用++=:(x)方法的list发生改变，被++=(x)方法调用的list不改变，并且会产生一个新的合并后的list
    val listBuffer6 = listBuffer3 ++=: listBuffer2
    println(listBuffer2)
    println(listBuffer3)
    println(listBuffer6)

    println("-------------------------------------------------------")

    // 4. 修改List元素
    // 4.1 使用原始语法修改
    listBuffer6(5) = 999
    println(listBuffer6)
    // 4.2 使用update()方法修改
    listBuffer6.update(6, 9999)
    println(listBuffer6)

    println("-------------------------------------------------------")

    // 5. 删除list元素
    // 5.1 使用-=(x)方法，subtractOne(x)方法的隐式转换，删除某个存在首先出现的元素
    listBuffer6.-=(999)
    println(listBuffer6)
    // 简写：省略小括号
    listBuffer6 -= 9999
    println(listBuffer6)
    // 5.2 使用-=(x)方法，subtractOne(x)方法的隐式转换，删除多个存在首先出现的元素
    listBuffer6.-=(260, 270, 280)
    println(listBuffer6)
    // 5.3 使用--=(x)方法，subtractAll(x)方法的隐式转换，删除本list中的在另一个list中存在的元素
    val listBuffer7 = ListBuffer(260, 270, 280, 9999999)
    listBuffer6.--=(listBuffer7)
    println(listBuffer6)
    // 简写：省略小括号
    listBuffer6 --= ListBuffer(230, 240)
    println(listBuffer6)
    // 5.4 使用remove(index)方法，删除指定索引位置的元素
    listBuffer6.remove(1)
    println(listBuffer6)
    // 5.5 使用remove(index, n)方法，删除指定索引位置后的n个元素
    listBuffer6.remove(1, 3)
    println(listBuffer6)
    // 5.6 使用drop()方法，删除List前n个元素，原List发生修改，并且返回一个新的List
    // 注意：当 n > List长度，不会抛异常，会把List所有元素删除
    // 5.7 使用dropRight()方法，删除List后n个元素，原List不发生修改，返回一个新的List
    // 5.8 使用dropWhile()方法，删除List中符合指定条件的元素，原List发生修改，并且返回一个新的List
    // 注意：如果第一个元素就不符合条件，就终止执行，剩余存在符合条件的元素也不会被删除

    // 6. 对整个List运算
    // 6.1 获取最小值
    println(listBuffer6.min)
    // 6.2 获取最大值
    println(listBuffer6.max)
    // 6.3 获取和值
    println(listBuffer6.sum)
    // 6.4 归约计算
    println(listBuffer6.reduce((a, b) => a - b))
    // 归约计算 简写
    println(listBuffer6.reduce(_-_))

  }
}
