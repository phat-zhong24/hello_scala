package chapter10

// 隐式转换：当编译器第一次编译失败的时候，会在当前的环境中查找能让代码编译通过的方法，用于将类型进行转换，实现二次编译
object Test01_Implicit {
  def main(args: Array[String]): Unit = {

    // 1. 隐式函数：隐式转换可以在不需改任何代码的情况下，扩展某个类的功能
    implicit def convert(int: Int): MyRichInt = new MyRichInt(int)

    // 当想调用对象功能时，如果编译错误，那么编译器会尝试在当前作用域范围内查找能调用对应功能的转换规则，这个调用过程是由编译器完成的，所以称之为隐式转换。也称之为自动转换
    println(2.myMax(3))
    println(2.myMin(3))

    println("--------------------------------------------------------------------------------------------------------------")

    // 2. 隐式类：在 Scala2.10 后提供了隐式类，可以使用 implicit 声明类，隐式类的非常强大，同样可以扩展类的功能，在集合中隐式类会发挥重要的作用
    // 1）隐式类说明
    //  （1）其所带的构造参数有且只能有一个
    //  （2）隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是顶级的
    implicit class MyRichInt2(val self: Int) {
      // 自定义比较大小的方法
      def myMax2(n: Int): Int = if (n < self) self else n
      def myMin2(n: Int): Int = if (n < self) n else self
    }

    println(2.myMax2(3))
    println(2.myMin2(3))

    println("--------------------------------------------------------------------------------------------------------------")

    // 3. 隐式参数：普通方法或者函数中的参数可以通过 implicit 关键字声明为隐式参数，调用该方法时，就可以传入该参数，编译器会在相应的作用域寻找符合条件的隐式值
    // 1）说明
    //  （1）同一个作用域中，相同类型的隐式值只能有一个
    //  （2）编译器按照隐式参数的类型去寻找对应类型的隐式值，与隐式值的名称无关。
    //  （3）隐式参数优先于默认参数
    implicit val str: String = "hello everyBody"
    implicit val int: Int = 20

    def sayHello(implicit helloStr: String = "hello everyOne"): Unit = {
      println(helloStr)
    }

    sayHello // 使用隐式参数的隐式值 hello everyBody
    sayHello() // 使用参数默认值 hello everyOne
    sayHello("hello everyPeople") // 使用传参值 "hello everyPeople

    // 简写: 使用implicitly方法
    def printInAge(): Unit = {
      println("age = " + implicitly[Int])
    }

    printInAge()
  }
}


// 自定义类
class MyRichInt(val self: Int) {
  // 自定义比较大小的方法
  def myMax(n: Int): Int = if (n < self) self else n
  def myMin(n: Int): Int = if (n < self) n else self
}



// 隐式解析机制
// 1）说明
//  （1）首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。（一般是这种情况）
//  （2）如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。类型的作用域是指与该类型相关联的全部伴生对象以及该类型所在包的包对象。