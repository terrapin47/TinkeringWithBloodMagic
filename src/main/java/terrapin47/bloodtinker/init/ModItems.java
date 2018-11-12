package terrapin47.bloodtinker.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import terrapin47.bloodtinker.item.ItemBase;
import terrapin47.bloodtinker.item.ItemBloodyThornRing;

public class ModItems {

    @GameRegistry.ObjectHolder("bloodtinker:blood_bronze_ingot")
    public static final ItemBase BLOOD_BRONZE_INGOT = new ItemBase("blood_bronze_ingot", "ingotBloodBronze");

    @GameRegistry.ObjectHolder("bloodtinker:bloody_thorn_ring")
    public static final ItemBloodyThornRing BLOODY_THORN_RING = new ItemBloodyThornRing();

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        BLOOD_BRONZE_INGOT.initModel();
        BLOODY_THORN_RING.initModel();
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        BLOOD_BRONZE_INGOT.register(event);
        BLOODY_THORN_RING.register(event);
    }

}
