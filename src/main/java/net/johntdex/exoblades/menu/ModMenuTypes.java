package net.johntdex.exoblades.menu;

import net.johntdex.exoblades.screen.CarbonatorMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, "exoblades");

    public static final Supplier<MenuType<CarbonatorMenu>> CARBONATOR_MENU =
            MENUS.register("carbonator_menu", () -> IMenuTypeExtension.create(CarbonatorMenu::new));
}
