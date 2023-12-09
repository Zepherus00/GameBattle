package com.example.gamebattleapp.warrior

interface Warrior {
    val isKilled: Boolean

    fun attack(enemy: AbstractWarrior)
    fun getSomeDamage(damage: Int)
}