package com.meownet.usf;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

final class ClientOnly {
    private static KeyMapping OPEN_ADMIN;

    private ClientOnly() {}

    static void init(IEventBus modBus) {
        modBus.addListener(ClientOnly::onRegisterKeys);
        NeoForge.EVENT_BUS.addListener(ClientOnly::onClientTick);
        USFAdminMod.LOGGER.info("[USF] ClientOnly listeners attached");
    }

    private static void onRegisterKeys(RegisterKeyMappingsEvent e) {
        OPEN_ADMIN = new KeyMapping(
            "key.usf_adminmod.open",
            InputConstants.KEY_U,
            "key.categories.misc"
        );
        e.register(OPEN_ADMIN);
        USFAdminMod.LOGGER.info("[USF] Key mapping registered (U)");
    }

    private static void onClientTick(ClientTickEvent.Post e) {
        if (OPEN_ADMIN != null && OPEN_ADMIN.consumeClick()) {
            USFAdminMod.LOGGER.info("[USF] U pressed — opening AdminScreen");
            Minecraft.getInstance().setScreen(new AdminScreen());
        }
    }
}
