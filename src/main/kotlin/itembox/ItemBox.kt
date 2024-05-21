package itembox

import character.villains.Villain
import itembox.consumable.ConsumableItem
import itembox.consumable.HealingPotion
import itembox.consumable.StrengthBooster

public class ItemBox(var itemBox: MutableList<Item> = mutableListOf()) {


//    fun useHeiltrank(villain: Villain) {
//        // printlns, die bescheid sagen, was passiert
//        // hp um 50% der gesamthp heilen
//        if (anzahlHeiltraenke > 0 ) {
//            villain.hp += (villain.maxHP / 2)
//            // anzahl der heiltraenke im beutel um 1 verringern
//            anzahlHeiltraenke--
//        } // else bescheid sagen, dass traenke leer sind
//    }


/**This function let you add an item to the itembox which can be used once every round until the Box is empty. There are two options in the listOf(), a strength Booster and a Healing Potion.
 * @param itemBox is a mutable list of the class item.
 * */
    fun addItem(itemBox: MutableList<Item>) {
        println("You may add up to four Items to you Item Box, choose wisely.")
        val itemOptions = listOf(StrengthBooster(), HealingPotion())
        itemOptions.indices.forEach { index -> println("${index + 1}. ${itemOptions[index].name}") }
        while (itemBox.size < 4) {
            print("Please enter the index of the item you want to add: ")
            var input: String = readln().lowercase()
            try {
                val itemIndex = input.toInt()
                if (itemIndex in 1..itemOptions.size) {
                    val item = itemOptions[itemIndex - 1]
                    itemBox.add(item)
                    println("${item.name} added to your Item Box.")
                } else {
                    println("Invalid item index")
                }
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number.")
            }
        }
        println("Your Item Box contains: ")
        itemBox.indices.forEach { index -> println("Nr.${index + 1}. ${itemBox[index].name}") }
    }

/**This function let you use an item from the itembox on a villain. if The item is a consumable it will be deleted from the list.
 * @param villain for the Class Villain, the item is used on this person.
 * @param itemBox  is a mutable list of the class item.
 * @return Boolean return false if the process is canceled and the user pressed q, return true if the user chose and used a valid item.
 *
 * */
    fun useItem(villain: Villain, itemBox: MutableList<Item>): Boolean {
        itemBox.indices.forEach { index -> println("${index + 1}. ${itemBox[index].name}") }
        while (true) {
            print("Please enter the index of the desired item (q to quit): ")
            val input: String = readln().lowercase()
            if (input == "q") {
                println("process canceled.")
                return false
            }
            try {
                val itemIndex = input.toInt()

                if (itemIndex in 1..itemBox.size) {
                    val item = itemBox[itemIndex - 1]
                    item.use(villain)
                    if (item is ConsumableItem) {
                        itemBox.removeAt(itemIndex - 1)
                    }
                    return true
                } else {
                    println("Invalid item index")
                }
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number. (q to quit)")
            }
        }
    }

}
