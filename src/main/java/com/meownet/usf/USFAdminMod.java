package com.meownet.usf;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;

@Mod(USFAdminMod.MOD_ID)
public final class USFAdminMod {
    public static final String MOD_ID = "usf_adminmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public USFAdminMod() {
        LOGGER.info("[USF] Init on dist={}", FMLEnvironment.dist);

        // MOD bus (registries, client key registration)
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Server/game events (commands, client ticks, etc.)
        NeoForge.EVENT_BUS.addListener(CommandHooks::onRegisterCommands);
        LOGGER.info("[USF] Registered CommandHooks listener");

        // Client-only hooks
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientOnly.init(modBus);
            LOGGER.info("[USF] ClientOnly.init done");
        }
    }
}
