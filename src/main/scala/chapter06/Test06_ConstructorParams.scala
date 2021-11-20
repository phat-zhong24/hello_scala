package src.main.scala.chapter06

object Test06_ConstructorParams {
  def main(args: Array[String]): Unit = {
    val teacher = new Teacher
    teacher.name = "罗老师"
    teacher.age = 35
    println(s"teacher: name = ${teacher.name}, age = ${teacher.age}")

    val teacher1 = new Teacher1("陈老师", 36)
    println(s"teacher1: name = ${teacher1.name}, age = ${teacher1.age}")

    val teacher2 = new Teacher2("李老师", 37)
    teacher2.printlnInfo()

    val teacher3 = new Teacher3("陈老师", 38)
    println(s"teacher3: name = ${teacher3.name}, age = ${teacher3.age}")

    val teacher4 = new Teacher4("王老师", 39, "育才小学")
    teacher4.printlnInfo()
  }
}

// 定义一个类
// 无参构造器
class Teacher() {
  // 单独定义属性
  var name: String = _
  var age: Int = _
}

// 定义一个类
// 有参构造器，参数有修饰 ==》 最推荐的类定义写法
class Teacher1(var name: String, var age: Int)

// 定义一个类
// 主构造方法参数无修饰
class Teacher2(name: String, age: Int) {
  def printlnInfo(): Unit = {
    println(s"teacher2: name = ${name}, age = ${age}")
  }
}

// 定义一个类
// 主构造方法参数无修饰 ==》极不推荐类定义这种写法，基本等同于Java的JavaBean写法了
class Teacher3(_name: String, _age: Int) {
  // 单独定义属性
  var name: String = _name
  var age: Int = _age
}

// 定义一个类
// 有参构造器，包含有修饰参数和无修饰参数
class Teacher4(var name: String, var age: Int) {
  var school: String = _

  def this(name: String, age: Int, school: String) {
    this(name, age)
    this.school = school
  }

  def printlnInfo() {
    println(s"teacher3: name = $name, age = $age, school = $school")
  }
}