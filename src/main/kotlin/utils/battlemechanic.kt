package utils

import character.heroes.Hero
import character.heroes.Savior
import character.heroes.Sidekick
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox

fun fightRound(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
) {
    var round = 1
    while (companions.isNotEmpty() && opponents.isNotEmpty()) {
        roundStart(round)
//        println(companions.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp )})
//        println(opponents.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp ) })
        villainsMove2(companions, opponents, itemBox)
//        println(companions.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp ) })
//        println(opponents.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp ) })
        heroMove2(companions, opponents)
//        println(companions.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp ) })
//        println(opponents.joinToString("][","[","]") { it.name +" "+ roundDouble( it.hp ) })
        roundEnd(round, companions, opponents)
        round++
    }
}

fun roundStart(round: Int) {
    threadsleep(4)
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    printlnWithDelay("########## Round $round ##########",15)
    threadsleep(4)
    println()
    println()
    println()
}

fun roundEnd(round: Int, companions: MutableList<Villain>, opponents: MutableList<Hero>) {
    threadsleep(4)
    println()
    threadsleep(4)
    printlnWithDelay("###### End of Round $round ######",15)
    threadsleep(4)
    println()
    println("Villains:")
    threadsleep(4)
    companions.forEach { companion ->
        if (companions.isNotEmpty()) printlnWithDelay(
            "${companion.name} has ${
                roundDouble(
                    companion.hp
                )
            } left."
        ,25)
    }
    companions.forEach { companion -> if (companion.isCursed) printlnWithDelay("${companion.name} is cursed.",25) }
    if (companions.isEmpty()) {
        gameEnd(companions, opponents)
    }
    println()
    threadsleep(4)
    println("Heroes:")
    opponents.forEach { opponent -> if (opponents.isNotEmpty()) printlnWithDelay("${opponent.name} has ${roundDouble(opponent.hp)} left.",25) }
    if (opponents.isEmpty()) {
        gameEnd(companions, opponents)
    }
    println()
    threadsleep(4)
    println("###### End of Round $round ######")
    threadsleep(4)
    println()
    println()
    println()
    println()

}
//        gameEnd(companions, opponents)
//        var buffDebuffRoundVillain = 1
//        var buffDebuffRoundHero = 1
//        var buffDebuffRound = 0
//        villainsMove(companions, opponents, itemBox, buffDebuffRoundVillain)
//        heroesMove(savior, sidekick, companions, opponents, buffDebuffRoundHero)
//        removeBuffDebuff(companions, opponents, buffDebuffRound)
//        buffDebuffRoundVillain++
//        buffDebuffRoundHero++


//fun villainsMove(
//    companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, buffDebuffRound: Int
//) {
//    for (companion in companions) {
//        if (opponents.isNotEmpty()) {
//            companion.decrementBuffRounds()
//            removeTheDead(companions, opponents)
//            gameEnd(companions, opponents)
//            chosenAction(opponents.random(), itemBox, companion, opponents, companions, companion.abilities)
//        } else gameEnd(companions,opponents)
//    }
//}
//
//fun chosenAction(
//    opponent: Hero,
//    itemBox: ItemBox,
//    companion: Villain,
//    opponents: List<Hero>,
//    companions: List<Villain>,
//    abilities: List<KFunction4<Hero, Villain, List<Villain>, List<Hero>, Unit>>
//) {
//    println("${companion.name}'s turn, which attack should be carried out?")
//    companion.attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack") }
//    println("[5] -> ${itemBox.name}")
//    val input = readln()
//    if (input.toIntOrNull() != null && input.toInt() in 1..companion.attacks.size + 1) {
//        when (input) {
//            "1" -> abilities[0](opponent, companion, companions, opponents)
//            "2" -> abilities[1](opponent, companion, companions, opponents)
//            "3" -> abilities[2](opponent, companion, companions, opponents)
//            "4" -> abilities[3](opponent, companion, companions, opponents)
//            "5" -> itemBox.useItem(companion, itemBox.itemBox)
//            else -> chosenAction(opponent, itemBox, companion, opponents, companions, abilities)
//        }
//    }
//}

fun villainsMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
//    buffDebuffRound: Int
) {
    var avaliableCompanions = companions.toMutableList()
    removeDeadOpponent(opponents)

    while (avaliableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
    if (opponents.isNotEmpty()) {
        printlnWithDelay("Which Defender should go next?",15)
        threadsleep(5)
        avaliableCompanions.forEachIndexed { index, it -> println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
        threadsleep(5)
        }
        println()
        printWithDelay("Your Choice: ",15)
        var input = readln()
        println()
        try {
        var villainIndex = input.toInt()
            if (villainIndex in 1..avaliableCompanions.size) {
                var chosenCompanion = avaliableCompanions[input.toIntOrNull()!!.minus(1)]
                avaliableCompanions.remove(chosenCompanion)
                if (opponents.isNotEmpty()) {
                    chosenAction2(avaliableCompanions, opponents, itemBox, chosenCompanion)
                    chosenCompanion.decrementBuffRounds()
                } else continue
            } else println("Invalid Input. Please enter a number between 1 and ${avaliableCompanions.size}.")
            continue
        } catch (e: NumberFormatException) {
            println("Invalid Input. Please enter a number between 1 and ${avaliableCompanions.size}.")
        }
    }
    }
}

fun chosenAction2(
    companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, companion: Villain) {
    removeDeadOpponent(opponents)
    printlnWithDelay("${companion.name}'s turn, which attack should be carried out?",15)
    threadsleep(5)
    companion.attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack")
    threadsleep(5)
    }
    println("[5] -> ${itemBox.name}")
    threadsleep(5)


    println()
    printWithDelay("Your Choice: ",15)
    do  {
        val input = readln()
        println()
        try {
            var attackIndex = input.toInt()
            if (attackIndex in 1..companion.attacks.size + 1) {
                when (input) {
                    "1" -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(
                        opponents.random()
                    )
                    else if (companion is SecondHeavenlyKing) companion.void(opponents.random())

                    "2" -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(
                        opponents.random(),
                        lowestHPCompanions(companions)
                    )
                    else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)

                    "3" -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(
                        companions
                    )
                    else if (companion is SecondHeavenlyKing) companion.bloodArt(opponents.random())

                    "4" -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(
                        opponents
                    )
                    else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())

                    "5" -> if (itemBox.useItem(companion, itemBox.itemBox))
                        else {
                        printWithDelay("ItemBox closed, which attack should be carried out?",15)
                        continue
                    }
                }
                println()
                removeDeadOpponent(opponents)
                break
            } else {
                println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
                continue
            }
        } catch (e: Exception) {
            println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
        }
    } while (true)
}


//fun Villain.attack(attackIndex: Int, target: Hero, opponents: MutableList<Hero>, companions: MutableList<Villain>) {
//    when (this) {
//        is DemonLord -> when (attackIndex) {
//            1 -> darkSword(target)
//            2 -> hellFlame(target)
//            3 -> gravityBomb(target)
//            4 -> rulersGrip(target)
//        }
//
//        is FirstHeavenlyKing -> when (attackIndex) {
//            1 -> bite(target)
//            2 -> bloodLetting(target, this)
//            3 -> darkHeal(companions)
//            4 -> bloodRain(opponents)
//        }
//
//        is SecondHeavenlyKing -> when (attackIndex) {
//            1 -> void(target)
//            2 -> eternalIce(this)
//            3 -> bloodArt(target)
//            4 -> chaosBurst(target)
//        }
//    }
//}


//fun removeTheDead(companions: MutableList<Villain>, opponents: MutableList<Hero>) {
//    val deadCompanions = companions.filter { it.hp < 0.0 }.toMutableList()
//    companions.removeAll(deadCompanions)
//    if (deadCompanions.isNotEmpty()) {
//        deadCompanions.forEach { companion -> println("${companion.name} has died.") }
//        deadCompanions.removeAll(deadCompanions)
//    }
//    val deadOpponents = opponents.filter { it.hp < 0.0 }.toMutableList()
//    opponents.removeAll(deadOpponents)
//    if (deadOpponents.isNotEmpty()) {
//        deadOpponents.forEach { opponent -> println("${opponent.name} has died.") }
//        deadOpponents.removeAll(deadOpponents)
//    }
//}

fun removeDeadVillain(companions: MutableList<Villain>) {
    val deadCompanions = companions.filter { it.hp < 0.0 }.toMutableList()
    companions.removeAll(deadCompanions)
    if (deadCompanions.isNotEmpty()) {
        deadCompanions.forEach { companion -> println("${companion.name} has died.") }
    }
}

fun removeDeadOpponent(opponents: MutableList<Hero>) {
    val deadOpponents = opponents.filter { it.hp < 0.0 }.toMutableList()
    opponents.removeAll(deadOpponents)
    if (deadOpponents.isNotEmpty()) {
        deadOpponents.forEach { opponent -> println("${opponent.name} has died.") }
    }
}


fun gameEnd(companions: MutableList<Villain>, opponents: MutableList<Hero>): Boolean {
    if (companions.isEmpty()) {
        println("All Villians died during Battle. you lost!!")
        return true
    } else if (opponents.isEmpty()) {
        println("All Heroes died during Battle. you won!!")
        return true
    } else {
        return false
    }
}

fun heroMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
//    buffDebuffRound: Int
) {
    if (companions.isNotEmpty()) {
        val opponentsCopy = opponents.toMutableList()
        for (opponent in opponentsCopy) {
            performHeroAction(opponents, companions)
            opponent.decrementBuffRounds()
        }

    }

}

fun performHeroAction(opponents: MutableList<Hero>, companions: MutableList<Villain>) {
    if (opponents.isNotEmpty()&& companions.isNotEmpty()) {
        var randomHero: Hero = opponents.random()

        val random = when (randomHero) {
            is Savior -> (1..6).random()
            is Sidekick -> (1..4).random()
            else -> throw IllegalArgumentException("Unknown hero type")
        }
        if (!anyVillainIsCursed(companions) && opponents.size == 1) {
            when (random) {
                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
                    companions.random()
                )

                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
                    companions.random()
                )

                3 -> if (randomHero is Savior) randomHero.holyHeal(opponents[0]) else if (randomHero is Sidekick) randomHero.elementalWave(
                    companions
                )

                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
                    opponents[0]
                )

                5 -> if (randomHero is Savior) randomHero.sacredCommand(companions)
                6 -> if (randomHero is Savior) randomHero.summoning(opponents)
            }
            println()
        } else if (!anyVillainIsCursed(companions) && opponents.size > 1) {
            when (random) {
                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
                    companions.random()
                )

                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
                    companions.random()
                )

                3 -> if (randomHero is Savior) randomHero.holyHeal(randomHero) else if (randomHero is Sidekick) randomHero.elementalWave(
                    companions
                )

                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
                    opponents.random()
                )

                5 -> if (randomHero is Savior) randomHero.sacredCommand(companions)
                6 -> (1..5).random()
            }
            println()
        } else {
            when (random) {
                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
                    companions.random()
                )

                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
                    companions.random()
                )

                3 -> if (randomHero is Savior) randomHero.holyHeal(randomHero) else if (randomHero is Sidekick) randomHero.elementalWave(
                    companions
                )

                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
                    opponents.random()
                )

                5 -> (1..6).random()
                6 -> if (randomHero is Savior) randomHero.summoning(opponents)
            }
            println()

        }
        removeDeadVillain(companions)
    }
}

private fun anyVillainIsCursed(villains: MutableList<Villain>): Boolean {
    for (villain in villains) {
        if (villain.isCursed) {
            return true
        }
    }
    return false
}


fun heroesMove(
    savior: Savior,
    sidekick: Sidekick = Sidekick(),
    villains: MutableList<Villain>,
    heroes: MutableList<Hero>,
    buffDebuffRound: Int
) {
    for (companion in villains) {
        if (!companion.isCursed) {
            if (heroes.size == 1) {
                var randomHero: Hero = heroes.random()
                println()
                if (randomHero == savior) {
                    var random = (1..6).random()
                    when (random) {
                        1 -> savior.holySword(villains.random())
                        2 -> savior.holyShield(savior)
                        3 -> savior.holyHeal(savior)
                        4 -> savior.sacredCommand(villains)
                        5 -> savior.holyLight(villains)
                        6 -> savior.summoning(heroes)
                    }
                } else if (randomHero == sidekick) {
                    var random = (1..4).random()
                    when (random) {
                        1 -> sidekick.elementalArrow(villains.random())
                        2 -> sidekick.holyHeal(savior)
                        3 -> sidekick.elementalBeam(villains.random())
                        4 -> sidekick.elementalWave(villains)
                    }
                }
                println()
            } else {
                var randomHero: Hero = heroes.random()
                println()
                if (randomHero == savior) {
                    var random = (1..5).random()
                    when (random) {
                        1 -> savior.holySword(villains.random())
                        2 -> savior.holyShield(savior)
                        3 -> savior.holyHeal(savior)
                        4 -> savior.sacredCommand(villains)
                        5 -> savior.holyLight(villains)
                    }
                } else if (randomHero == sidekick) {
                    var random = (1..4).random()
                    when (random) {
                        1 -> sidekick.elementalArrow(villains.random())
                        2 -> sidekick.holyHeal(savior)
                        3 -> sidekick.elementalBeam(villains.random())
                        4 -> sidekick.elementalWave(villains)
                    }
                }
                println()
            }
        } else {
            if (heroes.size == 1) {
                var randomHero: Hero = heroes.random()
                println()
                if (randomHero == savior) {
                    var random = (1..5).random()
                    when (random) {
                        1 -> savior.holySword(villains.random())
                        2 -> savior.holyShield(savior)
                        3 -> savior.holyHeal(savior)
                        4 -> savior.holyLight(villains)
                        5 -> savior.summoning(heroes)
                    }
                } else if (randomHero == sidekick) {
                    var random = (1..4).random()
                    when (random) {
                        1 -> sidekick.elementalArrow(villains.random())
                        2 -> sidekick.holyHeal(savior)
                        3 -> sidekick.elementalBeam(villains.random())
                        4 -> sidekick.elementalWave(villains)
                    }
                }
                println()
            } else {
                var randomHero: Hero = heroes.random()
                println()
                if (randomHero == savior) {
                    var random = (1..4).random()
                    when (random) {
                        1 -> savior.holySword(villains.random())
                        2 -> savior.holyShield(savior)
                        3 -> savior.holyHeal(savior)
                        4 -> savior.holyLight(villains)
                    }
                } else if (randomHero == sidekick) {
                    var random = (1..4).random()
                    when (random) {
                        1 -> sidekick.elementalArrow(villains.random())
                        2 -> sidekick.holyHeal(savior)
                        3 -> sidekick.elementalBeam(villains.random())
                        4 -> sidekick.elementalWave(villains)
                    }
                }
                println()
            }
        }
    }
}
//mutableListOf(savior, sidekick).random()

//    for (hero in heroes) {
//        var random = (1..6).random()
//        when (random) {
//            1 ->
//        }
//
//        }
//
//}

//fun removeBuffDebuff(companions: MutableList<Villain>, opponents: MutableList<Hero>, buffDebuffRound: Int) {
//    for (companion in companions) {
//        return if (buffDebuffRound > 1) {
//            println("All Buffs and Debuffs have been reset.")
//            companion.shield = 0
//            companion.attackFactor = 1.0
//        } else {
//            continue
//        }
//    }
//    for (opponent in opponents) {
//        return if (buffDebuffRound > 1) {
//            println("All Buffs and Debuffs have been reset.")
//            opponent.shield = 0
//            opponent.attackFactor = 1.0
//        } else {
//            continue
//        }
//    }
//}


