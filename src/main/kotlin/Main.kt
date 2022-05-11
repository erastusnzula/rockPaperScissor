fun main(args:Array<String>){
    val choices = arrayOf("Paper", "Scissor","Rock")
    val gameChoice = getGameChoice(choices)
    val userChoice = getUserChoice(choices)
    showResults(gameChoice, userChoice)
}

fun getGameChoice(choice: Array<String>): String{
    val randomIndex = (Math.random() * choice.size).toInt()
    return choice[randomIndex]
}


fun getUserChoice(choices: Array<String>) : String{
    var userChoice = ""
    var valid = false

    while (!valid){
        println("Enter one of the following choices : ")
        for ((i,choice) in choices.withIndex()){
            println("$i : $choice")
        }
        val userInput = readLine()
        if (userInput != null && userInput in choices){
            valid = true
            userChoice = userInput
        }
        else{
            println("Enter a valid choice.")
        }
    }
    return userChoice
}

fun showResults(gameChoice: String, userChoice: String){
    val results : String = if(userChoice==gameChoice) "Tie."
    else if ((userChoice=="Paper" && gameChoice=="Rock")||
        (userChoice=="Rock" && gameChoice=="Scissor")||
        (userChoice=="Scissor" && gameChoice=="Paper")) "You win."
    else "You lose."
    println("Your choice : $userChoice, my choice : $gameChoice, $results")
}