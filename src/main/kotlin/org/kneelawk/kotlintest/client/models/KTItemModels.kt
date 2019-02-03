package org.kneelawk.kotlintest.client.models

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import org.kneelawk.kotlintest.blocks.KTBlocks
import org.kneelawk.kotlintest.items.KTItems

object KTItemModels {
    fun init() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(KTBlocks.blockKotlin),
                0,
                ModelResourceLocation(KTBlocks.blockKotlin.registryName!!, "inventory")
        )

        ModelLoader.setCustomModelResourceLocation(
                KTItems.itemKotlin,
                0,
                ModelResourceLocation(KTItems.itemKotlin.registryName!!, "inventory")
        )
    }
}