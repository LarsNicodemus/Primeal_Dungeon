package character.villains

import character.heroes.Hero

class SecondHeavenlyKing(name: String) : Villan(name) {
    init {
        this.hp = 70.0 + Math.random()*(100.0-70.0)
    }
    fun void(opponent:List<Hero>){
        attackPower = (10..30).random()
        opponent.forEach { super.magicAttack(it,attackPower) }
        println("Second Heavenly King $name used Void on ${opponent.joinToString(", ") { it.name }} and inflicted $attackPower damage to each.")
    }
    fun eternalIce(opponent:Hero){
        if (super.block()){
            println("Second Heavenly King $name used Eternal Ice to block the next attack.")
            super.block()
        } else println("Second Heavenly King $name tried to used Eternal Ice but it failed.")

    }
    fun gravityBomb(opponent:Hero){
        attackPower = (15..35).random()
        super.magicAttack(opponent, attackPower)
        println("Demonlord $name used Gravity Bomb on ${opponent.name} and inflicted $attackPower damage.")
    }
    fun rulersGrip(opponent:Hero){
        attackPower = (25..35).random()
        super.swordAttack(opponent, attackPower)
        println("Demonlord $name used Ruler's Grip on ${opponent.name} and inflicted $attackPower damage.")
    }

}