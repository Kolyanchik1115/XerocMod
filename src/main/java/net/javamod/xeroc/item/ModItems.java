package net.javamod.xeroc.item;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.item.armor.ModArmorItem;
import net.javamod.xeroc.item.armor.ModArmorMaterials;
import net.javamod.xeroc.item.food.ModFood;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Xeroc.MOD_ID);

    public static final RegistryObject<Item> COSMIC_INGOT = ITEMS.register("cosmic_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_MEAT = ITEMS.register("cosmic_meat", () -> new Item(new Item.Properties().food(ModFood.COSMIC_MEAT)));
    public static final RegistryObject<Item> COSMIC_SNICKERS = ITEMS.register("cosmic_snickers", () -> new Item(new Item.Properties().food(ModFood.COSMIC_SNICKERS)));
    public static final RegistryObject<Item> COSMIC_KURS = ITEMS.register("cosmic_kurs", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_DIPLOMA = ITEMS.register("cosmic_diploma",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COSMIC_SWORD = ITEMS.register("cosmic_sword", () -> new SwordItem(ModToolTier.COSMIC_INGOT, 8, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_AXE = ITEMS.register("cosmic_axe", () -> new AxeItem(ModToolTier.COSMIC_INGOT, 10.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_PICKAXE = ITEMS.register("cosmic_pickaxe", () -> new PickaxeItem(ModToolTier.COSMIC_INGOT, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_SHOVEL = ITEMS.register("cosmic_shovel", () -> new ShovelItem(ModToolTier.COSMIC_INGOT, 1.5F, -3.0F, new Item.Properties()));


    public static final RegistryObject<Item> COSMIC_HELMET = ITEMS.register("cosmic_helmet", () -> new ModArmorItem(ModArmorMaterials.COSMIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_CHESTPLATE = ITEMS.register("cosmic_chestplate", () -> new ModArmorItem(ModArmorMaterials.COSMIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_BOOTS = ITEMS.register("cosmic_boots", () -> new ModArmorItem(ModArmorMaterials.COSMIC, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> COSMIC_LEGGINGS = ITEMS.register("cosmic_leggings", () -> new ArmorItem(ModArmorMaterials.COSMIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));



    //    public static final RegistryObject<Item> AlIEN_SPAWN_EGG = ITEMS.register("alien_spawn_egg", () -> new ForgeSpawnEggItem(ModEntitys.ALIEN, 0x22b341, 0x19732e, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
