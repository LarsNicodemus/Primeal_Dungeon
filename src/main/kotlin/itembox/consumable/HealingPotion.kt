package itembox.consumable

import character.villains.Villain
import utils.roundDouble

class HealingPotion(name : String = "Healing Potion") : ConsumableItem(name){
    override fun use(villain: Villain){
        villain.hp += (villain.maxHP / 2)
        println("${villain.name} drinks a healing potion and restores ${roundDouble(villain.maxHP/2)} health points. Actual health points: ${roundDouble(villain.hp)} ")
    }
    override fun toString(): String {
        return super.toString() + "Restores 50% of initial Health."
    }
}