package com.garam.pasterdelight.init;

import com.garam.pasterdelight.PasterDelight;
import com.garam.pasterdelight.world.block.pineapple.PineappleCropBlock;
import com.garam.pasterdelight.world.block.pasterdelightpie.PasterDelightPieBlock;
import com.garam.pasterdelight.world.block.pasterdelightcookingpot.moltengoldcookingpot.MoltenGoldCookingPotBlock;
import com.garam.pasterdelight.world.block.pasterdelightskillet.dyedreamalloyskillet.DyedreamAlloySkilletBlock;
import com.garam.pasterdelight.world.block.pasterdelightskillet.moltengoldskillet.MoltenGoldSkilletBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PasterDelight.MOD_ID);

    //工具类方块
    public static final RegistryObject<Block> MOLTEN_GOLD_COOKING_POT = BLOCKS.register("molten_gold_cooking_pot", MoltenGoldCookingPotBlock::new);
    public static final RegistryObject<Block> MOLTEN_GOLD_SKILLET = BLOCKS.register("molten_gold_skillet", MoltenGoldSkilletBlock::new);
    public static final RegistryObject<Block> DYEDREAM_ALLOY_SKILLET = BLOCKS.register("dyedream_alloy_skillet", DyedreamAlloySkilletBlock::new);

    //派方块
    public static final RegistryObject<Block> DYEDREAM_FRUIT_PIE = BLOCKS.register("dyedream_fruit_pie",
            () -> new PasterDelightPieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.DYEDREAM_FRUIT_PIE_SLICE));

    public static final RegistryObject<Block> FIG_PIE = BLOCKS.register("fig_pie",
            () -> new PasterDelightPieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.FIG_PIE_SLICE));

    // 作物
    public static final RegistryObject<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop",
            () -> new PineappleCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).randomTicks()));

    // 存储类方块（箱装染梦果，无花果，眠椰，凤梨）


    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
