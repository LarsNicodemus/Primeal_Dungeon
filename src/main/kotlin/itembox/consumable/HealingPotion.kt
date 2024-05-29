package itembox.consumable

import character.villains.Villain
import utils.printlnWithDelay
import utils.roundDouble
import utils.threadsleep

class HealingPotion(name: String = "Healing Potion") : ConsumableItem(name) {
    override fun use(villain: Villain) {
        villain.hp += (villain.maxHP / 2)
        if (villain.hp > villain.maxHP) {
            villain.hp = villain.maxHP
        }
        println()
        threadsleep(4)
        printlnWithDelay(
            "${villain.name} drinks a healing potion and restores ${roundDouble(villain.maxHP / 2)} health points. Actual health points: ${
                roundDouble(
                    villain.hp
                )
            } ", 15
        )
        threadsleep(4)
        println()
    }

    override fun toString(): String {
        return super.toString() + "Restores 50% of initial Health."
    }
}