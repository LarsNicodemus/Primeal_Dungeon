package itembox.consumable

import character.villains.Villain
import itembox.Item
import utils.roundDouble

open class ConsumableItem(name : String) : Item(name){
    override fun use(villain: Villain) {
        println("Item was consumed.")
    }
}