package com.garbagedata.ars_decor.block;

import com.garbagedata.ars_decor.ArsDecor;
import com.garbagedata.ars_decor.item.ArsDecorItemRegistry;

// Block entities that Ars Decor will extend
import com.hollingsworth.arsnouveau.common.block.ArcanePedestal;
import com.hollingsworth.arsnouveau.common.block.ArcanePlatform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArsDecorBlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ArsDecor.MODID);

    // Registering sourcestone variants
    public static final DeferredBlock<Block> SOURCESTONE_PILLAR = registerBlock(
            "sourcestone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                .explosionResistance(6.0f)
                .requiresCorrectToolForDrops()
            )
    );

    public static final DeferredBlock<Block> SMOOTH_SOURCESTONE_PILLAR = registerBlock(
            "smooth_sourcestone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                .explosionResistance(6.0f)
                .requiresCorrectToolForDrops()
            )
    );

    public static final DeferredBlock<Block> CHISELED_SOURCESTONE = registerBlock(
            "chiseled_sourcestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .explosionResistance(6.0f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final DeferredBlock<Block> CHISELED_SMOOTH_SOURCESTONE = registerBlock(
            "chiseled_smooth_sourcestone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .explosionResistance(6.0f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final DeferredBlock<Block> SOURCEGLASS = registerBlock(
            "sourceglass",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ArsDecorItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
