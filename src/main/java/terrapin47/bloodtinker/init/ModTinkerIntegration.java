package terrapin47.bloodtinker.init;

import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import c4.conarm.lib.materials.ArmorMaterialType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.common.TinkerPulse;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import terrapin47.bloodtinker.BloodTinker;
import terrapin47.bloodtinker.bloodmagic.armor.ArmorTraitBloodstained;
import terrapin47.bloodtinker.bloodmagic.tool.ToolTraitSoulstealer;
import terrapin47.bloodtinker.config.ConfigManager;

import static slimeknights.tconstruct.library.utils.HarvestLevels.OBSIDIAN;

public class ModTinkerIntegration extends TinkerPulse {

    public static final Material BLOOD_BRONZE_MAT = new Material("bloodbronze", 0xF26263);

    static public void preInit() {
        BLOOD_BRONZE_MAT.addItemIngot("ingotBloodBronze");
        BLOOD_BRONZE_MAT.addItem("ingotBloodBronze", Material.VALUE_Ingot, 1);
        BLOOD_BRONZE_MAT.setRepresentativeItem("ingotBloodBronze");
        BLOOD_BRONZE_MAT.setFluid(ModFluids.MOLTEN_BLOOD_BRONZE);
        BLOOD_BRONZE_MAT.setCraftable(false).setCastable(true);
        BLOOD_BRONZE_MAT.addTrait(ToolTraitSoulstealer.Get());
    }

    static public void preInitConarm() {
        BLOOD_BRONZE_MAT.addTrait(ArmorTraitBloodstained.Get(), ArmorMaterialType.CORE);
        BLOOD_BRONZE_MAT.addTrait(ArmorTraitBloodstained.Get(), ArmorMaterialType.PLATES);
        BLOOD_BRONZE_MAT.addTrait(ArmorTraitBloodstained.Get(), ArmorMaterialType.TRIM);
    }

    @SideOnly(Side.CLIENT)
    static public void preInitModel() {
        BLOOD_BRONZE_MAT.setRenderInfo(new MaterialRenderInfo.Metal(0x8A0707, 0.25f, 0.25f, -0.1f));
    }

    static public void init()
    {
        TinkerRegistry.addMaterial(BLOOD_BRONZE_MAT);
        if (ConfigManager.general.enableTcon) {
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new HeadMaterialStats(550, 8.2f, 6.20f, OBSIDIAN));
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new HandleMaterialStats(0.70f, 125));
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new ExtraMaterialStats(95));
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new BowMaterialStats(0.70f, 1.25f, 3.2f));
        }
        TinkerRegistry.registerMelting("ingotBloodBronze", ModFluids.MOLTEN_BLOOD_BRONZE, 144);
        TinkerRegistry.registerMelting("blockBloodBronze", ModFluids.MOLTEN_BLOOD_BRONZE, 1296);
        TinkerRegistry.registerBasinCasting(new ItemStack(ModBlocks.BLOOD_BRONZE_BLOCK), ItemStack.EMPTY, ModFluids.MOLTEN_BLOOD_BRONZE, 1296);
        if (isSmelteryLoaded()) {
            TinkerRegistry.registerTableCasting(new ItemStack(ModItems.BLOOD_BRONZE_INGOT), TinkerSmeltery.castIngot, ModFluids.MOLTEN_BLOOD_BRONZE, 144);
        }
    }

    static public void initConarm() {
        if (BloodTinker.isConarmLoaded() && ConfigManager.general.enableConarm) {
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new CoreMaterialStats(17.5f, 17));
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new PlatesMaterialStats(0.9f, 7, 2));
            TinkerRegistry.addMaterialStats(BLOOD_BRONZE_MAT, new TrimMaterialStats(7.0f));
        }
    }

    static public void integrate() {
        if (ConfigManager.general.enableTcon || ConfigManager.general.enableConarm) {
            TinkerRegistry.integrate(BLOOD_BRONZE_MAT);
        }
    }

}


