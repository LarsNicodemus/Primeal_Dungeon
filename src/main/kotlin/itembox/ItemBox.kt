package itembox

import character.villains.Villain

class ItemBox {
//    unterschiedliche Tränke darstellen
    // als Map, List oder jeden einzeln mit wert speichern.
    var anzahlHeiltraenke: Int = 4
    var anzahlBooster: Int = 4

    fun useHealingPotion(villain: Villain){
 //          if anzahlHeiltraenke >0
    //       villain.hp +=(villain.ursprungsHP/2)
//        anzahlHeiltraenke--
        // else keine Tränke mehr übrig
    }
    fun useBooster(villain: Villain){
        // attackFator: Double = 1.0 (Villain)
        // villain.attackFactor = 1.2
        // in attacken *attackFactor
        anzahlBooster--
    }
}