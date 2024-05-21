package character.villains

import character.Character
import character.heroes.Hero
import itembox.Item
import itembox.ItemBox
import utils.nextRandomDouble
import utils.randomDouble

/** The Villain class is child class to character and mother class to villains. aka. the true Heroes!
 * @constructor creates a Villain with a name and hp
 *
 * */

open class Villain(name: String) : Character(name) {
    var maxHP = 0.0
    var maxMP = 0.0
    var maxRage = 0.0
    init {
        this.hp = randomDouble(70.0,100.0)
        maxHP = hp
        this.mp = nextRandomDouble(70.0,100.0)
        maxMP = mp
        this.rage = randomDouble(70.0,100.0)
        maxRage = rage
        this.attackPower = randomDouble(70.0,100.0)
        this.healPower = 70.0 + Math.random() * (100.0 - 70.0)
        this.shield = 0
        this.attackFactor = 1.0
    }

    /** Performs a sword attack against an opposing hero.
     * @param opponent The opposing hero to perform the attack against.
     * @param attackPower the strength of the attack performed by the current villain.
     * The value of attack power will be subtracted from the heroes remaining health points.
     */

    open fun swordAttack(opponent: Hero, attackPower: Double) {
        opponent.hp -= attackPower
    }

    /** Performs a magic attack against an opposing hero.
     * @param opponent The opposing hero to perform the attack against.
     * @param attackPower the strength of the attack performed by the current villain.
     * The value of attack power will be subtracted from the heroes remaining health points.
     */

    open fun magicAttack(opponent: Hero, attackPower: Double) {
        opponent.hp -= attackPower
    }

    /** Performs healing on a villain of choice.
     * @param healPower the value added to the villains remaining health points.
     * @param companion the villain whom will be healed.
     * \\\\\The value of heal power will be added to the villains remaining health points.
     */

    open fun heal(healPower: Double, companion: Villain) {
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

    fun useItemBox(itemBox: ItemBox,villain: Villain){
        itemBox.useItem(villain,itemBox.itemBox)
    }
}