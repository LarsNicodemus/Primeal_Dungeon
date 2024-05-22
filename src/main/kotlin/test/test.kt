package test

import character.heroes.*
import character.villains.*
import itembox.*
import itembox.consumable.StrengthBooster
import utils.villainsMove2


public fun main() {
    var itemBox: ItemBox = ItemBox()
    val villains = mutableListOf(DemonLord(), FirstHeavenlyKing(), SecondHeavenlyKing())
    val heroes: MutableList<Hero> = mutableListOf(Savior())

    itemBox.addItem(itemBox.itemBox)
//    itemBox.useItem(villains[0],itemBox.itemBox)

    villainsMove2(villains,heroes,itemBox)

}
