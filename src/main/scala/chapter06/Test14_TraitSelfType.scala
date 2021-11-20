package src.main.scala.chapter06

// 定义一个用户类
class User(val name: String, val password: String)

trait UserDao {
  def insert(user: User): Unit = {
    println(s"insert a user: name${user.name}, password${user.password} to DB......")
  }
}

trait UserService {
  _: UserDao =>
  def register(user: User): Unit = {
    insert(user)
  }
}

object UserController extends UserService with UserDao {
  def main(args: Array[String]): Unit = {
    register(new User("phat", "63438"))
  }
}
