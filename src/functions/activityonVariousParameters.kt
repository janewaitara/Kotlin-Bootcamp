package functions
/*
* Create a program that suggests an
* activity based on various parameters.*/

fun main() {
    println(whatShouldIDoToday("sad"))
}

fun whatShouldIDoToday(mood: String,
                       weather: String = "sunny",
                       temperature: Int = 24): String {

   return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}
