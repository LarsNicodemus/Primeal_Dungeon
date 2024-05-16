package character

/** The Character class is the mother class to all villains and heroes.
 * @property name the characters name
 * @property hp the characters health points, if hp reaches 0 the character dies.
 * @property mp the characters mana points, used for magic attacks and heals, refills over time, if not enough or empty attack cannot be invoked.
 * @property rage the characters rage points, used for sword attacks, refills over time, if not enough or empty attack cannot be invoked.
 * @property attackPower defines the attack power of the character, the higher, the stronger is the dealt attack.
 * @property healPower defines the heal power of the character, the higher, the stronger is the given heal.
 * @property shield indicates if the character is able to block or nullify the next attack.
 * */

open class Character() {

    open var name: String = ""
    open var hp: Double = 0.0
    open var mp: Double = 0.0
    open var rage: Double = 0.0

    open var attackPower: Int = (70..100).random()
    open var healPower: Int = (70..100).random()

    open var shield: Int = 0
//    init {
//        hp = (70.0..100.0).random()
//        mp = (100.0..200.0).random()
//        rage = (100.0..200.0).random()
//    }

}