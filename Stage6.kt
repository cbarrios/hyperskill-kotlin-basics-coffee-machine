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

enum class State {
    ASK, BUY, FILL
}

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
    var state = State.ASK
        private set
        
    private var fillCounter = 1
    
    fun onEvent(input: String) {
        when (state) {
            State.ASK -> {
                when (input) {
                    "buy" -> state = State.BUY
                    "fill" -> {
                        state = State.FILL
                        fillCounter = 1
                    }
                    "take" -> {
                        takeMoney()
                        println()
                    }
                    "remaining" -> {
                        printState()
                        println()
                    }
                }
            }
            State.BUY -> {
                when (input) {
                    "1" -> buyEspresso()
                    "2" -> buyLatte()
                    "3" -> buyCappuccino()
                }
                state = State.ASK
            }
            State.FILL -> {
                val amount = input.toInt()
                when (fillCounter) {
                    1 -> fillWater(amount)
                    2 -> fillMilk(amount)                 
                    3 -> fillCoffee(amount)              
                    4 -> {
                        fillCups(amount)
                        state = State.ASK
                    }
                }
                fillCounter++
            } 
        }
    }
        
    fun buyEspresso() {
        if (water < WATER_PER_ESPRESSO) {
            println("Sorry, not enough water!")
            return
        }
        if (coffee < COFFEE_PER_ESPRESSO) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (cups < CUP_PER_COFFEE) {
            println("Sorry, not enough disposable cups!")
            return
        }
        water -= WATER_PER_ESPRESSO
        coffee -= COFFEE_PER_ESPRESSO
        cups -= CUP_PER_COFFEE
        money += COST_PER_ESPRESSO
        println("I have enough resources, making you a coffee!")  
    }
    
    fun buyLatte() {
        if (water < WATER_PER_LATTE) {
            println("Sorry, not enough water!")
            return
        }
        if (milk < MILK_PER_LATTE) {
            println("Sorry, not enough milk!")
            return
        }
        if (coffee < COFFEE_PER_LATTE) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (cups < CUP_PER_COFFEE) {
            println("Sorry, not enough disposable cups!")
            return
        }
        water -= WATER_PER_LATTE
        milk -= MILK_PER_LATTE
        coffee -= COFFEE_PER_LATTE
        cups -= CUP_PER_COFFEE
        money += COST_PER_LATTE
        println("I have enough resources, making you a coffee!")  
    }
    
    fun buyCappuccino() {
        if (water < WATER_PER_CAPPUCCINO) {
            println("Sorry, not enough water!")
            return
        }
        if (milk < MILK_PER_CAPPUCCINO) {
            println("Sorry, not enough milk!")
            return
        }
        if (coffee < COFFEE_PER_CAPPUCCINO) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (cups < CUP_PER_COFFEE) {
            println("Sorry, not enough disposable cups!")
            return
        }
        water -= WATER_PER_CAPPUCCINO
        milk -= MILK_PER_CAPPUCCINO
        coffee -= COFFEE_PER_CAPPUCCINO
        cups -= CUP_PER_COFFEE
        money += COST_PER_CAPPUCCINO
        println("I have enough resources, making you a coffee!")  
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
    
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): > ")
        val action = readln()
        coffeeMachine.onEvent(action)
        println()
        when (action) {
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")
                val buyOption = readln()
                coffeeMachine.onEvent(buyOption)
                println()
            }
            "fill" -> {
                print("Write how many ml of water do you want to add: > ")
                val waterAmount = readln()
                coffeeMachine.onEvent(waterAmount)
                println()
                print("Write how many ml of milk do you want to add: > ")
                val milkAmount = readln()
                coffeeMachine.onEvent(milkAmount)
                println()
                print("Write how many grams of coffee beans do you want to add: > ")
                val coffeeAmount = readln()
                coffeeMachine.onEvent(coffeeAmount)
                println()
                print("Write how many disposable cups of coffee do you want to add: > ")
                val cupsAmount = readln()
                coffeeMachine.onEvent(cupsAmount)
                println()
            }
            "exit" -> break
        }
    }
}