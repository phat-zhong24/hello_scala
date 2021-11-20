package src.main.scala

package object chapter06 {
  // 定义当前包共享的属性要和方法
  val commonValue = "scala is ok"
  def commonMethod(): Unit = {
    println(s"${commonValue}")
  }
}
