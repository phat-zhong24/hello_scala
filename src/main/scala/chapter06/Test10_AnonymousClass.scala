package src.main.scala.chapter06

object Test10_AnonymousClass {
  def main(args: Array[String]): Unit = {
    // 创建一个Language匿名子类
    val scala = new Language {
      override var name: String = "Scala"
      override def coding(): Unit = println("print language name: " + name)
    }

    scala.coding()
  }
}

// 定义一个抽象类
abstract class Language {
  var name: String
  def coding(): Unit
}