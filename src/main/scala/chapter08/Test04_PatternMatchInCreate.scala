package chapter08
// 变量声明中的模式匹配
object Test04_PatternMatchInCreate {
  def main(args: Array[String]): Unit = {
    // 1. 使用匹配模式声明创建元组 (好处：额外做了变量声明和赋值)
    val (a, b): (Int, String) = (1, "hello")
    println(a + b)                       // 1hello
    println((a, b)._1 + (a, b)._2) // 1hello

    val (x, y): (Int, Int) = (2, 3)
    println(x + y)                 // 5
    println((x, y)._1 + (x, y)._2) // 5

    val (foo, bar, foobar) = ("福", "报", 996)
    println(s"$foo$bar = $foobar") // 福报 = 996

    println("----------------------------------------")

    // 2. 使用匹配模式声明创建数组 (好处：额外做了变量声明和赋值)
    val Array(c, d, _*) = Array(1, 3, 5, 7, 9)
    val Array(e, f, _*) = Array(1, "fff", 5, 7, "jjj")
    println(c + d)
    println(s"e = $e, f = $f")

    println("----------------------------------------")

    // 3. 使用匹配模式声明创建List (好处：额外做了变量声明和赋值)
    // 3.1 使用匹配模式声明创建
    val List(g, h, _*) = List(1, 3, 5, 7, 9)
    val List(i, j, _*) = List(1, "fff", 5, 7, "jjj")
    println(g + h)
    println(s"i = $i, j = $j")
    // 3.2 使用匹配模式和::()方法声明创建
    val first :: second :: rest = List(10, 20, 30, 40, 50)
    println(s"first = $first, second = $second, rest = $rest")

    println("----------------------------------------")

    // 4. 使用匹配模式声明创建对象 (好处：额外做了变量声明和赋值) (注意：要使用匹配模式声明创建对象，就必须实现unapply方法)
    val Programmer(name, age) = Programmer("Mike", 27)
    println(s"name:$name, age:$age")
  }
}
