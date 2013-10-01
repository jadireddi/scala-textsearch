Scala text search algorithm
================

### description
Text search algorithm implemented with Scala . I wrote this code to study Scala lang .

Samples
---

KMP (Knuth-Morris-Pratt)

+ on REPL

        scala> import com.rkaneko.algorithm.search.KMP
        import com.rkaneko.algorithm.search.KMP

        scala> KMP.search("abcdeeabcdef", "abcdef")
        res0: Boolean = true

        scala> KMP.search("John F Kennedy was born on May 29 1917 .", "John F Kennedy")
        res1: Boolean = true

        scala> KMP.search("John F Kennedy was born on May 29 1917 .", "Maybe")
        res2: Boolean = false

        scala> KMP.search("I'm Bob .", "")
        res3: Boolean = true
