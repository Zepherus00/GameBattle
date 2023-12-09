package com.example.gamebattleapp.weapon

sealed class FireType {
    object SingleShooting : FireType()
    data class LineShooting(val lineSize: Int) : FireType()
}