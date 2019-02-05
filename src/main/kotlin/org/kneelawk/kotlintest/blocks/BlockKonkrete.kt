package org.kneelawk.kotlintest.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.IStringSerializable
import net.minecraft.util.NonNullList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.kneelawk.kotlintest.items.IHasItemMetaNames

class BlockKonkrete(material: Material) : Block(material), IHasItemMetaNames {
    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, VARIANT)
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty(VARIANT, KonkreteType.byMetadata(meta))
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue(VARIANT).meta
    }

    override fun getStateForPlacement(worldIn: World, pos: BlockPos, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float, meta: Int, placer: EntityLivingBase): IBlockState {
        return defaultState.withProperty(VARIANT, KonkreteType.byMetadata(meta))
    }

    override fun damageDropped(state: IBlockState): Int {
        return state.getValue(VARIANT).meta
    }

    override fun getSubBlocks(itemIn: CreativeTabs, items: NonNullList<ItemStack>) {
        items += ItemStack(this, 1, KonkreteType.NORMAL.meta)
        items += ItemStack(this, 1, KonkreteType.BRICKS.meta)
        items += ItemStack(this, 1, KonkreteType.TILES.meta)
    }

    override fun getMetaNames(): Map<Int, String> {
        return META_NAMES
    }

    companion object {
        val VARIANT = PropertyEnum.create("variant", KonkreteType::class.java)

        private val META_NAMES = KonkreteType.values().map { it.meta to "${VARIANT.name}=${it.serializedName}" }.toMap()

        enum class KonkreteType(val meta: Int, val serializedName: String) : IStringSerializable {
            NORMAL(0, "normal"),
            BRICKS(1, "bricks"),
            TILES(2, "tiles");

            override fun getName(): String {
                return serializedName
            }

            override fun toString(): String {
                return serializedName
            }

            companion object {
                private val META_LOOKUP = Array(values().size) { NORMAL }

                fun byMetadata(meta: Int): KonkreteType {
                    if (meta < 0 || meta >= META_LOOKUP.size) {
                        return META_LOOKUP[0]
                    }

                    return META_LOOKUP[meta]
                }

                init {
                    values().forEach {
                        META_LOOKUP[it.meta] = it
                    }
                }
            }
        }
    }
}