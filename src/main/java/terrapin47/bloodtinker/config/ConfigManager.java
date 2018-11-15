package terrapin47.bloodtinker.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import terrapin47.bloodtinker.BloodTinker;

@Config(modid = BloodTinker.MODID)
@Mod.EventBusSubscriber(modid = BloodTinker.MODID)
public class ConfigManager {

    @Config.Comment(("Tinkering with Blood Magic general config."))
    public static ConfigMetals general = new ConfigMetals();

    public static class ConfigMetals {

        @Config.Comment(("Enable Tconstruct Integration ( Tools/Weapons) "))
        public boolean enableTcon = true;

        @Config.Comment(("Enable Conarm Integration ( Armor )"))
        public boolean enableConarm = true;

        @Config.Comment(("Enable Bloodrose Ring"))
        public boolean enableThornRing = true;

    }

}

