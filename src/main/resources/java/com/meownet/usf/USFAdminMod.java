package com.meownet.usf;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(USFAdminMod.MOD_ID)
public final class USFAdminMod {
    public static final String MOD_ID = "usf_adminmod"; // must match mods.toml

    public USFAdminMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::onCommonSetup);
        Registries.init(modBus); // keep or remove if you haven't created it yet
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) { }
}
