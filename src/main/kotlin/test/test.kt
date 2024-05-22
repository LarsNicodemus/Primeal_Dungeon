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

    demonLord.darkSword(savior)
    secondHeavenlyKing.eternalIce(secondHeavenlyKing)
    savior.holySword(secondHeavenlyKing)

}