package character.villains

import character.heroes.Hero

class FirstHeavenlyKing(name: String) : Villan(name) {
    init {
        this.hp = 70.0 + Math.random()*(100.0-70.0)
    }
    fun bite(opponent:Hero){
        attackPower = (10..25).random()
        super.swordAttack(opponent, attackPower)
        println("First Heavenly King $name used Bite on ${opponent.name} and inflicted $attackPower damage.")
    }
    fun bloodLetting(opponent:Hero,companion: Villan){
        attackPower = (10..20).random()
        super.swordAttack(opponent,attackPower)
        super.heal(attackPower,companion)
        println("First Heavenly King $name used Bloodletting on ${opponent.name}, healed his Lord Points ${companion.name} with the inflicted damage of $attackPower.")
    }
    fun darkHeal(companions: List<Villan>){
        healPower = (25..35).random()
        companions.forEach { super.heal(healPower,it) }
        println("First Heavenly King $name used dark Heal on ${companions.joinToString(", "){it.name}} and healed each with $healPower points.")

    }

    fun bloodRain(opponent:List<Hero>){
        attackPower = (10..30).random()
        opponent.forEach { super.magicAttack(it,attackPower) }
        println("First Heavenly King $name used Blood Raid on ${opponent.joinToString(", ") { it.name }} and inflicted $attackPower damage to each.")
    }
}