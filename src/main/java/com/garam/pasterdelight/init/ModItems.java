package com.garam.pasterdelight.init;

import com.garam.pasterdelight.PasterDelight;
import com.garam.pasterdelight.world.item.pasterdelightknife.knive.*;
import com.pasterdream.pasterdreammod.helper.drinkandfoodproperties.PasterDreamDrinkAndFoodProperties;
import com.pasterdream.pasterdreammod.world.item.ModToolTiers;
import com.pasterdream.pasterdreammod.world.item.drinkandfooditem.PasterDreamDrinkItem;
import com.pasterdream.pasterdreammod.world.item.drinkandfooditem.PasterDreamFoodItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.CookingPotItem;
import vectorwing.farmersdelight.common.item.FuelBlockItem;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.item.SkilletItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PasterDelight.MOD_ID);

    // ====== 刀子（物理层面） ======
    public static final RegistryObject<Item> TITANIUM_KNIFE =
            ITEMS.register("titanium_knife",()-> new KnifeItem(ModToolTiers.TITANIUM, 0.5F, -2.0F,new Item.Properties()));
    public static final RegistryObject<Item> COPPER_KNIFE =
            ITEMS.register("copper_knife",()-> new KnifeItem(ModToolTiers.COPPER, 0.5F, -2.0F,new Item.Properties()));

    public static final RegistryObject<Item> DYEDREAM_KNIFE =
            ITEMS.register("dyedream_knife",()-> new KnifeItem(ModToolTiers.DYEDREAM, 0.5F, -2.0F,new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MELT_DREAM_KNIFE =
            ITEMS.register("melt_dream_knife",()-> new MeltDreamKnifeItem(ModToolTiers.MELT_DREAM, 0.5F, -2.0F,new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> CONGEAL_WIND_IRON_KNIFE =
            ITEMS.register("congeal_wind_iron_knife",()-> new CongealWindIronKnifeItem(ModToolTiers.CONGEAL_WIND_IRON, 0.5F, -1.0F,new Item.Properties()));
    public static final RegistryObject<Item> FLUFFY_WIND_ALLOY_KNIFE =
            ITEMS.register("fluffy_wind_alloy_knife",()-> new FluffyWindAlloyKnifeItem(ModToolTiers.FLUFFY_WIND_ALLOY, 0.5F, -1.0F,new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SHADOW_EROSION_KNIFE =
            ITEMS.register("shadow_erosion_knife",()-> new ShadowErosionKnifeItem(ModToolTiers.SHADOW_EROSION, 0.5F, -2.0F,new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SHADOW_ALLOY_KNIFE =
            ITEMS.register("shadow_alloy_knife",()-> new ShadowAlloyKnifeItem(ModToolTiers.SHADOW_ALLOY, 0.5F, -2.0F,new Item.Properties().rarity(Rarity.EPIC)));

    // ====== 饮品 ======

    // 玻璃杯类
    public static final RegistryObject<Item> GLASS_CUP_OF_BARLEY_TEA = ITEMS.register("glass_cup_of_barley_tea", () -> new PasterDreamDrinkItem(new PasterDreamDrinkAndFoodProperties().sanAdd(1).food(new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.REST.get(), 900, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 0), 1.0f)
            .nutrition(4).saturationMod(0.5f).alwaysEat().build())));

    public static final RegistryObject<Item> GLASS_CUP_OF_FIG_JUICE = ITEMS.register("glass_cup_of_fig_juice", () -> new PasterDreamDrinkItem(new PasterDreamDrinkAndFoodProperties().sanAdd(1.5).food(new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0f)
            .nutrition(4).saturationMod(0.5f).alwaysEat().build())));

    public static final RegistryObject<Item> SHROOMCLAW_ENERGY = ITEMS.register("shroomclaw_energy", () -> new PasterDreamDrinkItem(new PasterDreamDrinkAndFoodProperties().sanAdd(-4).food(new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), 1.0f)
            .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.CONFUSION.get(), 100, 0), 0.1f)
            .nutrition(4).saturationMod(0.5f).alwaysEat().build())){
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            tooltip.add(Component.translatable("tooltip.pasterdelight.shroomclaw_energy"));
        }
    });
    // 马提尼酒杯类
    public static final RegistryObject<Item> MARTINI_GLASS_OF_AXOLOTL_SPECIAL_DRINK = ITEMS.register("martini_glass_of_axolotl_special_drink", () -> new PasterDreamDrinkItem(new PasterDreamDrinkAndFoodProperties().sanAdd(1).food(new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 2400, 0), 1.0f)
            .effect(() -> new MobEffectInstance(ModEffects.AXOLOTL_GRACE.get(), 2400, 0), 1.0f)
            .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.COOK.get(), 1200, 0), 1.0f)
            .nutrition(3).saturationMod(0.5f).alwaysEat().build())){
        @Override
        protected void onDrinkSpecial(LivingEntity entity, Level level) {
            super.onDrinkSpecial(entity, level);
            level.playSound(null, entity.blockPosition(), SoundEvents.AXOLOTL_IDLE_AIR, SoundSource.PLAYERS, 2.0F, 1.0F);
        }

        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            tooltip.add(Component.translatable("tooltip.pasterdelight.martini_glass_of_axolotl_special_drink"));
        }
    });

    // ====== 吃的 ======

    // 碗盛放食物
    public static final RegistryObject<Item> LIGHT_BALL_FLUORESCENT_SAUCE = ITEMS.register("light_ball_fluorescent_sauce", () -> new PasterDreamFoodItem(new PasterDreamDrinkAndFoodProperties().food(new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1f)
            .nutrition(5).saturationMod(0.4f).build())){
        @Override
        protected void onFoodSpecial(LivingEntity entity, Level level)
        {
            if (!level.isClientSide && entity instanceof Player player && !player.isCreative())
            {
                ItemStack containerStack = new ItemStack(Items.BOWL);
                if (!player.getInventory().add(containerStack))
                {
                    player.drop(containerStack, false);
                }
            }
        }
    });

    // 凤梨类
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new PasterDreamFoodItem(new PasterDreamDrinkAndFoodProperties().food(new FoodProperties.Builder()
                    .nutrition(3).saturationMod(0.5f).build())));
    // 凤梨吸芽（凤梨作物的“种子”）
    public static final RegistryObject<Item> PINEAPPLE_SUCKER = ITEMS.register("pineapple_sucker",
            () -> new BlockItem(ModBlocks.PINEAPPLE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_WITH_WOLF_TAIL = ITEMS.register("pineapple_with_wolf_tail", () -> new PasterDreamFoodItem(new PasterDreamDrinkAndFoodProperties().food(new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.5f).build()).rarity(Rarity.RARE)){
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_1"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_2"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_3"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_4"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_5"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_6"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_7"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_8"));
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail.easter_egg_9"));
            }
            else {
                tooltip.add(Component.translatable("tooltip.pasterdelight.pineapple_with_wolf_tail"));
            }
        }
    });

    // 注册派 easy as a pie
    public static final RegistryObject<Item> DYEDREAM_FRUIT_PIE = ITEMS.register("dyedream_fruit_pie",
            () -> new BlockItem(ModBlocks.DYEDREAM_FRUIT_PIE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DYEDREAM_FRUIT_PIE_SLICE = ITEMS.register("dyedream_fruit_pie_slice", () -> new PasterDreamFoodItem(new PasterDreamDrinkAndFoodProperties()
            .sanAdd(1).meltDreamEnergyAdd(0.5).food(new FoodProperties.Builder()
                    .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.COOK.get(), 1200, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0f)
                    .nutrition(5).saturationMod(0.4f).alwaysEat().build())));

    public static final RegistryObject<Item> FIG_PIE = ITEMS.register("fig_pie",
            () -> new BlockItem(ModBlocks.FIG_PIE.get(), new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    super.appendHoverText(stack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.pasterdelight.fig_pie"));
                }
            });
    public static final RegistryObject<Item> FIG_PIE_SLICE = ITEMS.register("fig_pie_slice", () -> new PasterDreamFoodItem(new PasterDreamDrinkAndFoodProperties()
            .sanAdd(1).food(new FoodProperties.Builder()
                    .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.COOK.get(), 1200, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(com.pasterdream.pasterdreammod.init.ModEffects.WINDPROOF.get(), 1200, 0), 1.0f)
                    .nutrition(5).saturationMod(0.4f).alwaysEat().build()))
    {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            tooltip.add(Component.translatable("tooltip.pasterdelight.fig_pie"));
        }
    });

    // ====== 工具类方块（橱柜一类的放在这里）======

    // 锅
    public static final RegistryObject<Item> MOLTEN_GOLD_COOKING_POT = ITEMS.register("molten_gold_cooking_pot", () -> new CookingPotItem(ModBlocks.MOLTEN_GOLD_COOKING_POT.get(), new Item.Properties().stacksTo(1))
    {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_cooking_pot.1"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_cooking_pot.2"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_cooking_pot.3"));
        }

        @Override
        public boolean isFireResistant()
        {
            return true;
        }
    });
    // 炙焰金平底锅
    public static final RegistryObject<Item> MOLTEN_GOLD_SKILLET = ITEMS.register("molten_gold_skillet", () -> new SkilletItem(ModBlocks.MOLTEN_GOLD_SKILLET.get(), new Item.Properties().stacksTo(1))
    {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltip, flag);
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_skillet.1"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_skillet.2"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_skillet.3"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_skillet.4"));
            tooltip.add(Component.translatable("tooltip.pasterdelight.molten_gold_skillet.5"));
        }

        @Override
        public boolean isFireResistant()
        {
            return true;
        }
    });
    // 染梦合金平底锅
    public static final RegistryObject<Item> DYEDREAM_ALLOY_SKILLET = ITEMS.register("dyedream_alloy_skillet", () -> new SkilletItem(ModBlocks.DYEDREAM_ALLOY_SKILLET.get(), new Item.Properties().stacksTo(1))
    {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
        {
            super.appendHoverText(stack, level, tooltip, flag);
            //在这里添加Tooltip
        }
    });

    // 橱柜
    public static final RegistryObject<Item> DYEDREAM_CABINET = ITEMS.register("dyedream_cabinet", () -> new FuelBlockItem(ModBlocks.DYEDREAM_CABINET.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> SLUMBER_PALM_CABINET = ITEMS.register("slumber_palm_cabinet", () -> new FuelBlockItem(ModBlocks.SLUMBER_PALM_CABINET.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> SHADOW_CABINET = ITEMS.register("shadow_cabinet", () -> new FuelBlockItem(ModBlocks.SHADOW_CABINET.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> WIND_MOOR_CABINET = ITEMS.register("wind_moor_cabinet", () -> new FuelBlockItem(ModBlocks.WIND_MOOR_CABINET.get(), new Item.Properties(), 300));

    // 存储类方块（箱装染梦果，无花果，眠椰，凤梨）


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
