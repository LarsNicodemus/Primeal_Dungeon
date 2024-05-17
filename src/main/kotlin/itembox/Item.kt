package itembox

import character.villains.Villain

open class Item (var name: String){
    open fun use(villain: Villain) {}
}
//    unterschiedliche Tränke darstellen
// als Map, List oder jeden einzeln mit wert speichern.
var anzahlHeiltraenke: Int = 4
var anzahlBooster: Int = 4

fun useHealingPotion(villain: Villain) {
    if (anzahlHeiltraenke > 0) {
        villain.hp += (villain.maxHP / 2)
        anzahlHeiltraenke--
    } else println("No healing potions left.")

}

fun useBooster(villain: Villain) {
    // attackFator: Double = 1.0 (Villain)
    // villain.attackFactor = 1.2
    // in attacken *attackFactor
    anzahlBooster--
}

public fun useItems(villain: Villain, itemBox: MutableList<Item>) : Boolean{
    while (true) {
        for ((index, item) in itemBox.withIndex()){
            println("${index + 1}. ${item.name}")
        }
//        println("for: ${(itemBox[0].name)} -> Press 1")
//        println("for: ${(itemBox[1].name)} -> Press 2")
//        println("for: ${(itemBox[2].name)} -> Press 3")
//        println("for: ${(itemBox[3].name)} -> Press 4")
//        println("for: ${(itemBox[4].name)} -> Press 5")

        print("Please enter the index of the desired item (q to quit): ")
        var input: String = readln().lowercase()
        if (input == "q") {
            println("process canceled.")
            return false
        }
        try {
            var itemIndex = input.toInt()

            if (itemIndex in itemBox.indices) {
                val item = itemBox[itemIndex]
                item.use(villain)
                if (item is ConsumableItem) {
                    itemBox.removeAt(itemIndex)
                }
                return true
            } else {
                println("Invalid item index")
            }
        } catch (e:NumberFormatException) {
            println("Invalid Input. Please enter a number.")
        }
    }
}
