package org.kneelawk.kotlintest

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

/**
 * Created by Kneelawk on 4/18/18.
 */
object KotlinTestLog {
    private var myLogger: Logger? = null

    val log: Logger
        get() = myLogger!!

    fun init(event: FMLPreInitializationEvent) {
        myLogger = event.modLog
    }
}