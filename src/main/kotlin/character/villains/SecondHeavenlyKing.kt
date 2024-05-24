package character.villains

import character.Character
import character.heroes.Hero
import utils.randomDemonVillainName
import utils.roundDouble
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction4

/**The SecondHeavenlyKing Class is child to Villain Class and one of the playable characters.
 * @constructor creates a SecondHeavenlyKing with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class SecondHeavenlyKing(name: String = randomDemonVillainName()) : Villain(name) {

    override fun toString(): String {
        return """
            Second Heavenly King $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }
    override var attacks: List<String> = listOf("Void","Eternal Ice","Chaos Burst","Blood Art")

override var title: String = "Second Heavenly King"
    fun void(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Second Heavenly King $name tried to use Void on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Second Heavenly King $name used Void on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun eternalIce(companion: Villain) {
        if (!block(companion))
            println("Second Heavenly King $name tried to used Eternal Ice but it failed.")
        else println("Second Heavenly King $name used Eternal Ice to block the next attack.")

    }

    fun chaosBurst(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Second Heavenly King $name tried to use Chaos Burst on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Second Heavenly King $name used Chaos Burst on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun bloodArt(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Second Heavenly King $name tried to use Blood Art on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Second Heavenly King $name used Blood Art on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }
}