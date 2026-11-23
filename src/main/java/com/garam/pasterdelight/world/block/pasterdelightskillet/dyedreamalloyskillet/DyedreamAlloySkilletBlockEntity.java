package com.garam.pasterdelight.world.block.pasterdelightskillet.dyedreamalloyskillet;

import com.garam.pasterdelight.Config;
import com.garam.pasterdelight.init.ModBlockEntities;
import com.garam.pasterdelight.world.block.pasterdelightskillet.PasterDelightSkilletBlockEntity;
import com.pasterdream.pasterdreammod.capability.san.SanHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.Optional;

public class DyedreamAlloySkilletBlockEntity extends PasterDelightSkilletBlockEntity
{
    public DyedreamAlloySkilletBlockEntity(BlockPos blockPosition, BlockState blockState)
    {
        super(ModBlockEntities.DYEDREAM_ALLOY_SKILLET.get(), blockPosition, blockState);
    }

    @Override
    public void tickSpacial()
    {
        if(!itemHandler.getStackInSlot(0).isEmpty() && recipe.isPresent() && isHeated())
        {
            AABB area = new AABB(worldPosition).inflate(Config.DyedreamAlloySkilletGetPlayerSanAuraDistanceLimit);
            for (ServerPlayer player : level.getEntitiesOfClass(ServerPlayer.class, area))
            {
                SanHelper.addPlayerSanAndSync(player, Config.DyedreamAlloySkilletGetPlayerSanAuraSpeed);
            }
        }
    }
}
