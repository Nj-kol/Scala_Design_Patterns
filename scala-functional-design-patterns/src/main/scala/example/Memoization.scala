package example

import scala.collection.mutable.Map
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex

trait Memoizer {

  def memo[X, Y](f: X => Y): (X => Y) = {
    val cache = Map[X, Y]()
    (x: X) => cache.getOrElseUpdate(x, f(x))
  }
}

class Hasher extends Memoizer {

  def md5(input: String) = {
    System.out.println(s"Calling md5 for $input.")
    new String(Hex.encodeHex(MessageDigest.getInstance("MD5").digest(input.getBytes)))
  }

  val memoMd5 = memo(md5)
}