package character.heroes

import character.Character
import character.villains.Villain
import utils.randomDouble
import utils.randomName
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

//    fun curse(opponents: List<Villain>) {
//        var cursedVillain: Villain? = null
//        for (villain in opponents) {
//            if (cursedVillain == null){
//                cursedVillain = villain
//                println("${villain.name} wurde verflucht.")
//            } else if (cursedVillain == villain) {
//                val hpReduction = 0.1*villain.maxHP
//                villain.hp = maxOf(villain.hp-hpReduction,0.2*villain.maxHP)
//                println("${villain.name} wurden $hpReduction Schaden zugefügt")
//                cursedVillain = null
//            } else continue
//        }
//    }
//    fun curse2(opponents: List<Villain>){
//        if (opponents.any { it.isCursed }) {
//            var cursedVillain: Villain = opponents.random()
//            if (!cursedVillain.isCursed) {
//                cursedVillain.isCursed = true
//                println("${cursedVillain.name} is cursed.")
//            } else {
//                val hpReduction = 0.1 * cursedVillain.maxHP
//                cursedVillain.hp = maxOf(cursedVillain.hp - hpReduction, 0.2 * cursedVillain.maxHP)
//                println("${cursedVillain.name} wurden ${roundDouble(hpReduction)} Schaden zugefügt")
//            }
//        } else { println("blabla")
//
//        }
//    }
    fun curse(opponent: List<Villain>){
        if (cursedVillain == null) {
            cursedVillain = opponent.random()
            println("${cursedVillain?.name} is cursed now.")
            applycurse(cursedVillain!!)
        } else println("${cursedVillain?.name} is already cursed.")
    }

    fun applycurse(opponent: Villain){
        var curseActive = true
        while (curseActive) {
            opponent.hp = opponent.hp - (opponent.hp)
            println("${opponent.hp} HP left.")
            if (opponent.hp<(opponent.maxHP*0.2)){
                curseActive = false
                cursedVillain = null
                println("Curse on ${opponent.name} is liftet.")
            }
        }
    }

    fun summoning(): Sidekick {
        var sidekick: Sidekick = Sidekick(randomName())
        println("Sidekick ${sidekick.name} was summoned to support the hero. be cautious.")
        return sidekick
    }
//    fun aoe(opponent: List<Villain>,attackPower: Double) :Double{
//            var totalDamage = opponent.sumOf {
//                magicAttack(it, attackPower)
//                attackPower
//            }
//        return totalDamage
//    }

}