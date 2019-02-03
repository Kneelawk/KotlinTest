package org.kneelawk.kotlintest.creativetabs

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import org.kneelawk.kotlintest.items.KTItems

object KTCreativeTabs {
    object KOTLIN : CreativeTabs("kotlin") {
        override fun getTabIconItem(): ItemStack {
            return ItemStack(KTItems.itemKotlin)
        }
    }
}