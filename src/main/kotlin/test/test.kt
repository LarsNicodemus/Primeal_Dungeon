package test

import character.heroes.*
import character.villains.*
import itembox.*
import itembox.consumable.HealingPotion
import itembox.consumable.StrengthBooster
import utils.fightRound
import utils.heroMove2
import utils.villainsMove2
import utils.*

//import utils.removeTheDead

//import utils.villainsMove


public fun main() {
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    var savior = Savior()
    val companions: MutableList<Villain> = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    val opponents: MutableList<Hero> = mutableListOf(savior)
    var usedItemBox = false
    var deadOpponents: MutableList<Hero> = mutableListOf()
    var deadCompanions: MutableList<Villain> = mutableListOf()
    fightRound(companions, opponents, itemBox)

}
