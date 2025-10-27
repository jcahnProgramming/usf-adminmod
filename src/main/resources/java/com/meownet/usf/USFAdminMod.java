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
        ClientInit.register(modBus);      // keybind registration (client-side event)
        Registries.init(modBus);          // keep placeholder if you have it
        Commands.register();              // server command listener
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) { }
}
