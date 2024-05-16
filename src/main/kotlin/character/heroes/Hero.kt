package character.heroes

import character.Character
import character.villains.Villan

open class Hero(override var name: String, hp: Int = 0) : Character() {
    init {
        this.hp = 70.0 + Math.random()*(100.0-70.0)
    }

    open fun swordAttack(opponent: Villan, attackPower:Int) {
            opponent.hp -= attackPower
    }
    open fun magicAttack(opponent:Villan) {
            opponent.hp -= (15..50).random()
    }
    fun heal(opponent:Villan) {
        hp += (15..50).random()
    }
    fun block(): Boolean {
        var blockChance: Double = 0.55 + Math.random()*(0.7-0.55)
        var randomChance = Math.random()
        return randomChance <= blockChance
    }
}