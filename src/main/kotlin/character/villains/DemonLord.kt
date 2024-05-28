package character.villains

import character.Character
import character.heroes.Hero
import character.heroes.Savior
import utils.*

/**The DemonLord Class is child to Villain and one of the playable characters.
 * @constructor creates a Demonlord with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class DemonLord(name: String = randomVillainName()) : Villain(name) {


    override fun toString(): String {
        return """
            Demonlord $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }

    override var attacks: List<String> = listOf("Dark Sword","Hell Flame","Gravity Bomb","Rulers Grip")
    override var title: String = "Demonlord"

    fun darkSword(opponent: Hero) {
        companionAttackArt(1, 1)
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Demonlord $name tried to use Dark Sword on ${opponent.name}, attack was blocked! No damage taken.",15)
            opponent.blockCounter++
        } else {
            super.swordAttack(opponent, attackPower)
            printlnWithDelay("Demonlord $name used Dark Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun hellFlame(opponent: Hero) {
        companionAttackArt(1,2)
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Demonlord $name tried to use Hell Flame on ${opponent.name}, attack was blocked! No damage taken.",15)
            opponent.blockCounter++
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Demonlord $name used Hell Flame on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun gravityBomb(opponent: Hero) {
        companionAttackArt(1,3)
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Demonlord $name tried to use Gravity Bomb on ${opponent.name}, attack was blocked! No damage taken.",15)
            opponent.blockCounter++
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun rulersGrip(opponent: Hero) {
        companionAttackArt(1,4)
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Demonlord $name tried to use Ruler's Grip on ${opponent.name}, attack was blocked! No damage taken.",15)
            opponent.blockCounter++
        } else {
            super.swordAttack(opponent, attackPower)
            printlnWithDelay("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }


}