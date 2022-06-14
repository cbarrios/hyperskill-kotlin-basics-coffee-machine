const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val COFFEE_PER_CUP = 15

fun main() {
    print("Write how many ml of water the coffee machine has: > ")
    val water = readln().toInt()
    println()
    print("Write how many ml of milk the coffee machine has: > ")
    val milk = readln().toInt()
    println()
    print("Write how many grams of coffee beans the coffee machine has: > ")
    val coffee = readln().toInt()
    println()
    print("Write how many cups of coffee you will need: > ")
    val cups = readln().toInt()
    
    val waterLeft = water / WATER_PER_CUP
    val milkLeft = milk / MILK_PER_CUP
    val coffeeLeft = coffee / COFFEE_PER_CUP
    
    var min = if (waterLeft < milkLeft) waterLeft else milkLeft
    min = if (min < coffeeLeft) min else coffeeLeft
    
    if (cups > min) {
        println("No, I can make only $min cups of coffee")
    } else {
        if (cups < min) {
            val diff = min - cups
            println("Yes, I can make that amount of coffee (and even $diff more than that)")
        } else {
            println("Yes, I can make that amount of coffee")
        }
    }
}