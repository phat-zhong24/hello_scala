package chapter10

object Test02_Generics {
  def main(args: Array[String]): Unit = {
    val child: Parent = new Child
    // 0. 不变
    val collection: MyCollection[Child] = new MyCollection[Child]
    // 1. 协变
    val collection1: MyCollection1[Parent] = new MyCollection1[Child]
    // 2. 逆变
    val collection2: MyCollection2[SubChild] = new MyCollection2[Child]

    println("--------------------------------------------------------")

    /** 泛型函数 */
    // 1. 泛型上限在函数中的使用
    def testGenericUp[A <: Child](a: A): Unit = {
      println(a.getClass)
    }
    // 2. 泛型下限在函数中的使用
    def testGenericDown[A >: SubChild](a: A): Unit = {
      println(a.getClass.getName)
    }
    // 3. 入参和返回值都定义泛型
    def testGenericUpAndDown[A <: Child, B >: Parent](a: A): B = {
      println("入参类型：" + a.getClass.getName)
      new Parent
    }

    val parent = new Parent
    val child1 = new Child
    val subChild = new SubChild
    //testGenericUp(parent)
    //testGenericUp(child)
    testGenericUp(child1)
    testGenericUp(subChild)
    testGenericDown(subChild)
    testGenericDown(parent)
    testGenericDown(child)

    println(testGenericUpAndDown(child1).getClass.getName)
    println(testGenericUpAndDown(subChild).getClass.getName)

    println("--------------------------------------------------------")

    val childList: MyList1[Child] = new MyList1[Child]
    val subChildList: MyList1[SubChild] = new MyList1[SubChild]
    val parentList: MyList2[Parent] = new MyList2[Parent]
  }
}


// 定义继承关系
// 父母
class Parent {}
// 孩子
class Child extends Parent {}
// 孙
class SubChild extends Child {}

/** 泛型类 */
class MyCollection[T] {

}

/** 泛型类 */
class MyCollection1[+T >: Child] {

}

/** 泛型类 */
class MyCollection2[-T] {

}

// 1. 泛型上限在泛型类中的使用
class MyList1[T <: Child] {

}

// 2. 泛型下限在泛型类中的使用
class MyList2[T >: Parent] {

}
