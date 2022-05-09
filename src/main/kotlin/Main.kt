fun main(args: Array<String>) {
    val choices = arrayOf("Paper", "Rock", "Scissor")
    val gameChoice = getGameChoice(choices)
    val userInputChoice = getUserInputChoice(choices)
    showResults(userInputChoice, gameChoice)
}


fun getGameChoice(choices: Array<String>): String {
    val randomIndex = (Math.random() * choices.size).toInt()
    return choices[randomIndex]
}

fun getUserInputChoice(choices: Array<String>): String {
    var choice = ""
    var valid = false

    while (!valid) {
        println("Please enter one of the following choices: ")
        for ((i, item) in choices.withIndex()) {
            println(" $i : $item")
        }
        val userInput = readLine()
        if (userInput != null && userInput in choices) {
            valid = true
            choice = userInput
        } else {
            println("Enter a valid choice")
        }
    }
    return choice
}

fun showResults(userInput: String, gameChoice: String) {
    val results: String = if (userInput == gameChoice) "Tie"
    else if ((userInput == "Paper" && gameChoice == "Rock") ||
        (userInput == "Scissor" && gameChoice == "Paper") ||
        (userInput == "Rock" && gameChoice == "Scissor")
    ) "You win"
    else "You lose"
    println("Your choice $userInput, I chose $gameChoice. $results")
}