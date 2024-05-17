package test

import character.heroes.Savior
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing

fun main() {
    var demonLord: DemonLord = DemonLord("Lilith")
    var savior : Savior = Savior("Siegfried")
    var savior2 : Savior = Savior("Theresa")
    var savior3 : Savior = Savior("Berta")
    var firstHeavenlyKing = FirstHeavenlyKing("Jupiter")
    var secondHeavenlyKing = SecondHeavenlyKing("Mercure")


    var sidekick = savior.summoning()

    println(demonLord)
    savior.curse(listOf(demonLord))
    println(demonLord)
    savior.curse(listOf(demonLord))
    savior.curse(listOf(demonLord))
    println(demonLord)

}