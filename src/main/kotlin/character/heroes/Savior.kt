package character.heroes

import character.Character
import character.villains.Villain
import utils.randomHeroineName
import utils.randomSaviorName
import utils.roundDouble

/**The Savior Class is child to Hero and the main antagonist.
 * @constructor creates a Savior with a random name from a list of names
 * @see Hero
 * @see Character
 * */

class Savior(name: String = randomSaviorName()) : Hero(name) {

    override fun toString(): String {
        return """
            Savior $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }

    fun holySword(opponent: Villain){
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.4)
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Savior $name used Holy Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun lightBeam(opponent: Villain){
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.55)
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Savior $name used Light Beam on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }
    fun heal(companion: Hero) {
        healPower *= (0.25 + Math.random() * (0.35 - 0.25)) * attackFactor
        super.heal(companion,healPower)
        println("Savior $name used Heal on himself and healed $healPower points.")
    }
    fun curse(opponent: List<Villain>){
        if (cursedVillain == null) {
            cursedVillain = opponent.random()
            println("${cursedVillain?.name} is cursed now.")
            applycurse(cursedVillain!!)
        } else {
            println("${cursedVillain?.name} is already cursed.")
            applycurse(cursedVillain!!)
        }
    }
    fun holyLight(opponent: List<Villain>) {
        var unblockedOpponents = opponent.filter { it.shield <= 0 }
        var blockedOpponents = opponent.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower,attackFactor,0.39,0.4)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            println("Savior $name used Holy Light on ${unblockedOpponents.joinToString { it.name }} and inflicted ${roundDouble(totalDamage)} total damage and ${roundDouble(attackPower)} to each.")
            println(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "")
        } else println("All attacks were blocked! No damage taken.")
    }
    fun summoning(): Sidekick {
        var sidekick: Sidekick = Sidekick(randomHeroineName())
        println("Sidekick ${sidekick.name} was summoned to support the hero. be cautious.")
        return sidekick
    }



}