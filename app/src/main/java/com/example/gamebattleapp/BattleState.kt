package com.example.gamebattleapp

import com.example.gamebattleapp.warrior.AbstractWarrior

sealed class BattleState {
    data class Progress(
        val white: MutableList<AbstractWarrior>,
        val black: MutableList<AbstractWarrior>
    ) : BattleState()

    data class WinningTheHumansArmy(
        val white: MutableList<AbstractWarrior>,
        val black: MutableList<AbstractWarrior>
    ) : BattleState()

    data class WinningTheOrksArmy(
        val white: MutableList<AbstractWarrior>,
        val black: MutableList<AbstractWarrior>
    ) : BattleState()

    data class Draw(
        val white: MutableList<AbstractWarrior>,
        val black: MutableList<AbstractWarrior>
    ) : BattleState()
}