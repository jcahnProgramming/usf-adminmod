package com.meownet.usf;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod.EventBusSubscriber(modid = USFAdminMod.MOD_ID)
public final class CommandEvents {

    private CommandEvents() {}

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> d = event.getDispatcher();

        d.register(net.minecraft.commands.Commands.literal("usf")
            .requires(src -> src.hasPermission(2)) // OP-only for now
            .executes(ctx -> {
                ctx.getSource().sendSuccess(() ->
                    Component.literal("USF Admin Systems: /usf ping | /usf help"), false);
                return 1;
            })
            .then(net.minecraft.commands.Commands.literal("ping").executes(ctx -> {
                ctx.getSource().sendSuccess(() -> Component.literal("pong"), false);
                return 1;
            }))
            .then(net.minecraft.commands.Commands.literal("help").executes(ctx -> {
                ctx.getSource().sendSuccess(() ->
                    Component.literal("Press 'U' to open the Admin Console."), false);
                return 1;
            }))
        );
    }
}
