package com.example.gamebattleapp

// <- Press here to start the game
fun main() {
    println(
        """                        Welcome to the game!
        |Now you will witness the battle between army of humans and army of orcs.
    """.trimMargin()
    )
    println("Chose the size of armies: ")
    val sizeOfArmies = readlnOrNull()?.toIntOrNull() ?: return println("Incorrect value.")
    println()

    val humansArmy = Team(sizeOfArmies)
    println("The army of humans consists of $sizeOfArmies warriors: $humansArmy")
    val orcsArmy = Team(sizeOfArmies)
    println("The army of orcs consists of $sizeOfArmies warriors: $orcsArmy")
    println("_________________________________________________")

    val battle = Battle(humansArmy, orcsArmy)
    battle.getStateAboutBattle()
}