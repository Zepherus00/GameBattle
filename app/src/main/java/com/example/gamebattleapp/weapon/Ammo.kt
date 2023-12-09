package com.example.gamebattleapp.weapon

import com.example.gamebattleapp.chance
import kotlin.random.Random

enum class Ammo(
    private val damage: Int,
    private val criticalHitChance: Int,
    private val criticalHitDamage: Int
) {
    PistolBullet(Random.nextInt(8, 12), 5, 2),
    RifleBullet(Random.nextInt(10, 16), 10, 2),
    ShotgunBullet(Random.nextInt(2, 20), 20, 3),
    AutoRifleBullet(Random.nextInt(6, 10), 7, 2);

    fun getDamage(): Int {
        var attack = damage
        if (criticalHitChance.chance()) {
            attack *= criticalHitDamage
        }
        return attack
    }

    override fun toString(): String {
        return "Ammo - (Damage: $damage," +
                " critical hit chance: $criticalHitChance," +
                " and critical hit damage: $criticalHitDamage)"
    }
}