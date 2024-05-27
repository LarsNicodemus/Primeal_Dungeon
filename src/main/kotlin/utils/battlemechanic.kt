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
    reset: String,
    red: String,
    green: String,
    yellow: String,
    bold: String
) {
    var round = 1

    while (companions.isNotEmpty() && opponents.isNotEmpty()) {
        roundStart(round)
        villainsMove2(companions, opponents, itemBox)
        dot(anyVillainIsCursed(companions),companions)
        heroMove2(companions, opponents)
        roundEnd(round,companions,opponents,reset,red,green,yellow, bold)
        anyVillainIsCursed(companions)
        round++
    }

}

fun roundStart(round: Int) {
    threadsleep(4)
    println()
    println()
    threadsleep(4)
    println("########## Round $round ##########")
    threadsleep(4)
    println()
    println()
    threadsleep(4)
}

fun roundEnd(
    round: Int,
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    reset: String,
    red: String,
    green: String,
    yellow: String,
    bold: String,

) {
    threadsleep(4)
    println()
    println()
    threadsleep(4)
    println("###### End of Round $round ######")
    println()
    threadsleep(4)
    println("Villains:")
    threadsleep(4)
    companions.forEach { companion ->
        if (companions.isNotEmpty()) println(
            "${colorChoice(companion,red, green, yellow)}${companion.name} has ${roundDouble(companion.hp)} left.${reset}"
        )
    }
    companions.forEach { companion -> if (companion.isCursed) println("${companion.name} is cursed.")
        threadsleep(4)}
    if (companions.isEmpty()) {
        gameEnd(companions, opponents, red, reset, green, bold)
    }
    println()
    threadsleep(4)
    println("Heroes:")
    opponents.forEach { opponent -> if (opponents.isNotEmpty()) println("${colorChoice(opponent,red, green, yellow)}${opponent.name} has ${roundDouble(opponent.hp)} left.${reset}")
        threadsleep(4)}
    if (opponents.isEmpty()) {
        gameEnd(companions, opponents, red, reset, green, bold)
    }
    println()
    println()
    println("###### End of Round $round ######")
    threadsleep(4)
}

fun villainsMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
) {
    removeDeadOpponent(opponents)
    var availableCompanions = companions.toMutableList()
    var usedItemBox = false
    if (opponents.isNotEmpty()) {
    while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
            println("Which Defender should go next?")
            threadsleep(5)
            availableCompanions.forEachIndexed { index, it -> println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
                threadsleep(5)
            }
            println()
        print("Your Choice: ")
        val input = readln()
        try {
        val villainIndex = input.toInt()
            if (villainIndex in 1..availableCompanions.size) {
                val chosenCompanion = availableCompanions[input.toIntOrNull()!!.minus(1)]
                availableCompanions.remove(chosenCompanion)
                if (opponents.isNotEmpty()) {
                    println()
                    usedItemBox = chosenAction2(availableCompanions, opponents, itemBox, chosenCompanion, usedItemBox)
                    chosenCompanion.decrementBuffRounds()
                } else continue
            } else println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
            println()
            continue
        } catch (e: NumberFormatException) {
            println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
            println()
        }
    }
    }
}

fun chosenAction2(
    companions: MutableList<Villain>, opponents: MutableList<Hero>, itemBox: ItemBox, companion: Villain,usedItemBox: Boolean): Boolean {
    removeDeadOpponent(opponents)
    println("${companion.name}'s turn, which attack should be carried out?")
    threadsleep(5)
    companion.attacks.forEachIndexed { index, attack -> println("[${index + 1}] -> $attack")
    threadsleep(5)
    }
    if (!usedItemBox) {
        println("[5] -> ${itemBox.name}")
        threadsleep(5)
    }
    println()
    do  {
        print("Your Choice: ")
        val input = readln()
        println()
        try {
            var attackIndex = input.toInt()
            if (attackIndex in 1..companion.attacks.size + 1) {
                when (attackIndex) {
                    1 -> if (companion is DemonLord) companion.darkSword(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bite(
                        opponents.random()
                    )
                    else if (companion is SecondHeavenlyKing) companion.void(opponents.random())

                    2 -> if (companion is DemonLord) companion.hellFlame(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodLetting(
                        opponents.random(),
                        lowestHPCompanions(companions+companion)
                    )
                    else if (companion is SecondHeavenlyKing) companion.eternalIce(companion)

                    3 -> if (companion is DemonLord) companion.gravityBomb(opponents.random()) else if (companion is FirstHeavenlyKing) companion.darkHeal(
                        companions+companion
                    )
                    else if (companion is SecondHeavenlyKing) companion.chaosBurst(opponents.random())

                    4 -> if (companion is DemonLord) companion.rulersGrip(opponents.random()) else if (companion is FirstHeavenlyKing) companion.bloodRain(
                        opponents
                    )
                    else if (companion is SecondHeavenlyKing) companion.originsDoom(opponents.random())

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
    return usedItemBox
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


fun gameEnd(companions: MutableList<Villain>, opponents: MutableList<Hero>, red: String, reset: String, green: String, bold: String): Boolean {
    if (companions.isEmpty()) {
        println("All Villians died during Battle")
        println("""$red
            
              ▄████     ▄▄▄          ███▄ ▄███▓   ▓█████           ▒█████      ██▒   █▓   ▓█████     ██▀███  
             ██▒ ▀█▒   ▒████▄       ▓██▒▀█▀ ██▒   ▓█   ▀          ▒██▒  ██▒   ▓██░   █▒   ▓█   ▀    ▓██ ▒ ██▒
            ▒██░▄▄▄░   ▒██  ▀█▄     ▓██    ▓██░   ▒███            ▒██░  ██▒    ▓██  █▒░   ▒███      ▓██ ░▄█ ▒
            ░▓█  ██▓   ░██▄▄▄▄██    ▒██    ▒██    ▒▓█  ▄          ▒██   ██░     ▒██ █░░   ▒▓█  ▄    ▒██▀▀█▄  
            ░▒▓███▀▒    ▓█   ▓██▒   ▒██▒   ░██▒   ░▒████▒         ░ ████▓▒░      ▒▀█░     ░▒████▒   ░██▓ ▒██▒
             ░▒   ▒     ▒▒   ▓▒█░   ░ ▒░   ░  ░   ░░ ▒░ ░         ░ ▒░▒░▒░       ░ ▐░     ░░ ▒░ ░   ░ ▒▓ ░▒▓░
              ░   ░      ▒   ▒▒ ░   ░  ░      ░    ░ ░  ░           ░ ▒ ▒░       ░ ░░      ░ ░  ░     ░▒ ░ ▒░
            ░ ░   ░      ░   ▒      ░      ░         ░            ░ ░ ░ ▒          ░░        ░        ░░   ░ 
                  ░          ░  ░          ░         ░  ░             ░ ░           ░        ░  ░      ░     
                                                                                   ░                         

    $reset
        """.trimIndent())
        return true
    } else if (opponents.isEmpty()) {
        println("All Heroes died during Battle")
        println("""
            $green$bold
         ▄· ▄▌      ▄• ▄▌    ▄▄▌ ▐ ▄▌       ▐ ▄     ▄▄ 
        ▐█▪██▌▪     █▪██▌    ██· █▌▐█▪     •█▌▐█    ██▌
        ▐█▌▐█▪ ▄█▀▄ █▌▐█▌    ██▪▐█▐▐▌ ▄█▀▄ ▐█▐▐▌    ▐█·
         ▐█▀·.▐█▌.▐▌▐█▄█▌    ▐█▌██▐█▌▐█▌.▐▌██▐█▌    .▀ 
          ▀ •  ▀█▄▀▪ ▀▀▀      ▀▀▀▀ ▀▪ ▀█▄▀▪▀▀ █▪     ▀ 
        
        $reset
        """.trimIndent())
        return true
    } else {
        return false
    }
}
fun villainsMove5(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,
    itemBox: ItemBox,
) {
    removeDeadOpponent(opponents)
    var availableCompanions = companions.toMutableList()
    var usedItemBox = false
    if (opponents.isNotEmpty()) {
        while (availableCompanions.isNotEmpty() && opponents.isNotEmpty()) {
            println("Which Defender should go next?")
            threadsleep(5)
            availableCompanions.forEachIndexed { index, it -> println("${index + 1} -> ${it.title} ${it.name} Attacks: -> ${it.attacks}")
                threadsleep(5)
            }
            println()
            print("Your Choice: ")
            val input = readln()
            try {
                val villainIndex = input.toInt()
                if (villainIndex in 1..availableCompanions.size) {
                    val chosenCompanion = availableCompanions[input.toIntOrNull()!!.minus(1)]
                    availableCompanions.remove(chosenCompanion)
                    if (opponents.isNotEmpty()) {
                        println()
                        usedItemBox = chosenAction2(availableCompanions, opponents, itemBox, chosenCompanion, usedItemBox)
                        chosenCompanion.decrementBuffRounds()
                    } else continue
                } else println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
                println()
                continue
            } catch (e: NumberFormatException) {
                println("Invalid Input. Please enter a number between 1 and ${availableCompanions.size}.")
                println()
            }
        }
    }
}
fun heroMove2(
    companions: MutableList<Villain>,
    opponents: MutableList<Hero>,

) {
    val opponentsCopy = opponents.toMutableList()
    if (companions.isNotEmpty() && opponentsCopy.isNotEmpty()) {
        var chosenOpponent: Hero = opponentsCopy.random()
            performHeroAction(opponents, companions)
            chosenOpponent.decrementBuffRounds()
            opponentsCopy.remove(chosenOpponent)
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
        when (random) {
            1 -> heroAttackOne(randomHero,companions)
            2 -> heroAttackTwo(randomHero,companions, opponents)
            3 -> heroAttackThree(randomHero,companions)
            4 -> heroAttackFour(randomHero,companions, opponents)
            5 -> heroAttackFive(randomHero,companions,opponents)
            6 -> heroAttackSix(randomHero, opponents, companions)
        }
//        if (!anyVillainIsCursed(companions) && opponents.size == 1) {
//            when (random) {
//                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
//                    companions.random()
//                )
//
//                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
//                    companions.random()
//                )
//
//                3 -> if (randomHero is Savior) randomHero.holyHeal(opponents[0]) else if (randomHero is Sidekick) randomHero.elementalWave(
//                    companions
//                )
//
//                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
//                    opponents[0]
//                )
//
//                5 -> if (randomHero is Savior) randomHero.sacredCommand(companions)
//                6 -> if (randomHero is Savior) randomHero.summoning(opponents)
//            }
//            println()
//        } else if (!anyVillainIsCursed(companions) && opponents.size > 1) {
//            when (random) {
//                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
//                    companions.random()
//                )
//
//                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
//                    companions.random()
//                )
//
//                3 -> if (randomHero is Savior) randomHero.holyHeal(randomHero) else if (randomHero is Sidekick) randomHero.elementalWave(
//                    companions
//                )
//
//                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
//                    opponents.random()
//                )
//
//                5 -> if (randomHero is Savior) randomHero.sacredCommand(companions)
//                6 -> (1..5).random()
//            }
//            println()
//        } else {
//            when (random) {
//                1 -> if (randomHero is Savior) randomHero.holySword(companions.random()) else if (randomHero is Sidekick) randomHero.elementalArrow(
//                    companions.random()
//                )
//
//                2 -> if (randomHero is Savior) randomHero.holyShield(randomHero) else if (randomHero is Sidekick) randomHero.elementalBeam(
//                    companions.random()
//                )
//
//                3 -> if (randomHero is Savior) randomHero.holyHeal(randomHero) else if (randomHero is Sidekick) randomHero.elementalWave(
//                    companions
//                )
//
//                4 -> if (randomHero is Savior) randomHero.holyLight(companions) else if (randomHero is Sidekick) randomHero.holyHeal(
//                    opponents.random()
//                )
//
//                5 -> (1..6).random()
//                6 -> if (randomHero is Savior) randomHero.summoning(opponents)
//            }
//            println()
//
//        }
        removeDeadVillain(companions)
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
fun heroAttackFive(hero: Hero, companions: MutableList<Villain>,opponents: MutableList<Hero>) {
    when (hero) {
        is Savior -> if (!anyVillainIsCursed(companions))hero.sacredCommand(companions) else {
            var random = (1..5).random()
            when (random) {
                1 -> heroAttackOne(hero, companions)
                2 -> heroAttackTwo (hero, companions, opponents)
                3 -> heroAttackThree(hero, companions)
                4 -> heroAttackFour(hero, companions, opponents)
                5 -> heroAttackSix (hero, opponents, companions)
            }
        }
    }
}
fun heroAttackSix(hero: Hero, opponents: MutableList<Hero>, companions: MutableList<Villain>) {
    when (hero) {
        is Savior -> if (opponents.size==1)hero.summoning(opponents) else {
            var random = (1..5).random()
            when (random) {
                1 -> heroAttackOne(hero, companions)
                2 -> heroAttackTwo (hero, companions, opponents)
                3 -> heroAttackThree(hero, companions)
                4 -> heroAttackFour(hero, companions, opponents)
                5 -> heroAttackFive(hero, companions, opponents)
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
fun dot2(anyVillainsCursed: Boolean, companions: MutableList<Villain>) {
    if (anyVillainsCursed) {
        for (companion in companions) {
            if (companion.isCursed) {
                companion.hp -= (companion.maxHP * 0.1)
                println(
                    "Sacred Command on ${companion.name} is still active ${roundDouble(companion.maxHP * 0.1)} damage taken, ${
                        roundDouble(
                            companion.hp
                        )
                    } health points left."
                )
            }
        }
    }
}
fun dot(anyVillainsCursed: Boolean,companions: MutableList<Villain>) {
    if (anyVillainsCursed) {
        companions.forEach { if (it.isCursed) {
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



