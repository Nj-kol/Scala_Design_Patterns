package example.cakepattern

trait GenericLogger {
  def info(log: String)
}

trait Log4j extends GenericLogger {
  def info(log: String) = println(s"log4j INFO: $log")
}

trait LogBack extends GenericLogger {
  def info(log: String) = println(s"logback INFO: $log")
}

trait GenericDao { 
  def dbcall: String
}

trait MySQLDao extends GenericDao { // This is like implementing interface with default in Java8 (An implementation)
  def dbcall: String = "MySQL Implementation"
}

trait PostGresDao extends GenericDao { // This is like implementing interface with default in Java8 (An implementation)
  def dbcall: String = "PostGres Implementation"
}

case class Person(name: String)

class PersonService {
 
  // This relies on 'interface' instead of 'implementation' - it just normal Java/Spring best practice anyway.
  this: GenericDao with GenericLogger => // Syntax for trait 'self type annotation', we really should just call it 'extending an interface'

  def createPerson(p: Person) {
   this.dbcall
   this.info(s"adding ${p.name} to db")
  }
  
}
