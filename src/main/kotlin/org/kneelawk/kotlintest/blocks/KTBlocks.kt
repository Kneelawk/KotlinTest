package org.kneelawk.kotlintest.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.ForgeRegistries
import org.kneelawk.kotlintest.creativetabs.KTCreativeTabs
import org.kneelawk.kotlintest.ref.Constants

object KTBlocks {
    val blocks = ArrayList<Block>()
    val items = ArrayList<Item>()

    lateinit var blockKotlin: BlockItemPair

    fun init() {
        blockKotlin = createBlock("blockkotlin", Material.ROCK)
        blockKotlin.block.setCreativeTab(KTCreativeTabs.KOTLIN)
    }

    private fun createBlock(name: String, material: Material): BlockItemPair {
        val block = Block(material)
        block.setRegistryName(Constants.MODID, name)
        block.unlocalizedName = Constants.getUnlocalizedName(name)

        val itemBlock = ItemBlock(block)
        itemBlock.registryName = block.registryName

        blocks += block
        items += itemBlock

        return BlockItemPair(block, itemBlock)
    }

    fun registerBlocks() {
        blocks.forEach { ForgeRegistries.BLOCKS.register(it) }
    }

    fun registerBlockItems() {
        items.forEach { ForgeRegistries.ITEMS.register(it) }
    }
}