package com.garbagedata.ars_decor;

import com.garbagedata.ars_decor.block.ArsDecorBlockRegistry;
import com.garbagedata.ars_decor.item.ArsDecorItemRegistry;
import com.garbagedata.ars_decor.item.CreativeTabs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ArsDecor.MODID)
public class ArsDecor {
    public static final String MODID = "ars_decor";

    private static final Logger LOGGER = LogManager.getLogger();

    public ArsDecor(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        NeoForge.EVENT_BUS.register(this);

        // register my fucking blocks please
        ArsDecorBlockRegistry.register(modEventBus);
        // okay can it do items now?
        ArsDecorItemRegistry.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    public static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    // please just get in my creative tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ArsDecorBlockRegistry.SOURCESTONE_PILLAR);
            event.accept(ArsDecorBlockRegistry.SMOOTH_SOURCESTONE_PILLAR);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("If you are seeing this message, Ars Decor is installed.");
    }

}
