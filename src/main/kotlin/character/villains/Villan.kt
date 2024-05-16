package character.villains

import character.Character
import character.heroes.Hero

open class Villan(override var name: String, hp: Double = 0.0) : Character() {


    open fun swordAttack(opponent: Hero, attackPower: Int) {
        opponent.hp -= attackPower
    }

    open fun magicAttack(opponent: Hero, attackPower: Int) {
        opponent.hp -= attackPower
    }

    open fun heal(healPower: Int, companion: Villan) {
        companion.hp += healPower
    }

    fun block(): Boolean {
        var blockChance: Double = 0.55 + Math.random() * (0.7 - 0.55)
        var randomChance = Math.random()
        return if (randomChance <= blockChance) {
            randomChance <= blockChance
        } else {
            false
        }
    }
}