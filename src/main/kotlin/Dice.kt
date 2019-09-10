import java.util.concurrent.ThreadLocalRandom

class Dice {

    //values that define dice pits

}

enum class State{
    WON, LOST, PLAYING, FIRST
}

enum class Score {
    POINT
}


fun main() {
    val redDie = Dice()
    val blackDie = Dice()
    var point = 0
    var state = State.FIRST

    //arrays of wins and loses for the first roll
    val loses: IntArray = intArrayOf(2,3,12)
    val wins: IntArray = intArrayOf(7,11)


    //function that takes in two dice objects and returns the sums of their values
    fun doRoll(): Int {
        var die = ThreadLocalRandom.current().nextInt(1, 6)
        var die2 = ThreadLocalRandom.current().nextInt(1,6)
        return die + die2

    }


    fun playGame(){


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
               println ("Keep rolling...")
           }
         }

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
                    else -> println("re-rolling")
                }
            }



        }
    }

    playGame()




}