package character.heroes

import character.villains.Villain
import utils.roundDouble

class Savior(name: String) : Hero(name) {

    override fun toString(): String {
        return """
            Savior $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
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
}