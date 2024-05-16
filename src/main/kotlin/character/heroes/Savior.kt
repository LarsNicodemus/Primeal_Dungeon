package character.heroes

import character.villains.Villain

class Savior(name: String) : Hero(name) {
    init {
        this.hp = 70.0 + Math.random() * (100.0 - 70.0)
    }

    fun darkSword(opponent: Villain) {
        attackPower = (20..40).random()
        if (opponent.shield > 0) {
            println("Attack was blocked! No damage taken.")

        } else {

            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted $attackPower damage.")
        }
    }
}