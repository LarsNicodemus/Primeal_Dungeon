package test

import character.heroes.*
import character.villains.*
import itembox.*
import utils.fightRound
import utils.villainsMove2

//import utils.removeTheDead

//import utils.villainsMove


public fun main() {
    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val blue = "\u001B[34m"
    val magenta = "\u001B[35m"
    val cyan = "\u001B[36m"
    val bold = "\u001B[1m"
    val underline = "\u001B[4m"
    val backgroundYellow = "\u001B[43m"
    val reset = "\u001B[0m"
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    var savior = Savior()
    val companions = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    val opponents: MutableList<Hero> = mutableListOf(savior)
    var usedItemBox = false
//    itemBox.addItem(itemBox.itemBox)
//    fightRound(villains,heroes,itemBox)
//    roundStart(round = 1)
//    roundEnd(round = 1,villains,heroes)
//    firstHeavenlyKing.bloodLetting(heroes.random(), lowestHPCompanions(villains))
//    villainsMove2(villains,heroes,itemBox)
//    villainsMove2(companions,opponents,itemBox)
//    fightRound(companions, opponents, itemBox, reset, red, green, yellow)
//    chooseAttack(villains.random(),heroes,villains,itemBox,usedItemBox)
//    attackChoice(villains.random(),heroes,villains,itemBox,usedItemBox)
//    firstHeavenlyKing.darkHeal(companions)
    println("""
            $green$bold
            _____.___.               __      __               ._.
            \__  |   | ____  __ __  /  \    /  \____   ____   | |
             /   |   |/  _ \|  |  \ \   \/\/   /  _ \ /    \  | |
             \____   (  <_> )  |  /  \        (  <_> )   |  \  \|
             / ______|\____/|____/    \__/\  / \____/|___|  /  __
             \/                            \/             \/   \/
        $reset
        """.trimIndent())
}
