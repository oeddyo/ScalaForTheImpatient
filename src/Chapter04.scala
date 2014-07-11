import scala.collection.mutable.{Map => MMap}
import scala.collection.immutable.{Map => IMap}
import scala.collection.immutable.{SortedMap => SMap}

import scala.math._
import scala.collection.JavaConversions.mapAsScalaMap;


object Chapter04{
    def main(args: Array[String]){

        // 01
        println("01\n\n")
        val prices = MMap[String, Int]("A"->10, "B"->20, "C"->30);
        val discountPrices = for((k, v) <- prices) yield (k, v*0.9)
        println("Original prices:")
        println(prices)
        println("10% discount")
        println(discountPrices)


        // 02
        println("02\n\n")
        var in = new java.util.Scanner(new java.io.File("myfile.txt"))
        var wordCounter = MMap[String, Int]()
        while (in.hasNext()){
            val word = in.next
            wordCounter(word) = wordCounter.getOrElse(word, 0) + 1
            
        }
        println("Count map = " + wordCounter)


        // 03
        println("03\n\n")
        in = new java.util.Scanner(new java.io.File("myfile.txt"))
        var wordCounterImmutable = IMap[String, Int]()

        while(in.hasNext()){
            val word = in.next
            wordCounterImmutable = wordCounterImmutable + (word -> (wordCounterImmutable.getOrElse(word, 0)+1))
        }
        println(wordCounterImmutable)


        // 04
        println("04 sorted map \n\n")
        var wordCountSortedMap = SMap[String, Int]()
        
        in = new java.util.Scanner(new java.io.File("myfile.txt"))
        while(in.hasNext()){
            val word = in.next
            wordCountSortedMap = wordCountSortedMap + (word -> (wordCountSortedMap.getOrElse(word, 0)+1))
        }
        println(wordCountSortedMap)
        

        // 05
        var treeMapCount : scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
        in = new java.util.Scanner(new java.io.File("myfile.txt"))
        while(in.hasNext()){
            val word = in.next
            treeMapCount = treeMapCount + (word -> (treeMapCount.getOrElse(word, 0)+1))
        }
        println(treeMapCount)

        // 06
        var linkedCount = scala.collection.mutable.LinkedHashMap[String, Int]()
        println(java.util.Calendar.MONDAY.getClass().getName())
        
        linkedCount += ("Monday" -> java.util.Calendar.MONDAY)
        linkedCount += ("Tuesday" -> java.util.Calendar.TUESDAY)
        linkedCount += ("Wednesday" -> java.util.Calendar.WEDNESDAY)

        for((k,v) <- linkedCount){
            println((k + v))
        }

    
        // 07


        // 08

        def minmax(values: Array[Int]) : (Int, Int)= {
            if(values.length<=1){
                (values.head, values.head)
            } else{
                var tmp = minmax(values.drop(1)) 
                (max(tmp._1, values.head), min(tmp._2, values.head))
            }
        }

        val input08 = Array[Int](1, 2, 3, 7)
        println(minmax(input08))
        

        // 09
        println("09 \n\n")
        val input09 = Array[Int](1, 2, 3, 10)
        implicit def bool2int(b: Boolean) = if(b) 1 else 0

        def lteqgt(values: Array[Int], v: Int) : (Int, Int, Int) = {
            if(values.length==0){
                (0, 0, 0)
            } else{
                val tmp = lteqgt(values.drop(1), v)
                (bool2int(values.head<v) + tmp._1, bool2int(values.head==v) + tmp._2, bool2int(values.head>v) + tmp._3)
            }
        }

        println(lteqgt(input09, 3))

        // 10
        println("10 \n\n")
        println("Hello".zip("World"))


        
    }
}
