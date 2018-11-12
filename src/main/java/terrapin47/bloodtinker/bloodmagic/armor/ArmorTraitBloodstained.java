package terrapin47.bloodtinker.bloodmagic.armor;

import WayofTime.bloodmagic.core.data.SoulNetwork;
import WayofTime.bloodmagic.core.data.SoulTicket;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class ArmorTraitBloodstained extends AbstractArmorTrait  {
    public static final ArmorTraitBloodstained bloodstained = new ArmorTraitBloodstained();

    public ArmorTraitBloodstained() {
        super("bloodstained", 0xF26263);
    }

    public static ArmorTraitBloodstained Get()
    {
        return bloodstained;
    }

    public float onDamaged(ItemStack armor, EntityPlayer player, DamageSource source, float damage, float newDamage, LivingDamageEvent event) {
        //Add life essence to the player's soul network when damaged by an enemy.
        if(source.getTrueSource() != null && source.getTrueSource() instanceof EntityLivingBase) {
            SoulNetwork network = NetworkHelper.getSoulNetwork(player);

            int essenceToAdd = 10 * Math.round(damage);
            int essenceMax = NetworkHelper.getMaximumForTier(network.getOrbTier()); //Maximum amount of essence you can get depending on blood orb.

            if(essenceMax == 0) {
                return super.onDamaged(armor, player, source, damage, newDamage, event); //Can't hold any essence, return out of function.
            }

            network.add(new SoulTicket(essenceToAdd), essenceMax);

        }
        return super.onDamaged(armor, player, source, damage, newDamage, event);
    }

}

