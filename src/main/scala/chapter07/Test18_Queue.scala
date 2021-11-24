package src.main.scala.chapter07

import scala.collection.{immutable, mutable}


object Test18_Queue {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个不可变队列
    // 注意：immutable.Queue是一个密封类，不可使用new的方式创建
    // val immutableQueue = new immutable.Queue[Int]()
    // 使用其伴生对象的apply()方法创建对象
    val immutableQueue = immutable.Queue("a", "b", "c", "d")
    println(immutableQueue)

    println("-------------------------------------------------")

    // 2. 不可变队列添加数据，原队列不发生修改，并且返回一个新的不可变队列
    val immutableQueueAfterEn = immutableQueue.enqueue("e")
    println(immutableQueue)
    println(immutableQueueAfterEn)
    println(immutableQueueAfterEn.getClass)

    println("-------------------------------------------------")

    // 3. 不可变队列取出数据，原队列不发生修改，并且返回一个二元Tuple
    val immutableQueueAfterDe = immutableQueue.dequeue
    println(immutableQueue)
    println(immutableQueueAfterDe)
    println(immutableQueueAfterDe.getClass)


    println("=========================================================================================================")

    // 1. 创建一个可变队列  注意：使用队列本身就要求（能够先进先出）队列可变，所以一般都是使用可变队列，而不是不可变队列
    // 1.1 使用new的方式创建 注意：要指定类型
    val mutableQueue1 = new mutable.Queue[String]()
    // 1.2 使用其伴生对象的apply()方法创建对象
    val mutableQueue2 = mutable.Queue("a", "b", "c", "d")
    println(mutableQueue1)
    println(mutableQueue2)

    println("-------------------------------------------------")

    // 2. 可变队列添加数据，原队列发生修改，并且返回原可变队列
    val mutableQueueAfterEn = mutableQueue2.enqueue("e")
    println(mutableQueue2)
    println(mutableQueueAfterEn)
    println(mutableQueueAfterEn.getClass)
    println(mutableQueueAfterEn == mutableQueue2)

    println("-------------------------------------------------")

    // 3. 可变队列取出数据，原队列发生修改，并且返回一个从队列头部取出的数据
    val element = mutableQueue2.dequeue
    println(mutableQueue2)
    println(element)
  }
}
