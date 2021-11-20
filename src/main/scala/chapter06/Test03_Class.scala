package src.main.scala.chapter06

import scala.beans.BeanProperty

object Test03_Class {
  def main(args: Array[String]): Unit = {
    // 创建一个对象
    val student = new Student()
    println(student.age)
    println(student.sex)
    student.setSex("female")
    println(student.getSex)
  }
}

// 定义一个类
class Student {
  // 声明属性
  private var name: String = _
  var age: Int = _
  @BeanProperty
  var sex: String = "male"
}
