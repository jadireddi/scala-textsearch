Scala text search algorithm
================

### description
Text search algorithm implemented with Scala . I wrote this code to study Scala lang .

Samples
---

KMP (Knuth-Morris-Pratt)

+ on sbt console 

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


BM (Boyer-Moore)

+ on sbt console

        scala> import com.rkaneko.algorithm.search.BM
        import com.rkaneko.algorithm.search.BM

        scala> val text = "djfkjalkgjsabcd"
        text: String = djfkjalkgjsabcd

        scala> val pattern = "abcd"
        pattern: String = abcd

        scala> implicit val isDebug = true
        isDebug: Boolean = true

        scala> BM.search(text, pattern)
        k equals d ?
        k equals d ?
        a equals d ?
        d equals d ?
        c equals c ?
        b equals b ?
        a equals a ?
        found abcd from text(11) !
        res0: Boolean = true
