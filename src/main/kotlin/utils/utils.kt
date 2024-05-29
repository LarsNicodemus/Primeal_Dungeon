package utils


import character.Character
import character.heroes.Hero
import character.villains.DemonLord
import character.villains.FirstHeavenlyKing
import character.villains.SecondHeavenlyKing
import character.villains.Villain
import itembox.ItemBox
import java.util.*
import kotlin.math.roundToInt
import kotlin.random.Random


/*
##########################################
##############Rounding Utils##############
##########################################
**/
/**A function that rounds a Double to two decimal places.
 * @author Marianne Leal
 * @author respectively the internet.
 * @return the input with two decimal places.
 * */
fun roundDouble(input: Double): Double {
    return ((input * 100).roundToInt()) / 100.0
}

fun roundDouble2(input: Double): Double {
    return ((input * 100).roundToInt()) / 100.0
}

/*
############################################
##############Global Variables##############
############################################
**/
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

val gameSound = "src/main/kotlin/audio/Viking Sound.wav"
val outroSound = "src/main/kotlin/audio/Ending Theme.wav"
val doorkickSound = "src/main/kotlin/audio/Door Kick.wav"
val introSound = "src/main/kotlin/audio/Opening Theme.wav"

/*
#######################################
#############Random Utils##############
#######################################
**/
/**A function that returns a random Double between min and max.
 * @param min a Double standing for the min. possible return of the Double.
 * @param max a Double standing for the max. possible return of the Double.
 * @return a random Double between min and max.
 * @author claude.ai
 * @author https://stackoverflow.com/questions/40431966/what-is-the-best-way-to-generate-a-random-float-value-included-into-a-specified
 * */
fun randomDouble(min: Double, max: Double): Double {
    return min + Math.random() * (max - min)
}

/**A function that returns a random Double between min and max.
 * @param min a Double standing for the min. possible return of the Double.
 * @param max a Double standing for the max. possible return of the Double.
 * @return a random Double between min and max.
 * @author https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-double.html
 * @author https://stackoverflow.com/questions/59200033/how-to-generate-a-random-double-value-in-a-specific-range-using-kotlin
 * */
fun nextRandomDouble(min: Double, max: Double): Double {
    return Random.nextDouble(min, max)
}

/**A function, returning a random name for the Savior from the list of names.
 * @return a random Name
 * */
fun randomSaviorName(): String {
    return listOf(
        "Avalera", "Zephyros", "Kaldra", "Thalassus", "Aezira", "Vaelros", "Xaren"
    ).random()
}

/**A function, returning a random name for the Sidekick of the Hero from the list of names.
 * @return a random Name
 * */
fun randomHeroineName(): String {
    return listOf(
        "Anja",
        "Artemis",
        "Athena",
        "Belle",
        "Callisto",
        "Ivy",
        "Shuri",
        "Kara",
        "Scarlett",
        "Clara",
        "Alice",
        "Eloise",
        "Mae",
        "Amelia",
        "Freya",
        "Eleanor",
        "Cordelia",
        "Josephine",
        "Emma",
        "Florence",
        "Elizabeth",
        "Grace",
        "Audrey",
        "Maya",
        "Juno",
        "Harlow",
    ).random()
    /**A function, returning a random name for the Villain from the list of names.
     * @return a random Name
     * */
}

fun randomVillainName(): String {
    return listOf(
        "Belial", "Bael", "Azazel", "Leviathan", "Beelzebub", "Balphegor", "Mammon"
    ).random()
}

/**A function, returning a random name for a companion from the Villain from the list of names.
 * @return a random Name
 * */
fun randomDemonVillainNameFirst(): String {
    return listOf(
        "Amon",
        "Marbas",
        "Barbatos",
        "Marax",
        "Naberius",
        "Astaroth",
        "Stolas",
        "Shax",
        "Procel",
        "Orobas",
        "Andras",
        "Dantalion",
        "Andromalius",
        "Valefar",
        "Vassago",
        "Sabnoc",
        "Allocer",
        "Gremory",
        "Valac",
        "Kimaris"
    ).random()
}

fun randomDemonVillainNameSecond(): String {
    return listOf(
        "Lilith",
        "Paimon",
        "Sitri",
        "Furfur",
        "Marchosias",
        "Lamia",
        "Hecate",
        "Aeshma",
        "Empusa",
        "Akasha",
        "Carmilla",
        "Azrael",
        "Elena",
        "Abbadon",
        "Belphegora",
        "Lilim",
        "Naamah",
        "Sallosa",
        "Veparis",
        "Aswang"
    ).random()
}

/*
#######################################
##############Delay Utils##############
#######################################
**/
fun threadsleep(version: Int) {
//    var stout = st
//    Thread.sleep(stout)
    when (version) {
        1 -> Thread.sleep(100)
        2 -> Thread.sleep(200)
        3 -> Thread.sleep(300)
        4 -> Thread.sleep(400)
        5 -> Thread.sleep(500)
        6 -> Thread.sleep(600)
        7 -> Thread.sleep(700)
        8 -> Thread.sleep(800)
        9 -> Thread.sleep(900)
        10 -> Thread.sleep(1000)
        11 -> Thread.sleep(1100)
        12 -> Thread.sleep(1200)
    }
}

fun printlnWithDelay(string: String, delayMillis: Long) {
    string.forEach { char ->
        print(char)
        Thread.sleep(delayMillis)
    }
    println()
}

fun printWithDelay(string: String, delayMillis: Long) {
    string.forEach { char ->
        print(char)
        Thread.sleep(delayMillis)
    }
}

/*
#######################################
################HP Utils###############
#######################################
**/
fun lowestHPCompanions(companions: List<Villain>): Villain {
    var villainWithLowestHP: Villain? = null
    var lowestHP = Double.MAX_VALUE
    for (companion in companions) {
        if (companion.hp < lowestHP) {
            villainWithLowestHP = companion
            lowestHP = companion.hp
        }
    }
    return villainWithLowestHP!!
}

fun hpLeft(hp: Double): Double {
    return if (hp <= 0.0) {
        0.0
    } else roundDouble2(hp)
}

fun lowestHPOpponents(opponents: List<Hero>): Hero {
    var opponentWithLowestHP: Hero? = null
    var lowestHP = Double.MAX_VALUE
    for (opponent in opponents) {
        if (opponent.hp < lowestHP) {
            opponentWithLowestHP = opponent
            lowestHP = opponent.hp
        }
    }
    return opponentWithLowestHP!!
}

/*
#############################################
##############Intro Outro Utils##############
#############################################
**/
fun intro(
    demonLord: DemonLord,
    firstHeavenlyKing: FirstHeavenlyKing,
    secondHeavenlyKing: SecondHeavenlyKing
) {
    println()
    println()
    threadsleep(4)
    printlnWithDelay(
        "A tremor echoed through the obsidian throne room, shaking the flickering torches that cast long, dancing shadows on the walls.",
        15
    )
    introNameChoice(demonLord)
    printlnWithDelay("${demonLord.name}, $red$bold The Demonlord!$reset ", 15)
    printlnWithDelay(
        """
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
        
    """.trimIndent(), 15
    )
    threadsleep(3)
    printlnWithDelay("Or die tryin'.", 15)

}

fun outro(
    demonLord: DemonLord,
    firstHeavenlyKing: FirstHeavenlyKing,
    secondHeavenlyKing: SecondHeavenlyKing,
    opponents: MutableList<Hero>,
    companions: MutableList<Villain>
) {
    var possibilityOne = mutableListOf(demonLord, firstHeavenlyKing, secondHeavenlyKing)
    var possibilityTwo = mutableListOf(demonLord, firstHeavenlyKing)
    var possibilityThree = mutableListOf(demonLord)
    var possibilityFour = mutableListOf(firstHeavenlyKing)
    var possibilityFive = mutableListOf(secondHeavenlyKing)
    var possibilitySix = mutableListOf(demonLord, secondHeavenlyKing)
    var possibilitySeven = mutableListOf(firstHeavenlyKing, secondHeavenlyKing)
    println()
    println()
    threadsleep(4)
    if (opponents.isEmpty()) {
        when (companions) {
            possibilityOne -> {
                printlnWithDelay(
                    """
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

            possibilityTwo -> {
                printlnWithDelay(
                    """
                        Silence. 
                        Smoke curled from the battlefield, a final plume before dispersing. 
                        ${demonLord.name}, chest heaving, surveyed the carnage. 
                        ${firstHeavenlyKing.name}, her blade slick with blood, stood beside him, her face grimly satisfied. 
                        The Primeal Dungeon stood, defiant. A bitter victory, but a victory nonetheless.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }

            possibilityThree -> {
                printlnWithDelay(
                    """
                    Silence. 
                    Smoke curled from the battlefield, a final plume before dispersing. 
                    ${demonLord.name}, his eyes hollow, surveyed the carnage. 
                    The Primeal Dungeon stood, a monument to their sacrifice. 
                    A victory forged in loss, a triumph born from despair.
    """.trimIndent(), 15
                )
                threadsleep(3)
            }

            possibilityFour -> {
                printlnWithDelay(
                    """
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

            possibilityFive -> {
                printlnWithDelay(
                    """
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

            possibilitySix -> {
                printlnWithDelay(
                    """
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

            possibilitySeven -> {
                printlnWithDelay(
                    """
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
        printlnWithDelay(
            """
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

/*
########################################
##############Choice Utils##############
########################################
**/
fun itemChoice(itemBox: ItemBox) {
    itemBox.addItem(itemBox.itemBox)
}

fun colorChoice(character: Character, red: String, green: String, yellow: String): String {
    val hpPercent = (character.hp / character.maxHP) * 100
    return when {
        hpPercent < 30 -> red
        hpPercent > 50 -> green
        else -> yellow
    }
}

/*
#######################################
##############Round Utils##############
#######################################
**/

fun introNameChoice(demonLord: DemonLord) {
    println()
    printlnWithDelay("Oh dear Player, bestow a name please, but choose wisely! ", 15)
    printlnWithDelay("If you want fate to guide you press [f] and a name shall be granted!", 15)
    printWithDelay("Your choice: ", 15)
    val input: String = readln().lowercase()
    do {
        if (input.isNotEmpty()) {
            if (input == "f") {
                demonLord.name
                printlnWithDelay("Fate decided, the name shall be ${demonLord.name} ", 15)
                break
            } else {
                var name = input
                demonLord.name =
                    name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                printlnWithDelay("Names bear power, ${demonLord.name} is a powerful and great name.", 15)
                break
            }
        }
    } while (true)
    println()
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