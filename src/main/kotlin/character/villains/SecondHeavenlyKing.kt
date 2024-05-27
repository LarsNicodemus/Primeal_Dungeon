package character.villains

import character.Character
import character.heroes.Hero
import utils.hpLeft
import utils.printlnWithDelay
import utils.randomDemonVillainNameSecond
import utils.roundDouble

/**The SecondHeavenlyKing Class is child to Villain Class and one of the playable characters.
 * @constructor creates a SecondHeavenlyKing with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class SecondHeavenlyKing(name: String = randomDemonVillainNameSecond()) : Villain(name) {

    override fun toString(): String {
        return """
            Second Heavenly King $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }
    override var attacks: List<String> = listOf("Void","Eternal Ice","Chaos Burst","Origins Doom")

override var title: String = "Second Heavenly King"
    fun void(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Second Heavenly King $name tried to use Void on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Second Heavenly King $name used Void on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun eternalIce(companion: Villain) {
        if (!block(companion))
            printlnWithDelay("Second Heavenly King $name tried to used Eternal Ice but it failed.",15)
        else printlnWithDelay("Second Heavenly King $name used Eternal Ice to block the next attack.",15)

    }

    fun chaosBurst(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Second Heavenly King $name tried to use Chaos Burst on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Second Heavenly King $name used Chaos Burst on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun originsDoom(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Second Heavenly King $name tried to use Origins Doom on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.swordAttack(opponent, attackPower)
            printlnWithDelay("Second Heavenly King $name used Origins Doom on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }
}