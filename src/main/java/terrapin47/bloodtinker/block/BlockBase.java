package terrapin47.bloodtinker.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import terrapin47.bloodtinker.BloodTinker;

public class BlockBase extends Block {

    private String oredict;

    public BlockBase(String name, String oredict, Material material, float hardness, String harvestTool, int harvestLevel) {
        super(material);
        setUnlocalizedName(BloodTinker.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.oredict = oredict;
        setHardness(hardness);
        setHarvestLevel(harvestTool, harvestLevel);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void register(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    public void registerAsItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        OreDictionary.registerOre(this.oredict, this);
    }

}
