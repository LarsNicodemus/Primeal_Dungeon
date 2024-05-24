package itembox

import character.villains.Villain
import itembox.consumable.ConsumableItem
import itembox.consumable.HealingPotion
import itembox.consumable.StrengthBooster

public class ItemBox(var name: String = "Item Box", var itemBox: MutableList<Item> = mutableListOf()) {
val arsenal: Set <Item> = setOf(StrengthBooster(),HealingPotion(),StrengthBooster(),HealingPotion(),StrengthBooster(),HealingPotion())

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
                    println("Invalid item index. Please enter a number between 1 and ${itemOptions.size}.")
                }
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number between 1 and ${itemOptions.size}.")
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
    open fun useItem(villain: Villain, itemBox: MutableList<Item>): Boolean {
        itemBox.indices.forEach { index -> println("${index + 1}. ${itemBox[index].name}") }
//        itemBox.forEach { item, count ->
//            repeat(count) {
//                println("[${itemBox.keys.indices}]$count x ${item.name}")
//            }
//        }
//    val itemList = mutableListOf<String>()
//    itemBox.forEach { item ->
//        repeat(itemBox.count { it == item }) {
//            itemList.add(item.name)
//        }
//    }
//    itemList.forEach { println(it) }
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
                    println("Invalid item index. Please enter a number between 1 and ${itemBox.size}.")
                }
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number between 1 and ${itemBox.size}. (q to quit)")
            }
        }
    }

}
