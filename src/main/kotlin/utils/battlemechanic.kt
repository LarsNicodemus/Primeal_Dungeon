package utils

import character.heroes.Hero
import character.villains.Villain
import itembox.ItemBox
import kotlin.reflect.KFunction4

fun fightRound() {
//    villainsMove()
//    heroesMove()
    removeBuffDebuff()
    removeTheDead()
}
fun villainsMove(companions: MutableList<Villain>, opponents: List<Hero>, itemBox: ItemBox) {
    for (companion in companions)
        chosenAction(opponents[0], itemBox, companion, opponents, companions, companion.abilities)
}

fun chosenAction(
    opponent: Hero, itemBox: ItemBox, companion: Villain, opponents: List<Hero>, companions: List<Villain>,
    abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>>
) {
    println("${companion.name}'s turn, which attack should be carried out?")
    companion.attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack") }
    println("[5] -> ${itemBox.name}")
    val input = readln()
    if (input.toIntOrNull() != null && input.toInt() in 1..companion.attacks.size + 1) {
        when (input) {
            "1" -> abilities[0](opponent, companion, companions, opponents)
            "2" -> abilities[1](opponent, companion, companions, opponents)
            "3" -> abilities[2](opponent, companion, companions, opponents)
            "4" -> abilities[3](opponent, companion, companions, opponents)
            "5" -> itemBox.useItem(companion, itemBox.itemBox)
            else -> chosenAction(opponent, itemBox, companion, opponents, companions, abilities)
        }
    }
}


fun removeTheDead() {
    TODO("Not yet implemented")
}

fun heroesMove(heroes: MutableList<Hero>, villains: MutableList<Villain>) {

}

fun removeBuffDebuff() {
    TODO("Not yet implemented")
}


