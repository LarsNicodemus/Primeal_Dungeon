package character.villains

import character.heroes.Hero
import utils.randomDemonVillainName

class SecondHeavenlyKing(name: String = randomDemonVillainName()) : Villain(name) {


    fun void(opponent: List<Hero>) {
        attackPower = actualAttackPower(attackPower,attackFactor,0.1,0.3)
        opponent.forEach { super.magicAttack(it, attackPower) }
        println("Second Heavenly King $name used Void on ${opponent.joinToString(", ") { it.name }} and inflicted $attackPower damage to each.")
    }

    fun eternalIce(companion: Villain) {
        if (!block(companion))
            println("Second Heavenly King $name tried to used Eternal Ice but it failed.")
        else println("Second Heavenly King $name used Eternal Ice to block the next attack.")

    }

    fun gravityBomb(opponent: Hero) {
        attackPower = actualAttackPower(attackPower,attackFactor,0.15,0.35)
        super.magicAttack(opponent, attackPower)
        println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted $attackPower damage.")
    }

    fun rulersGrip(opponent: Hero) {
        attackPower = actualAttackPower(attackPower,attackFactor,0.25,0.35)
        super.swordAttack(opponent, attackPower)
        println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted $attackPower damage.")
    }

}