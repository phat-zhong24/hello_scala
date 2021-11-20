package src.main.scala.chapter06

object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    // 创建对象
    val human = new Human()
    human.Human()

    val tom = new Human("tom")
    val tom1 = new Human("tom", 13)
  }
}

// 定义一个类  // {}括号内的代码都属于主构造方法的方法体
class Human {
  // 定义属性
  var name: String = _
  var age: Int = _

  println("start-主构造方法被调用")

  // 声明辅助构造方法
  def this(name: String) {
    this() // 直接调用主构造方法
    println("2.第一个辅助构造方法被调用")
    this.name = name
    println(s"name: $name, age: $age")
  }

  def this(name: String, age: Int) {
    this(name) // 间接调用主构造方法
    println("3.第二个辅助构造方法被调用")
    this.age = age
    println(s"name: $name, age: $age")
  }

  def Human(): Unit = {
    println("一般方法被调用")
  }

  println("end-主构造方法被调用")

}
