package terrapin47.bloodtinker;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import terrapin47.bloodtinker.proxy.CommonProxy;

@Mod(modid = BloodTinker.MODID, name = BloodTinker.MODNAME, version = BloodTinker.MODVERSION, useMetadata = true,
        dependencies="required-after:tconstruct;" +
                "required-after:mantle;" +
                "required-after:conarm")
public class BloodTinker {

    public static final String MODID = "bloodtinker";
    public static final String MODNAME = "BloodTinker";
    public static final String MODVERSION= "1.0.0";

    public boolean isConarmLoaded() {
        return Loader.isModLoaded("conarm");
    }

    @SidedProxy(clientSide = "terrapin47.bloodtinker.proxy.ClientProxy", serverSide = "terrapin47.bloodtinker.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static BloodTinker instance;

    public static Logger logger;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
