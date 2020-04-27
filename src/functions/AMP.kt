package functions

import java.util.*

fun main(args: Array<String>) {
    //to use an argument in main function, edit configuration on program arguments
    // then use string templates to fetch the fist element in the array(expression)
    println("Hello, ${args[0]}!")

    dayOfWeek()
    time(12.toString())
    feedTheFish()
}
fun dayOfWeek(){
    println ("What day is it today?")

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    val stringToPrint: String = when (day) {
        1 -> "Today is Sunday"
        2 -> "Today is Monday"
        3 -> "Today is Tuesday"
        4 -> "Today is Wednesday"
        5 -> "Today is Thursday"
        6 -> "Today is Friday"
        7 -> "Today is Saturday"
        else -> "Its non a day of the week"
    }

    println(stringToPrint)
}
fun time(arg: String){
//if statement in string template
    println("${if (arg[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin"}")
}
fun feedTheFish(){
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}
//returns a random day using Random library
fun randomDay(): String{
 val week = listOf("Monday","Tuesday","Wednesday","Thursday","Friday"," Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
