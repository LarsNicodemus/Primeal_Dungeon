package character.villains
import character.Character
import character.heroes.Hero
import utils.*

/**The FirstHeavenlyKing Class is child to Villain Class and one of the playable characters.
 * @constructor creates a FirstHeavenlyKing with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class FirstHeavenlyKing(name: String = randomDemonVillainNameFirst()) : Villain(name) {

    override fun toString(): String {
        return """
            First Heavenly King $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }
    override var attacks: List<String> = listOf("Bite","Blood Letting","Dark Heal","Blood Rain")

    override var title: String = "First Heavenly King"
    fun bite(opponent: Hero) {
        attackPower = actualAttackPower(attackPower,attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("First Heavenly King $name tried to use Bite on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.swordAttack(opponent, attackPower)
            printlnWithDelay("First Heavenly King $name used Bite on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun bloodLetting(opponent: Hero,companion: Villain) {
        attackPower = actualAttackPower(attackPower,attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("First Heavenly King $name tried to use Blood Letting on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.swordAttack(opponent, attackPower)
            super.heal(attackPower, companion)
            printlnWithDelay("First Heavenly King $name used Bloodletting on ${opponent.name}, healed ${companion.name} to a total of ${roundDouble(companion.hp)} Health Points with the inflicted damage of ${roundDouble(attackPower)}. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun darkHeal(companions: List<Villain>) {
        healPower *= (nextRandomDouble(0.8,1.2) * attackFactor)
        companions.forEach { super.heal(healPower, it) }
        val healedCompanions = companions.joinToString(", ") { it.name }
        printlnWithDelay("First Heavenly King $name used Dark Heal on $healedCompanions and healed each with ${roundDouble(healPower)} points to a total of ${companions.joinToString(", ","",".") { it.name +" "+ roundDouble(it.hp)+" Health Points" }}",15)
    }

    fun bloodRain(opponents: List<Hero>) {
        var unblockedOpponents = opponents.filter { it.shield <= 0 }
        var blockedOpponents = opponents.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower,attackFactor)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            printlnWithDelay("First Heavenly King $name used Blood Rain on ${unblockedOpponents.joinToString { it.name }} and inflicted ${roundDouble(totalDamage)} total damage and ${roundDouble(attackPower)} to each. ${unblockedOpponents.joinToString(", ","",".") { it.name +" "+ hpLeft(roundDouble(it.hp)) +" Health Points left" }}",15)
            printlnWithDelay(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "",15)
        } else printlnWithDelay("First Heavenly King $name tried to use Blood Rain on ${blockedOpponents.joinToString { it.name }}, all attacks were blocked! No damage taken.",15)
    }
}