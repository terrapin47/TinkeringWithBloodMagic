package terrapin47.bloodtinker.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import terrapin47.bloodtinker.BloodTinker;

public class ItemBase extends Item {

    private String oredict = null;

    public ItemBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(BloodTinker.MODID + "." + name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    public ItemBase(String name, String oredict) {
        this(name);
        this.oredict = oredict;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void register(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);

        if (!(this.oredict == null)) {
            OreDictionary.registerOre(this.oredict, this);
        }
    }

}
