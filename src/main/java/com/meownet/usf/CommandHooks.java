package com.meownet.usf;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public final class CommandHooks {
    private CommandHooks() {}

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        USFAdminMod.LOGGER.info("[USF] RegisterCommandsEvent fired — registering /usf");

        CommandDispatcher<CommandSourceStack> d = event.getDispatcher();

        d.register(net.minecraft.commands.Commands.literal("usf")
            .requires(src -> src.hasPermission(2)) // OP-only for now
            .executes(ctx -> {
                ctx.getSource().sendSuccess(
                    () -> Component.literal("USF Admin Systems: /usf ping | /usf help | press 'U' for console"),
                    false
                );
                return 1;
            })
            .then(net.minecraft.commands.Commands.literal("ping").executes(ctx -> {
                ctx.getSource().sendSuccess(() -> Component.literal("pong"), false);
                return 1;
            }))
            .then(net.minecraft.commands.Commands.literal("help").executes(ctx -> {
                ctx.getSource().sendSuccess(() -> Component.literal("Press 'U' to open the Admin Console."), false);
                return 1;
            }))
        );
    }
}
