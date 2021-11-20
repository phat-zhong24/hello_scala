package com {
  import com.phat.scala.Inner
  import one.One
  // 在外层包中定义单例对象
  object Outer {
    var out: String = "out"
    // 访问子包中的对象，需要导包
    def main(args: Array[String]): Unit = {
      println(Inner.in)
      Inner.in = "inner"
      println(Inner.in)
      println(One.one)
    }
  }

  package phat {
    package scala {
      import one.two.three.Three
      // 内层包中定义单例对象
      object Inner {
        var in: String = "in"
        def main(args: Array[String]): Unit = {
          // 访问父包中的对象，不需要导包
          println(Outer.out)
          Outer.out = "outer"
          println(Outer.out)
          println(One.one)
          println(Three.three)
        }
      }
    }
  }
}


package one {

  object One {
    var one = 1
  }
  package two {
    object Two {
      var two = 2
    }
    package three {
      // 导包
      // 通配符导入
      import java.lang._
      // 给类起名、导入相同包的多个类、屏蔽类
      import java.util.{HashMap, ArrayList => AL, HashSet => HS, Vector=>_,_}
      object Three {
        var three = 3
        private val arrayList = new AL[String]()
        private val hashSet = new HS[String]()
        private val hashMap = new HashMap[String, Int]()
      }
    }
  }
}