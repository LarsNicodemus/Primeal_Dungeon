package itembox.consumable

import character.villains.Villain
import utils.roundDouble

class StrengthBooster(name : String = "Strength Booster"): ConsumableItem(name){
    override fun use (villain: Villain){
        villain.applyBuff(2,1.2,0)
        println("${villain.name} drinks a strength booster and increases his attack power by 20%.Actual attack power: ${roundDouble(villain.attackPower*villain.attackFactor)} ")
    }
}