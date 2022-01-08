package example.ducktyping

object DuckTypingExamples {

  // Example 1:
  def callSpeak[A <: { def speak(): Unit }](obj: A) {
    obj.speak()
  }

  class Dog { def speak() { println("woof") } }
  class Klingon { def speak() { println("Qapla!") } }

  // Example 2:
  def printSentenceParts[A <: { def parse(sentence: String): Array[String] }](sentence: String, parser: A) {
    parser.parse(sentence).foreach(println)
  }

  // Alternate syntax
  def printSentencePartsAlter(sentence: String, parser: {
    def parse(sentence: String): Array[String]
  }) = {
    parser.parse(sentence).foreach(println)
  }

  def main(args: Array[String]): Unit = {

    // Example 1:
    callSpeak(new Dog)
    callSpeak(new Klingon)

    // Example 2:
    val tokenizerParser = new SentenceParserTokenize
    val splitParser = new SentenceParserSplit

    val sentence = "This is the sentence we will be splitting."

    System.out.println("Using the tokenize parser: ")

    printSentenceParts(sentence, tokenizerParser)

    System.out.println("Using the split parser: ")

    printSentenceParts(sentence, splitParser)
  }
}