package com.meownet.usf;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.platform.InputConstants;

public final class ClientInit {
    private static KeyMapping OPEN_ADMIN;

    private ClientInit() {}

    static void register(IEventBus modBus) {
        modBus.addListener(ClientInit::onRegisterKeys);
        NeoForge.EVENT_BUS.addListener(ClientInit::onKeyInput);
    }

    private static void onRegisterKeys(RegisterKeyMappingsEvent e) {
        OPEN_ADMIN = new KeyMapping(
            "key.usf_adminmod.open",              // translation key (can add to lang later)
            InputConstants.KEY_U,                 // default: U
            "key.categories.misc"                 // category
        );
        e.register(OPEN_ADMIN);
    }

    private static void onKeyInput(InputEvent.Key e) {
        if (OPEN_ADMIN != null && OPEN_ADMIN.consumeClick()) {
            Minecraft.getInstance().setScreen(new AdminScreen());
        }
    }
}
