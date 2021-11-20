package src.main.scala.chapter06

class GuShu{

}

object GuShu {
  def main(args: Array[String]): Unit = {
    val guShu = new GuShu

    //（1）判断对象是否为某个类型的实例
    if (guShu.isInstanceOf[GuShu]) {
      //（2）将对象转换为某个类型的实例
      val newGuShu: GuShu = guShu.asInstanceOf[GuShu]
      println(newGuShu)
    }

    //（3）获取类的信息
    val guShuClass: Class[GuShu] = classOf[GuShu]
    println(guShuClass)
  }
}