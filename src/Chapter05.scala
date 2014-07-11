import java.util.TimeZone.getAvailableIDs;

object Chapter05{
    def main(args: Array[String]){
        
        // 01
        class Counter {
            private var value = BigInt(0)
            def increment() { value += 1L}
            def current = value
        }

        val counter = new Counter()
        var cnt = BigInt(23000L) // Increase this to test for larger numbers
        while(cnt>=0){
            counter.increment()
            cnt -= 1
        }
        println("final counter = " + counter.current)
    

        // 02

        class BankAccount (private var balance: Int){
            def deposit(v: Int) = {
                balance = v + balance;
            }

            def withdraw(v: Int){
                if(balance > v){
                    balance = balance - v
                }
            }

            def currentBalance = balance
        }


        val myAccount = new BankAccount(105)
        println("initially I have " + myAccount.currentBalance + " dollars in my bank")
        println("depositing 100")
        myAccount.deposit(100)

        println("Now I have " + myAccount.currentBalance)

        println("withdraw 100")
        myAccount.withdraw(100)
        println("Now left " + myAccount.currentBalance)


        // 03 04
        
        class Time (val hrs: Int, val min: Int){
            
            val internalMiniutes = min + hrs*60

            
            def before(other: Time) : Boolean = {
                if (hrs < other.hrs){
                    true
                } else if (hrs > other.hrs){
                    false
                } else{
                    if(min < other.min){
                        true
                    } else{
                        false
                    }
                }
            }

            def before2(other: Time): Boolean = {
                if(internalMiniutes < other.internalMiniutes){
                    true
                } else{
                    false
                }
            }
        }

        val currentTime = new Time(5, 11)
        
        if(!currentTime.before2(new Time(2, 11))){
            println("No! Current time is after the parameter time")
        }

        if(currentTime.before(new Time(8, 11))){
            println("Yes! Current time is before the parameter time")
        }


        // 05
        
        class Student {

        }


        // 06

        class Person (var age: Int, var name: String){
            age = math.max(age, 0)
        }

        val person = new Person(-100, "Eddie")

        println("Age of the person after correction :"+ person.age)





        // 07
        class Person2 (val fullname: String){
            val splittedName = fullname.split(" ")
            val firstName = splittedName(0)
            val lastName = splittedName(1)
        }

        val person2 = new Person2("james bond")
        println(person2.firstName + "+" + person2.lastName)
    }
}
