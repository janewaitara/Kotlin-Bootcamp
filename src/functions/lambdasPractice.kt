package functions
/*
* Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
Create a new variable, rollDice2, for this same lambda using the function type notation.*/

/*Why would you want to use the function type notation instead of just the lambda?
Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
Pass your rollDice2 function as an argument to gamePlay()
to generate a dice roll every time gamePlay() is called.*/
import java.util.*

//var rollDice ={(1..12).random() }
val rollDice =  {Random().nextInt(12) +1}
var rollDiceA ={sides: Int -> Random().nextInt(12) +1 }
/*Function type notation is more readable, which reduces errors,
 clearly showing the what type is passed in and what type is returned.*/
var rollDiceB ={sides: Int ->
    if (sides == 0) 0
   else  Random().nextInt(12) +1 }
val rollDice2 : (Int) -> Int = {sides ->
    if (sides == 0) 0
    else  Random().nextInt(12) +1 }

fun gamePlay(rollDice: Int){
    println(rollDice)
}

fun main() {
    println(rollDice())
    println(rollDiceA(2))
    println(rollDiceB(3))
    println(rollDice2(0))

    gamePlay(rollDice2(0))
}