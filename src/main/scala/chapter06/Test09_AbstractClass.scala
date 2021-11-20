package src.main.scala.chapter06

object Test09_AbstractClass {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger
    tiger.sleep()
    tiger.eat()
  }
}

// 定义一个抽象类
abstract class Animal {
  // 非抽象属性
  val name: String = "animal"
  // 抽象属性
  var age: Int

  // 非抽象方法
  def eat(): Unit = {
    println("animal eat________")
  }
  // 抽象方法
  def sleep(): Unit
}


// 定义一个具体的实现子类
class Tiger extends Animal {
  // 实现抽象父类的抽象属性
  override var age: Int = _

  // 实现抽象父类的抽象方法
  override def sleep(): Unit = {
    println("tiger sleep_________ " )
  }

  // 重写抽象父类的非抽象属性
  override val name: String = "tiger"

  // 重写抽象父类的非抽象方法
  override def eat(): Unit = {
    super.eat()
    println("tiger eat_________")
  }
}

// 继承&重写
//（1）如果父类为抽象类，那么子类需要将抽象的属性和方法实现，否则子类也需声明为抽象类
//（2）重写非抽象方法需要用 override 修饰，重写抽象方法则可以不加 override。
//（3）子类中调用父类的方法使用 super 关键字
//（4）子类对抽象属性进行实现，父类抽象属性可以用 var 修饰；
            // 子类对非抽象属性重写，父类非抽象属性只支持 val 类型，而不支持 var。
            // 因为 var 修饰的为可变变量，子类继承之后就可以直接使用，没有必要重写