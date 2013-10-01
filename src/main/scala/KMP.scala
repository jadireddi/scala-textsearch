package com.rkaneko.algorithm.search

/**
 * KMP (Knuth-Morris-Pratt) method .
 */
object KMP {
  
  /**
   * Search for pattern from text .
   *
   * @param text The text you want to search for pattern from .
   * @param pattern The text you want to search for from text .
   * @return The pattern exists in text or not .
   */
  def search(text: String, pattern: String): Boolean = {
    val patternChars = pattern.toList
    val patternLength = pattern.length
    if (patternLength <= 0) return true
    else {
      val textLength = text.length
      if (textLength < patternLength) false;
      else {
        val table = makeTable(pattern)
        val textChars = text.toList
        def comp(i: Int, j: Int): Boolean = {
          if (textLength - i < patternLength - j)
            false
          else {
            (i < textLength, j < patternLength) match {
              case (true, true) =>
                if (textChars(i) == patternChars(j)) {
                  comp(i + 1, j + 1)
                } else {
                  val index = table(j)
                  val (_i, _j) = if (index == -1) (i + 1, 0) else (i, index)
                  comp(_i, _j)
                }
              case (false, true) => false
              case _ => true
              }
            }
          }
        comp(0, 0)
        }
    }
  }

  /**
   * Make table for KMP method .
   * 
   * @param pattern The text which you want to search for .
   * @return Table for KMP method . Table's head element is -1 .
   */
  private def makeTable(pattern: String): Array[Int] = {
    val patternLength = pattern.length
    require(patternLength > 0)
    def inner(i: Int, j: Int, table: Array[Int] = Array(-1, 0)): Array[Int] = {
      if (j == patternLength - 1) table
      else {
        val isMatch = pattern(i) == pattern(j)
        val index = if (isMatch) table.last + 1 else 0
        inner(if (isMatch) i + 1 else i, j + 1, table :+ index)
      }
    }
    if (patternLength == 1) Array(-1)
    else inner(0, 1)
  }

}
