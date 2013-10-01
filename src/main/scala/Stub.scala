package com.rkaneko

object Stub {
  def main(args: Array[String]) {
    val t = "abcdabcabc"
    val p = "abcabc"
    import com.rkaneko.algorithm.search.KMP
    println("result " + KMP.search(t, p))
  }
}

class Stub {
  // do something
}
