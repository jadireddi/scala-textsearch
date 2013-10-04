package com.rkaneko.algorithm.search

/**
 * BM (Boyer-Moore) method .
 */
object BM {

  /**
   * Search for pattern from text .
   *
   * @param text The text you want to search for pattern from .
   * @param pattern The text you want to search for from text .
   * @param isDebug If you want print process of searching, you may well define 'implicit val isDebug = true' .
   * @return The pattern exists in text or not .
   */
  def search(text: String, pattern: String)(implicit isDebug: Boolean = false): Boolean = {
    val textLength = text.length
    val patternLength = pattern.length
    val table = makeTable(pattern)
    def inner(patternIndex: Int, textIndex: Int, tailIndex: Int): Boolean = {
      if (textIndex >= textLength) false
      else {
        if (patternIndex < 0) {
          if (isDebug)
            println(s"""found ${pattern} from text(${tailIndex - patternLength + 1}) !""")
          true
        } else {
          if (isDebug)
            println(s"""${text(textIndex)} equals ${pattern(patternIndex)} ?""")
          val (nextPatternIndex, nextTextIndex, nextTailIndex) = nextIndex(patternIndex, textIndex, tailIndex)
          inner(nextPatternIndex, nextTextIndex, nextTailIndex)
        }
      }
    }
    def nextIndex(patternIndex: Int, textIndex: Int, tailIndex: Int): Tuple3[Int, Int, Int] = {
      val charOfText = text(textIndex)
      if (charOfText == pattern(patternIndex))
        (patternIndex - 1, textIndex - 1, tailIndex)
      else {
        val nextPatternIndex = patternLength - 1
        table.get(charOfText) match {
          case None => (nextPatternIndex, tailIndex + patternLength, tailIndex + patternLength)
          case Some(shiftFromTail) =>
            if ((patternLength - shiftFromTail - 1) >= patternIndex)
              (nextPatternIndex, tailIndex + 1, tailIndex + 1)
            else
              (nextPatternIndex, tailIndex + shiftFromTail, tailIndex + shiftFromTail)
        }
      }
    }
    inner(patternLength - 1, patternLength - 1, patternLength - 1)
  }

  /**
   * Make table for BM method .
   *
   * @param pattern The text which you want to search for .
   * @return Table for BM method .
   */
  private def makeTable(pattern: String): Map[Char, Int] = {
    pattern.reverse.toList.zipWithIndex.reverse.toMap
  }
}
