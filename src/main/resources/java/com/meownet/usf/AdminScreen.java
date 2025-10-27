package com.meownet.usf;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AdminScreen extends Screen {
    protected AdminScreen() { super(Component.literal("USF Admin Console")); }

    @Override
    protected void init() {
        // placeholder – we’ll build the real UI next
        // (Esc closes; add widgets later)
    }

    @Override
    public boolean isPauseScreen() { return false; }
}
