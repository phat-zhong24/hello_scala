package src.main.scala.chapter06

object Test04_Worker {
  def main(args: Array[String]): Unit = {
    // 创建父类对象
    val person: Person = new Person
    //println(person.name)   // 私有属性不能被访问
    //println(person.idCard) // 被保护属性不能被访问
    println(person.sex)
    println(person.age)
    person.printlnInfo()

    // 创建子类对象
    val worker = new Worker
    worker.printlnInfo()
  }
}

// 定义一个子类
class Worker extends Person {
  override def printlnInfo() = {
    // idCard  // 子类并不能继续父类的私有对象  ==》 因为private为私有权限，只有在本类和类伴生对象中可用
    name = "jerry"
    sex = "female"
    age = 13
    println(s"Worker: ${},$name, $sex, $age")
  }
}
