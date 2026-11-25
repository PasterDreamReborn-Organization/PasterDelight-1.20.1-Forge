package com.garam.pasterdelight.world.block.pineapple;

import com.garam.pasterdelight.init.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class PineappleCropBlock extends CropBlock
{
    // 凤梨有 0~6 共 7 个生长阶段（贴图 pineapple_age0 ~ pineapple_age6）
    public static final int MAX_AGE = 6;

    public PineappleCropBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public int getMaxAge()
    {
        return MAX_AGE;
    }

    // 采集中键/破坏时给玩家返回的“种子”（凤梨吸芽）
    @Override
    protected ItemLike getBaseSeedId()
    {
        return ModItems.PINEAPPLE_SUCKER.get();
    }
}
