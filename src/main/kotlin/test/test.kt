package test

import character.*
import character.heroes.*
import character.villains.*
import itembox.*
import utils.*

public fun main() {
    var itemBox: MutableList<Item> = mutableListOf()
    var item = StrengthBooster("SBooster")

    var demonLord: DemonLord = DemonLord("Lilith")
    var savior : Savior = Savior("Siegfried")
    var savior2 : Savior = Savior("Theresa")
    var savior3 : Savior = Savior("Berta")
    var firstHeavenlyKing = FirstHeavenlyKing("Jupiter")
    var secondHeavenlyKing = SecondHeavenlyKing("Mercure")


    var sidekick = savior.summoning()
    demonLord.darkSword(sidekick)
    println(sidekick)
    itemBox.add(HealingPotion("HP Potion"))
    itemBox.add(HealingPotion("HP Potion"))
    itemBox.add(StrengthBooster("SBooster"))
    itemBox.add(StrengthBooster("SBooster"))
    itemBox.add(DarknessBomb("DBomb"))
    itemBox.add(DarknessBomb("DBomb"))


    println(itemBox.joinToString { it.name })
    useItems(demonLord,itemBox)
}