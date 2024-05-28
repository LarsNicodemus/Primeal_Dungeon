package character.heroes
import character.Character
import character.villains.Villain
import utils.*

/**The Sidekick Class is child to Hero and the support antagonist.
 * @constructor creates a Sidekick with a random name from a list of names
 * @see Hero
 * @see Character
 * */

class Sidekick(name: String = randomHeroineName()) : Hero(name) {
//    override fun toString(): String {
//        return """
//            Sidekick $name
//            Health Points ${roundDouble(hp)}
//            Attack Power ${roundDouble(attackPower)}
//        """.trimIndent()
//    }
    init {
    this.hp = randomDouble(70.0, 100.0)
    this.maxHP = hp
    }

    fun elementalArrow(opponent: Villain){
        println("""
            
            ▄▄▄ .▄▄▌  ▄▄▄ .• ▌ ▄ ·. ▄▄▄ . ▐ ▄ ▄▄▄▄▄ ▄▄▄· ▄▄▌       ▄▄▄· ▄▄▄  ▄▄▄        ▄▄▌ ▐ ▄▌
            ▀▄.▀·██•  ▀▄.▀··██ ▐███▪▀▄.▀·•█▌▐█•██  ▐█ ▀█ ██•      ▐█ ▀█ ▀▄ █·▀▄ █·▪     ██· █▌▐█
            ▐▀▀▪▄██▪  ▐▀▀▪▄▐█ ▌▐▌▐█·▐▀▀▪▄▐█▐▐▌ ▐█.▪▄█▀▀█ ██▪      ▄█▀▀█ ▐▀▀▄ ▐▀▀▄  ▄█▀▄ ██▪▐█▐▐▌
            ▐█▄▄▌▐█▌▐▌▐█▄▄▌██ ██▌▐█▌▐█▄▄▌██▐█▌ ▐█▌·▐█ ▪▐▌▐█▌▐▌    ▐█ ▪▐▌▐█•█▌▐█•█▌▐█▌.▐▌▐█▌██▐█▌
             ▀▀▀ .▀▀▀  ▀▀▀ ▀▀  █▪▀▀▀ ▀▀▀ ▀▀ █▪ ▀▀▀  ▀  ▀ .▀▀▀      ▀  ▀ .▀  ▀.▀  ▀ ▀█▄▀▪ ▀▀▀▀ ▀▪

        """.trimIndent())
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Attack was blocked! No damage taken.",15)
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Sidekick $name used elemental Arrow on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }
    fun holyHeal(companion: Hero) {
        println("""
            
             ▄ .▄      ▄▄▌   ▄· ▄▌     ▄ .▄▄▄▄ . ▄▄▄· ▄▄▌  
            ██▪▐█▪     ██•  ▐█▪██▌    ██▪▐█▀▄.▀·▐█ ▀█ ██•  
            ██▀▐█ ▄█▀▄ ██▪  ▐█▌▐█▪    ██▀▐█▐▀▀▪▄▄█▀▀█ ██▪  
            ██▌▐▀▐█▌.▐▌▐█▌▐▌ ▐█▀·.    ██▌▐▀▐█▄▄▌▐█ ▪▐▌▐█▌▐▌
            ▀▀▀ · ▀█▄▀▪.▀▀▀   ▀ •     ▀▀▀ · ▀▀▀  ▀  ▀ .▀▀▀ 

        """.trimIndent())
        healPower *= nextRandomDouble(0.8, 1.2) * attackFactor
        super.heal(companion, healPower)
        printlnWithDelay("Sidekick $name used Holy Heal on ${companion.name} and restored ${roundDouble(healPower)} points to a total of ${roundDouble(companion.hp) } Health points.",15)
    }

    fun elementalBeam(opponent: Villain) {
        println("""
            
            ▄▄▄ .▄▄▌  ▄▄▄ .• ▌ ▄ ·. ▄▄▄ . ▐ ▄ ▄▄▄▄▄ ▄▄▄· ▄▄▌      ▄▄▄▄· ▄▄▄ . ▄▄▄· • ▌ ▄ ·. 
            ▀▄.▀·██•  ▀▄.▀··██ ▐███▪▀▄.▀·•█▌▐█•██  ▐█ ▀█ ██•      ▐█ ▀█▪▀▄.▀·▐█ ▀█ ·██ ▐███▪
            ▐▀▀▪▄██▪  ▐▀▀▪▄▐█ ▌▐▌▐█·▐▀▀▪▄▐█▐▐▌ ▐█.▪▄█▀▀█ ██▪      ▐█▀▀█▄▐▀▀▪▄▄█▀▀█ ▐█ ▌▐▌▐█·
            ▐█▄▄▌▐█▌▐▌▐█▄▄▌██ ██▌▐█▌▐█▄▄▌██▐█▌ ▐█▌·▐█ ▪▐▌▐█▌▐▌    ██▄▪▐█▐█▄▄▌▐█ ▪▐▌██ ██▌▐█▌
             ▀▀▀ .▀▀▀  ▀▀▀ ▀▀  █▪▀▀▀ ▀▀▀ ▀▀ █▪ ▀▀▀  ▀  ▀ .▀▀▀     ·▀▀▀▀  ▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀

        """.trimIndent())
        attackPower = actualAttackPower(attackPower, attackFactor)
        if (opponent.shield > 0) {
            printlnWithDelay("Sidekick $name tried to use Elemental Beam on ${opponent.name}, attack was blocked! No damage taken.",15)
        } else {
            super.magicAttack(opponent, attackPower)
            printlnWithDelay("Sidekick $name used Elemental Beam on ${opponent.name} and inflicted ${roundDouble(attackPower)} damage. ${hpLeft(opponent.hp)} Health Points left.",15)
        }
    }

    fun elementalWave(opponent: List<Villain>) {
        println("""
            
            ▄▄▄ .▄▄▌  ▄▄▄ .• ▌ ▄ ·. ▄▄▄ . ▐ ▄ ▄▄▄▄▄ ▄▄▄· ▄▄▌      ▄▄▌ ▐ ▄▌ ▄▄▄·  ▌ ▐·▄▄▄ .
            ▀▄.▀·██•  ▀▄.▀··██ ▐███▪▀▄.▀·•█▌▐█•██  ▐█ ▀█ ██•      ██· █▌▐█▐█ ▀█ ▪█·█▌▀▄.▀·
            ▐▀▀▪▄██▪  ▐▀▀▪▄▐█ ▌▐▌▐█·▐▀▀▪▄▐█▐▐▌ ▐█.▪▄█▀▀█ ██▪      ██▪▐█▐▐▌▄█▀▀█ ▐█▐█•▐▀▀▪▄
            ▐█▄▄▌▐█▌▐▌▐█▄▄▌██ ██▌▐█▌▐█▄▄▌██▐█▌ ▐█▌·▐█ ▪▐▌▐█▌▐▌    ▐█▌██▐█▌▐█ ▪▐▌ ███ ▐█▄▄▌
             ▀▀▀ .▀▀▀  ▀▀▀ ▀▀  █▪▀▀▀ ▀▀▀ ▀▀ █▪ ▀▀▀  ▀  ▀ .▀▀▀      ▀▀▀▀ ▀▪ ▀  ▀ . ▀   ▀▀▀ 

        """.trimIndent())
        var unblockedOpponents = opponent.filter { it.shield <= 0 }
        var blockedOpponents = opponent.filter { it.shield > 0 }
        attackPower = actualAttackPower(attackPower,attackFactor)
        if (unblockedOpponents.isNotEmpty()) {
            var totalDamage = unblockedOpponents.sumOf {
                super.magicAttack(it, attackPower)
                attackPower
            }
            printlnWithDelay("Sidekick $name used elemental Wave on ${unblockedOpponents.joinToString { it.name }} and inflicted ${roundDouble(totalDamage)} total damage and ${roundDouble(attackPower)} to each. ${unblockedOpponents.joinToString(", ","",".") { it.name +" "+ hpLeft(roundDouble(it.hp)) +" Health Points left" }}",15)
            printlnWithDelay(if (blockedOpponents.isNotEmpty()) "${blockedOpponents.joinToString { it.name }} blocked and took no Damage." else "",15)
        } else printlnWithDelay("All attacks were blocked! No damage taken.",15)
    }

}