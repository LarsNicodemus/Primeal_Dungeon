package utils

import character.heroes.Hero
import character.heroes.Savior
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import itembox.ItemBox
import java.util.*

fun main() {
    game()
}

fun game() {
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    val companions = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    var savior = Savior()
    val opponents: MutableList<Hero> = mutableListOf(savior)
    intro(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    itemChoice(itemBox)
    fightRound(companions, opponents, itemBox)

}

fun itemChoice(itemBox: ItemBox) {
    itemBox.addItem(itemBox.itemBox)
}

fun villainChoice(demonLord: DemonLord) {
    println()
    printlnWithDelay("Oh dear Player, bestow a name please, but choose wisely! ",25)
    printlnWithDelay("If you want fate to guide you press [f] and a name shall be granted!",25)
    printlnWithDelay("Your choice: ",25)
    val input: String = readln().lowercase()
    do {
        if (input.isNotEmpty()) {
            if (input == "f") {
                demonLord.name
                printlnWithDelay("Fate decided, the name shall be ${demonLord.name} ",25)
                break
            } else {
                var name = input
                demonLord.name = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                printlnWithDelay("Names bear power, ${demonLord.name} is a powerful and great name.",25)
                break
            }
        }
    } while (true)
    println()
}

fun intro(demonLord: DemonLord,firstHeavenlyKing: FirstHeavenlyKing,secondHeavenlyKing: SecondHeavenlyKing) {
    println()
    println()
    threadsleep(4)
    printlnWithDelay("A tremor echoed through the obsidian throne room, shaking the flickering torches that cast long, dancing shadows on the walls.",25)
    villainChoice(demonLord)
    printlnWithDelay("${demonLord.name}, The Demonlord! ",25)

    printlnWithDelay("A being of smoldering crimson skin and horns that scraped the ceiling, slammed his massive fist onto the armrest.",25)
    println()
    printlnWithDelay("The tremor originated from above, yet another human siege hammering at the gates of the Primeal Dungeon, the last bastion of their kind.",25)

    printlnWithDelay("Beside him stood his two most loyal lieutenants, the Left Heavenly Kings.",25)
    println()
    printlnWithDelay("First Heavenly King ${firstHeavenlyKing.name}, the Duchess of Shadows,",25)

    printlnWithDelay("her obsidian armor swirling with an inky mist, remained impassive, her violet eyes gleaming with a predatory hunger for battle.",25)

    printlnWithDelay("In contrast,Second Heavenly King ${secondHeavenlyKing.name}, the Elemental King,",25)

    printlnWithDelay("a tempestuous embodiment of all the elements, though not humanoid, his presence held a primal intelligence, the incarnation of nature's untamed fury.",25)
    println()
    printlnWithDelay("They had endured countless assaults on the Primeal Dungeon, human paladins, elven archers, and dwarven berserkers all throwing themselves against their demonic defenses.",25)
    println()
    printlnWithDelay("Yet, ${demonLord.name} knew this siege felt different, a desperate final push by a cornered enemy.",25)

    printlnWithDelay("He rose from his throne, his gaze hardening. \"They will break,\" he declared, his voice a rumbling inferno,",25)

    printlnWithDelay("\"but not the walls of the Primeal Dungeon. We will show them the wrath of a demon lord cornered!\"",25)
    println()
    printlnWithDelay("${firstHeavenlyKing.name} and ${secondHeavenlyKing.name} exchanged a glance, a silent promise flashing between them.",25)

    printlnWithDelay("They would fight. They would win. Or die defending the last refuge of their kind.",25)


}

