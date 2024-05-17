package utils




import itembox.ItemBox
import kotlin.math.roundToInt
import character.heroes.Hero
import character.villains.Villain

fun roundDouble(input:Double):Double{
    return ((input*100).roundToInt())/100.0
}
fun randomDouble(min:Double,max:Double):Double{
    return min + Math.random() * (max - min)
}
fun randomName(): String{
    return listOf(
        "Anja",
        "Artemis",
        "Athena",
        "Belle",
        "Callisto",
        "Ivy",
        "Shuri",
        "Kara",
    ).random()
}
fun useItemBox(itemBox: ItemBox){
    // inhalt beutel drucken
    println("Wir haben noch itemBox.anzahlheiltraenke Heiltränke")
    // user gibt über readln seine auswahl ein
    // je nach auswahl:
        // beutel.useHeiltrank(this) // hier muss der held übergeben werden der den Beutel nutzt
        // beutel.useBooster(this) //
}