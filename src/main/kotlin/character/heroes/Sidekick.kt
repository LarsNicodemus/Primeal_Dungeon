package character.heroes

import character.villains.Villain
import utils.roundDouble

class Sidekick(name: String) : Hero(name) {
    override fun toString(): String {
        return """
            Sidekick $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }

    fun elementalArrow(opponent: Villain){
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.55)
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Sidekick $name used elemental Arrow on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }
    fun heal(companion: Hero) {
        healPower *= (0.25 + Math.random() * (0.35 - 0.25)) * attackFactor
        super.heal(companion,healPower)
        println("Sidekick $name used Heal on ${companion.name} and healed $healPower points.")
    }

    fun elementalWave(opponent: List<Villain>) {
        var unblockedOpponents = opponent.filter { it.shield <= 0 }
        var blockedOpponents = opponent.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower,attackFactor,0.39,0.4)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            println("Sidekick $name used elemental Wave on ${unblockedOpponents.joinToString { it.name }} and inflicted ${roundDouble(totalDamage)} total damage and ${roundDouble(attackPower)} to each.")
            println(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "")
        } else println("All attacks were blocked! No damage taken.")
    }

}