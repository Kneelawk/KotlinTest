package org.kneelawk.kotlintest.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

class BlockKonkreteTable(material: Material) : Block(material) {
    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun addCollisionBoxToList(state: IBlockState, worldIn: World, pos: BlockPos, entityBox: AxisAlignedBB, collidingBoxes: MutableList<AxisAlignedBB>, entityIn: Entity?, isActualState: Boolean) {
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, TABLE_AABB)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG1_AABB)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG2_AABB)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG3_AABB)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG4_AABB)
    }

    override fun collisionRayTrace(blockState: IBlockState, worldIn: World, pos: BlockPos, start: Vec3d, end: Vec3d): RayTraceResult? {
        var res = rayTrace(pos, start, end, TABLE_AABB)
        if (res != null)
            return res
        res = rayTrace(pos, start, end, LEG1_AABB)
        if (res != null)
            return res
        res = rayTrace(pos, start, end, LEG2_AABB)
        if (res != null)
            return res
        res = rayTrace(pos, start, end, LEG3_AABB)
        if (res != null)
            return res
        return rayTrace(pos, start, end, LEG4_AABB)
    }

    companion object {
        val TABLE_AABB = AxisAlignedBB(0.0, 0.75, 0.0, 1.0, 1.0, 1.0)
        val LEG1_AABB = AxisAlignedBB(0.0, 0.0, 0.0, 0.25, 0.75, 0.25)
        val LEG2_AABB = AxisAlignedBB(0.75, 0.0, 0.0, 1.0, 0.75, 0.25)
        val LEG3_AABB = AxisAlignedBB(0.0, 0.0, 0.75, 0.25, 0.75, 1.0)
        val LEG4_AABB = AxisAlignedBB(0.75, 0.0, 0.75, 1.0, 0.75, 1.0)
    }
}