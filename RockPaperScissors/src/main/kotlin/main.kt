/*********************************************************
 *                                                       *
 * Kotlin Rock-Paper-Scissors Program that implement OOP *
 *                                                       *
 *          For 2nd GDSC Mobile Path Assignment          *
 *                                                       *
 *                Grant Gabriel Tambunan                 *
 *                                                       *
 ********************************************************/

import java.util.*

interface Game
{
    fun play()
}

class RockPaperScissors(private val playerOneName: String, private val playerTwoName: String) : Game
{
    private var playerOneChoice = "" // To hold User choices
    private var playerTwoChoice = "" // To hold Computer choices
    private var playerOneScore = 0   // A variabel that can indicates User score
    private var playerTwoScore = 0   // A variabel that can indicates Computer score

    init
    {
        println("Welcome to Rock-Paper-Scissors!")
        println("$playerOneName vs $playerTwoName")
    }

    override fun play()
    {
        while (true) // While the User still want to play
        {
            println("Enter your choice, $playerOneName (Rock, Paper, Scissors):")
            playerOneChoice = readLine()!!.toLowerCase() // To lowercase in order to simplify and shorten the case
            if (playerOneChoice == "rock" || playerOneChoice == "paper" || playerOneChoice == "scissors")
            {
                break
            }
            else
            {
                println("Invalid choice, please try again.")
            }
        }

        val choices = arrayOf("rock", "paper", "scissors")         // This is the choices for the computer to pick
        playerTwoChoice = choices[Random().nextInt(choices.size)]  // This line is used to make a random choice among rock-paper-scissors
        println("$playerTwoName chooses $playerTwoChoice.")

        when
        {
            playerOneChoice == playerTwoChoice ->  // The case when the User and Computer pick the same object
            {
                println("It's a tie!")
            }
            playerOneChoice == "rock" && playerTwoChoice == "scissors" ||
                    playerOneChoice == "paper" && playerTwoChoice == "rock" ||
                    playerOneChoice == "scissors" && playerTwoChoice == "paper" -> // The case when the User wins against the Computer
            {
                println("$playerOneName wins!")
                playerOneScore++                    // User score increase by 1
            }
            else ->
            {
                println("$playerTwoName wins!")
                playerTwoScore++                    // User score increase by 1
            }
        }

        println("$playerOneName: $playerOneScore, $playerTwoName: $playerTwoScore") // Show the scores
    }
}

fun main()
{
    /* This section is used to create account registration */

    println("Register a new account:")
    print("Enter your name: ")
    val playerName = readLine()!!
    print("Enter your password: ")
    val playerPassword = readLine()!!

    val registeredUsers = mutableMapOf(playerName to playerPassword)
    println("Account registered successfully.")

    /* This section is used for users to login */

    println("Login to your account:")
    print("Enter your name: ")
    val loginName = readLine()!!
    print("Enter your password: ")
    val loginPassword = readLine()!!

    if (registeredUsers[loginName] == loginPassword) // To check if the password and fot rhe userName is correct
    {
        println("Login successful.")
        val game = RockPaperScissors(loginName, "Computer") // Send the parameter needed for the game, while creating an "Object" called "game"
        while (true)
        {
            game.play()                                   // Calls the "play" function from the "game" object that inherits from the RockPaperScissors class
            println("Play again? Press any key to continue, press (N) to exit.")
            val playAgain = readLine()!!.toLowerCase()
            if (playAgain == "n")                         // To check if the user still want to play or not.
            {
                break
            }
        }
        println("Thanks for playing!")
    }
    else
    {
        println("Login failed. Incorrect username or password.")
    }
}
