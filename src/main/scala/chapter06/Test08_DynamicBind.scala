package src.main.scala.chapter06

object Test08_DynamicBind {
  def main(args: Array[String]): Unit = {
    // Scala 中属性和方法都是动态绑定，而 Java 中只有方法为动态绑定
    val mac: Mac = new Mac()
    println(mac.name)
    mac.run()
    val mac1: Computer = new Mac
    println(mac1.name)
    mac1.run()
  }
}

class Computer {
  val name: String = "person"

  def run(): Unit = {
    println("run computer -----------")
  }
}

class Mac extends Computer {
  // Scala中，可以通过override关键字，对父类的val属性进行重写覆盖
  // 注意：var属性不能被子类重写覆盖。因为 var 修饰的为可变变量，子类继承之后就可以直接使用，没有必要重写
  override val name: String = "mac"

  override def run(): Unit = {
    println("run mac ----------")
  }
}



