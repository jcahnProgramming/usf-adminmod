package com.meownet.usf;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands as Brig;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public final class Commands {
    private Commands() {}

    public static void register() {
        NeoForge.EVENT_BUS.addListener(Commands::onRegisterCommands);
    }

    private static void onRegisterCommands(RegisterCommandsEvent e) {
        CommandDispatcher<CommandSourceStack> d = e.getDispatcher();

        LiteralArgumentBuilder<CommandSourceStack> root = Brig.literal("usf")
            .requires(src -> src.hasPermission(2)) // OP-only for now
            .executes(ctx -> {
                ctx.getSource().sendSuccess(() ->
                    Component.literal("USF Admin Systems: /usf open to open the console."), false);
                return 1;
            })
            .then(Brig.literal("open").executes(ctx -> {
                // tell the player how to open via key for now
                ctx.getSource().sendSuccess(() ->
                    Component.literal("Press 'U' to open the USF Admin Console."), false);
                return 1;
            }))
            .then(Brig.literal("ping").executes(ctx -> {
                ctx.getSource().sendSuccess(() -> Component.literal("pong"), false);
                return 1;
            }));

        d.register(root);
    }
}
