package com.garam.pasterdelight.event;

import com.garam.pasterdelight.PasterDelight;
import com.garam.pasterdelight.init.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PasterDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ComposterHandler
{
    @SubscribeEvent
    public static void onTagsUpdated(TagsUpdatedEvent event)
    {
        ComposterBlock.COMPOSTABLES.put(ModItems.PINEAPPLE_SUCKER.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItems.DYEDREAM_FRUIT_PIE.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FIG_PIE.get(), 1.0F);
    }
}
