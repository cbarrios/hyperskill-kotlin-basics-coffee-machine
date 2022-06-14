const val WATER = 200
const val MILK = 50
const val COFFEE = 15

fun main() {
    print("Write how many cups of coffee you will need: > ")
    val cups = readln().toInt()
    
    val waterTotal = cups * WATER
    val milkTotal = cups * MILK
    val coffeeTotal = cups * COFFEE
    
    println("For $cups cups of coffee you will need:")
    println("$waterTotal ml of water")
    println("$milkTotal ml of milk")
    println("$coffeeTotal g of coffee beans")
}