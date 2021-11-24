package src.main.scala.chapter07

import scala.collection.parallel.CollectionConverters._

object Test19_ParallelOperation {
  def main(args: Array[String]): Unit = {

    // Scala默认使用单核的主线程(即是单线程)，来操作数据
    val singletonThreadTuples = (1 to 10000).map(
      x => (
        Thread.currentThread().getId,
        Thread.currentThread().getName,
        Thread.currentThread().getThreadGroup
      )
    )
    println(singletonThreadTuples)


    println("-----------------------------------")


    // 调用par方法，使用多核多线，来操作数据
    val multiThreadTuples = (1 to 10000).par.map(
      x => (
        Thread.currentThread().getId,
        Thread.currentThread().getName,
        Thread.currentThread().getThreadGroup
      )
    )
    println(multiThreadTuples)

  }
}
