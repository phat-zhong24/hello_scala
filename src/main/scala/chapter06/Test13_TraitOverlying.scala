package src.main.scala.chapter06

object Test13_TraitOverlying {
  def main(args: Array[String]): Unit = {
    val player = new Player
    player.play()

    // 钻石问题特征叠加
    val myBall = new MyBall
    println(myBall.describe())
  }
}

trait BasketBall {
  def play(): Unit = {
    println("play basketBall......")
  }
}

trait FootBall {
  def play(): Unit = {
    println("play footBall......")
  }
}

class Player extends BasketBall with FootBall {
  var name: String = _
  var age: Int = _

  // 第一种，一个类（Sub）混入的两个 trait（TraitA，TraitB）中具有相同的具体方法，且两个 trait 之间没有任何关系，解决这类冲突问题，直接在类（Sub）中重写冲突方法。
  override def play(): Unit = {
    println("play some sport......")
  }
}


trait Ball {
  def describe(): String = "ball"
}

// 定义颜色特征
trait ColorBall extends Ball {
  var color: String = "red"
  override def describe(): String = color + "-" + super.describe()
}

// 定义类型特征
trait CategoryBall extends Ball {
  var category: String = "foot"
  override def describe(): String = category + "-" + super.describe()
}

// 定义一个自定义的球
class MyBall extends CategoryBall with ColorBall {
  override def describe(): String = "myBall is a " + super.describe()
  // 如果想要调用某个指定的混入特质中的方法，可以增加约束：super[]
  // override def describe(): String = "myBall is a " + super[CategoryBall].describe()
}

// 特质叠加
// 由于一个类可以混入（mixin）多个 trait，且 trait 中可以有具体的属性和方法，若混入的特质中具有相同的方法（方法名，参数列表，返回值均相同），必然会出现继承冲突问题。
// 冲突分为以下两种：
// 第一种，一个类（Sub）混入的两个 trait（TraitA，TraitB）中具有相同的具体方法，且两个 trait 之间没有任何关系，解决这类冲突问题，直接在类（Sub）中重写冲突方法。
// 第二种，一个类（Sub）混入的两个 trait（TraitA，TraitB）中具有相同的具体方法，且两个 trait 继承自相同的 trait（TraitC），及所谓的“钻石问题”，解决这类冲突问题，Scala采用了特质叠加的策略。