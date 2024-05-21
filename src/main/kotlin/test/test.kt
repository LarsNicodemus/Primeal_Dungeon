package test

import character.heroes.*
import character.villains.*
import itembox.*
import itembox.consumable.StrengthBooster


public fun main() {
    var beutel: ItemBox = ItemBox()
    var item = StrengthBooster()

    var demonLord: DemonLord = DemonLord()
    var savior : Savior = Savior()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    var sidekick1 = savior.summoning()
    var sidekick2 = savior.summoning()

    println(demonLord)
    println(savior)
    println(firstHeavenlyKing)
    println(secondHeavenlyKing)
    println(sidekick1)
    println(sidekick2)
//    demonLord.darkSword(sidekick)
//    println(demonLord.hp)
//    println(demonLord.mp)
//    println(sidekick)
//    getItems(itemBox)
//    itemBox.add(HealingPotion("HP Potion"))
//    itemBox.add(HealingPotion("HP Potion"))
//    itemBox.add(StrengthBooster("SBooster"))
//    itemBox.add(StrengthBooster("SBooster"))
//    itemBox.add(DarknessBomb("DBomb"))
//    itemBox.add(DarknessBomb("DBomb"))
//    println(itemBox.joinToString { it.name })
//    useItems(demonLord,itemBox)
//    useItems(demonLord,itemBox)
//    useItems(demonLord,itemBox)
//    addItem(itemBox)
//    getItems(itemBox)
//    beutel.addItem(beutel.itemBox)
//    beutel.useItem(demonLord,beutel.itemBox)
//    demonLord.useItemBox(beutel,demonLord)
}