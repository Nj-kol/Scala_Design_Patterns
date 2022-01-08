package example.typeclass

/**
 * Common Code
 */
sealed trait Animal
final case class Dog(name: String) extends Animal
final case class Cat(name: String) extends Animal
final case class Bird(name: String) extends Animal

// The typeclass : Using the generic type A lets us apply this new functionality to whatever type we want.
trait BehavesLikeHuman[A] {
  def speak(a: A): Unit
}

// Typeclass instances
object BehavesLikeHumanInstances {

  // only for `Dog`
  implicit val dogBehavesLikeHuman = new BehavesLikeHuman[Dog] {
    def speak(dog: Dog): Unit = {
      println(s"I'm a Dog, my name is ${dog.name}")
    }
  }

  // only for `Bird`
  implicit val birdBehavesLikeHuman = new BehavesLikeHuman[Bird] {
    def speak(bird: Bird): Unit = {
      println(s"I'm a Bird, my name is ${bird.name}")
    }
  }
}

/**
 * Now that you defined the "TypeClasses" . You can implement the API in two ways
 */

// Approach 1 : Utils Syntax

// Define behaviour
object MyAPI {
  def speak[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
    behavesLikeHumanInstance.speak(a)
  }
}

object DemoApproachOne extends App {

  import BehavesLikeHumanInstances._

  val rover = Dog("Rover")
  val tota = Bird("Tota")

  MyAPI.speak(rover)
  MyAPI.speak(tota)
}

// Approach 2 : Defining API by implicit class ( Interface Syntax )

// Define behaviour
object BehavesLikeHumanSyntax {

  implicit class BehavesLikeHumanOps[A](value: A) {
    def speak(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.speak(value)
    }
  }
}

/**
 * The Dog instance has a new `speak` method. If you didn’t have access to the original Dog source code, this would be a huge win
 */
object DemoApproachTwo extends App {

  import BehavesLikeHumanInstances._
  import BehavesLikeHumanSyntax.BehavesLikeHumanOps

  val rover = Dog("Rover")
  val tota = Bird("Tota")

  rover.speak
  tota.speak
}