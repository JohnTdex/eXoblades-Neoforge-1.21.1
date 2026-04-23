package net.johntdex.exoblades.client;

import net.johntdex.exoblades.menu.CarbonatorMenu;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

public class CarbonatorScreen extends AbstractFurnaceScreen<CarbonatorMenu> {
    public CarbonatorScreen(CarbonatorMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }
}