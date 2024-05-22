package character.villains

import character.Character
import character.heroes.Hero
import utils.randomDemonVillainName
import utils.roundDouble

/**The DemonLord Class is child to Villain and one of the playable characters.
 * @constructor creates a Demonlord with a random name from a list of names
 * @see Villain
 * @see Character
 * */

class DemonLord(name: String = randomDemonVillainName()) : Villain(name) {


    override fun toString(): String {
        return """
            Demonlord $name
            Health Points ${roundDouble(hp)}
            Attack Power ${roundDouble(attackPower)}
        """.trimIndent()
    }

    fun darkSword(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.4)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Dark Sword on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun hellFlame(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.55)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Hell Flame on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Hell Flame on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun gravityBomb(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.15, 0.35)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Gravity Bomb on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun rulersGrip(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.25, 0.35)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Ruler's Grip on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }


}