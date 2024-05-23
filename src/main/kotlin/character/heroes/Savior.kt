package character.heroes

import character.Character
import character.villains.Villain
import utils.nextRandomDouble
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

    fun holySword(opponent: Villain) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Savior $name tried to use Holy Sword on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Savior $name used Holy Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun holyShield(companion: Hero) {
        if (!block(companion))
            println("Savior $name tried to used Holy Shield but it failed.")
        else println("Savior $name used Holy Shield to block the next attack.")
    }

    fun holyHeal(companion: Hero) {
        healPower *= nextRandomDouble(0.8,1.2) * attackFactor
        super.heal(companion, healPower)
        println("Savior $name used Holy Heal on himself and healed ${roundDouble(healPower)} points.")
    }

    fun sacredCommand(opponent: List<Villain>) {
        if (cursedVillain == null) {
            cursedVillain = opponent.random()
            println("Savior $name used Sacred Command on ${cursedVillain?.name}, is cursed now.")
            applycurse(cursedVillain!!)
        } else {
            println("${cursedVillain?.name} is already cursed.")
            applycurse(cursedVillain!!)
        }
    }

    fun holyLight(opponent: List<Villain>) {
        var unblockedOpponents = opponent.filter { it.shield <= 0 }
        var blockedOpponents = opponent.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            println(
                "Savior $name used Holy Light on ${unblockedOpponents.joinToString { it.name }} and inflicted ${
                    roundDouble(
                        totalDamage
                    )
                } total damage and ${roundDouble(attackPower)} to each."
            )
            println(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "")
        } else println("Savior $name tried to use Holy Sword on ${blockedOpponents.joinToString { it.name }}, all attacks were blocked! No damage taken.")
    }

    fun summoning(companions: MutableList<Hero>){
        var sidekick: Sidekick = Sidekick()
        companions.add(sidekick)
        println("Sidekick ${sidekick.name} was summoned to support the hero. be cautious.")
    }

}