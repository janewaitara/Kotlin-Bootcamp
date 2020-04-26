package functions

import java.util.*

fun main(args: Array<String>) {
    println("Hello, world!")

    dayOfWeek()
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