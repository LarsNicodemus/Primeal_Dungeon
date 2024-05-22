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

    override var abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>> = listOf(
        ::darkSword,
        ::hellFlame,
        ::gravityBomb,
        ::rulersGrip
    )

//    override fun chosenAction(
//        opponent: Hero, itemBox: ItemBox, companion: Villain,opponents: List<Hero>,companions: List<Villain>,
//        abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>>
//    ) {
//        super.chosenAction(opponent,itemBox,companion,opponents,companions,abilities)
//    }
//    override fun chosenAction(opponent: Hero, itemBox: ItemBox, villain: Villain){
//        println("$name's turn, which attack should be carried out?")
//        attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack") }
//        val input = readln()
//        if (input.toIntOrNull() != null && input.toInt() in 1..attacks.size) {
//            when (input) {
//                "1" -> test[0](opponent)
//                "2" -> test[1](opponent)
//                "3" -> test[2](opponent)
//                "4" -> test[3](opponent)
//                "5" -> itemBox.useItem(villain,itemBox.itemBox)
//                else -> chosenAction(opponent, itemBox, villain)
//            }
//        }
//    }

    fun darkSword(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.4)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Dark Sword on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun hellFlame(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.2, 0.55)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Hell Flame on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Hell Flame on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun gravityBomb(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.15, 0.35)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Gravity Bomb on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }

    fun rulersGrip(opponent: Hero,companion: Villain,companions: List<Villain>,opponents: List<Hero>) {
        attackPower = actualAttackPower(attackPower, attackFactor, 0.25, 0.35)
        if (opponent.shield > 0) {
            println("Demonlord $name tried to use Ruler's Grip on ${opponent.name}, attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage.")
        }
    }


}