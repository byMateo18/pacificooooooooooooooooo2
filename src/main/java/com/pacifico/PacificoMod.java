package com.pacifico;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(PacificoMod.MODID)
public class PacificoMod {
    public static final String MODID = "pacifico";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Item> CERVEZA_PACIFICO = ITEMS.register(
            "cerveza_pacifico",
            () -> new BeerItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<CreativeModeTab> PACIFICO_TAB = TABS.register(
            "pacifico_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pacifico"))
                    .icon(() -> CERVEZA_PACIFICO.get().getDefaultInstance())
                    .displayItems((params, output) -> output.accept(CERVEZA_PACIFICO.get()))
                    .build());

    public PacificoMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        TABS.register(bus);
    }
}
