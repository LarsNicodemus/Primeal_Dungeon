package test

import character.heroes.Savior
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villan

fun main() {
    var demonLord: DemonLord = DemonLord("Lilith")
    var savior : Savior = Savior("Siegfried")
    var savior2 : Savior = Savior("Theresa")
    var savior3 : Savior = Savior("Berta")
    var firstHeavenlyKing = FirstHeavenlyKing("Jupiter")
    var firstHeavenlyKing2 = SecondHeavenlyKing("Mercure")

//    println(savior.hp)
//    println(firstHeavenlyKing.magicAttack(savior))
//    demonLord.darkSword(savior)
//    demonLord.rulersGrip(savior)
//    demonLord.hellFlame(savior)
//    demonLord.gravityBomb(savior)
//    firstHeavenlyKing.bloodLetting(savior,demonLord)
//    firstHeavenlyKing.bite(savior)
//    firstHeavenlyKing.darkHeal(listOf(demonLord,firstHeavenlyKing2,firstHeavenlyKing))
//    firstHeavenlyKing.bloodRain(listOf(savior,savior2,savior3))
//demonLord.hellFlame(savior)
//    println(savior.hp)

    firstHeavenlyKing2.eternalIce(savior)
    savior.darkSword(firstHeavenlyKing2)

}