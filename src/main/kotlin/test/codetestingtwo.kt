package test

import character.heroes.Hero
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox
import utils.chosenAction2
import utils.lowestHPCompanions
import utils.removeDeadOpponent
import utils.threadsleep


//fun villainsMove3(
//    companions: MutableList<Villain>,
//    opponents: MutableList<Hero>,
//    itemBox: ItemBox,
//) {
//    removeDeadOpponent(opponents,)
//    var availableCompanions = companions.toMutableList()
//    var usedItemBox = false
//    if (opponents.isNotEmpty()) {
//        while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
//            println("Which Defender should go next?")
//            threadsleep(5)
//            availableCompanions.forEachIndexed { index, it -> println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
//                threadsleep(5)
//            }
//            println()
//            print("Your Choice: ")
//            val input = readln()
//            try {
//                val villainIndex = input.toInt()
//                if (villainIndex in 1..availableCompanions.size) {
//                    val chosenCompanion = availableCompanions[input.toIntOrNull()!!.minus(1)]
//                    availableCompanions.remove(chosenCompanion)
//                    if (opponents.isNotEmpty()) {
//                        println()
//                        usedItemBox = chosenAction2(availableCompanions, opponents, itemBox, chosenCompanion, usedItemBox)
//                        chosenCompanion.decrementBuffRounds()
//                    } else continue
//                } else println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
//                println()
//                continue
//            } catch (e: NumberFormatException) {
//                println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
//                println()
//            }
//        }
//    }
//}
//fun chosenAction3(companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, companion: Villain, usedItemBox: Boolean): Boolean {
//    removeDeadOpponent(opponents)
//    println("${companion.name}'s turn, which attack should be carried out?")
//    threadsleep(5)
//    companion.attacks.forEachIndexed { index, attack ->
//        println("[${index + 1}] -> $attack")
//        threadsleep(5)
//    }
//    if (!usedItemBox) {
//        println("[${companion.attacks.size + 1}] -> ${itemBox.name}")
//        threadsleep(5)
//    }
//    println()
//
//    var validInput = false
//    while (!validInput) {
//        print("Your Choice: ")
//        val input = readln()
//        println()
//        try {
//            val attackIndex = input.toInt()
//            if (attackIndex in 1..(companion.attacks.size + if (usedItemBox) 0 else 1)) {
//                when (attackIndex) {
//                    1 -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(opponents.random()) else if (companion is SecondHeavenlyKing) companion.void(opponents.random())
//                    2 -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(opponents.random(), lowestHPCompanions(companions + companion)) else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)
//                    3 -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(companions + companion) else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())
//                    4 -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(opponents) else if (companion is SecondHeavenlyKing) companion.originsDoom(opponents.random())
//                    companion.attacks.size + 1 -> if (!usedItemBox) {
//                        itemBox.useItem(companion, itemBox.itemBox)
//                        return true
//                    } else {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                    }
//                }
//                println()
//                removeDeadOpponent(opponents)
//                validInput = true
//            } else {
//                println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + if (usedItemBox) 0 else 1}.")
//            }
//        } catch (e: Exception) {
//            println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + if (usedItemBox) 0 else 1}.")
//        }
//    }
//
//    return usedItemBox
//}
//fun villainsMove3(companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox) {
//    var availableCompanions = companions.toMutableList()
//    var usedItemBox = false
//
//    while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
//        removeDeadOpponent(opponents)
//        displayAvailableCompanions(availableCompanions)
//
//        val chosenCompanion = selectCompanion(availableCompanions)
//        if (chosenCompanion != null) {
//            availableCompanions.remove(chosenCompanion)
//            if (opponents.isNotEmpty()) {
//                println()
//                usedItemBox = chosenAction3(availableCompanions, opponents, itemBox, chosenCompanion, usedItemBox)
//                chosenCompanion.decrementBuffRounds()
//            }
//        } else {
//            println()
//        }
//    }
//}
//
//fun displayAvailableCompanions(availableCompanions: MutableList<Villain>) {
//    println("Which Defender should go next?")
//    threadsleep(5)
//    availableCompanions.forEachIndexed { index, it ->
//        println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
//        threadsleep(5)
//    }
//    println()
//    print("Your Choice: ")
//}
//
//fun selectCompanion(availableCompanions: MutableList<Villain>): Villain? {
//    val input = readln()
//    val villainIndex = input.toIntOrNull()
//
//    if (villainIndex != null && villainIndex in 1..availableCompanions.size) {
//        return availableCompanions[villainIndex - 1]
//    } else {
//        println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
//        return null
//    }
//}
//fun chosenAction3(companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, companion: Villain, usedItemBox: Boolean): Boolean {
//    removeDeadOpponent(opponents)
//    println("${companion.name}'s turn, which attack should be carried out?")
//    threadsleep(5)
//    companion.attacks.forEachIndexed { index, attack ->
//        println("[${index + 1}] -> $attack")
//        threadsleep(5)
//    }
//    if (!usedItemBox) {
//        println("[${companion.attacks.size + 1}] -> ${itemBox.name}")
//        threadsleep(5)
//    }
//    println()
//
//    val maxChoice = companion.attacks.size + if (!usedItemBox) 1 else 0
//    var choice = getValidChoice(maxChoice)
//
//    executeChoice(choice,companion,opponents,companions, maxChoice, usedItemBox, itemBox)
////    when (choice) {
////        1 -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(opponents.random()) else if (companion is SecondHeavenlyKing) companion.void(opponents.random())
////        2 -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(opponents.random(), lowestHPCompanions(companions + companion)) else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)
////        3 -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(companions + companion) else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())
////        4 -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(opponents) else if (companion is SecondHeavenlyKing) companion.bloodArt(opponents.random())
////        maxChoice -> if (!usedItemBox) {
////            val itemUsed = itemBox.useItem(companion, itemBox.itemBox)
////            if (itemUsed) {
////                return true
////            } else return false
////        }
////    }
//    println()
//    removeDeadOpponent(opponents)
//
//    return usedItemBox
//}
//
//fun getValidChoice(maxChoice: Int): Int {
//    while (true) {
//        print("Your Choice: ")
//        val input = readln()
//        println()
//        try {
//            val choice = input.toInt()
//            if (choice in 1..maxChoice) {
//                return choice
//            } else {
//                println("Invalid Input. Please enter a number between 1 and $maxChoice.")
//            }
//        } catch (e: Exception) {
//            println("Invalid Input. Please enter a number between 1 and $maxChoice.")
//        }
//    }
//}
//
//fun executeChoice(choice: Int, companion: Villain, opponents: MutableList<Hero>, companions: MutableList<Villain>, maxChoice: Int,usedItemBox: Boolean,itemBox: ItemBox): Boolean {
//    var localUsedItemBox = usedItemBox
//    while (true) {
//        if (choice in 1..maxChoice || usedItemBox)
//        when (choice) {
//            1 -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(
//                opponents.random()
//            ) else if (companion is SecondHeavenlyKing) companion.void(opponents.random())
//
//            2 -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(
//                opponents.random(),
//                lowestHPCompanions(companions + companion)
//            ) else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)
//
//            3 -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(
//                companions + companion
//            ) else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())
//
//            4 -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(
//                opponents
//            ) else if (companion is SecondHeavenlyKing) companion.bloodArt(opponents.random())
//
//            maxChoice -> if (!usedItemBox) {
//                val itemUsed = itemBox.useItem(companion, itemBox.itemBox)
//                if (itemUsed) {
//                    localUsedItemBox = true
//                    break
//                } else {
//                    localUsedItemBox = false
//                    continue
//                }
//            }
//        }
//    }
//    return localUsedItemBox
//}
////fun villainsMove3(
////    companions: MutableList<Villain>,
////    opponents: MutableList<Hero>,
////    itemBox: ItemBox
////) {
////    var availableCompanions = companions.toMutableList()
////    removeDeadOpponent(opponents)
////    var usedItemBox = false
////    while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
////
////    }
////}
//
////fun chooseCompanion(availableCompanions:  MutableList<Villain>,
////    companions: MutableList<Villain>,
////    opponents: MutableList<Hero>,
////    itemBox: ItemBox,
////    ): Villain {
////    println("Which Defender should go next?")
////    threadsleep(5)
////    println()
////    print("Your Choice: ")
////    val input = readln()
////    try {
////        val villainIndex = input.toInt()
////        if (villainIndex in 1..availableCompanions.size) {
////            val chosenCompanion = availableCompanions[input.toIntOrNull()!!.minus(1)]
////            availableCompanions.remove(chosenCompanion)
////            if (opponents.isNotEmpty()) {
////                println()
////                usedItemBox = chosenAction2(availableCompanions, opponents, itemBox, chosenCompanion, usedItemBox)
////                chosenCompanion.decrementBuffRounds()
////            } else continue
////        } else errorPrint(availableCompanions)
////        println()
////        continue
////    } catch (e: NumberFormatException) {
////        errorPrint(availableCompanions)
////        println()
////    }
////}
////
////fun errorPrint(availableCompanions:  MutableList<Villain>){
////    println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
////}
//fun villainsMove3(opponents: MutableList<Hero>, companions: MutableList<Villain>, itemBox: ItemBox){
//    removeDeadOpponent(opponents)
//    var availableCompanions = companions.toMutableList()
//    var usedItemBox = false
//    while (opponents.isNotEmpty()) {
//        usedItemBox = chooseVillain(companions,opponents,itemBox,availableCompanions,usedItemBox)
//    }
//}
//
//fun chooseVillain(companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, availableCompanions:  MutableList<Villain>, usedItemBox: Boolean): Boolean {
//    var localUsedItemBox = usedItemBox
//    while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
//        println("Which Defender should go next?")
//        threadsleep(5)
//        availableCompanions.forEachIndexed { index, it ->
//            println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
//            threadsleep(5)
//        }
//        println()
//        print("Your Choice: ")
//        val input = readln()
//        try {
//            val villainIndex = input.toInt()
//            if (villainIndex in 1..availableCompanions.size) {
//                val chosenCompanion = availableCompanions[villainIndex - 1]
//                availableCompanions.remove(chosenCompanion)
//                println()
//                localUsedItemBox = chooseAttack(chosenCompanion,opponents,companions,itemBox,localUsedItemBox)
//
//            }
//        } catch (e: NumberFormatException) {
//            println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
//            println()
//        }
//
//    }
//    return localUsedItemBox
//}
//
//    fun chooseAttack(
//        companion: Villain,
//        opponents: MutableList<Hero>,
//        companions: MutableList<Villain>,
//        itemBox: ItemBox,
//        usedItemBox: Boolean
//    ):Boolean {
//        var localUsedItemBox = usedItemBox
//        removeDeadOpponent(opponents)
//        println("${companion.name}'s turn, which attack should be carried out?")
//        threadsleep(5)
//        companion.attacks.forEachIndexed { index, attack ->
//            println("[${index + 1}] -> $attack")
//            threadsleep(5)
//        }
//        if (!localUsedItemBox) {
//            println("[5] -> ${itemBox.name}")
//            threadsleep(5)
//        }
//        println()
//        localUsedItemBox = attackChoice(companion, opponents, companions, itemBox, localUsedItemBox)
//        return localUsedItemBox
//    }
//
//    fun attackChoice(
//        companion: Villain,
//        opponents: MutableList<Hero>,
//        companions: MutableList<Villain>,
//        itemBox: ItemBox,
//        usedItemBox: Boolean
//    ):Boolean {
//        var localUsedItemBox = usedItemBox
//        while (true) {
//            print("Your Choice: ")
//            val input = readln()
//            println()
//            try {
//                var attackIndex = input.toInt()
//                if (attackIndex in 1..companion.attacks.size + 1) {
//                    when (companion) {
//                        is DemonLord -> localUsedItemBox = companionAttack2(
//                            companion,
//                            attackIndex,
//                            opponents,
//                            companions,
//                            itemBox,
//                            localUsedItemBox
//                        )
//
//                        is FirstHeavenlyKing -> localUsedItemBox = companionAttack2(
//                            companion,
//                            attackIndex,
//                            opponents,
//                            companions,
//                            itemBox,
//                            localUsedItemBox
//                        )
//
//                        is SecondHeavenlyKing -> localUsedItemBox =  companionAttack2(
//                            companion,
//                            attackIndex,
//                            opponents,
//                            companions,
//                            itemBox,
//                            localUsedItemBox
//                        )
//                    }
//                    break
//                } else println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
//            } catch (e: Exception) {
//                println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
//            }
//        }
//        return localUsedItemBox
//    }
//
//
//
//
//
//fun companionAttack2(companion: Villain, input: Int, opponents: MutableList<Hero>, companions: MutableList<Villain>, itemBox: ItemBox, usedItemBox: Boolean): Boolean {
//    var  localusedItemBox = usedItemBox
//    while (true) {
//        return when {
//            companion is DemonLord -> {
//                when (input) {
//                    1 -> {
//                        companion.darkSword(opponents.random()); true
//
//                    }
//
//                    2 -> {
//                        companion.hellFlame(opponents.random()); true
//                    }
//
//                    3 -> {
//                        companion.gravityBomb(opponents.random()); true
//                    }
//
//                    4 -> {
//                        companion.rulersGrip(opponents.random()); true
//                    }
//
//                    5 -> if (!localusedItemBox) {
//                        val usedItem = itemBox.useItem(companion, itemBox.itemBox)
//                        if (usedItem) {
//                            true
//                        } else {
//                            continue
//                        }
//
//                    } else {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//
//                    else -> {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//                }
//
//            }
//
//
//            companion is FirstHeavenlyKing -> {
//                when (input) {
//                    1 -> {
//                        companion.bite(opponents.random()); true
//                    }
//
//                    2 -> {
//                        companion.bloodLetting(opponents.random(), lowestHPCompanions(companions)); true
//                    }
//
//                    3 -> {
//                        companion.darkHeal(companions); true
//                    }
//
//                    4 -> {
//                        companion.bloodRain(opponents); true
//                    }
//
//                    5 -> if (!usedItemBox) {
//                        val usedItem = itemBox.useItem(companion, itemBox.itemBox)
//                        if (usedItem) {
//                            true
//                        } else {
//                            continue
//                        }
//                    } else {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//
//                    else -> {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//                }
//            }
//
//            companion is SecondHeavenlyKing -> {
//                when (input) {
//                    1 -> {
//                        companion.void(opponents.random()); true
//                    }
//
//                    2 -> {
//                        companion.eternalIce(companion); true
//                    }
//
//                    3 -> {
//                        companion.chaosBurst(opponents.random()); true
//                    }
//
//                    4 -> {
//                        companion.bloodArt(opponents.random()); true
//                    }
//
//                    5 -> if (!usedItemBox) {
//                        val usedItem = itemBox.useItem(companion, itemBox.itemBox)
//                        if (usedItem) {
//                            true
//                        } else {
//                            continue
//                        }
//                    } else {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//
//                    else -> {
//                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                        continue
//                    }
//                }
//            }
//
//            else -> {
//                println("Invalid companion type.")
//                false
//            }
//        }
//    }
//}
//
//
//    fun companionAttack(
//        companion: Villain,
//        input: Int,
//        opponents: MutableList<Hero>,
//        companions: MutableList<Villain>,
//        itemBox: ItemBox,
//        usedItemBox: Boolean
//    ): Boolean {
//        if (companion is DemonLord) {
//            when (input) {
//                1 -> companion.darkSword(opponents.random())
//                2 -> companion.darkSword(opponents.random())
//                3 -> companion.darkSword(opponents.random())
//                4 -> companion.darkSword(opponents.random())
//                5 -> if (!usedItemBox) {
//                    (itemBox.useItem(companion, itemBox.itemBox))
//                    return !usedItemBox
//                } else {
//                    println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                }
//            }
//        } else if (companion is FirstHeavenlyKing) {
//            when (input) {
//                1 -> companion.bite(opponents.random())
//                2 -> companion.bloodLetting(opponents.random(), lowestHPCompanions(companions))
//                3 -> companion.darkHeal(companions)
//                4 -> companion.bloodRain(opponents)
//                5 -> if (!usedItemBox) {
//                    (itemBox.useItem(companion, itemBox.itemBox))
//                    return !usedItemBox
//                } else {
//                    println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                }
//            }
//        } else if (companion is SecondHeavenlyKing) {
//            when (input) {
//                1 -> companion.void(opponents.random())
//                2 -> companion.eternalIce(companion)
//                3 -> companion.chaosBurst(opponents.random())
//                4 -> companion.bloodArt(opponents.random())
//                5 -> if (!usedItemBox) {
//                    (itemBox.useItem(companion, itemBox.itemBox))
//                    return !usedItemBox
//                } else {
//                    println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//                }
//            }
//        }
//        return usedItemBox
//    }
//
//    fun useItemBox(itemBox: ItemBox, companion: Villain, usedItemBox: Boolean): Boolean {
//        var usedItemBox = usedItemBox
//        if (!usedItemBox) {
//            (itemBox.useItem(companion, itemBox.itemBox))
//            usedItemBox = true
//            return true
//        } else {
//            println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
//        }
//        return usedItemBox
//    }
