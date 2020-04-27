package functions

//Create a function that checks if we can add another
// fish into a tank that already has fish in it.

/*tankSize (in gallons)
currentFish (a list of Ints representing the length of each fish currently in the tank)
fishSize (the length of the new fish we want to add to the tank)
hasDecorations (true if the the tank has decorations, false if not)*/

fun canAddFish(tankSize: Double,
               currentFish: List<Int>,
               fishSize: Int = 2,
               hasDecorations: Boolean = true): Boolean {


    //A really handy way to multiply all
    // values of an Iterable or range is to use reduce:
    // The accumulator is initially the first value of the range.
    // This will be multiplied/added with the next element and becomes the accumulator for the next run.
    var totalLengthOfFish = currentFish.reduce { accumulator, element ->
        accumulator + element
    }

    if (hasDecorations == true) {
        if (totalLengthOfFish + fishSize <= (tankSize * 80 / 100))
            return true
        else return false

    } else {
        return totalLengthOfFish + fishSize <= tankSize
    }

}
//another solution
/*fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}*/
fun main() {
    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    //println(canAddFish(10.0, listOf(), 7, true))
}