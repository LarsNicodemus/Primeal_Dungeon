package character.heroes

import character.Character
import character.villains.Villain

open class Hero(override var name: String, hp: Int = 0) : Character() {
    init {
        this.hp = 70.0 + Math.random() * (100.0 - 70.0)
    }

    override var shield: Int = 0
    open fun swordAttack(opponent: Villain, attackPower: Int) {
        opponent.hp -= attackPower
    }

    open fun magicAttack(opponent: Villain) {
        opponent.hp -= (15..50).random()
    }

    fun heal(opponent: Villain) {
        hp += (15..50).random()
    }

    fun block(companion: Hero): Boolean {
        var blockChance: Double = 0.55 + Math.random() * (0.7 - 0.55)
        var randomChance = Math.random()
        return if (randomChance <= blockChance) {
            companion.shield = 1
            true
        } else {
            companion.shield = 0
            false
        }
    }
}