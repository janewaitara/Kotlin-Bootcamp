//Practice Time
/*
*from fortuneCookie
The getFortune() function should really only be getting the fortune,
and not be in the business of getting the birthday.
Instead of calculating the fortune based on the birthday,
 use a when statement to assign some fortunes as follows (or use your own conditions):
If the birthday is 28 or 31...
If the birthday is in the first week…
else … return the calculated fortune as before.*/

package functions

fun main(args: Array<String>) {
    // print("Your Fortune is ${getFortuneCookie()}")

    var fortune: String
    for (i in 1..10) {
        fortune = getFortuneCookie2(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }
}
fun getBirthday(): Int{
    print("Enter your birthday:")

    val birthday: Int = readLine()?.toIntOrNull() ?: 1
    return birthday

}

fun getFortuneCookie2(birthday: Int): String {

    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")


    /*val birthday: Int = readLine()?.toIntOrNull() ?: 1
    val index =  birthday.rem(fortune.size) // birthday % fortune.size*/
    val index = when (birthday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[index]
}

