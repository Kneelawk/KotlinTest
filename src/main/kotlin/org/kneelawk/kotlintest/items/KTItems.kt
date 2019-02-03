package org.kneelawk.kotlintest.items

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.ForgeRegistries
import org.kneelawk.kotlintest.ref.Constants

object KTItems {
    val items = ArrayList<Item>()

    lateinit var itemKotlin: Item

    fun init() {
        itemKotlin = createItem("itemkotlin").setCreativeTab(CreativeTabs.DECORATIONS)
    }

    private fun createItem(name: String): Item {
        val item = Item()
        item.setRegistryName(Constants.MODID, name)
        item.unlocalizedName = Constants.getUnlocalizedName(name)

        items += item

        return item
    }

    fun registerItems() {
        items.forEach { ForgeRegistries.ITEMS.register(it) }
    }
}