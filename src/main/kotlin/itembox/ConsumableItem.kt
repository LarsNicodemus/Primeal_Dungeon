package itembox

import character.villains.Villain
import utils.roundDouble

open class ConsumableItem(name : String) : Item(name){
    override fun use(villain: Villain) {
        println("Item was consumed.")
    }
}
class HealingPotion(name : String) : ConsumableItem(name){
    override fun use(villain: Villain){
        villain.hp += (villain.maxHP / 2)
        println("${villain.name} drinks a healing potion and restores ${roundDouble(villain.maxHP/2)} health points. Actual health points: ${roundDouble(villain.hp)} ")
    }
}class ManaPotion(name : String) : ConsumableItem(name){
    override fun use(villain: Villain){
        villain.mp += (villain.maxMP / 2)
        println("${villain.name} drinks a mana potion and restores ${roundDouble(villain.maxMP/2)} mana points. Actual mana points: ${roundDouble(villain.mp)} ")
    }
}class RagePotion(name : String) : ConsumableItem(name){
    override fun use(villain: Villain){
        villain.hp += (villain.maxRage / 2)
        println("${villain.name} drinks a rage potion and restores ${roundDouble(villain.maxRage/2)} rage points. Actual rage points: ${roundDouble(villain.rage)} ")
    }
}
class StrengthBooster(name : String): ConsumableItem(name){
    override fun use (villain: Villain){
        villain.attackFactor = 1.2
        println("${villain.name} drinks a strength booster and increases his attack power by 20%.Actual attack power: ${roundDouble(villain.attackPower*villain.attackFactor)} ")
    }
}
class DarknessBomb(name : String): ConsumableItem(name){
    override fun use (villain: Villain){
        villain.shield = 1
        println("${villain.name} throws a darkness bomb, he can't be seen and evades the next attack")
    }
}