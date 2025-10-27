package com.meownet.usf;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AdminScreen extends Screen {
    public AdminScreen() { super(Component.literal("USF Admin Console")); }
    @Override public boolean isPauseScreen() { return false; }
}
