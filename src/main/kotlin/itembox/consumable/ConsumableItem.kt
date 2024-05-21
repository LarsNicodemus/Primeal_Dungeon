package itembox.consumable

import character.villains.Villain
import itembox.Item
import utils.roundDouble

open class ConsumableItem(name : String) : Item(name){
    override fun use(villain: Villain) {
        println("Item was consumed.")
    }
}

//class ManaPotion(name : String) : ConsumableItem(name){
//    override fun use(villain: Villain){
//        villain.mp += (villain.maxMP / 2)
//        println("${villain.name} drinks a mana potion and restores ${roundDouble(villain.maxMP/2)} mana points. Actual mana points: ${roundDouble(villain.mp)} ")
//    }
//}


//class DarknessBomb(name : String): ConsumableItem(name){
//    override fun use (villain: Villain){
//        villain.shield = 1
//        println("${villain.name} throws a darkness bomb, he can't be seen and evades the next attack")
//    }
//}