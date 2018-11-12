package terrapin47.bloodtinker.bloodmagic.tool;

import WayofTime.bloodmagic.core.RegistrarBloodMagicItems;
import WayofTime.bloodmagic.soul.EnumDemonWillType;
import WayofTime.bloodmagic.soul.IDemonWill;
import WayofTime.bloodmagic.soul.PlayerDemonWillHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ToolTraitSoulstealer extends AbstractTrait {
    public static final ToolTraitSoulstealer soulstealer = new ToolTraitSoulstealer();

    public ToolTraitSoulstealer() {
        super("soulstealer", 0xF26263);
    }

    public static ToolTraitSoulstealer Get()
    {
        return soulstealer;
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        //Get demon will if target died and is an enemy or player
        if(target.getHealth() <= 0 && (target instanceof EntityPlayer || target.isCreatureType(EnumCreatureType.MONSTER, false))) {
            IDemonWill soul = ((IDemonWill) RegistrarBloodMagicItems.MONSTER_SOUL);
            int looting = EnchantmentHelper.getLootingModifier(player);

            double willModifier = target instanceof EntitySlime ? 0.67 : 1;
            for (int i = 0; i <= looting; i++) {
                if (i == 0 || target.getEntityWorld().rand.nextDouble() < 0.4) {
                    ItemStack soulStack = soul.createWill(EnumDemonWillType.DEFAULT.ordinal(), willModifier * (target.getEntityWorld().rand.nextDouble()  * target.getMaxHealth() / 20d));
                    PlayerDemonWillHandler.addDemonWill((EntityPlayer)player, soulStack);
                }
            }
        }
    }

}

