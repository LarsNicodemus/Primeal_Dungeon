package character.villains

import character.heroes.Hero

class FirstHeavenlyKing(name: String) : Villain(name) {
    init {
        this.hp = 70.0 + Math.random() * (100.0 - 70.0)
    }

    fun bite(opponent: Hero) {
        attackPower = (10..25).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("First Heavenly King $name used Bite on ${opponent.name} and inflicted $attackPower damage.")
        }
    }

    fun bloodLetting(opponent: Hero, companion: Villain) {
        attackPower = (10..20).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            super.heal(attackPower, companion)
            println("First Heavenly King $name used Bloodletting on ${opponent.name}, healed his Lord Points ${companion.name} with the inflicted damage of $attackPower.")
        }
    }

    fun darkHeal(companions: List<Villain>) {
        healPower = (25..35).random()
        companions.forEach { super.heal(healPower, it) }
        println("First Heavenly King $name used dark Heal on ${companions.joinToString(", ") { it.name }} and healed each with $healPower points.")
    }

    fun bloodRain(opponent: List<Hero>) {
        var unblockedOpponents = opponent.filter { it.shield <= 0 }
        var blockedOpponents = opponent.filter { it.shield > 0 }
        var attackPower = (10..30).random()
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            println("First Heavenly King $name used Blood Raid on ${unblockedOpponents.joinToString { it.name }} and inflicted $totalDamage total damage and $attackPower to each.")
            println(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "")
        } else println("All attacks were blocked! No damage taken.")
    }
}