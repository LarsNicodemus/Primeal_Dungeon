package itembox

import character.villains.Villain

open class Item(var name: String) {
    var count = 0
    open fun use(villain: Villain) {}

    override fun toString(): String {
        return "Attribute: "
    }
//    unterschiedliche Tränke darstellen
// als Map, List oder jeden einzeln mit wert speichern.
//var anzahlHeiltraenke: Int = 4
//var anzahlBooster: Int = 4
//
//fun useHealingPotion(villain: Villain) {
//    if (anzahlHeiltraenke > 0) {
//        villain.hp += (villain.maxHP / 2)
//        anzahlHeiltraenke--
//    } else println("No healing potions left.")
//
//}
//
//fun useBooster(villain: Villain) {
//    // attackFator: Double = 1.0 (Villain)
//    // villain.attackFactor = 1.2
//    // in attacken *attackFactor
//    anzahlBooster--
//}

}


