package character.heroes

import character.Character
import character.villains.Villain
import utils.randomDouble
import utils.roundDouble

open class Hero(name: String) : Character(name) {
    init {
        this.hp = randomDouble(140.0, 200.0)
        this.attackPower = randomDouble(70.0, 100.0)
        this.healPower = 70.0 + Math.random() * (100.0 - 70.0)
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
    }

    fun block(companion: Hero): Boolean {
        var blockChance: Double = 0.55 + Math.random() * (0.7 - 0.55)
        var randomChance = Math.random()
        return if (randomChance <= blockChance) {
            companion.shield = 1
            true
        } else {
            companion.shield = 0
            false
        }
    }

    fun applycurse(opponent: Villain){
        var curseActive = true
            opponent.hp -= (opponent.hp * 0.1)
            println("${roundDouble(opponent.hp*0.1)} damage taken, ${roundDouble(opponent.hp)} health points left.")
            if (opponent.hp<(opponent.maxHP*0.2)){
                curseActive = false
                cursedVillain = null
                println("Curse on ${opponent.name} is liftet.")
        }
    }

    fun eternalIce(companion: Hero) {
        if (!block(companion))
            println("Second Heavenly King $name tried to used Eternal Ice but it failed.")
        else println("Second Heavenly King $name used Eternal Ice to block the next attack.")

    }
//    fun aoe(opponent: List<Villain>,attackPower: Double) :Double{
//            var totalDamage = opponent.sumOf {
//                magicAttack(it, attackPower)
//                attackPower
//            }
//        return totalDamage
//    }

}