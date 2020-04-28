package functions
/*
from activityOnVariousParameters
* Create a program that suggests an
* activity based on various parameters.*/
//add single-expression function

fun main() {
    println(whatShouldIDoToday2(getMood(), "Sunny"))
    println(whatShouldIDoToday2("happy", "sunny"))
    println(whatShouldIDoToday2("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday2(readLine()!!))

}

fun whatShouldIDoToday2(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"


fun getMood(): String {
    println("Please enter your current mood")
    val mood: String = readLine()!!
    return mood
}
