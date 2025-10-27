package com.meownet.usf;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod.EventBusSubscriber(modid = USFAdminMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModBusEvents {
    public static KeyMapping OPEN_ADMIN;

    private ClientModBusEvents() {}

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        OPEN_ADMIN = new KeyMapping(
            "key.usf_adminmod.open",   // translation key (optional to localize later)
            InputConstants.KEY_U,      // default key
            "key.categories.misc"
        );
        event.register(OPEN_ADMIN);
    }
}
