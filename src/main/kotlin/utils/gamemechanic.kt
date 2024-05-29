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
    val gameSound = "src/main/kotlin/audio/Miracle of Sound - Valhalla Calling - Karaoke Instrumental Lyrics - ObsKure.wav"
    val outroSound = "src/main/kotlin/audio/Fairy Tail Theme End.wav"
    val doorkickSound = "src/main/kotlin/audio/Door Kick.wav"
    val introSound = "src/main/kotlin/audio/Fairy Tail Theme (Violin Cover) Taylor Davis.wav"
    var endGame = false
    var index = 1
    var itemBox: ItemBox = ItemBox()
    var demonLord = DemonLord()
    var firstHeavenlyKing = FirstHeavenlyKing()
    var secondHeavenlyKing = SecondHeavenlyKing()
    val companions = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    var savior = Savior()
    val opponents: MutableList<Hero> = mutableListOf(savior)
    while (!endGame) {
        val intro = playSound(introSound, 0.30f, 100000)
        intro(demonLord, firstHeavenlyKing, secondHeavenlyKing, red, bold, reset)
        itemChoice(itemBox)
        threadsleep(12)
        playSound(doorkickSound, 0.40f, 1200)
        endSound(intro)
        val gameMusic = playSound(gameSound, 0.30f, 300000)
        gameArt(1, cyan, bold, reset)
        fightRound(companions, opponents, itemBox, reset, red, green, yellow, bold)
        threadsleep(2)
        endSound(gameMusic)
        val outro = playSound(outroSound, 0.35f, 29000)
        outro(demonLord, firstHeavenlyKing, secondHeavenlyKing, red, bold, reset, opponents, companions)
        println()
        println()
        threadsleep(2)
        gameArt(2, cyan, bold, reset)
        println()
        println()
        Thread.sleep(2000)
        printlnWithDelay("Mortal, do you wish to test your fate once more? (y/n)",15)
        printWithDelay("Your Choice: ",15)
        var choice = readln().lowercase()
        while (choice !="y" && choice != "n"){
            println("Please enter y for yes or n for no.")
            choice = readln().lowercase()
        }
        if (choice == "y") {
            endGame = false
            endSound(outro)
            gameArt(3,cyan, bold, reset)
            game()
        } else {
            endSound(outro)
            exitProcess(0)
        }
    }
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

fun outro(demonLord: DemonLord,firstHeavenlyKing: FirstHeavenlyKing,secondHeavenlyKing: SecondHeavenlyKing,red: String,bold: String, reset: String, opponents: MutableList<Hero>,companions: MutableList<Villain>) {
    var possibilityOne = mutableListOf(demonLord,firstHeavenlyKing,secondHeavenlyKing)
    var possibilityTwo = mutableListOf(demonLord,firstHeavenlyKing)
    var possibilityThree = mutableListOf(demonLord)
    var possibilityFour = mutableListOf(firstHeavenlyKing)
    var possibilityFive = mutableListOf(secondHeavenlyKing)
    var possibilitySix = mutableListOf(demonLord,secondHeavenlyKing)
    var possibilitySeven = mutableListOf(firstHeavenlyKing,secondHeavenlyKing)
    println()
    println()
    threadsleep(4)
    if (opponents.isEmpty()) {
        when (companions) {
            possibilityOne  -> {
                printlnWithDelay("""
                        Silence. 
                        Smoke curled from the battlefield, a final plume before dispersing. 
                        ${demonLord.name}, chest heaving, surveyed the carnage. 
                        ${firstHeavenlyKing.name} knelt, wiping blood from her blade, a grim smile playing on her lips. 
                        ${secondHeavenlyKing.name}, a flicker of storm cloud lingering around his form, rumbled in satisfaction. 
                        The Primeal Dungeon stood, defiant. They wouldn't forget this day.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilityTwo ->{
                printlnWithDelay("""
                        Silence. 
                        Smoke curled from the battlefield, a final plume before dispersing. 
                        ${demonLord.name}, chest heaving, surveyed the carnage. 
                        ${firstHeavenlyKing.name}, her blade slick with blood, stood beside him, her face grimly satisfied. 
                        The Primeal Dungeon stood, defiant. A bitter victory, but a victory nonetheless.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilityThree ->{
                printlnWithDelay("""
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${demonLord.name}, his eyes hollow, surveyed the carnage. 
                    The Primeal Dungeon stood, a monument to their sacrifice. 
                    A victory forged in loss, a triumph born from despair.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilityFour ->{
                printlnWithDelay("""
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${firstHeavenlyKing.name}, her armor gleaming under the setting sun, surveyed the carnage. 
                    The Primeal Dungeon stood, a testament to their valor. 
                    A victory hard-won, a legacy etched in blood.
                    Silence.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilityFive ->{
                printlnWithDelay("""
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${secondHeavenlyKing.name}, his storm cloud swirling with newfound power, surveyed the carnage. 
                    The Primeal Dungeon stood, a symbol of their defiance. 
                    A victory forged in unity, a triumph born from resilience.
                    Silence.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilitySix ->{
                printlnWithDelay("""
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${demonLord.name}, his crimson skin streaked with ash, surveyed the carnage. 
                    ${secondHeavenlyKing.name}, his elemental form simmering with power, stood beside him, a silent guardian. 
                    The Primeal Dungeon stood, a beacon of hope in a world of darkness. 
                    A victory tempered by grief, a triumph tinged with sorrow.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }
            possibilitySeven ->{
                printlnWithDelay("""
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${firstHeavenlyKing.name}, her eyes burning with determination, surveyed the carnage. 
                    ${secondHeavenlyKing.name}, his storm clouds swirling with newfound power, roared in victory. 
                    The Primeal Dungeon stood, a symbol of their unwavering spirit. A victory born from loss, a triumph forged in resilience. 
                    Yet, ${demonLord.name}, the demon lord, was no more. 
                    His absence cast a shadow over their victory, leaving an uncertain future ahead. 
                    Only time would tell.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }

        }
    } else {
        printlnWithDelay("""
                    A blinding flash. Silence. 
                    Dust settled on the shattered throne. 
                    ${demonLord.name} lay still, an extinguished ember. 
                    ${firstHeavenlyKing.name}, her armor shattered, mirrored him. 
                    ${secondHeavenlyKing.name}, a fading storm, screamed defiance - then vanished. 
                    The Primeal Dungeon fell. 
                    
                    A new era, uncertain and chilling, began.
    """.trimIndent(), 15
        )
    }
}

