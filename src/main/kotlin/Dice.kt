import java.util.concurrent.ThreadLocalRandom

//enum class storing game state constants
enum class State{
    WON, LOST, PLAYING, FIRST
}


fun main() {
    //point and game-state variables
    var point = 0
    var state = State.FIRST
    //function that takes in two dice objects and returns the sums of their values
    fun doRoll(): Int {
        return ThreadLocalRandom.current().nextInt(1, 6) + ThreadLocalRandom.current().nextInt(1, 6)
    }


    fun playGame(){
        //while loop for the first round of the game
        while(state == State.FIRST){
            var roll = doRoll()
            println("You rolled a $roll")

         when (roll){
           2,3,12 -> {
               println("You lose!")
               state = State.LOST
           }
           7,11 -> {
               println("You win!")
               state = State.WON
           }
           else -> {
               state = State.PLAYING
               point = roll
               println ("Point is $point. Keep rolling...")
           }
         }
        }
        //while loop the rest of the game
        while (state == State.PLAYING){
                var newRoll = doRoll()
                println("You shot a $newRoll")

                when (newRoll) {
                    point -> {
                        println("You win!")
                        state = State.WON
                    }
                    7 -> {
                        println("You lose!")
                        state = State.LOST
                    }
                    else -> println("Point is $point. Re-rolling...")
                }
            }

    }
    playGame()
}