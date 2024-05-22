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


fun chosenAction(
    opponent: Hero, itemBox: ItemBox, companion: Villain, opponents: List<Hero>, companions: List<Villain>,
    abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>>
) {
    println("${opponent.name}'s turn, which attack should be carried out?")
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
fun villainsMove2(companions: MutableList<Villain>, opponents: List<Hero>, itemBox: ItemBox) {
    for (companion in companions)
        chosenAction(opponents[0], itemBox, companion, opponents, companions, companion.abilities)
}

//fun villainsMove(villains: MutableList<Villain>) {
//    for (villain in villains) {
//        chooseAction(villain)
//    }
//}

fun removeTheDead() {
    TODO("Not yet implemented")
}

fun heroesMove(heroes: MutableList<Hero>, villains: MutableList<Villain>) {
    TODO("Not yet implemented")
}

fun removeBuffDebuff() {
    TODO("Not yet implemented")
}

//fun chooseAction(villain: Villain) {
//    println("${villain.name}'s turn, which attack should be carried out?")
//    villain.attacks.forEachIndexed { index, attack ->
//        println("${index + 1} -> $attack")
//    }
//    print("Enter your choice: ")
//    val choice = readln().toIntOrNull()
//    if (choice != null && choice in 1..villain.attacks.size) {
//
//    } else {
//        println("Invalid choice, skipping turn.")
//    }
//
//}

//fun chooseAction2(villain: Villain, attacklist: List<String>) {
//    println("${villain.name}'s turn, which attack should be carried out?")
//    attacklist.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack") }
//    val input = readln()
//    if (input.toIntOrNull() != null && input.toInt() in 1..villain.attacks.size) {
//        when (input) {
//            is 1 -> villain.test[0]
//        }
//    }
//}

//fun executeAttack(villains: MutableList<Villain>) {
//    for (villain in villains) {
//        println("${villain.name}'s turn, which attack should be carried out?")
//        villain.attacks.forEachIndexed { index, attack ->
//            println("${index + 1} -> $attack")
//        }
//
//        print("Enter your choice: ")
//        val choice = readLine()?.toIntOrNull()
//
//        if (choice != null && choice in 1..villain.attacks.size) {
//            val selectedAttack = villain.test[choice - 1]
//            selectedAttack
//        } else {
//            println("Invalid choice, skipping turn.")
//        }
//    }
//}
fun executeAttack2(villains: MutableList<Villain>) {
    for (villain in villains) {
        // Name des Schurken und verfügbare Angriffe ausgeben
        println("${villain.name}'s turn, welcher Angriff soll ausgeführt werden?")
        villain.attacks.forEachIndexed { index, attack ->
            println("${index + 1} -> $attack")
        }

        // Benutzereingabe für die Wahl des Angriffs erhalten
        print("Eingabe: ")
        val choice = readLine()?.toIntOrNull()

        // Validieren und Ausführen des gewählten Angriffs
        if (choice != null && choice in 1..villain.attacks.size) {
            val selectedAttack = villain.attacks[choice - 1]
            selectedAttack
        } else {
            println("Ungültige Eingabe, Zug überspringen.")
        }
    }
}

fun test(villain: Villain) {

}
