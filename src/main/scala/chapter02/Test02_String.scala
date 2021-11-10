package chapter02

object Test02_String {
  def main(args: Array[String]): Unit = {

    // 1.字符串，通过+号连接
    val name: String = "jack"
    val age: Int = 18
    println(name + "今年" + age + "岁")

    // *号用于将一个字符串复制多次并拼接  ==> scala这个骚操作可以啊
    println(name * 10)


    // 2.println用法：字符串通过占位符%传值
    printf("昨天晚上搞%s到%d点钟才睡觉，今天%s真难受啊！", "Scala", 2, "上班")
    println

    // 3.字符串模板（插值字符串）：通过$符获取变量  ==> 注意在模板字符串“***”前面加上s
    println(s"昨天晚上搞${"Scala"}到${2}点钟才睡觉，今天${"上班"}真难受啊！")

    // 使用f (对应英文单词format) 格式化模板字符串
    val num: Double = 3.1475
    println(f"The num is ${num}%50.2f")
    // 使用raw还原原始数据
    println(raw"The num is ${num}%50.2f")


    // 三引号便是字符串，保持多行字符串的原格式输出 ===> 操作手法：按下s 和 连续三个“”,然后在“”“”“”中间按下Enter键
    val sqlString= s"""
       |select *
       |from
       |  student
       |where
       |  name = ${name}
       |where
       |  age >= ${age}
       |""".stripMargin
    printf(sqlString)
  }
}
