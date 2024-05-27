package utils

import character.Character
import character.heroes.Hero
import character.heroes.Savior
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox
import java.util.*

fun main() {
    game()
}

fun game() {
    val red = "\u001B[31m"
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val blue = "\u001B[34m"
    val magenta = "\u001B[35m"
    val cyan = "\u001B[36m"
    val bold = "\u001B[1m"
    val underline = "\u001B[4m"
    val backgroundYellow = "\u001B[43m"
    val reset = "\u001B[0m"


    var index = 1
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    val companions = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    var savior = Savior()
    val opponents: MutableList<Hero> = mutableListOf(savior)

    intro(demonLord,firstHeavenlyKing,secondHeavenlyKing, red, bold, reset)
    itemChoice(itemBox)
    threadsleep(3)
    println("""${cyan} ${bold}
        
         ▄▄ •  ▄▄▄· • ▌ ▄ ·. ▄▄▄ .    .▄▄ · ▄▄▄▄▄ ▄▄▄· ▄▄▄  ▄▄▄▄▄
        ▐█ ▀ ▪▐█ ▀█ ·██ ▐███▪▀▄.▀·    ▐█ ▀. •██  ▐█ ▀█ ▀▄ █·•██  
        ▄█ ▀█▄▄█▀▀█ ▐█ ▌▐▌▐█·▐▀▀▪▄    ▄▀▀▀█▄ ▐█.▪▄█▀▀█ ▐▀▀▄  ▐█.▪
        ▐█▄▪▐█▐█ ▪▐▌██ ██▌▐█▌▐█▄▄▌    ▐█▄▪▐█ ▐█▌·▐█ ▪▐▌▐█•█▌ ▐█▌·
        ·▀▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀ ▀▀▀      ▀▀▀▀  ▀▀▀  ▀  ▀ .▀  ▀ ▀▀▀ 
                                                               
    ${reset}
    """.trimIndent())
    fightRound(companions, opponents, itemBox,reset,red, green, yellow, bold)
    threadsleep(2)
    println()
    println()
    threadsleep(2)
    println("""
        ${cyan} ${bold}
        
         ▄▄ •  ▄▄▄· • ▌ ▄ ·. ▄▄▄ .    ▄▄▄ . ▐ ▄ ·▄▄▄▄  
        ▐█ ▀ ▪▐█ ▀█ ·██ ▐███▪▀▄.▀·    ▀▄.▀·•█▌▐███▪ ██ 
        ▄█ ▀█▄▄█▀▀█ ▐█ ▌▐▌▐█·▐▀▀▪▄    ▐▀▀▪▄▐█▐▐▌▐█· ▐█▌
        ▐█▄▪▐█▐█ ▪▐▌██ ██▌▐█▌▐█▄▄▌    ▐█▄▄▌██▐█▌██. ██ 
        ·▀▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀ ▀▀▀      ▀▀▀ ▀▀ █▪▀▀▀▀▀• 

        ${reset}
    """.trimIndent())
    println()
    println()

}

fun itemChoice(itemBox: ItemBox) {
    itemBox.addItem(itemBox.itemBox)
}

fun colorChoice(character: Character, red: String,green:String,yellow: String) :String{
    val hpPercent = (character.hp / character.maxHP) * 100
    return when {
        hpPercent < 30 -> red
        hpPercent > 50 -> green
        else -> yellow
    }
}

fun villainChoice(demonLord: DemonLord) {
    println()
    printlnWithDelay("Oh dear Player, bestow a name please, but choose wisely! ",15)
    printlnWithDelay("If you want fate to guide you press [f] and a name shall be granted!",15)
    printWithDelay("Your choice: ",15)
    val input: String = readln().lowercase()
    do {
        if (input.isNotEmpty()) {
            if (input == "f") {
                demonLord.name
                printlnWithDelay("Fate decided, the name shall be ${demonLord.name} ",15)
                break
            } else {
                var name = input
                demonLord.name = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                printlnWithDelay("Names bear power, ${demonLord.name} is a powerful and great name.",15)
                break
            }
        }
    } while (true)
    println()
}

fun intro(demonLord: DemonLord,firstHeavenlyKing: FirstHeavenlyKing,secondHeavenlyKing: SecondHeavenlyKing,red: String,bold: String, reset: String) {
    println()
    println()
    threadsleep(4)
    printlnWithDelay("A tremor echoed through the obsidian throne room, shaking the flickering torches that cast long, dancing shadows on the walls.",15)
    villainChoice(demonLord)
    printlnWithDelay("${demonLord.name}, $red$bold The Demonlord!$reset ",15)
    printlnWithDelay("""
        the crimson-skinned Demonlord with ceiling-scraping horns, slammed his massive fist on the armrest. 
        
        The tremor came from above, another human siege pounding at the gates of the Primeal Dungeon, the last bastion of their kind. 
        Beside him stood his two most loyal lieutenants, the Left Heavenly Kings. 
        
        The First Heavenly King ${firstHeavenlyKing.name}, 
        the Duchess of Shadows in swirling obsidian armor, remained impassive, violet eyes gleaming with predatory hunger. 
        
        The Second Heavenly King ${secondHeavenlyKing.name}, 
        the Elemental King, an elemental embodiment of untamed nature's fury. 
        
        They had endured countless assaults, yet ${demonLord.name} sensed this siege was different, a desperate final push. 
        
        He rose, gaze hardening. "They will break, but not the walls of our bastion. We will show them a cornered demon lord's wrath!" 
        ${firstHeavenlyKing.name} and ${secondHeavenlyKing.name} exchanged a glance, a silent vow. 
        
        They would fight. Win. 
        
    """.trimIndent(),15)
    threadsleep(3)
    printlnWithDelay("Or die tryin'.",15)

}

