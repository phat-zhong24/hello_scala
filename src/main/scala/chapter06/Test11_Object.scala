package src.main.scala.chapter06

object Test11_Object {
  def main(args: Array[String]): Unit = {
    //val db = new DB("MySql")
    val db = DB.createDB("MySql")
    db.printInInfo()

    val mongoDB = DB.apply("MongoDB")
    mongoDB.printInInfo()

    // DB.apply("MongoDB") 实质上就是 DB("MongoDB")
    val mongoDB1 = DB("MongoDB")
    mongoDB1.printInInfo()

    val db1 = DB()
    db1.printInInfo()

    println("➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢➢")

    // 使用匹配模式声明创建对象 (好处：额外做了变量声明和赋值) (注意：要使用匹配模式声明创建对象，就必须实现unapply方法)
    val DB(dbName) = DB("Mike")
    println(s"name:$dbName")
  }
}

// 定义类
// 如果想让主构造器变成私有的，可以在()之前加上 private。然后在类对应的伴生对象中提供一个创建对象的工厂方法
class DB private(var name: String) {
  def printInInfo(): Unit = {
    println(s"db name: $name, createFrom: ${DB.createFrom}")
  }
}

// 定义类的伴生对象
object DB {
  val createFrom: String = "US"

  def createDB(name: String): DB = {
    new DB(name)
  }

  def apply(name: String): DB = new DB(name)

  def apply(): DB = new DB("Neo4j")

  def unapply(db: DB): Option[String] = {
    if (db == null) {
      None
    } else {
      Some(db.name)
    }
  }
}

// 伴生对象：
//（1）单例对象采用 object 关键字声明
//（2）单例对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
//（3）单例对象中的属性和方法都可以通过伴生对象名（类名）直接调用访问。

// apply()方法：
//（1）通过伴生对象的 apply 方法，实现不使用 new 方法创建对象。
//（2）如果想让主构造器变成私有的，可以在()之前加上 private。
//（3）apply 方法可以重载。
//（4）Scala 中 obj(arg)的语句实际是在调用该对象的 apply 方法，即 obj.apply(arg)。用以统一面向对象编程和函数式编程的风格。
//（5）当使用 new 关键字构建对象时，调用的其实是类的构造方法，当直接使用类名构建对象时，调用的其实时伴生对象的 apply 方法。


// 可以使用 主构造器变成私有化 和 伴生对象实现 全局单例对象(即单例模式)