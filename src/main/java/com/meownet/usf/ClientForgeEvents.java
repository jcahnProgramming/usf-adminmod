package com.meownet.usf;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@Mod.EventBusSubscriber(modid = USFAdminMod.MOD_ID, value = Dist.CLIENT)
public final class ClientForgeEvents {
    private ClientForgeEvents() {}

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post e) {
        if (ClientModBusEvents.OPEN_ADMIN != null && ClientModBusEvents.OPEN_ADMIN.consumeClick()) {
            Minecraft.getInstance().setScreen(new AdminScreen());
        }
    }
}
