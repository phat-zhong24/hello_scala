package src.main.scala.chapter07

import scala.collection.mutable.ArrayBuffer

object Test02_ArrayBuffer {
  def main(args: Array[String]): Unit = {
    // 1. 创建可变数组
    // 1.1 使用new创建
    val arrayBuffer1: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    // 1.2 使用伴生对象apply方法创建
    val arrayBuffer2 = ArrayBuffer(1, 3, 5)
    println(arrayBuffer2)
    println(arrayBuffer2.toString())
    println(arrayBuffer2.mkString(","))

    // 2. 赋值or修改数组
    // 2.1 修改数组的某个元素
    arrayBuffer2(0) = 11
    arrayBuffer2.update(1, 33)
    arrayBuffer2.update(2, 55)

    // 3. 遍历数组
    // 3.1 查看数组
    println(arrayBuffer2(0))
    println(arrayBuffer2.apply(1))
    println(arrayBuffer2.mkString(","))

    // 3.2 普通遍历
    // 3.2.1 通过索引遍历
    for (i <- 0 until arrayBuffer2.length) {
      println(arrayBuffer2(i))
    }
    // 索引获取简写
    for (i <- arrayBuffer2.indices) {
      println(arrayBuffer2(i))
    }
    // 省略大括号
    for (i <- arrayBuffer2.indices)  println(arrayBuffer2(i))

    // 3.2.2 直接遍历元素
    for (elem <- arrayBuffer2) {
      println(elem)
    }
    // 省略大括号
    for (elem <- arrayBuffer2) println(elem)

    // 3.3 使用增强for循环简化遍历
    arrayBuffer2.foreach((elem: Int) => {println(elem)})
    arrayBuffer2.foreach(println(_))
    arrayBuffer2.foreach(println)

    // 3.4 使用迭代器遍历
    val iterator = arrayBuffer2.iterator
    while (iterator.hasNext) {
      println(iterator.next())
    }
    // 省略大括号
    while (iterator.hasNext) println(iterator.next())

    // 4. 增加元素（由于创建的是不可变数组，增加元素，其实是产生新的数组）
    // :+(x) 是appended(x)方法的隐式转换, 把元素追加在数组最后。可方便连续追加无限个元素
    val arrayBuffer3 = arrayBuffer2.:+(77).:+(99)
    // 省略小括号()
    val arrayBuffer4 = arrayBuffer3.:+(11).:+(13)
    // +:(x) 是prepended(x)方法的隐式转换, 把元素追加在数组最后。可方便连续追加无限个元素
    val arrayBuffer5 = arrayBuffer4.+:(15).+:(17)
    // 省略小括号()。注意参数在前，调用方对象在后
    val arrayBuffer6 = 21 +: 19 +: arrayBuffer5
    println(arrayBuffer3.mkString(","))
    println(arrayBuffer4.mkString(","))
    println(arrayBuffer5.mkString(","))
    println(arrayBuffer6.mkString(","))

    // 前后开弓
    val arrayBuffer7 = 29 +: 27 +: arrayBuffer6 :+ 23 :+ 25
    println(arrayBuffer7.mkString(","))

    println("=====================================================================")

    // 对可变数组的修改，会生效
    // +=(x)是addOne(x)方法的隐式转换，对可变数组增加元素，在末尾添加
    arrayBuffer7 += 31
    // +=:(x)是Buffer.prepend(x)方法的隐式转换，对可变数组增加元素，在头部添加
    101 +=: 99 +=: arrayBuffer7
    // 支持链式操作
    arrayBuffer7 += 33 += 35 += 37
    println(arrayBuffer7.mkString(","))
    // -=(x)是subtractOne(x)方法的隐式转换，对可变数组删减元素
    arrayBuffer7 -= 33 -= 35 -= 37
    // 支持链式操作
    println(arrayBuffer7.mkString(","))

    println("=====================================================================")

    // appended和prepended方法 不会对原可变数组修改，只用于生成新数组。此方法限制对其他可变集合ListBuffer、MutableSet、MutableMap同样适用
    val arrayBuffer8 = arrayBuffer7.appended(33).prepended(35)
    println(arrayBuffer7.mkString(","))
    println(arrayBuffer8.mkString(","))

    // append和prepend方法 会对原可变数组修改， 返回原数组
    val newArrayBuffer = arrayBuffer8.append(999, 1111, 2222).prepend(3333, 4444, 5555)
    println(arrayBuffer8.mkString(","))
    println(arrayBuffer8 == newArrayBuffer)

    // 向指定的位置插入数据
    arrayBuffer8.insert(2, 6666)
    println(arrayBuffer8.mkString(","))
    // 向指定的位置插入另一个数组
    arrayBuffer8.insertAll(3, ArrayBuffer(7777, 8888, 9999))
    println(arrayBuffer8.mkString(","))

    // 向可变数组末尾插入另一个数组
    arrayBuffer8.appendAll(ArrayBuffer(123, 456, 789))
    // 向可变数组头部插入另一个数组
    arrayBuffer8.prependAll(ArrayBuffer(10086, 10010, 10011))
    println(arrayBuffer8.mkString(","))
    val arrayBuffer9 = ArrayBuffer(555, 666, 777)
    // ++=(x)方法是addAll(x)方法的隐式转换，向可变数组末尾插入另一个数组
    val arrayBuffer10 = arrayBuffer8 ++= arrayBuffer9
    println(arrayBuffer8.mkString(","))
    println(arrayBuffer9.mkString(","))
    println(arrayBuffer10.mkString(","))

    println("=====================================================================")

    // 5. 删减元素
    // 5.1 使用remove(index)方法，删除指定索引位置的元素
    arrayBuffer8.remove(1)
    // 5.2 使用remove(index, n)方法，删除指定索引位置后的n个元素
    arrayBuffer8.remove(1, 10)
    println(arrayBuffer8.mkString(","))
    // 5.3 -=(x)是subtractOne(x)方法的隐式转换，对可变数组删减元素
    // 5.4 使用--=(x)方法，subtractAll(x)方法的隐式转换，删除本可变数组中的在另一个数组中存在的元素
    val listBuffer7 = ArrayBuffer(555, 666, 777, 9999999)
    arrayBuffer8.--=(listBuffer7)
    println(arrayBuffer8.mkString(","))
    // 简写：省略小括号
    arrayBuffer8 --= ArrayBuffer(10086, 99)
    println(arrayBuffer8.mkString(","))

    println("=====================================================================")

    // 6. 不可变数组 与 可变数组 之间的转换
    // 可变数组 转换成 不可变数组
    val immutableArray = arrayBuffer8.toArray
    immutableArray :+ 10000
    println(immutableArray.mkString(","))
    // 不可变数组 转换成 可变数组
    val bufferArray = immutableArray.toBuffer
    bufferArray += 20000
    println(bufferArray.mkString(","))

    println("=====================================================================")

    // 7 对整个数组运算
    // 7.1 获取最小值
    println(arrayBuffer8.min)
    // 7.2 获取最大值
    println(arrayBuffer8.max)
    // 7.3 获取和值
    println(arrayBuffer8.sum)
    // 7.4 归约计算
    println(arrayBuffer8.reduce((a, b) => a - b))
    // 归约计算 简写
    println(arrayBuffer8.reduce(_-_))

  }
}
