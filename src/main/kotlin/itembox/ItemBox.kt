package itembox

import character.villains.Villain

public class ItemBox {
    open var itemBox: MutableList<Item> = mutableListOf()

    fun useHeiltrank(villain: Villain) {
        // printlns, die bescheid sagen, was passiert
        // hp um 50% der gesamthp heilen
        if (anzahlHeiltraenke > 0 ) {
            villain.hp += (villain.maxHP / 2)
            // anzahl der heiltraenke im beutel um 1 verringern
            anzahlHeiltraenke--
        } // else bescheid sagen, dass traenke leer sind
    }

    open fun addItem(item: Item){
        itemBox.add(item)
    }

    public fun useItems(villain: Villain) : Boolean{
        while (true) {
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

    fun getItems():List<Item>{
        return itemBox.toList()
    }


}
