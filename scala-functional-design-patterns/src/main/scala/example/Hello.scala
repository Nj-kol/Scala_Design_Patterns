package example

import example.cakepattern._

object Hello extends App {

  def demoMemoization() {
    val hasher = new Hasher
    System.out.println(s"MD5 for 'hello' is '${hasher.memoMd5("hello")}'.")
    System.out.println(s"MD5 for 'bye' is '${hasher.memoMd5("bye")}'.")
    System.out.println(s"MD5 for 'hello' is '${hasher.memoMd5("hello")}'.")
    System.out.println(s"MD5 for 'bye1' is '${hasher.memoMd5("bye1")}'.")
    System.out.println(s"MD5 for 'bye' is '${hasher.memoMd5("bye")}'.")
  }

  def testCakePattern() {
 
    // Mix and match various implementations
    
    val mysql = new PersonService with MySQLDao with Log4j
    mysql.createPerson(Person("Nilanjan"))

    val postgres = new PersonService with PostGresDao with LogBack
    postgres.createPerson(Person("Nilanjan"))
    
    // Compile time error : Self type check done here
    // val postgres1 = new PersonService with PostGresDao 
  }
}
