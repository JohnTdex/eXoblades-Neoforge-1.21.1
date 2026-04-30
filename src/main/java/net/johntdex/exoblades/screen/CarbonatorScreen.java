package net.johntdex.exoblades.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.world.item.Item;

import java.util.Set;

public class CarbonatorScreen extends AbstractFurnaceScreen<CarbonatorMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath("exoblades", "textures/gui/container/carbonator.png");

    public CarbonatorScreen(CarbonatorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(
                pMenu,
                new AbstractFurnaceRecipeBookComponent() {
                    @Override
                    protected Set<Item> getFuelItems() {
                        return Set.of();
                    }
                },
                pPlayerInventory,
                pTitle,
                TEXTURE,
                null,
                null
        );
    }

    @Override
    public void init() {
        super.init();
        // This tells the recipe book it's not allowed to be visible
        this.recipeBookComponent.init(this.width, this.height, this.minecraft, false, this.menu);
    }

    // // 3. The Rendering Logic // //
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Draw the background
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // Draw the 'Fire' animation
        if (this.menu.isLit()) {
            int k = Math.round(this.menu.getLitProgress() * 13.0F);
            guiGraphics.blit(TEXTURE, x + 56, y + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        // Draw the 'Arrow' animation
        int l = Math.round(this.menu.getBurnProgress() * 24.0F);
        guiGraphics.blit(TEXTURE, x + 79, y + 34, 176, 14, l + 1, 16);
    }
}

