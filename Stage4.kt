const val CUP_PER_COFFEE = 1

const val WATER_PER_ESPRESSO = 250
const val COFFEE_PER_ESPRESSO = 16
const val COST_PER_ESPRESSO = 4

const val WATER_PER_LATTE = 350
const val MILK_PER_LATTE = 75
const val COFFEE_PER_LATTE = 20
const val COST_PER_LATTE = 7

const val WATER_PER_CAPPUCCINO = 200
const val MILK_PER_CAPPUCCINO = 100
const val COFFEE_PER_CAPPUCCINO = 12
const val COST_PER_CAPPUCCINO = 6

class CoffeeMachine { 
    var water = 400
        private set
    var milk = 540
        private set
    var coffee = 120
        private set    
    var cups = 9
        private set 
    var money = 550
        private set 
        
    fun buyEspresso() {
        water -= WATER_PER_ESPRESSO
        coffee -= COFFEE_PER_ESPRESSO
        cups -= CUP_PER_COFFEE
        money += COST_PER_ESPRESSO  
    }
    
    fun buyLatte() {
        water -= WATER_PER_LATTE
        milk -= MILK_PER_LATTE
        coffee -= COFFEE_PER_LATTE
        cups -= CUP_PER_COFFEE
        money += COST_PER_LATTE
    }
    
    fun buyCappuccino() {
        water -= WATER_PER_CAPPUCCINO
        milk -= MILK_PER_CAPPUCCINO
        coffee -= COFFEE_PER_CAPPUCCINO
        cups -= CUP_PER_COFFEE
        money += COST_PER_CAPPUCCINO
    }
    
    fun fillWater(amount: Int) {
        water += amount
    }
    
    fun fillMilk(amount: Int) {
        milk += amount
    }
    
    fun fillCoffee(amount: Int) {
        coffee += amount
    }
    
    fun fillCups(amount: Int) {
        cups += amount
    }
    
    fun takeMoney() {
        println("I gave you \$$money")
        money = 0
    }
    
    fun printState() {
        val state =
            """
                The coffee machine has:
                $water ml of water
                $milk ml of milk
                $coffee g of coffee beans
                $cups disposable cups
                $money of money
            """.trimIndent()
        println(state)
    }
    
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.printState()
    println() 
    
    print("Write action (buy, fill, take): > ")
    val action = readln()
    println()
    
    when (action) {
        "buy" -> {
            print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: > ")
            val buyOption = readln().toInt()
            when (buyOption) {
                1 -> coffeeMachine.buyEspresso()
                2 -> coffeeMachine.buyLatte()
                3 -> coffeeMachine.buyCappuccino()
            }
            println()
            coffeeMachine.printState()
        }
        "fill" -> {
            print("Write how many ml of water do you want to add: > ")
            val waterAmount = readln().toInt()
            coffeeMachine.fillWater(waterAmount)
            println()
            print("Write how many ml of milk do you want to add: > ")
            val milkAmount = readln().toInt()
            coffeeMachine.fillMilk(milkAmount)
            println()
            print("Write how many grams of coffee beans do you want to add: > ")
            val coffeeAmount = readln().toInt()
            coffeeMachine.fillCoffee(coffeeAmount)
            println()
            print("Write how many disposable cups of coffee do you want to add: > ")
            val cupsAmount = readln().toInt()
            coffeeMachine.fillCups(cupsAmount)
            println()
            coffeeMachine.printState()
        }
        "take" -> {
            coffeeMachine.takeMoney()
            println()
            coffeeMachine.printState()
        } 
    }
}