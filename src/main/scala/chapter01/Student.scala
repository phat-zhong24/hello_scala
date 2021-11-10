package chapter01

class Student(name: String,var age: Int) {

  def printInfo(): Unit = {
    println(name + " " + age + " " + Student.school)
  }
}


// 引入伴生对象 --> 解决Java的Static问题
object Student {
  val school: String = "清华大学"

  def main(args: Array[String]): Unit = {
    val tom = new Student("Tom", 20)
    val jerry = new Student("Jerry", 20)

    tom.printInfo()
    jerry.printInfo()

  }
}