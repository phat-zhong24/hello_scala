package src.main.scala.chapter06

object Test12_Trait {
  def main(args: Array[String]): Unit = {
    val english = new English(87) with Exam {
      override def exam(name: String): Unit = {
        println(s"$name 正在考试......")
      }
    }
    english.printInInfo()
    english.read("GoodMorning")
    english.upgrade()
    english.exam(english.name)

    println(english.apply(999))
  }
}

// 定义一个父类
class Subject {
  val name: String = "jerry"
  var score: Int = _
  def printInInfo(): Unit = {
    println(s"subject: name = ${name}, score$score")
  }
}

// 定义第一个特质
trait Read {
  // 声明非抽象属性
  val voice: String = "voice"
  // 声明抽象属性
  val name: String = "tom"

  // 声明非抽象方法
  def doBeforeRead(): Unit = {
    println("doSomething before Read......")
  }

  // 声明抽象方法
  def read(content: String): Unit
}

// 定义第二个特质
trait Update {
  def upgrade(): Unit
}

// 定义第三个特质
trait Exam {
  def exam(name: String): Unit
}

// 定义一个实现类                                     // 还可以这样继承一个极抽象的特质
class English extends Subject with Read with Update with (Int => String) {
  // 重写冲突的属性
  override val name: String = "phat"

  def this(score: Int) {
    this()
    this.score = score
  }

  // 实现抽象方法
  override def read(content: String): Unit = {
    println(s"read $content......")
  }

  // 重写父类方法
  override def printInInfo(): Unit = {
    println(s"english: name = ${name}, score$score")
  }

  override def upgrade(): Unit = {
    println("Upgrading course content......")
  }

  override def apply(v1: Int): String = {
    v1.toString
  }
}

//（1）特质可以同时拥有抽象方法和具体方法
//（2）一个类可以混入（mixin）多个特质
//（3）所有的 Java 接口都可以当做 Scala 特质使用
//（4）动态混入：可灵活的扩展类的功能
   //（4.1）动态混入：创建对象时混入 trait，而无需使类混入该 trait
   //（4.2）如果混入的 trait 中有未实现的方法，则需要实现