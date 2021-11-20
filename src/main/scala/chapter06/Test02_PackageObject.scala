package src.main.scala.chapter06

object Test02_PackageObject {
  def main(args: Array[String]): Unit = {
    // 直接访问包对象的变量和方法
    println(commonValue)
    commonMethod()
  }
}
