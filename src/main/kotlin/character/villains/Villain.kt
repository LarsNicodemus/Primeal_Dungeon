package character.villains

import character.Character
import character.heroes.Hero

/** The Villain class is child class to character and mother class to villains. aka. the true Heroes!
 * @constructor creates a Villain with a name and hp
 * @see shield
 * */

open class Villain(override var name: String, override var hp: Double = 0.0) : Character() {

    override var shield: Int = 0

    /**returns a String with information about the villain
     * */
    override fun toString(): String {
        return """
            $name
            $hp
            $attackPower
        """.trimIndent()
    }

    /** Performs a sword attack against an opposing hero.
     * @param opponent The opposing hero to perform the attack against.
     * @param attackPower the strength of the attack performed by the current villain.
     * The value of attack power will be subtracted from the heroes remaining health points.
     */

    open fun swordAttack(opponent: Hero, attackPower: Int) {
        opponent.hp -= attackPower
    }

    /** Performs a magic attack against an opposing hero.
     * @param opponent The opposing hero to perform the attack against.
     * @param attackPower the strength of the attack performed by the current villain.
     * The value of attack power will be subtracted from the heroes remaining health points.
     */

    open fun magicAttack(opponent: Hero, attackPower: Int) {
        opponent.hp -= attackPower
    }

    /** Performs healing on a villain of choice.
     * @param healPower the value added to the villains remaining health points.
     * @param companion the villain whom will be healed.
     * \\\\\The value of heal power will be added to the villains remaining health points.
     */

    open fun heal(healPower: Int, companion: Villain) {
        companion.hp += healPower
    }

    /**Performs a block of the next incoming attack
     * @param villain the chosen villain himself.
     * @return If the blockchance is bigger than the random chance, the villains shield will be stacked with 1 and block the next attack,
     * else it will be returned with a 0 which leads to a failed block attempt.
     * */

    fun block(villain: Villain): Boolean {
        var blockChance: Double = 0.55 + Math.random() * (0.7 - 0.55)
        var randomChance = Math.random()
        return if (randomChance <= blockChance) {
            villain.shield = 1
            true
        } else {
            villain.shield = 0
            false
        }
    }



}