package functions

//Practice Time
/**from fortuneCookie2
Change your fortune cookie program to use repeat()
instead of a for loop. What happens to the break instruction?
Using the error message from the compiler,
with what you've learned so far, can you think of why?*/





fun main(args: Array<String>) {
    // print("Your Fortune is ${getFortuneCookie()}")

    var fortune: String = ""
    for (i in 1..10) {
        fortune = getFortuneCookie3(getBirthday2())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }
    //using repeat function in loops
    repeat (10) {
        fortune = getFortuneCookie3(getBirthday2())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) {

        }
    }

    //using while loop
    while (!fortune.contains("Take it easy")) {
        fortune = getFortuneCookie3(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}
fun getBirthday2(): Int{
    print("Enter your birthday:")

    val birthday: Int = readLine()?.toIntOrNull() ?: 1
    return birthday

}

fun getFortuneCookie3(birthday: Int): String {

    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")


/*val birthday: Int = readLine()?.toIntOrNull() ?: 1
    val index =  birthday.rem(fortune.size) // birthday % fortune.size //rem() used to find the reminder of a division */

    val index = when (birthday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[index]
}

