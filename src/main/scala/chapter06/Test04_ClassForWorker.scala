package src.main.scala.chapter06

object Test04_ClassForWorker {

}


// 定义一个父类
class Person {
  private var idCard: String = "000001"
  protected var name: String = _
  var sex: String = "male"
  private[chapter06] var age: Int = _

  def printlnInfo() = {
    println(s"Person: $idCard, $name, $sex, $age")
  }
}