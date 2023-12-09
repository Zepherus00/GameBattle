package com.example.gamebattleapp

import com.example.gamebattleapp.BattleState.Draw
import com.example.gamebattleapp.BattleState.Progress
import com.example.gamebattleapp.BattleState.WinningTheHumansArmy
import com.example.gamebattleapp.BattleState.WinningTheOrksArmy

class Battle(
    humansArmy: Team,
    orcsArmy: Team
) {
    private val humans = humansArmy.army
    private val orcs = orcsArmy.army
    private var state: BattleState = Progress(humans, orcs)
    private val isBattleEnd: Boolean
        get() = humans.size == 0 || orcs.size == 0

    fun getStateAboutBattle() {
        var count = 1
        while (state is Progress) {
            println("Move: $count\n")
            iterateOfTheBattle()
            count++
        }
    }

    private fun iterateOfTheBattle() {
        var currentHuman = humans[0]
        var currentOrc = orcs[0]
        if (!currentHuman.isKilled) {
            println("Human's warrior $currentHuman is moving.")
            currentHuman.attack(currentOrc)
        } else {
            humans.removeFirst()
            if (humans.size > 0) {
                currentHuman = humans[0]
                println("New human's warrior $currentHuman has arrived.")
                currentHuman.attack(currentOrc)
            }
        }
        if (!currentOrc.isKilled) {
            println("Orc's warrior $currentOrc is moving.")
            currentOrc.attack(currentHuman)
        } else {
            orcs.removeFirst()
            if (orcs.size > 0) {
                currentOrc = orcs[0]
                println("New orc's warrior $currentOrc has arrived.")
                currentOrc.attack(currentHuman)
            }
        }
        val sumOfHealthTheHumansArmy = humans.sumOf { it.currentHealth }
        val sumOfHealthTheOrcsArmy = orcs.sumOf { it.currentHealth }
        println(
            """Sum of human's army health after move: $sumOfHealthTheHumansArmy.
            |Sum of orc's army health after move: $sumOfHealthTheOrcsArmy.
            |_________________________________________________
        """.trimMargin()
        )
        if (isBattleEnd) {
            when {
                sumOfHealthTheOrcsArmy <= 0 -> {
                    state = WinningTheHumansArmy(humans, orcs)
                    println("Human's army win!")
                }

                sumOfHealthTheHumansArmy <= 0 -> {
                    state = WinningTheOrksArmy(humans, orcs)
                    println("Orc's army win!")
                }

                sumOfHealthTheHumansArmy <= 0 && sumOfHealthTheOrcsArmy <= 0 -> {
                    state = Draw(humans, orcs)
                    println("Draw!")
                }
            }
        }
    }

    override fun toString(): String {
        return "Battle (Human's army = $humans," +
                " orc's army = $orcs," +
                " state = $state. Is battle end? - $isBattleEnd)"
    }
}