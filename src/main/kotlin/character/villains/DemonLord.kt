package character.villains

import character.heroes.Hero

class DemonLord(name: String,) : Villan(name) {
    init {
        this.hp = 70.0 + Math.random()*(100.0-70.0)

    }

    fun darkSword(opponent:Hero){
        attackPower = (20..40).random()
        if (block()){
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Dark Sword on ${opponent.name} and inflicted $attackPower damage.")
        }
    }
    fun hellFlame(opponent:Hero){
        attackPower = (30..55).random()
        if (block()){
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Hell Flame on ${opponent.name} and inflicted $attackPower damage.")
        }
    }
    fun gravityBomb(opponent:Hero){
        attackPower = (15..35).random()
        if (block()){
            println("Attack was blocked! No damage taken.")
        } else {
            super.magicAttack(opponent, attackPower)
            println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted $attackPower damage.")
        }
    }
    fun rulersGrip(opponent:Hero){
        attackPower = (25..35).random()
        if (block()){
            println("Attack was blocked! No damage taken.")
        } else {
            super.swordAttack(opponent, attackPower)
            println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted $attackPower damage.")
        }
    }
    


}