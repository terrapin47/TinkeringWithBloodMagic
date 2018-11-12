package terrapin47.bloodtinker.block.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import terrapin47.bloodtinker.BloodTinker;


public class FluidMoltenBlock extends BlockFluidClassic {

    public FluidMoltenBlock(String name, Fluid fluid) {
        super(fluid, Material.LAVA);
        setUnlocalizedName(BloodTinker.MODID + "." + name);
        setRegistryName(name);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "fluid"));
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(FluidMoltenBlock.LEVEL).build());
    }

    public void register(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    public void registerAsItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

}