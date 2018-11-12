package terrapin47.bloodtinker.init;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.common.TinkerPulse;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.TinkerFluids;
import terrapin47.bloodtinker.block.fluid.FluidMoltenBloodBronze;
import WayofTime.bloodmagic.block.BlockLifeEssence;

public class ModFluids extends TinkerPulse {

    public static final FluidMoltenBloodBronze MOLTEN_BLOOD_BRONZE = new FluidMoltenBloodBronze();

    public static void registerFluids() {
        FluidRegistry.registerFluid(MOLTEN_BLOOD_BRONZE);
        FluidRegistry.addBucketForFluid(MOLTEN_BLOOD_BRONZE);
    }

    //Register smeltery recipes
    public static void registerAlloys() {
        if(!isSmelteryLoaded())
            return;

        if(TinkerIntegration.isIntegrated(TinkerFluids.bronze)) {
            TinkerRegistry.registerAlloy(new FluidStack(MOLTEN_BLOOD_BRONZE, 36),
                    new FluidStack(FluidRegistry.getFluid("bronze"), 18),
                    new FluidStack(BlockLifeEssence.getLifeEssence(), 125));
        } else {
            TinkerRegistry.registerAlloy(new FluidStack(MOLTEN_BLOOD_BRONZE, 36),
                    new FluidStack(FluidRegistry.getFluid("gold"), 18),
                    new FluidStack(BlockLifeEssence.getLifeEssence(), 125));
        }

    }

}
