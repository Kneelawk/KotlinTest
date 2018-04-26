package org.kneelawk.kotlintest.proxy

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

/**
 * Sided-proxy interface.
 */
interface IKotlinTestProxy {
    fun preInit(event: FMLPreInitializationEvent)

    fun init(event: FMLInitializationEvent)

    fun postInit(event: FMLPostInitializationEvent)
}