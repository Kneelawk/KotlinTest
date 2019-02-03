package org.kneelawk.kotlintest.ref

/**
 * Created by Kneelawk on 4/17/18.
 */
object Constants {
    const val MODID = "kotlintest"
    const val MOD_NAME = "Kotlin Test"
    const val MOD_VERSION = "1.12.2-0.0.1"
    const val MOD_LANGUAGE = "kotlin"
    const val MOD_LANGUAGE_ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"

    fun getUnlocalizedName(name: String): String = "$MODID.$name"
}