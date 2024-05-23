package test

import character.heroes.*
import character.villains.*
import itembox.*
import utils.fightRound
import utils.removeTheDead
//import utils.villainsMove


public fun main() {
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    var savior = Savior()
    var sidekick = Sidekick()
    val villains = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    val heroes: MutableList<Hero> = mutableListOf(savior)
    itemBox.addItem(itemBox.itemBox)
//    fightRound(villains,heroes,itemBox,savior, sidekick = Sidekick(), opponent = Hero())
    fightRound(villains,heroes,itemBox)

}
