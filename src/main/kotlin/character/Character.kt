package character

import character.heroes.Hero
import character.heroes.Savior
import character.villains.DemonLord
import character.villains.Villan

open class Character() {

    open var name: String = ""
    open var hp: Double = 0.0
    open var mp: Double = 0.0
    open var rage: Double = 0.0

    open var attackPower:Int = (70..100).random()
    open var healPower:Int = (70..100).random()

//    init {
//        hp = (70.0..100.0).random()
//        mp = (100.0..200.0).random()
//        rage = (100.0..200.0).random()
//    }

}