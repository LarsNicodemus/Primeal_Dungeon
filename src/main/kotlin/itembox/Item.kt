package itembox

import character.villains.Villain

open class Item(var name: String) {
    var count = 0
    open fun use(villain: Villain) {}

    override fun toString(): String {
        return ""
    }

}


