package com.example.gamebattleapp

import com.example.gamebattleapp.warrior.AbstractWarrior
import com.example.gamebattleapp.warrior.WarriorWithAutoRifle
import com.example.gamebattleapp.warrior.WarriorWithPistol
import com.example.gamebattleapp.warrior.WarriorWithRifle
import com.example.gamebattleapp.warrior.WarriorWithShotgun
import kotlin.random.Random

class Team(size: Int) {
    private var count = size
    val army = mutableListOf<AbstractWarrior>()

    init {
        while (count != 0) {
            when (Random.nextInt(1, 100)) {
                in 1..60 -> army.add(WarriorWithPistol())
                in 61..80 -> army.add(WarriorWithRifle())
                in 81..92 -> army.add(WarriorWithShotgun())
                in 93..100 -> army.add(WarriorWithAutoRifle())
            }
            count--
        }
    }

    override fun toString(): String {
        return "$army"
    }
}