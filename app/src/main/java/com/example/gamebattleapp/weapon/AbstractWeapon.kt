package com.example.gamebattleapp.weapon

import com.example.gamebattleapp.weapon.FireType.*
import com.example.gamebattleapp.Stack

abstract class AbstractWeapon(
    private val maxCountOfAmmoInMagazine: Int,
    private val typeOfFire: FireType
) {
    private var magazineOfAmmo: Stack<Int> = Stack()
    val haveAmmoInMagazine: Boolean
        get() = !magazineOfAmmo.isEmpty()

    abstract fun createAmmo(): Int

    fun reload() {
        val newMagazine: Stack<Int> = Stack()
        var count = 0
        while (count != maxCountOfAmmoInMagazine) {
            newMagazine.push(createAmmo())
            count++
        }
        magazineOfAmmo = newMagazine
    }

    fun ammoForShot(): Stack<Int> {
        val ammoForDamage: Stack<Int> = Stack()
        if (typeOfFire is LineShooting) {
            var count = 0
            while (count < typeOfFire.lineSize) {
                val item = magazineOfAmmo.pop()
                if (item != null) {
                    ammoForDamage.push(item)
                }
                count++
            }
        } else {
            val item = magazineOfAmmo.pop()
            if (item != null) {
                ammoForDamage.push(item)
            }
        }
        return ammoForDamage
    }

    override fun toString(): String {
        return "weapon magazine consists of $maxCountOfAmmoInMagazine ammo," +
                " ammo in magazine: ${if (magazineOfAmmo.isEmpty()) 0 else magazineOfAmmo}"
    }

    object Weapons {
        fun createPistol(): AbstractWeapon {
            val pistol = object : AbstractWeapon(
                maxCountOfAmmoInMagazine = 8,
                SingleShooting
            ) {
                override fun createAmmo(): Int {
                    return Ammo.PistolBullet.getDamage()
                }
            }
            return pistol
        }

        fun createRifle(): AbstractWeapon {
            val rifle = object : AbstractWeapon(
                maxCountOfAmmoInMagazine = 5,
                SingleShooting
            ) {
                override fun createAmmo(): Int {
                    return Ammo.RifleBullet.getDamage()
                }
            }
            return rifle
        }

        fun createShotgun(): AbstractWeapon {
            val shotgun = object : AbstractWeapon(
                maxCountOfAmmoInMagazine = 2,
                SingleShooting
            ) {
                override fun createAmmo(): Int {
                    return Ammo.ShotgunBullet.getDamage()
                }
            }
            return shotgun
        }

        fun createAutoRifle(): AbstractWeapon {
            val autoRifle = object : AbstractWeapon(
                maxCountOfAmmoInMagazine = 15,
                LineShooting(3)
            ) {
                override fun createAmmo(): Int {
                    return Ammo.AutoRifleBullet.getDamage()
                }
            }
            return autoRifle
        }
    }
}