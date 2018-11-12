package terrapin47.bloodtinker.proxy;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import terrapin47.bloodtinker.BloodTinker;
import terrapin47.bloodtinker.init.ModBlocks;
import terrapin47.bloodtinker.init.ModFluids;
import terrapin47.bloodtinker.init.ModItems;
import terrapin47.bloodtinker.init.ModTinkerIntegration;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModFluids.registerFluids();
        ModTinkerIntegration.preInit();
        if (BloodTinker.isConarmLoaded()) {
            ModTinkerIntegration.preInitConarm();
        }
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModFluids.registerAlloys();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.registerBlocks(event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.registerItems(event);
        ModBlocks.registerItems(event);
        ModTinkerIntegration.init();
        if (BloodTinker.isConarmLoaded()) {
            ModTinkerIntegration.initConarm();
        }
        ModTinkerIntegration.integrate();
    }
}

