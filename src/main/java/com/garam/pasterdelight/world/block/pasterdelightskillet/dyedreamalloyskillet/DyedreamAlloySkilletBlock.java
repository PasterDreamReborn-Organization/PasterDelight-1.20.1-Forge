package com.garam.pasterdelight.world.block.pasterdelightskillet.dyedreamalloyskillet;

import com.garam.pasterdelight.init.ModBlockEntities;
import com.garam.pasterdelight.world.block.pasterdelightskillet.PasterDelightSkilletBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class DyedreamAlloySkilletBlock extends PasterDelightSkilletBlock
{
    public DyedreamAlloySkilletBlock()
    {
        super(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.SKILLET.get()));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPosition, BlockState blockState)
    {
        return ModBlockEntities.DYEDREAM_ALLOY_SKILLET.get().create(blockPosition, blockState);
    }

    @Override
    public BlockEntityType<DyedreamAlloySkilletBlockEntity> getBlockEntity()
    {
        return ModBlockEntities.DYEDREAM_ALLOY_SKILLET.get();
    }
}
