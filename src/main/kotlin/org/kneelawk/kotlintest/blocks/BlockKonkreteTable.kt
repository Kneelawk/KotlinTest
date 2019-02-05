package org.kneelawk.kotlintest.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState

class BlockKonkreteTable(material: Material) : Block(material) {
    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }
}