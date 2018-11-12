package terrapin47.bloodtinker.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import terrapin47.bloodtinker.BloodTinker;
import terrapin47.bloodtinker.init.ModBlocks;
import terrapin47.bloodtinker.init.ModItems;
import terrapin47.bloodtinker.init.ModTinkerIntegration;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        if (BloodTinker.isConarmLoaded()) {
            ModTinkerIntegration.preInitConarmModel();
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels();
        ModItems.initModels();
    }
}
