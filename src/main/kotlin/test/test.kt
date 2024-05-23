package test

import character.heroes.*
import character.villains.*
import itembox.*
import utils.fightRound
import utils.removeTheDead
import utils.roundEnd
import utils.roundStart

//import utils.villainsMove


public fun main() {
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    var savior = Savior()
    val villains = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    val heroes: MutableList<Hero> = mutableListOf(savior)
//    itemBox.addItem(itemBox.itemBox)
    fightRound(villains,heroes,itemBox)
//    roundStart(round = 1)
//    roundEnd(round = 1,villains,heroes)

}
