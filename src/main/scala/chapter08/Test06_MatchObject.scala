package chapter08

object
Test06_MatchObject {
  def main(args: Array[String]): Unit = {
    // 针对对象实例的内容进行匹配
    val programmer = new Programmer("Jack", 25)

    val result = programmer match {
      case Programmer("Jack", 25) => s"programmer: name=${programmer.name}, age=${programmer.age}"
      case _ => "other programmer"
    }

    println(result)

    println("➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢")

    // 使用匹配模式声明创建对象 (好处：额外做了变量声明和赋值) (注意：要使用匹配模式声明创建对象，就必须实现unapply方法)
    val Programmer(name, age) = Programmer("Mike", 27)
    println(s"name:$name, age:$age")
  }
}

class Programmer(var name: String, var age: Int)

object Programmer {
  def apply(name: String, age: Int): Programmer = new Programmer(name, age)

  // 伴生对象必须实现 unapply 方法，用来提取拆解目标对象的属性
  def unapply(programmer: Programmer): Option[(String, Int)] = {
    if (programmer == null) {
      None
    } else {
      Some(programmer.name, programmer.age)
    }
  }
}

// val programmer = Programmer("Jack", 25)，该语句在执行时，实际调用的是 Programmer 伴生对象中的 apply 方法，因此不用 new 关键字也能构造出相应的对象。
// ➢ 当将 Programmer("Jack", 25) 写在 case 后时，会默认调用 unapply 方法(对象提取器)，programmer 作为 unapply 方法的参数，unapply 方法将 user 对象的 name 和 age 属性提取出来，与 User("zhangsan", 11)中的属性值进行匹配
// ➢ case 中对象的 unapply 方法(提取器)返回 Some，且所有属性均一致，才算匹配成功，属性不一致，或返回 None，则匹配失败。
// ➢ 若只提取对象的一个属性，则提取器为 unapply(obj:Obj):Option[T]
//    若提取对象的多个属性，则提取器为 unapply(obj:Obj):Option[(T1,T2,T3…)]
//    若提取对象的可变个属性，则提取器为 unapplySeq(obj:Obj):Option[Seq[T]]
