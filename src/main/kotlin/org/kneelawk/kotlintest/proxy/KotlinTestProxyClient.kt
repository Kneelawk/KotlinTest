package org.kneelawk.kotlintest.proxy

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.kneelawk.kotlintest.client.models.KTBlockModels
import org.kneelawk.kotlintest.client.models.KTItemModels

/**
 * Client proxy. Houses all functionality that only works on the client.
 */
class KotlinTestProxyClient : KotlinTestProxyCommon() {
    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event)

        registerModels()
    }

    private fun registerModels() {
        KTBlockModels.init()
        KTItemModels.init()
    }
}
