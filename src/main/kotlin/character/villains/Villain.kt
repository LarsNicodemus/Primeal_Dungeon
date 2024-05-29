package character.villains

import character.Character
import character.heroes.Hero
import itembox.ItemBox
import utils.Buff
import utils.nextRandomDouble
import utils.randomDouble
import kotlin.reflect.KFunction4

/** The Villain class is child class to character and mother class to villains. aka. the true Heroes!
 * @constructor creates a Villain with a name, the stats are initialized when created.
 * @property name the characters name
 * @property hp the characters health points, if hp reaches 0 the character dies.
 * @property attackPower defines the attack power of the character, the higher, the stronger is the dealt attack.
 * @property attackFactor attack power is 1.0 from start. if a booster is used the value goes up
 * @property shield indicates if the character is able to block or nullify the next attack.
 * @property maxHP 100% of the characters health points.
 * @property healPower defines the heal power of the character, the higher, the stronger is the given heal.
 * @see Character
 * */

open class Villain(name: String) : Character(name) {


    init {
        this.hp = randomDouble(70.0, 100.0)
        this.maxHP = hp
        this.attackPower = randomDouble(30.0, 40.0)
        this.healPower = randomDouble(30.0, 40.0)
        this.shield = 0
        this.attackFactor = 1.0
    }

    open var attacks = listOf("")
    open var title = ""

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
        if (companion.hp > companion.maxHP) {
            companion.hp = companion.maxHP
        }
    }

    /**Performs a block of the next incoming attack
     * @param villain the chosen villain himself.
     * @return If the blockchance is bigger than the random chance, the villains shield will be stacked with 1 and block the next attack,
     * else it will be returned with a 0 which leads to a failed block attempt.
     * */

    fun block(villain: Villain): Boolean {
        var blockChance: Double = randomDouble(0.7, 1.0)
        var randomChance = randomDouble(0.7, 1.0)
        return if (randomChance <= blockChance) {
            villain.applyBuff(Buff(2, 1.0, 1))
            true
        } else {
            villain.shield = 0
            false
        }
    }
}