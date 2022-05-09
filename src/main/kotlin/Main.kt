import java.util.*

fun main(args: Array<String>){
    val options = arrayOf("Rock", "Paper", "Scissor")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserGameChoice(options)
    printResults(userChoice, gameChoice)

}

fun getGameChoice(optionsParam: Array<String>): String {
    return optionsParam[(Math.random() * optionsParam.size).toInt()]
}

fun getUserGameChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice){
        println("Please enter one of the following: ")
        for (item in optionsParam) print(" $item")
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } in optionsParam ){
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice")
    }
    return userChoice
}

fun printResults(userChoice:String, gameChoice:String){
    val result : String = if (userChoice.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } == gameChoice) "Tie"
    else if ((userChoice.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } =="Rock" && gameChoice=="Scissor") ||
        (userChoice.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } == "Scissor" && gameChoice == "Paper")||
        (userChoice.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } == "Paper" && gameChoice == "Rock")) "You win"
    else "You lose"
    println("You chose ${userChoice.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}, I chose $gameChoice. $result")
}