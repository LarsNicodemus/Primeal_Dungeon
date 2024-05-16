package character.villains

import character.heroes.Hero

/**The DemonLord Class is child to Villain and one of the playable characters.
 * @constructor creates a Demonlord with a name
 * @property hp is invoked in the init and added as a part of the constructor so that the new created instance has both
 * name and health points.
 * The Class also gets some properties from the Character Class and the Villain Class
 * @see attackPower
 * @see shield
 * */

class DemonLord(name: String) : Villain(name, hp = 0.0) {
    init {
        hp = 70.0 + Math.random() * (100.0 - 70.0)

    }

    override fun toString(): String {
        return """
            Demonlord $name
            Health Points $hp
            Attack Power $attackPower
        """.trimIndent()
    }

    fun darkSword(opponent: Hero) {
        attackPower = (20..40).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted $attackPower damage.")
        }
    }

    fun hellFlame(opponent: Hero) {
        attackPower = (30..55).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Hell Flame on ${opponent.name} and inflicted $attackPower damage.")
        }
    }

    fun gravityBomb(opponent: Hero) {
        attackPower = (15..35).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted $attackPower damage.")
        }
    }

    fun rulersGrip(opponent: Hero) {
        attackPower = (25..35).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted $attackPower damage.")
        }
    }


}