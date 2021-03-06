package functions

import java.util.*

fun main(args: Array<String>) {
    //to use an argument in main function, edit configuration on program arguments
    // then use string templates to fetch the fist element in the array(expression)

    println("Hello, ${args[0]}!")

    //dayOfWeek()
    //time(12.toString())
    feedTheFish()
    //controlFunctions()
    //eagerExample()
}

fun eagerExample() {
    //using filters
    val decoration = listOf<String>("rock", "pagoda", "plastic plant", "elementary")
    //filter as an eager
    val eager = decoration.filter { it[0] == 'p' }
    println(eager)
    //apply filter lazily
    val filtered = decoration.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    //apply map lazily
    val lazyMap = decoration.asSequence().map {
        println("map: $it")
        it
    }
    println(lazyMap)//since its lazy, it doesn't print anything
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

}

fun controlFunctions() {
    var bubbles = 0

    //cannot assign a variable to a for loop and while loop
    while (bubbles < 50) {
        bubbles++
    }
    println(bubbles)

    //repeat function for standard library
    repeat(3) {
        println("A fish is swimming")
    }


}

fun dayOfWeek() {
    println("What day is it today?")

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

fun time(arg: String) {
//if statement in string template
    println("${if (arg[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin"}")
}

fun shouldChangeWater(day: String,
                      temperature: Int = 22,
                      dirty: Int = getDirtySensorReading()): Boolean {

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun getDirtySensorReading(): Int = 20 //using a fun's return value as a default parameter of another function

//single-expression functions
fun isTooHot(temperature: Int): Boolean = temperature > 30
fun isDirty(dirty: Int): Boolean = dirty > 30
fun isSunday(day: String): Boolean = day == "Sunday"


fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day, dirty = 50)) {
        println("Change the water today")
    }

    dirtyProcessor()

}

fun fishFood(day: String): String {
//using when to return a value...unlike switch, when breaks on itself.
// whenever its not assigned to a variable, one must pass an else statement
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Saturday" -> "plankton"
        else -> "fasting"
    }

}

//returns a random day using a java library for random
//The nextInt() is used to get the next random integer value from this random number generator’s sequence.
// Here we pass the excluded boundary
fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", " Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

var dirty = 20
var waterDirty = { dirt: Int -> dirt / 2 }  //lambda with parameters
var waterFilter: (Int) -> Int = { dirt -> dirt / 2 }//kotlin function types
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int { //higher order fun -> takes a fun as an arg
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty , waterFilter )
    dirty = updateDirty(dirty, ::feedFish) //to pass a named function we use double colon ->
    // kotlin know you are not trying to call it lets you pass reference
    dirty = updateDirty(dirty) { dirty -> dirty + 50} //last parameter call syntax where the lambda can be in () or not
}