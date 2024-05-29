package utils

import audio.endSound
import audio.playSound
import character.Character
import character.heroes.Hero
import character.heroes.Savior
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox
import java.util.*
import kotlin.system.exitProcess


fun main() {
    game()
}

fun game() {
    var endGame = false
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    val companions = mutableListOf(demonLord, firstHeavenlyKing, secondHeavenlyKing)
    var savior = Savior()
    val opponents: MutableList<Hero> = mutableListOf(savior)
    while (!endGame) {
        val intro = playSound(introSound, 0.30f, 100000)
        intro(demonLord, firstHeavenlyKing, secondHeavenlyKing)
        itemChoice(itemBox)
        threadsleep(12)
        playSound(doorkickSound, 0.40f, 1200)
        endSound(intro)
        val gameMusic = playSound(gameSound, 0.30f, 300000)
        gameArt(1)
        fightRound(companions, opponents, itemBox)
        threadsleep(2)
        endSound(gameMusic)
        val outro = playSound(outroSound, 0.35f, 29000)
        outro(demonLord, firstHeavenlyKing, secondHeavenlyKing, opponents, companions)
        println()
        println()
        threadsleep(2)
        gameArt(2)
        println()
        println()
        Thread.sleep(2000)
        printlnWithDelay("Mortal, do you wish to test your fate once more? (y/n)", 15)
        printWithDelay("Your Choice: ", 15)
        var choice = readln().lowercase()
        while (choice != "y" && choice != "n") {
            println("Please enter y for yes or n for no.")
            choice = readln().lowercase()
        }
        if (choice == "y") {
            endGame = false
            endSound(outro)
            gameArt(3)
            game()
        } else {
            endSound(outro)
            exitProcess(0)
        }
    }
}