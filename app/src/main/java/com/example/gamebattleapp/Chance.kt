package com.example.gamebattleapp

import kotlin.random.Random

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 100)
}