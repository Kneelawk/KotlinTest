package org.kneelawk.kotlintest

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

/**
 * Proxy constants.
 */
object KotlinTestProxies {
    const val client = "org.kneelawk.kotlintest.KotlinTestProxyClient"
    const val server = "org.kneelwak.kotlintest.KotlinTestProxyServer"
}

/**
 * Sided-proxy interface.
 */
interface IKotlinTestProxy {
    fun preInit(event: FMLPreInitializationEvent)

    fun init(event: FMLInitializationEvent)

    fun postInit(event: FMLPostInitializationEvent)
}

/**
 * Common proxy. Houses all functionality common between client and server.
 */
abstract class KotlinTestProxyCommon : IKotlinTestProxy {
    override fun preInit(event: FMLPreInitializationEvent) {
        KotlinTestLog.init(event)
    }

    override fun init(event: FMLInitializationEvent) {
    }

    override fun postInit(event: FMLPostInitializationEvent) {
    }
}

/**
 * Client proxy. Houses all functionality that only works on the client.
 */
class KotlinTestProxyClient : KotlinTestProxyCommon() {

}

/**
 * Server proxy. Houses all functionality that only works on the server.
 */
class KotlinTestProxyServer : KotlinTestProxyCommon() {

}