package org.kneelawk.kotlintest.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.properties.IProperty
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.Rotation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
class BlockKonkretePillar(material: Material) : Block(material) {
    init {
        defaultState = blockState.baseState.withProperty(AXIS, EnumFacing.Axis.Y)
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, AXIS)
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty(AXIS, axisFromMetadata(meta))
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return metadataFromAxis(state.getValue(AXIS))
    }

    override fun damageDropped(state: IBlockState): Int {
        return metadataFromAxis(EnumFacing.Axis.Y)
    }

    override fun getSilkTouchDrop(state: IBlockState): ItemStack {
        return ItemStack(this, 1, metadataFromAxis(EnumFacing.Axis.Y))
    }

    override fun getStateForPlacement(worldIn: World, pos: BlockPos, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float, meta: Int, placer: EntityLivingBase): IBlockState {
        return defaultState.withProperty(AXIS, facing.axis)
    }

    override fun rotateBlock(world: World, pos: BlockPos, axis: EnumFacing): Boolean {
        val state = world.getBlockState(pos)
        state.propertyKeys.forEach { property ->
            if (AXIS.name.equals(property.getName()) && AXIS.valueClass == property.getValueClass()) {
                val blockAxis = state.getValue(property as IProperty<EnumFacing.Axis>)
                val newAxis = when (axis.axis) {
                    EnumFacing.Axis.Y -> {
                        when (blockAxis) {
                            EnumFacing.Axis.X -> EnumFacing.Axis.Z
                            EnumFacing.Axis.Y -> EnumFacing.Axis.Y
                            EnumFacing.Axis.Z -> EnumFacing.Axis.X
                        }
                    }
                    EnumFacing.Axis.X -> {
                        when (blockAxis) {
                            EnumFacing.Axis.X -> EnumFacing.Axis.X
                            EnumFacing.Axis.Y -> EnumFacing.Axis.Z
                            EnumFacing.Axis.Z -> EnumFacing.Axis.Y
                        }
                    }
                    EnumFacing.Axis.Z -> {
                        when (blockAxis) {
                            EnumFacing.Axis.X -> EnumFacing.Axis.Y
                            EnumFacing.Axis.Y -> EnumFacing.Axis.X
                            EnumFacing.Axis.Z -> EnumFacing.Axis.Z
                        }
                    }
                }
                world.setBlockState(pos, state.withProperty(property, newAxis))
                return true
            }
        }
        return false
    }

    override fun withRotation(state: IBlockState, rot: Rotation): IBlockState {
        return when (rot) {
            Rotation.CLOCKWISE_90, Rotation.COUNTERCLOCKWISE_90 -> {
                when (state.getValue(AXIS)) {
                    EnumFacing.Axis.X -> state.withProperty(AXIS, EnumFacing.Axis.Z)
                    EnumFacing.Axis.Y -> state
                    EnumFacing.Axis.Z -> state.withProperty(AXIS, EnumFacing.Axis.X)
                }
            }
            else -> state
        }
    }

    companion object {
        val AXIS = PropertyEnum.create("axis", EnumFacing.Axis::class.java)

        private fun axisFromMetadata(meta: Int): EnumFacing.Axis {
            return when (meta) {
                1 -> EnumFacing.Axis.X
                2 -> EnumFacing.Axis.Z
                else -> EnumFacing.Axis.Y
            }
        }

        private fun metadataFromAxis(axis: EnumFacing.Axis): Int {
            return when (axis) {
                EnumFacing.Axis.Y -> 0
                EnumFacing.Axis.X -> 1
                EnumFacing.Axis.Z -> 2
            }
        }
    }
}