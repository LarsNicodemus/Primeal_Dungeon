package utils


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
fun nextRandomDouble(min: Double,max:Double):Double{
    return Random.nextDouble(min,max)
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
        "Anja", "Artemis", "Athena", "Belle", "Callisto", "Ivy", "Shuri", "Kara", "Scarlett", "Clara", "Alice", "Eloise", "Mae",
        "Amelia", "Freya", "Eleanor", "Cordelia", "Josephine", "Emma", "Florence", "Elizabeth", "Grace", "Audrey", "Maya", "Juno", "Harlow",
    ).random()
/**A function, returning a random name for the Villain from the list of names.
 * @return a random Name
 * */
}fun randomVillainName(): String {
    return listOf(
        "Belial", "Bael", "Azazel", "Leviathan", "Beelzebub", "Balphegor", "Mammon"
    ).random()
}
/**A function, returning a random name for a companion from the Villain from the list of names.
 * @return a random Name
 * */
fun randomDemonVillainNameFirst(): String {
    return listOf(
        "Amon", "Marbas", "Barbatos", "Marax", "Naberius", "Astaroth", "Stolas", "Shax", "Procel",
        "Orobas", "Andras", "Dantalion", "Andromalius", "Valefar", "Vassago", "Sabnoc", "Allocer", "Gremory", "Valac", "Kimaris"
    ).random()
}
fun randomDemonVillainNameSecond(): String {
    return listOf(
        "Lilith", "Paimon", "Sitri", "Furfur", "Marchosias", "Lamia", "Hecate", "Aeshma", "Empusa",
        "Akasha", "Carmilla", "Azrael", "Elena", "Abbadon", "Belphegora", "Lilim", "Naamah", "Sallosa", "Veparis", "Aswang"
    ).random()
}

fun threadsleep(version: Int){
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
fun lowestHPCompanions(companions: MutableList<Villain>): Villain {
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
fun lowestHPOpponents(companions: MutableList<Villain>): Villain {
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

//fun useItemBox(itemBox: ItemBox) {
//    // inhalt beutel drucken
//    println("Wir haben noch itemBox.anzahlheiltraenke Heiltränke")
//    // user gibt über readln seine auswahl ein
//    // je nach auswahl:
//    // beutel.useHeiltrank(this) // hier muss der held übergeben werden der den Beutel nutzt
//    // beutel.useBooster(this) //
//}

//fun addItem(itemBox: MutableList<Item>) {
//    println("You may add up to four Items to you Item Box, choose wisely.")
//    val itemOptions = listOf(StrengthBooster(), HealingPotion())
//    itemOptions.indices.forEach { index -> println("${index + 1}. ${itemOptions[index].name}") }
//    while (itemBox.size < 4) {
//        print("Please enter the index of the item you want to add: ")
//        var input: String = readln().lowercase()
//        try {
//            val itemIndex = input.toInt()
//            if (itemIndex in 1..itemOptions.size) {
//                val item = itemOptions[itemIndex - 1]
//                itemBox.add(item)
//                println("${item.name} added to your Item Box.")
//            } else {
//                println("Invalid item index")
//            }
//        } catch (e: NumberFormatException) {
//            println("Invalid Input. Please enter a number.")
//        }
//    }
//    println("Your Item Box contains: ")
//    itemBox.indices.forEach { index -> println("Nr.${index + 1}. ${itemBox[index].name}") }
//}

//fun getItems(itemBox: MutableList<Item>){
//    return itemBox.indices.forEach { index -> println("${index + 1}. ${itemBox[index].name}") }
//}

