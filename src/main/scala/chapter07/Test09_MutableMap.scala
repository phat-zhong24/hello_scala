package src.main.scala.chapter07

import scala.collection.mutable

object Test09_MutableMap {
  def main(args: Array[String]): Unit = {
    // 1. 创建可变Map（注意：无法使用new的方式创建可变Map）
    // 1.1 使用伴生对象的apply()方法创建
    val mutableMap1: mutable.Map[String, Int] = mutable.Map("a" -> 10, "b" -> 20, "c" -> 30)

    println("-----------------------------------------------------------------------------")

    // 2. 添加元素
    // 2.1 使用put()方法
    mutableMap1.put("d", 40)
    mutableMap1.put("e", 50)
    mutableMap1.put("f", 60)
    println(mutableMap1)
    // 2.2 使用 +=()方法，注意：要使用小括号()把二元组k-v对括起来
    mutableMap1.+=(("g", 70))
    println(mutableMap1)
    // 简写，注意：要使用小括号()把二元组k-v对括起来
    mutableMap1 += (("h", 80))
    println(mutableMap1)
    // 2.3 使用update()方法
    mutableMap1.update("i", 90)
    println(mutableMap1)

    println("-----------------------------------------------------------------------------")

    // 3. 删除元素
    // 3.1 使用remove()方法
    mutableMap1.remove("i")
    println(mutableMap1)
    // 3.2 使用-=()方法
    mutableMap1.-=("h").-=("g")
    println(mutableMap1)
    // 简写
    mutableMap1 -= "f" -= "e"
    println(mutableMap1)

    println("-----------------------------------------------------------------------------")

    // 4. 修改元素
    mutableMap1.update("d", 400)
    println(mutableMap1)

    println("-----------------------------------------------------------------------------")

    // 5. 合并Map
    val mutableMap2: mutable.Map[String, Int] = mutable.Map("aaa" -> 111, "b" -> 20, "c" -> 333, "d" -> 444)
    // 5.1 使用++=()方法，调用++=()方法的Map发生修改，被++=()方法调用的Map不发生修改
    val mutableMap3 = mutableMap1.++=(mutableMap2)
    println(mutableMap1)
    println(mutableMap2)
    println(mutableMap3)
    // 简写：省略小括号
    mutableMap1 ++= mutable.Map("eee" -> 555, "fff" -> 666) ++= mutable.Map( "ggg" -> 777, "hhh" -> 888)
    println(mutableMap1)
    // 5.2 使用++()方法，调用++=()方法的Map和被++=()方法调用的Map都不发生修改，返回一个新的合并后的Map
    val mutableMap4 = mutable.Map("iii" -> 999, "jjj" -> 10111)
    val mutableMap5 = mutable.Map("kkk" -> 10222, "lll" -> 10333)
    val mutableMap6 = mutableMap1 ++ mutableMap4 ++ mutableMap5
    println(mutableMap1)
    println(mutableMap4)
    println(mutableMap5)
    println(mutableMap6)

  }
}
