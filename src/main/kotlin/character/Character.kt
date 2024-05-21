package character

import character.villains.Villain
import utils.roundDouble

/** The Character class is the mother class to all villains and heroes.
 * @property name the characters name
 * @property hp the characters health points, if hp reaches 0 the character dies.
 * @property maxHP 100% of the characters health points.
 * @property mp the characters mana points, used for magic attacks and heals, refills over time, if not enough or empty attack cannot be invoked.
 * @property maxMP 100% of the characters mana points.
 * @property rage the characters rage points, used for sword attacks, refills over time, if not enough or empty attack cannot be invoked.
 * @property maxRage 100% of characters rage
 * @property attackPower defines the attack power of the character, the higher, the stronger is the dealt attack.
 * @property healPower defines the heal power of the character, the higher, the stronger is the given heal.
 * @property shield indicates if the character is able to block or nullify the next attack.
 * @property isCursed indicates if the character is cursed.
 * @property cursedVillain indicates if a spezific class Villain is cursed
 * */

open class Character(var name: String, var hp: Double = 0.0) {

    /**returns a String with information about the Character
     * */
    override fun toString(): String {
        return """
            Name: $name
            Health Points: ${roundDouble(hp)}
            Attack Power: ${roundDouble(attackPower)}
            ${if (healPower > 0) "Heal Power :${roundDouble(healPower)}" else ""}
        """.trimIndent()
    }

    var maxHP = 0.0
    var maxMP = 0.0
    var maxRage = 0.0
    var rage: Double = 0.0
    var attackFactor: Double = 1.0
    var attackPower: Double = 0.0
    var healPower: Double = 0.0
    var isCursed: Boolean = false
    var shield: Int = 0
    var cursedVillain: Villain? = null

    open fun actualAttackPower(attackPower: Double, attackFactor: Double, minValue: Double, maxValue: Double): Double {
        this.attackPower *= (minValue + Math.random() * (maxValue - minValue)) * attackFactor
        return this.attackPower
    }
}