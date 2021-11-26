package chapter08

// 模式匹配：匹配样例类
// 好处：匹配对象类型时，使用样例类会节省大量代码
object Test07_MatchCaseClass {
  def main(args: Array[String]): Unit = {
    val coder = new Coder("Jack", 25)

    val result = coder match {
      case Coder("Jack", 25) => s"coder: name=${coder.name}, age=${coder.age}"
      case _ => "other coder"
    }

    println(result)

    println("➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢")

    // 使用匹配模式声明创建对象 (好处：额外做了变量声明和赋值) (注意：要使用匹配模式声明创建对象，就必须实现unapply方法)
    val Coder(name, age) = Coder("Mike", 27)
    println(s"name:$name, age:$age")
  }
}

// 定义样例类 (注意：属性前可以不加var or val修饰)
case class Coder(name: String, age: Int)

// 样例类
//（1）语法：case class Person (name: String, age: Int)
//（2）说明
//  2.1 样例类仍然是类，和普通类相比，只是其自动生成了伴生对象，并且伴生对象中自动提供了一些常用的方法，如 apply、unapply、toString、equals、hashCode 和 copy。
//  2.2 样例类是为模式匹配而优化的类，因为其默认提供了 unapply 方法，因此，样例类可以直接使用模式匹配，而无需自己实现 unapply 方法。
//  2.3 构造器中的每一个参数都默认成为 val，除非它被显式地声明为 var（不建议这样做）