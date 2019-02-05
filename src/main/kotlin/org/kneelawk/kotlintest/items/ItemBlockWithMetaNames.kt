package org.kneelawk.kotlintest.items

import com.google.common.collect.ImmutableMap
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack

class ItemBlockWithMetaNames(block: Block) : ItemBlock(block), IHasItemMetaNames {
    override fun getMetadata(damage: Int): Int {
        return damage
    }

    override fun getUnlocalizedName(stack: ItemStack): String {
        return if (block is IHasItemMetaNames) {
            "${super.getUnlocalizedName(stack)}.${block.getMetaNames()[stack.metadata]}"
        } else {
            super.getUnlocalizedName(stack)
        }
    }

    override fun getMetaNames(): Map<Int, String> {
        return if (block is IHasItemMetaNames) {
            block.getMetaNames()
        } else {
            ImmutableMap.of(0, "inventory")
        }
    }
}