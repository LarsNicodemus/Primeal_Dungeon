package character.heroes

class Sidekick(name: String) : Hero(name) {
    init {
        this.hp = 70.0 + Math.random() * (100.0 - 70.0)
    }
}