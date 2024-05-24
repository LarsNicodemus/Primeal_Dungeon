package character.villains

import character.Character
import character.heroes.Hero
import itembox.ItemBox
import utils.randomDemonVillainName
import utils.roundDouble
import kotlin.reflect.KFunction4

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

    override var attacks: List<String> = listOf("Dark Sword","Hell Flame","Gravity Bomb","Rulers Grip")
    override var title: String = "Demonlord"

//    override var abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>> = listOf(
//        ::darkSword,
//        ::hellFlame,
//        ::gravityBomb,
//        ::rulersGrip
//    )

    fun darkSword(opponent: Hero) {
        attackPower
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Dark Sword on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun hellFlame(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Hell Flame on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Hell Flame on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun gravityBomb(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Gravity Bomb on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun rulersGrip(opponent: Hero) {
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Ruler's Grip on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }


}