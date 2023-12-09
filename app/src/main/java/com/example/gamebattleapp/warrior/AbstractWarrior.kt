package com.example.gamebattleapp.warrior

import com.example.gamebattleapp.chance
import com.example.gamebattleapp.weapon.AbstractWeapon

abstract class AbstractWarrior(
    private val maxHealth: Int,
    private val weapon: AbstractWeapon,
    private val accuracy: Int,
    private val evasion: Int
) : Warrior {
    internal var currentHealth = maxHealth

    override val isKilled: Boolean
        get() = currentHealth <= 0

    override fun attack(enemy: AbstractWarrior) {
        if (weapon.haveAmmoInMagazine) {
            var damage: Int
            val arrayOfAmmo = weapon.ammoForShot()
            while (!arrayOfAmmo.isEmpty()) {
                if (enemy.isKilled) break
                damage = arrayOfAmmo.pop() ?: 0
                if (accuracy.chance() && enemy.evasion.chance()) {
                    enemy.getSomeDamage(damage)
                    if (!enemy.isKilled) {
                        println(
                            """Warrior attack: Enemy is getting $damage score of damage,
                        |enemy health: ${enemy.currentHealth}/${enemy.maxHealth}.
                        |
                    """.trimMargin()
                        )
                    } else {
                        enemy.currentHealth = 0
                        println(
                            """Warrior attack: Enemy is getting $damage score of damage,
                            |enemy was killed.
                            |
                    """.trimMargin()
                        )
                    }
                } else {
                    println("Warrior attack: Miss!\n")
                }
            }
        } else {
            weapon.reload()
            println("Warrior is reloading.\n")
        }
    }

    override fun getSomeDamage(damage: Int) {
        currentHealth -= damage
    }

    override fun toString(): String {
        return "(Health: $currentHealth/$maxHealth, $weapon)"
    }
}