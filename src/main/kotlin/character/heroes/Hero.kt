package character.heroes

import character.Character
import character.villains.Villain
import utils.Buff
import utils.randomDouble
import utils.randomSaviorName
import utils.roundDouble

/** The Hero class is child class to character and mother class to Sidekick!
 * @constructor creates a Hero with a name, the stats are initialized when created.
 * @property name the characters name
 * @property hp the characters health points, if hp reaches 0 the character dies.
 * @property attackPower defines the attack power of the character, the higher, the stronger is the dealt attack.
 * @property attackFactor attack power is 1.0 from start. if a booster is used the value goes up
 * @property shield indicates if the character is able to block or nullify the next attack.
 * @property maxHP 100% of the characters health points.
 * @property healPower defines the heal power of the character, the higher, the stronger is the given heal.
 * @see Character
 * */
open class Hero(name: String = randomSaviorName()) : Character(name) {
    init {
        this.hp = randomDouble(200.0, 220.0)
        this.maxHP = hp
        this.attackPower = randomDouble(35.0, 40.0)
        this.healPower = randomDouble(40.0, 45.0)
        this.shield = 0
        this.attackFactor = 1.0
    }

    open fun swordAttack(opponent: Villain, attackPower: Double) {
        opponent.hp -= attackPower
    }

    open fun magicAttack(opponent: Villain, attackPower: Double) {
        opponent.hp -= attackPower
    }

    fun heal(companion: Hero, healPower: Double) {
        companion.hp += healPower
        if (companion.hp > companion.maxHP) {
            companion.hp = companion.maxHP
        }
    }

    fun block(companion: Hero): Boolean {
        var blockChance: Double = randomDouble(0.7, 1.0)
        var randomChance = randomDouble(0.0, 1.0)
        return if (randomChance <= blockChance) {
            if (blockCounter == 0) {
                companion.applyBuff(Buff(2, 1.0, 1))
                true
            } else {
                companion.shield = 0
                false
            }
        } else {
            companion.shield = 0
            false
        }
    }

    fun applycurse(opponent: Villain) {
        opponent.hp -= (opponent.maxHP * 0.1)
        println("${roundDouble(opponent.maxHP * 0.1)} damage taken, ${roundDouble(opponent.hp)} health points left.")
    }

}