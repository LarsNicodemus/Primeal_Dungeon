package character.villains

import character.Character
import character.heroes.Hero
import utils.nextRandomDouble
import utils.randomDemonVillainName
import utils.roundDouble
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction4

/**The FirstHeavenlyKing Class is child to Villain Class and one of the playable characters.
 * @constructor creates a FirstHeavenlyKing with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class FirstHeavenlyKing(name: String = randomDemonVillainName()) : Villain(name) {

    override var attacks: List<String> = listOf("Bite","Blood Letting","Dark Heal","Blood Rain")
    override var abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>> = listOf(
        ::bite,
        ::bloodLetting,
        ::darkHeal,
        ::bloodRain
    )
    fun bite(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower,attackFactor,0.1,0.25)
        if (opponent.shield > 0) {
            println("First Heavenly King $name tried to use Bite on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("First Heavenly King $name used Bite on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun bloodLetting(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower,attackFactor,0.1,0.2)
        if (opponent.shield > 0) {
            println("First Heavenly King $name tried to use Blood Letting on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            super.heal(attackPower, companion)
            println("First Heavenly King $name used Bloodletting on ${opponent.name}, healed his Lord's health points ${companion.name} with the inflicted damage of ${roundDouble(attackPower)}.")
        }
    }

    fun darkHeal(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        healPower *= nextRandomDouble(0.25,0.35) * attackFactor
        companions.forEach { super.heal(healPower, it) }
        println("First Heavenly King $name used Dark Heal on ${companions.joinToString(", ") { it.name }} and healed each with ${roundDouble(healPower)} points.")
    }

    fun bloodRain(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        var unblockedOpponents = opponents.filter { it.shield <= 0 }
        var blockedOpponents = opponents.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower,attackFactor,0.39,0.4)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            println("First Heavenly King $name used Blood Raid on ${unblockedOpponents.joinToString { it.name }} and inflicted ${roundDouble(totalDamage)} total damage and ${roundDouble(attackPower)} to each.")
            println(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "")
        } else println("First Heavenly King $name tried to use Blood Rain on ${blockedOpponents.joinToString { it.name }}, all attacks were blocked! No damage taken.")
    }
}