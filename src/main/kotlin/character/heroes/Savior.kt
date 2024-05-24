package character.heroes

import character.Character
import character.villains.Villain
import utils.nextRandomDouble
import utils.printlnWithDelay
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
            printlnWithDelay("Savior $name tried to use Holy Sword on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.swordAttack(opponent, attackPower)
            printlnWithDelay("Savior $name used Holy Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.",15)
        }
    }

    fun holyShield(companion: Hero) {
        if (!block(companion))
            printlnWithDelay("Savior $name tried to used Holy Shield but it failed.",15)
        else printlnWithDelay("Savior $name used Holy Shield to block the next attack.",15)
    }

    fun holyHeal(companion: Hero) {
        healPower *= nextRandomDouble(0.8,1.2) * attackFactor
        super.heal(companion, healPower)
        printlnWithDelay("Savior $name used Holy Heal on himself and healed ${roundDouble(healPower)} points.",15)
    }

    fun sacredCommand(opponent: List<Villain>) {
        if (cursedVillain == null) {
            cursedVillain = opponent.random()
            printlnWithDelay("Savior $name used Sacred Command on ${cursedVillain?.name}, is cursed now.",15)
            applycurse(cursedVillain!!)
        } else {
            printlnWithDelay("${cursedVillain?.name} is already cursed.",15)
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
            printlnWithDelay(
                "Savior $name used Holy Light on ${unblockedOpponents.joinToString { it.name }} and inflicted ${
                    roundDouble(
                        totalDamage
                    )
                } total damage and ${roundDouble(attackPower)} to each."
                ,15)
            printlnWithDelay(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "",15)
        } else printlnWithDelay("Savior $name tried to use Holy Sword on ${blockedOpponents.joinToString { it.name }}, all attacks were blocked! No damage taken.",15)
    }

    fun summoning(companions: MutableList<Hero>){
        var sidekick: Sidekick = Sidekick()
        companions.add(sidekick)
        printlnWithDelay("Sidekick ${sidekick.name} was summoned to support the hero. be cautious.",15)
    }

}