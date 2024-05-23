package utils

import character.heroes.Hero
import character.heroes.Savior
import character.heroes.Sidekick
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox
import kotlin.reflect.KFunction4

fun fightRound(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
    ) {
    var round = 1
    while (companions.isNotEmpty() && opponents.isNotEmpty()) {
        roundStart(round)
        villainsMove2(companions, opponents, itemBox)
//        companions.forEach { companion -> println("${companion.shield} ${companion.attackFactor}") }
        heroMove2(companions, opponents)
//        opponents.forEach { opponent -> println("${opponent.shield} ${opponent.attackFactor}") }
        roundEnd(round, companions, opponents)
        round++
    }
}

fun roundStart(round:Int){
    println("########## Round $round ##########")
    println()
}fun roundEnd(round:Int, companions: MutableList<Villain>, opponents: MutableList<Hero>){
    println()
    println("###### End of Round $round ######")
    println()
    println("Villains:")
    companions.forEach { companion -> if (companions.isNotEmpty()) println("${companion.name} has ${roundDouble(companion.hp)} left.")}
    companions.forEach { companion -> if (companion.isCursed) println("${ companion.name } is cursed.") }
    if (companions.isEmpty()) {
        gameEnd(companions,opponents)
    }
    println()
    println("Heroes:")
    opponents.forEach { opponent -> if (opponents.isNotEmpty()) println("${opponent.name} has ${roundDouble(opponent.hp)} left.")}
    if (opponents.isEmpty()) {
        gameEnd(companions,opponents)
    }
    println()
    println("###### End of Round $round ######")

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
    for (companion in companions) {
        if (opponents.isNotEmpty()) {
            chosenAction2(companions, opponents, itemBox, companion)
            companion.decrementBuffRounds()
//            if (companion.buff != null) {
//                companion.removeBuff()
//            }
        } else continue
    }
}

fun chosenAction2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
    companion: Villain
) {
    removeDeadOpponent(opponents)
    println("${companion.name}'s turn, which attack should be carried out?")
    companion.attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack") }
    println("[5] -> ${itemBox.name}")
    var validInput = false
    while (!validInput) {
    val input = readln()
    if (input.toIntOrNull() != null && input.toInt() in 1..companion.attacks.size + 1) {
        validInput = true
        when (input) {
            "1" -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(
                opponents.random()
            ) else if (companion is SecondHeavenlyKing) companion.void(opponents.random())

            "2" -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(
                opponents.random(),
                companion
            ) else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)

            "3" -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(
                companions
            ) else if (companion is SecondHeavenlyKing) companion.bloodArt(opponents.random())

            "4" -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(
                opponents
            ) else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())

            "5" -> itemBox.useItem(companion, itemBox.itemBox)
        }
        println()
        removeDeadOpponent(opponents)
    } else println("Please insert a valid Index!")
    }

}


fun removeTheDead(companions: MutableList<Villain>, opponents: MutableList<Hero>) {
    val deadCompanions = companions.filter { it.hp < 0.0 }.toMutableList()
    companions.removeAll(deadCompanions)
    if (deadCompanions.isNotEmpty()) {
        deadCompanions.forEach { companion -> println("${companion.name} has died.") }
        deadCompanions.removeAll(deadCompanions)
    }
    val deadOpponents = opponents.filter { it.hp < 0.0 }.toMutableList()
    opponents.removeAll(deadOpponents)
    if (deadOpponents.isNotEmpty()) {
        deadOpponents.forEach { opponent -> println("${opponent.name} has died.") }
        deadOpponents.removeAll(deadOpponents)
    }
}

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
        for (opponent in opponentsCopy){
            performHeroAction(opponents, companions)
            opponent.decrementBuffRounds()
        }

    }

}

private fun performHeroAction(opponents: MutableList<Hero>, companions: MutableList<Villain>) {
    if (opponents.isNotEmpty()) {
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

                3 -> if (randomHero is Savior) randomHero.holyHeal(randomHero) else if (randomHero is Sidekick) randomHero.elementalWave(
                    companions
                )

                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
                    opponents.random()
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


