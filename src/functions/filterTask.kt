package functions

/*
Create a list of spices
Create a filter that gets all the curries and sorts them by string length.
Hint: After you type the dot (.),IntelliJ will give you a list of functions you can apply.
Filter the list of spices to return all the spices that start with 'c' and end in 'e'.
Do it in two different ways.
Take the first three elements of the list and return the ones that start with 'c'.
*/

fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    //filtering all words with length > 4
    val filterLength  = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(filterLength)
    //filtering the map with some predicates
    val filterLetters = spices.filter { it.startsWith('c') && it.endsWith('e') }  //or spices.filter{it.startsWith('c')}.filter{it.endsWith('e')}
    println(filterLetters)
    //filtering a list by : first three words starting with c
    val filterFirstThree = spices.take(3).filter{it.startsWith('c')}
       /*or spices.filterIndexed { index, string ->
        (index == 0 || index == 1|| index == 2) && (string.startsWith('c'))
    }*/
    println(filterFirstThree)
}