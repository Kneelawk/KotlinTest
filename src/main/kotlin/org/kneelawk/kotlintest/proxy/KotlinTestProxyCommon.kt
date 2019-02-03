package org.kneelawk.kotlintest.proxy

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.kneelawk.kotlintest.blocks.KTBlocks
import org.kneelawk.kotlintest.items.KTItems
import org.kneelawk.kotlintest.log.KotlinTestLog

/**
 * Common proxy. Houses all functionality common between client and server.
 */
abstract class KotlinTestProxyCommon : IKotlinTestProxy {
    override fun preInit(event: FMLPreInitializationEvent) {
        KotlinTestLog.init(event)

        KTBlocks.init()
        KTItems.init()

        KTBlocks.registerBlocks()
        KTBlocks.registerBlockItems()
        KTItems.registerItems()
    }

    override fun init(event: FMLInitializationEvent) {
    }

    override fun postInit(event: FMLPostInitializationEvent) {
    }
}
