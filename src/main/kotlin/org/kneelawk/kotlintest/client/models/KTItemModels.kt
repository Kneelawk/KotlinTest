package org.kneelawk.kotlintest.client.models

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.registries.IRegistryDelegate
import org.apache.commons.lang3.tuple.Pair
import org.kneelawk.kotlintest.items.IHasItemMetaNames
import org.kneelawk.kotlintest.blocks.KTBlocks
import org.kneelawk.kotlintest.items.KTItems
import org.kneelawk.kotlintest.log.KotlinTestLog

object KTItemModels {
    fun init() {
        KTBlocks.blocks.forEach { block ->
            if (block is IHasItemMetaNames) {
                block.getMetaNames().forEach { meta, name ->
                    ModelLoader.setCustomModelResourceLocation(
                            Item.getItemFromBlock(block),
                            meta,
                            ModelResourceLocation(block.registryName!!, name)
                    )
                }
            } else {
                val item = Item.getItemFromBlock(block)
                if (item is IHasItemMetaNames) {
                    item.getMetaNames().forEach { meta, name ->
                        ModelLoader.setCustomModelResourceLocation(
                                item,
                                meta,
                                ModelResourceLocation(block.registryName!!, name)
                        )
                    }
                } else {
                    ModelLoader.setCustomModelResourceLocation(
                            item,
                            block.getMetaFromState(block.defaultState),
                            ModelResourceLocation(block.registryName!!, "inventory")
                    )
                }
            }
        }

        KTItems.items.forEach { item ->
            if (item is IHasItemMetaNames) {
                item.getMetaNames().forEach { meta, name ->
                    ModelLoader.setCustomModelResourceLocation(
                            item,
                            meta,
                            ModelResourceLocation(item.registryName!!, name)
                    )
                }
            } else {
                ModelLoader.setCustomModelResourceLocation(
                        item,
                        0,
                        ModelResourceLocation(item.registryName!!, "inventory")
                )
            }
        }
    }
}