class CoffeeMachine(
    private var water: Int,
    private var milk: Int,
    private var beans: Int,
    private var cups: Int,
    private var money: Int
) {
    private var exit: Boolean = false

    fun action() {
        while (!exit) {
            println("Enter your choice (buy, fill, take, check, exit): ")
            when (readLine().toString()) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "check" -> check()
                "exit" -> exit = true
            }
        }

    }

    private fun check() {
        println("The coffee machine has: ")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$beans g of beans")
        println("$cups of disposal cups")
        println("$money of money")
    }

    private fun take() {
        println("I give you $$money")
        money = 0
    }

    private fun buy() {
        println("What do you want? 1-Espresso, 2-Latte, 3-Cappuccino, back-to menu : ")
        when (readLine().toString()) {
            "1" -> makeEspresso()
            "2" -> makeLatte()
            "3" -> makeCappuccino()
            "back" -> return
        }
    }

    private fun makeEspresso() {
        val espWater: Boolean = water - 250 >= 0
        val espBeans: Boolean = beans - 16 >= 0
        val espCups: Boolean = cups - 1 >= 0
        if (espWater && espBeans && espCups) {
            println("I have enough resources, making you a coffee!")
            water -= 250
            beans -= 16
            cups -= 1
            money += 4
        } else if (!espWater) {
            println("Sorry, not enough water for espresso!")
        } else if (!espBeans) {
            println("Sorry, not enough coffee beans for espresso!")
        } else {
            println("Sorry, not enough disposable cup!")
        }
    }

    private fun makeLatte() {
        val latWater: Boolean = water - 350 >= 0
        val latMilk: Boolean = milk - 75 >= 0
        val latBeans: Boolean = beans - 20 >= 0
        val latCups: Boolean = cups - 1 >= 0
        if (latWater && latMilk && latBeans && latCups) {
            println("I have enough resources, making you a coffee!")
            water -= 350
            milk -= 75
            beans -= 20
            cups--
            money += 7
        } else if (!latWater) {
            println("Sorry, not enough water for latte!")
        } else if (!latMilk) {
            println("Sorry, not enough milk for latte!")
        } else if (!latBeans) {
            println("Sorry, not enough coffee beans for latte!")
        } else {
            println("Sorry, not enough disposable cup!")
        }
    }

    private fun makeCappuccino() {
        val capWater: Boolean = water - 200 >= 0
        val capMilk: Boolean = milk - 100 >= 0
        val capBeans: Boolean = beans - 12 >= 0
        val capCups: Boolean = cups - 1 >= 0
        if (capWater && capMilk && capBeans && capCups) {
            println("I have enough resources, making you a coffee!")
            water -= 200
            milk -= 100
            beans -= 12
            cups -= 1
            money += 6
        } else if (!capWater) {
            println("Sorry, not enough water for cappuccino!")
        } else if (!capMilk) {
            println("Sorry, not enough milk for cappuccino!")
        } else if (!capBeans) {
            println("Sorry, not enough coffee beans for cappuccino!")
        } else {
            println("Sorry, not enough disposable cup")
        }
    }

    private fun fill() {
        println("Write how many ml of water do you want to add: ")
        val addedWater: Int = readLine()!!.toInt()
        println("Write how many ml of milk do you want to add: ")
        val addedMilk: Int = readLine()!!.toInt()
        println("Write how many grams of coffee beans do you want to add: ")
        val addedBeans: Int = readLine()!!.toInt()
        println("Write how many disposable cups of coffee do you want to add: ")
        val addedCups: Int = readLine()!!.toInt()
        water += addedWater
        milk += addedMilk
        beans += addedBeans
        cups += addedCups
    }
}

fun main() {
    val myMachine = CoffeeMachine(500, 200, 100, 10, 500)
    myMachine.action()
}