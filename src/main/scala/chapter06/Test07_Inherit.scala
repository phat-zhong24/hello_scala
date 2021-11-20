package src.main.scala.chapter06

object Test07_Inherit {
  def main(args: Array[String]): Unit = {

    val people = new People()

    val curdBoy = new CurdBoy("dick", 24, 3)
    curdBoy.printlnInfo()

    val callApiBoy1 = new CallApiBoy
    callApiBoy1.printlnInfo()

    println("====================================================")

    def peopleInfo(people: People): Unit = {
      people.printlnInfo()
    }

    // 多态    多态的本质：运行时 动态绑定 实例方法
    val callApiBoy2: People = new CallApiBoy
    callApiBoy2.printlnInfo()
    peopleInfo(people)
    peopleInfo(curdBoy)
    peopleInfo(callApiBoy1)
    peopleInfo(callApiBoy2)

  }
}

// 定义一个父类
class People {
  var name: String = _
  var age: Int = _

  println("1.父类的主构造方法被调用")

  def this(name: String, age: Int) {
    this()
    this.name = name
    this.age = age
    println("2.父类的辅助构造方法被调用")
  }

  def printlnInfo(): Unit = {
    println(s"people: name = $name, age = $age")
  }
}

// 定义一个子类
// class CurdBoy(name: String, age: Int) extends People {
class CurdBoy(name: String, age: Int) extends People(name, age) {
  var workTime: Int = _

  println("3.子类的主构造方法被调用")

  def this(name: String, age: Int, workTime: Int) {
    this(name, age)
    println("4.子类的辅助构造方法被调用")
    this.workTime = workTime
  }

  override def printlnInfo(): Unit = {
    println(s"curdBoy: name = $name, age = $age, workTime = $workTime")
  }
}

// 定义另一个子类
class CallApiBoy extends People {
  override def printlnInfo(): Unit = {
    println("this is a callApiBoy")
  }
}