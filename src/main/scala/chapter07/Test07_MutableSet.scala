package src.main.scala.chapter07

import scala.collection.mutable

object Test07_MutableSet {
  def main(args: Array[String]): Unit = {
    // 1. 创建可变Set（注意：无法使用new的方式创建可变Set）
    // 1.1 使用伴生对象的apply()方法创建
    val mutableSet1 = mutable.Set(10, 20, 30)
    println(mutableSet1)

    println("--------------------------------------------------")

    // 2. 添加元素
    // 2.1 使用+()方法，原Set集合不改变，返回一个新的Set
    val mutableSet2 = mutableSet1.+(40).+(50).+(60)
    println(mutableSet1)
    println(mutableSet2)
    // 简写：省略小括号
    val mutableSet3 = mutableSet2 + 70 + 80 + 90
    println(mutableSet3)
    // 2.2 使用+=()方法，原Set集合改变，并且返回一个新的Set
    val mutableSet4 = mutableSet3.+=(100).+=(110).+=(120)
    println(mutableSet3)
    println(mutableSet4)
    // 简写：省略小括号
    val mutableSet5 = mutableSet4 += 130 += 140 += 150
    println(mutableSet4)
    println(mutableSet5)
    // 2.3 使用add()方法 (注意：add方法返回Boolean类型结果，所以不支持链式调用)
    mutableSet5.add(160)
    println(mutableSet5)

    println("--------------------------------------------------")

    // 3. 删除元素
    // 3.1 使用-()方法，原Set不改变，返回一个新的Set
    val mutableSet6 = mutableSet5.-(160).-(150).-(140)
    println(mutableSet5)
    println(mutableSet6)
    // 简写：省略小括号
    val mutableSet7 = mutableSet6 - 130 - 120 - 110
    println(mutableSet6)
    println(mutableSet7)
    // 3.2 使用-=()方法，subtractOne(x)方法的隐式转换，原Set集合改变，并且返回一个新的Set
    val mutableSet8 = mutableSet7.-=(100, 90, 80)
    println(mutableSet7)
    println(mutableSet8)
    // 简写：省略小括号
    val mutableSet9 = mutableSet8 -= (70, 60, 50) -= 99 -= 999 -= 9999
    println(mutableSet8)
    println(mutableSet9)
    // 3.3 使用remove方法 (注意：remove方法返回Boolean类型结果，所以不支持链式调用)
    mutableSet9.remove(40)
    println(mutableSet9)
    // 3.4 使用diff()方法，删除Set中在另一个set中存在的元素，原Set不改变，返回一个新的Set
    val mutableSet10 = mutableSet9.diff(mutable.Set(30, 20, 10)).diff(Set(99, 999, 9999))
    println(mutableSet9)
    println(mutableSet10)

    println("--------------------------------------------------")

    // 4. 合并可变Set
    // 4.1 使用++()方法，是concat()方法的隐式转换，原来的Set都不改变，返回一个新的的合并后的Set
    val mutableSet11 = mutable.Set(10, 20, 30)
    val mutableSet12 = mutable.Set(40, 50, 60)
    val mutableSet13 = mutableSet11.++(mutableSet12)
    println(mutableSet11)
    println(mutableSet12)
    println(mutableSet13)
    // 简写：省略小括号
    val mutableSet14 = mutableSet11 ++ mutableSet12
    println(mutableSet14)
    // 4.2 使用++=()的方法，是addAll()方法的隐式转换，调用++=()的原Set会修改，被++=()方法调用的原Set不发生修改，并且返回一个新的合并后的Set
    val mutableSet15 = mutableSet11.++=(mutableSet12)
    println(mutableSet11)
    println(mutableSet12)
    println(mutableSet15)
    // 简写：省略小括号
    val mutableSet16 = mutableSet11 ++= mutableSet12
    println(mutableSet16)

    println("--------------------------------------------------")

    // 5. 对整个Set运算
    // 5.1 获取最小值
    println(mutableSet16.min)
    // 5.2 获取最大值
    println(mutableSet16.max)
    // 5.3 获取和值
    println(mutableSet16.sum)
    // 5.4 归约计算
    println(mutableSet16.reduce((a, b) => a - b))
    // 归约计算 简写
    println(mutableSet16.reduce(_-_))
  }
}
