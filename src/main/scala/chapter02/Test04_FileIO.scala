package chapter02

import java.io.{File, PrintWriter}

import scala.io.Source

object Test04_FileIO {
  def main(args: Array[String]): Unit = {
    // 1.从文件中读取数据
    val filePath = "src/main/resources/test.txt"
    Source.fromFile(filePath).foreach(print)   //Scala的语法风格真的挺简洁，因为它处处都是FP风格

    // 2.将数据写入文件
    val writer = new PrintWriter(new File("src/main/resources/outPut.txt"))
    writer.write("I Love You\n在海柔的G栋办公室写下这行文字")
    writer.close()

  }
}
