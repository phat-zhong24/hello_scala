package src.main.scala.chapter06

object Test16_EnumAndApp {
  def main(args: Array[String]): Unit = {
    println(Color.YELLOW)
  }
}

// 枚举类
object Color extends Enumeration {
  val RED = Value(1, "red")
  val YELLOW = Value(2, "yellow")
  val BLUE = Value(3, "blue")
}

// 应用类
object MyApp extends App {
  println("run myApp......")
}