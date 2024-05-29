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
    itemBox: ItemBox
) {
    var round = 1
    val deadCompanions: MutableList<Villain> = mutableListOf()
    val deadOpponents: MutableList<Hero> = mutableListOf()

    while (companions.isNotEmpty() && opponents.isNotEmpty()) {
        roundStart(round)
        villainsMove2(companions, opponents, itemBox, deadOpponents)
        dot(anyVillainIsCursed(companions), companions)
        heroMove2(companions, opponents, deadCompanions, deadOpponents)
        roundEnd(round, companions, opponents)
        anyVillainIsCursed(companions)
        round++
    }

}

fun roundStart(round: Int) {
    threadsleep(4)
    println()
    println()
    threadsleep(4)
    roundStartArt(round)
    threadsleep(4)
    println()
    println()
    threadsleep(4)
}

fun roundEnd(
    round: Int,
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>
) {
    threadsleep(4)
    println()
    println()
    threadsleep(4)
    roundEndArt(round)
    println()
    threadsleep(4)
    println("Villains:")
    threadsleep(4)
    companions.forEach { companion ->
        if (companions.isNotEmpty()) println(
            "${
                colorChoice(
                    companion,
                    red,
                    green,
                    yellow
                )
            }${companion.name} has ${roundDouble(companion.hp)} left.${reset}"
        )
    }
    companions.forEach { companion ->
        if (companion.isCursed) println("${companion.name} is cursed.")
        threadsleep(4)
    }
    if (companions.isEmpty()) {
        gameEnd(companions, opponents, red, reset, green, bold)
    }
    println()
    threadsleep(4)
    println("Heroes:")
    opponents.forEach { opponent ->
        if (opponents.isNotEmpty()) println(
            "${
                colorChoice(
                    opponent,
                    red,
                    green,
                    yellow
                )
            }${opponent.name} has ${roundDouble(opponent.hp)} left.${reset}"
        )
        threadsleep(4)
    }
    if (opponents.isEmpty()) {
        gameEnd(companions, opponents, red, reset, green, bold)
    }
    println()
    threadsleep(4)
}

fun villainsMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
    deadOpponents: MutableList<Hero>
) {
    removeDeadOpponent(opponents, deadOpponents)
    var activeCompanions = companions.toMutableList()
    var usedItemBox = false
    if (opponents.isNotEmpty()) {
        while (activeCompanions.isNotEmpty() && opponents.isNotEmpty()) {
            println("Which Defender should go next?")
            threadsleep(5)
            showCompanionOptions(activeCompanions)
            println()
            print("Your Choice: ")
            val input = readln()
            try {
                val companionIndex = input.toInt()
                if (companionIndex in 1..activeCompanions.size) {
                    val chosenCompanion = activeCompanions[companionIndex - 1]
                    activeCompanions.remove(chosenCompanion)
                    if (opponents.isNotEmpty()) {
                        println()
                        usedItemBox =
                            chosenAction2(companions, opponents, itemBox, chosenCompanion, usedItemBox, deadOpponents)
                        chosenCompanion.decrementBuffRounds()
                        opponents.forEach { opponent ->
                            if (opponent is Savior) {
                                if (opponent.blockCounter > 0) {
                                    !opponent.block(opponent)
                                    opponent.decrementBuffRounds()
                                }
                            }
                        }
                    } else continue
                } else println("Invalid Input. Please enter a number between 1 and ${activeCompanions.size}.")
                println()
                continue
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number between 1 and ${activeCompanions.size}.")
                println()
            }


        }
    }
}

fun chosenAction2(
    companions: List<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
    companion: Villain,
    usedItemBox: Boolean,
    deadOpponents: MutableList<Hero>
): Boolean {
    removeDeadOpponent(opponents, deadOpponents)
    println("${companion.name}'s turn, which attack should be carried out?")
    threadsleep(5)
    showAttackOptions(companion, usedItemBox, itemBox)
    println()
    while (true) {
        print("Your Choice: ")
        val input = readln()
        println()
        try {
            var attackIndex = input.toInt()
            if (attackIndex in 1..companion.attacks.size + 1) {
                when (attackIndex) {
                    1 -> villainAttackOne(companion, companions, opponents)
                    2 -> villainAttackTwo(companion, companions, opponents)
                    3 -> villainAttackThree(companion, companions, opponents)
                    4 -> villainAttackFour(companion, companions, opponents)
                    5 -> if (!usedItemBox) {
                        var usedItem = itemBox.useItem(companion, itemBox.itemBox)
                        if (!usedItem) {
                            continue
                        } else {
                            return true
                        }
                    } else {
                        println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size}.")
                        continue
                    }
                }
                println()
                removeDeadOpponent(opponents, deadOpponents)
                break
            } else {
                println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
                continue
            }
        } catch (e: Exception) {
            println("Invalid Input. Please enter a number between 1 and ${companion.attacks.size + 1}.")
        }
    }
    return usedItemBox
}

fun showAttackOptions(companion: Villain, usedItemBox: Boolean, itemBox: ItemBox) {
    companion.attacks.forEachIndexed { index, attack ->
        println("[${index + 1}] -> $attack")
        threadsleep(5)
    }
    if (!usedItemBox) {
        println("[5] -> ${itemBox.name}")
        threadsleep(5)
    }
}

fun showCompanionOptions(availableCompanions: MutableList<Villain>) {
    availableCompanions.forEachIndexed { index, it ->
        println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
        threadsleep(5)
    }
}

fun villainAttackOne(villain: Villain, companions: List<Villain>, opponents: MutableList<Hero>) {
    val target = opponents.random()
    when (villain) {
        is DemonLord -> villain.darkSword(target)
        is FirstHeavenlyKing -> villain.bite(target)
        is SecondHeavenlyKing -> villain.void(target)
    }
}

fun villainAttackTwo(villain: Villain, companions: List<Villain>, opponents: MutableList<Hero>) {
    val target = opponents.random()
    when (villain) {
        is DemonLord -> villain.hellFlame(target)
        is FirstHeavenlyKing -> villain.bloodLetting(target, lowestHPCompanions(companions))
        is SecondHeavenlyKing -> villain.eternalIce(villain)
    }
}

fun villainAttackThree(villain: Villain, companions: List<Villain>, opponents: MutableList<Hero>) {
    val target = opponents.random()
    when (villain) {
        is DemonLord -> villain.gravityBomb(target)
        is FirstHeavenlyKing -> villain.darkHeal(companions)
        is SecondHeavenlyKing -> villain.chaosBurst(target)
    }
}

fun villainAttackFour(villain: Villain, companions: List<Villain>, opponents: MutableList<Hero>) {
    val target = opponents.random()
    when (villain) {
        is DemonLord -> villain.rulersGrip(target)
        is FirstHeavenlyKing -> villain.bloodRain(opponents)
        is SecondHeavenlyKing -> villain.originsDoom(target)
    }
}

fun heroMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    deadCompanions: MutableList<Villain>,
    deadOpponents: MutableList<Hero>
) {
    val opponentsCopy: MutableList<Hero> = opponents.toMutableList()
    val deadSidekicks: List<Hero> = opponents.filter { sidekick -> deadOpponents.contains(sidekick) }
    if (companions.isNotEmpty() && opponentsCopy.isNotEmpty() && deadSidekicks.isEmpty()) {
        val chosenOpponent: Hero = opponentsCopy.random()
        performHeroAction(opponents, companions, deadOpponents, deadCompanions)
        chosenOpponent.decrementBuffRounds()
        opponentsCopy.remove(chosenOpponent)
    } else if (companions.isNotEmpty() && opponentsCopy.isNotEmpty()) {
        val chosenOpponent: Hero? = opponentsCopy.find { it is Savior }
        performHeroAction(opponents, companions, deadOpponents, deadCompanions)
        chosenOpponent?.decrementBuffRounds()
        opponentsCopy.remove(chosenOpponent)
    }
}

fun performHeroAction(
    opponents: MutableList<Hero>,
    companions: MutableList<Villain>,
    deadOpponents: MutableList<Hero>,
    deadCompanions: MutableList<Villain>
) {
    if (opponents.isNotEmpty() && companions.isNotEmpty()) {
        val randomHero: Hero = opponents.random()
        val random: Int = when (randomHero) {
            is Savior -> (1..6).random()
            is Sidekick -> (1..4).random()
            else -> throw IllegalArgumentException("Unknown hero type")
        }
        when (random) {
            1 -> heroAttackOne(randomHero, companions)
            2 -> heroAttackTwo(randomHero, companions, opponents)
            3 -> heroAttackThree(randomHero, companions)
            4 -> heroAttackFour(randomHero, companions, opponents)
            5 -> heroAttackFive(randomHero, companions, opponents, deadOpponents)
            6 -> heroAttackSix(randomHero, opponents, companions, deadOpponents)
        }
        removeDeadVillain(companions, deadCompanions)
    }
}

fun heroAttackOne(hero: Hero, companions: MutableList<Villain>) {
    val target = companions.random()
    when (hero) {
        is Savior -> hero.holySword(target)
        is Sidekick -> hero.elementalArrow(target)
    }
}

fun heroAttackTwo(hero: Hero, companions: MutableList<Villain>, opponents: MutableList<Hero>) {
    val target = companions.random()
    val friendlyTarget = opponents.random()
    when (hero) {
        is Savior -> hero.holyShield(friendlyTarget)
        is Sidekick -> hero.elementalBeam(target)
    }
}

fun heroAttackThree(hero: Hero, companions: MutableList<Villain>) {
    when (hero) {
        is Savior -> hero.holyHeal(hero)
        is Sidekick -> hero.elementalWave(companions)
    }
}

fun heroAttackFour(hero: Hero, companions: MutableList<Villain>, opponents: MutableList<Hero>) {
    when (hero) {
        is Savior -> hero.holyLight(companions)
        is Sidekick -> hero.holyHeal(lowestHPOpponents(opponents))
    }
}

fun heroAttackFive(
    hero: Hero,
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    deadOpponents: MutableList<Hero>
) {
    when (hero) {
        is Savior -> if (!anyVillainIsCursed(companions)) hero.sacredCommand(companions) else {
            var random = (1..5).random()
            when (random) {
                1 -> heroAttackOne(hero, companions)
                2 -> heroAttackTwo(hero, companions, opponents)
                3 -> heroAttackThree(hero, companions)
                4 -> heroAttackFour(hero, companions, opponents)
                5 -> heroAttackSix(hero, opponents, companions, deadOpponents)
            }
        }
    }
}

fun heroAttackSix(
    hero: Hero,
    opponents: MutableList<Hero>,
    companions: MutableList<Villain>,
    deadOpponents: MutableList<Hero>
) {
    when (hero) {
        is Savior -> if (opponents.size == 1 && deadOpponents.isEmpty()) hero.summoning(opponents) else {
            var random = (1..5).random()
            when (random) {
                1 -> heroAttackOne(hero, companions)
                2 -> heroAttackTwo(hero, companions, opponents)
                3 -> heroAttackThree(hero, companions)
                4 -> heroAttackFour(hero, companions, opponents)
                5 -> heroAttackFive(hero, companions, opponents, deadOpponents)
            }
        }
    }
}

fun anyVillainIsCursed(companions: MutableList<Villain>): Boolean {
    for (companion in companions) {
        if (companion.isCursed) {
            return true
        }
    }
    return false
}

fun dot(anyVillainsCursed: Boolean, companions: MutableList<Villain>) {
    if (anyVillainsCursed) {
        companions.forEach {
            if (it.isCursed) {
                if (it.hp <= it.maxHP * 0.2) {
                    it.isCursed = false
                    println(
                        "Sacred Command on ${it.name} is no longer active. ${
                            roundDouble(
                                it.hp
                            )
                        } health points left."
                    )
                } else {
                    it.hp -= (it.maxHP * 0.1)
                    println(
                        "Sacred Command on ${it.name} is still active ${roundDouble(it.maxHP * 0.1)} damage taken, ${
                            roundDouble(
                                it.hp
                            )
                        } health points left."
                    )
                }
            }
        }
    }
}

fun removeDeadVillain(companions: MutableList<Villain>, deadCompanions: MutableList<Villain>) {
    var deadCompanion = companions.filter { it.hp < 0.0 }.toMutableList()
    companions.removeAll(deadCompanion)
    deadCompanions.addAll(deadCompanion)
    if (deadCompanion.isNotEmpty()) {
        deadCompanion.forEach { companion -> println("${companion.name} has died.") }
    }
}

fun removeDeadOpponent(opponents: MutableList<Hero>, deadOpponents: MutableList<Hero>) {
    val deadOpponent = opponents.filter { it.hp < 0.0 }.toMutableList()
    opponents.removeAll(deadOpponent)
    deadOpponents.addAll(deadOpponent)
    if (deadOpponent.isNotEmpty()) {
        deadOpponent.forEach { opponent -> println("${opponent.name} has died.") }
    }
}

fun gameEnd(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    red: String,
    reset: String,
    green: String,
    bold: String
): Boolean {
    if (companions.isEmpty()) {
        println("All Villians died during Battle")
        gameWinnerArt(2, red, green, bold, reset)
        return true
    } else if (opponents.isEmpty()) {
        println("All Heroes died during Battle")
        gameWinnerArt(1, red, green, bold, reset)
        return true
    } else {
        return false
    }
}