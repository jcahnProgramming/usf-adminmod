package com.meownet.usf;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;
import net.minecraft.world.item.Item;

public final class Registries {
    private Registries() {}

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, USFAdminMod.MODID);

    public static final RegistryObject<Item> ADMIN_SCEPTER =
            ITEMS.register("admin_scepter", () -> new Item(new Item.Properties().stacksTo(1)));

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
