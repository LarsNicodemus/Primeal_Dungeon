package character.heroes

import character.Character
import character.villains.Villain
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
        this.hp = randomDouble(140.0, 200.0)
        this.maxHP = hp
        this.attackPower = randomDouble(30.0,40.0)
        this.healPower = randomDouble(30.0,40.0)
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
        if (companion.hp>companion.maxHP) {
            companion.hp = companion.maxHP
        }
    }

    fun block(companion: Hero): Boolean {
        var blockChance: Double = 0.55 + Math.random() * (0.7 - 0.55)
        var randomChance = Math.random()
        return if (randomChance <= blockChance) {
            companion.applyBuff(2,1.0,1)
            true
        } else {
            companion.shield = 0
            false
        }
    }

    fun applycurse(opponent: Villain){
        var curseActive = true
            opponent.hp -= (opponent.maxHP * 0.1)
            println("${roundDouble(opponent.hp*0.1)} damage taken, ${roundDouble(opponent.hp)} health points left.")
            if (opponent.hp<(opponent.maxHP*0.2)){
                curseActive = false
                cursedVillain = null
                println("Curse on ${opponent.name} is liftet.")
        }
    }

//    fun eternalIce(companion: Hero) {
//        if (!block(companion))
//            println("Second Heavenly King $name tried to used Eternal Ice but it failed.")
//        else println("Second Heavenly King $name used Eternal Ice to block the next attack.")
//
//    }
//    fun aoe(opponent: List<Villain>,attackPower: Double) :Double{
//            var totalDamage = opponent.sumOf {
//                magicAttack(it, attackPower)
//                attackPower
//            }
//        return totalDamage
//    }

}