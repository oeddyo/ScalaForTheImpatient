import java.util.TimeZone.getAvailableIDs;

object Chapter03{
    def main(args: Array[String]){
        
        // 07 remove duplicate

        val input07 = Array(1,2,3,1,2,5)
        def removeDup(input: Array[Int]) : Array[Int] = {
            if(input.length<=1){
                input
            }else{
                if(input.dropRight(1).contains(input.last)){
                    removeDup(input.dropRight(1))
                }else{
                    removeDup(input.dropRight(1)) ++ Array(input.last)
                }
            }
        }
        println("07:")
        println(removeDup(input07).toList)
        println(input07.distinct.toList)

    
        

        // 08 

        
        // 09

        val tzList = getAvailableIDs().toList
        val tzListTrim = for(tz <- tzList ) yield {tz.replaceFirst("America", "")} 
        println(tzListTrim)
        

        // 10 

    }
}
