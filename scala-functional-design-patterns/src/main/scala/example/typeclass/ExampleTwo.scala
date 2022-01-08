package example.typeclass

/**
 * Ref
 *   - https://www.youtube.com/watch?v=bupBZKJT0EA
 *   - https://blog.rockthejvm.com/why-are-typeclasses-useful/
 */

trait Summable[T] {
  def sumElements(list: List[T]): T
}

object SummableTypeClasses {

  implicit object IntSummable extends Summable[Int] {
    def sumElements(list: List[Int]): Int = list.sum
  }

  implicit object StringSummable extends Summable[String] {
    def sumElements(list: List[String]): String = list.mkString("")
  }
}

object DemoExampleTwo extends App {

  import SummableTypeClasses._

  def processMyList[T](list: List[T])(implicit summable: Summable[T]): T = {
    summable.sumElements(list)
  }

  processMyList(List(1, 2, 3)) // 6
  processMyList(List("Scala ", "is ", "awesome")) // "Scala is awesome"
  // processMyList(List(true, true, false)) // ERROR
}