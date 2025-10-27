package com.meownet.usf;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(USFAdminMod.MODID)
public final class USFAdminMod {
    public static final String MODID = "usf_admin";

    public USFAdminMod() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        Registries.init(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent e) {
        // networking/commands later
    }
}
