package net.darkhax.toolstats;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Tier;

import java.lang.reflect.Method;

public class ToolStatsFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        final ToolStatsCommon toolStats = new ToolStatsCommon(FabricLoader.getInstance().getConfigDir(), stack -> stack.getItem().getEnchantmentValue(), ToolStatsFabric::getHarvestLevel);

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> toolStats.displayTooltipInfo(stack, lines, type));
    }

    private static int getHarvestLevel(Tier tier) {

        if (tier == Tiers.WOOD || tier == Tiers.GOLD) return 0;
        if (tier == Tiers.STONE) return 1;
        if (tier == Tiers.IRON) return 2;
        if (tier == Tiers.DIAMOND) return 3;
        if (tier == Tiers.NETHERITE) return 4;

        // Minecraft 1.21 removed the scalar level from Tier. Keep compatibility with
        // third-party Tier implementations that still expose the old public method.
        try {
            final Method method = tier.getClass().getMethod("getLevel");
            return ((Number) method.invoke(tier)).intValue();
        }
        catch (ReflectiveOperationException ignored) {
            return -1;
        }
    }
}
