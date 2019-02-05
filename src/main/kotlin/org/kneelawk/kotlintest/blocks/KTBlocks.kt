package org.kneelawk.kotlintest.blocks

import io.netty.util.Constant
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fml.common.registry.ForgeRegistries
import org.kneelawk.kotlintest.creativetabs.KTCreativeTabs
import org.kneelawk.kotlintest.items.ItemBlockWithMetaNames
import org.kneelawk.kotlintest.ref.Constants

object KTBlocks {
    val blocks = ArrayList<Block>()
    val items = ArrayList<Item>()

    lateinit var blockKotlin: Block
    lateinit var blockKonkrete: Block

    fun init() {
        blockKotlin = createBlock("block_kotlin", Material.ROCK)
                .setCreativeTab(KTCreativeTabs.KOTLIN)

        blockKonkrete = setupBlockWithMetaNames("block_konkrete", BlockKonkrete(Material.ROCK))
                .setCreativeTab(KTCreativeTabs.KOTLIN)
    }

    private fun createBlock(name: String, material: Material): Block {
        val block = Block(material)
        block.setRegistryName(Constants.MODID, name)
        block.unlocalizedName = Constants.getUnlocalizedName(name)

        val itemBlock = ItemBlock(block)
        itemBlock.registryName = block.registryName

        blocks += block
        items += itemBlock

        return block
    }

    private fun setupBlock(name: String, block: Block): Block {
        block.setRegistryName(Constants.MODID, name)
        block.unlocalizedName = Constants.getUnlocalizedName(name)

        val itemBlock = ItemBlock(block)
        itemBlock.registryName = block.registryName

        blocks += block
        items += itemBlock

        return block
    }

    private fun setupBlockWithMetaNames(name: String, block: Block): Block {
        block.setRegistryName(Constants.MODID, name)
        block.unlocalizedName = Constants.getUnlocalizedName(name)

        val itemBlock = ItemBlockWithMetaNames(block)
        itemBlock.registryName = block.registryName

        blocks += block
        items += itemBlock

        return block
    }

    fun registerBlocks() {
        blocks.forEach { ForgeRegistries.BLOCKS.register(it) }
    }

    fun registerBlockItems() {
        items.forEach { ForgeRegistries.ITEMS.register(it) }
    }
}