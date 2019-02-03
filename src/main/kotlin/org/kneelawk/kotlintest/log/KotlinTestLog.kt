package org.kneelawk.kotlintest.log

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

/**
 * Created by Kneelawk on 4/18/18.
 */
object KotlinTestLog {
    private lateinit var myLogger: Logger

    val log: Logger
        get() = myLogger

    fun init(event: FMLPreInitializationEvent) {
        myLogger = event.modLog
    }

    fun info(string: String) {
        log.info(string)
    }
}
