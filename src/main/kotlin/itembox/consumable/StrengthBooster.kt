package itembox.consumable

import character.villains.Villain
import utils.Buff
import utils.printlnWithDelay
import utils.roundDouble
import utils.threadsleep

class StrengthBooster(name : String = "Strength Booster"): ConsumableItem(name){
    override fun use (villain: Villain){
        villain.applyBuff(Buff(2,1.2,0))
        println()
        threadsleep(4)
        printlnWithDelay("${villain.name} drinks a strength booster and increases his attack power by 20%. Actual attack power: ${roundDouble(villain.attackPower*villain.attackFactor)} ",15)
        threadsleep(4)
        println()
    }

    override fun toString(): String {
        return super.toString() + "Increase of Attack Power by 20%."
    }
}