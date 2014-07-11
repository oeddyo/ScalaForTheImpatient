object Chapter06 extends App {
    // 01

    object Conversions {
        def inchesToCentimeters(inch: Double) = {
            3.3  // pretending convert
        }
    }
    println(Conversions.inchesToCentimeters(5.5))



    // 02
     class UnitConversion(val factor: Double) {
        def convert( value: Double): Double =  factor*value
    }

    object InchesToCentimeters extends UnitConversion(2.2)
    println(InchesToCentimeters.convert(3.4))


    // 03


    // 04
    
    class Point private (val x: Double, val y: Double){ 
   
    }
    
    object Point {
        def apply(x: Double, y: Double){
            new Point(x, y)
        }
    }

    println(Point(0.3, 0.1))



    // 05
    
    println(args.toList.reverse)


    // 06
    
    
}
