package example.ducktyping

import java.util.StringTokenizer

class SentenceParserTokenize {

  def parse(sentence: String): Array[String] = {
    val tokenizer = new StringTokenizer(sentence)
    Iterator.continually({
      val hasMore = tokenizer.hasMoreTokens
      if (hasMore) {
        (hasMore, tokenizer.nextToken())
      } else {
        (hasMore, null)
      }
    }).takeWhile(_._1).map(_._2).toArray
  }

}

class SentenceParserSplit {
  def parse(sentence: String): Array[String] = sentence.split("\\s")
}


