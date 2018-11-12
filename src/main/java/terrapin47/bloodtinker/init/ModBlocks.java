package terrapin47.bloodtinker.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import terrapin47.bloodtinker.block.BlockBase;

public class ModBlocks {

    @GameRegistry.ObjectHolder("bloodtinker:blood_bronze_block")
    public static final BlockBase BLOOD_BRONZE_BLOCK = new BlockBase("blood_bronze_block", "blockBloodBronze", Material.ROCK, 5.f, "pickaxe", 2);

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        BLOOD_BRONZE_BLOCK.initModel();
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BLOOD_BRONZE_BLOCK.register(event);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        BLOOD_BRONZE_BLOCK.registerAsItem(event);
    }
}