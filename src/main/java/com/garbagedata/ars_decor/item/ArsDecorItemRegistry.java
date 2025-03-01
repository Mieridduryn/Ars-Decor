package com.garbagedata.ars_decor.item;

import net.neoforged.bus.api.IEventBus;

import com.garbagedata.ars_decor.ArsDecor;
import com.garbagedata.ars_decor.block.ArsDecorBlockRegistry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ArsDecorItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArsDecor.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
