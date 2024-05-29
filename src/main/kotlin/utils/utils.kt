package utils


import character.heroes.Hero
import character.villains.Villain
import kotlin.math.roundToInt
import kotlin.random.Random

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

