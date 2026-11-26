package com.garam.pasterdelight.datagen.common;

import com.garam.pasterdelight.init.ModBlocks;
import com.garam.pasterdelight.init.ModItems;
import com.garam.pasterdelight.world.block.pineapple.PineappleCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider
{
    public ModBlockLootTablesProvider()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        dropNone(ModBlocks.DYEDREAM_FRUIT_PIE.get());
        dropNone(ModBlocks.FIG_PIE.get());

        dropSelf(ModBlocks.MOLTEN_GOLD_COOKING_POT.get());
        dropSelf(ModBlocks.MOLTEN_GOLD_SKILLET.get());
        dropSelf(ModBlocks.DYEDREAM_ALLOY_SKILLET.get());

        LootItemBlockStatePropertyCondition.Builder maxAge = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PINEAPPLE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(CropBlock.AGE, PineappleCropBlock.MAX_AGE));

        add(ModBlocks.PINEAPPLE_CROP.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(ModItems.PINEAPPLE_WITH_WOLF_TAIL.get())
                                        .when(maxAge)
                                        .when(LootItemRandomChanceCondition.randomChance(0.05F)),
                                LootItem.lootTableItem(ModItems.PINEAPPLE.get())
                                        .when(maxAge),
                                LootItem.lootTableItem(ModItems.PINEAPPLE_SUCKER.get())
                        )))
                .withPool(LootPool.lootPool()
                        .when(maxAge)
                        .add(LootItem.lootTableItem(ModItems.PINEAPPLE_SUCKER.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));

        dropSelf(ModBlocks.DYEDREAM_CABINET.get());
        dropSelf(ModBlocks.SLUMBER_PALM_CABINET.get());
        dropSelf(ModBlocks.SHADOW_CABINET.get());
        dropSelf(ModBlocks.WIND_MOOR_CABINET.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected void dropNone(Block block)
    {
        this.add(block, LootTable.lootTable());
    }
}
