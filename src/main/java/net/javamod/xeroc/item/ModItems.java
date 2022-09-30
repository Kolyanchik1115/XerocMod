package net.javamod.xeroc.item;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static net.javamod.xeroc.Xeroc.MOD_ID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> COSMIC_MEAT = ITEMS.register("cosmic_meat", () -> new Item(new Item.Properties().tab(ModCreativeTab.XEROC_TAB).food(ModFood.COSMIC_MEAT)));
    public static final RegistryObject<Item> COSMIC_SNICKERS = ITEMS.register("cosmic_snickers", () -> new Item(new Item.Properties().tab(ModCreativeTab.XEROC_TAB).food(ModFood.COSMIC_SNICKERS)));
    public static final RegistryObject<Item> COSMIC_ORE = ITEMS.register("cosmic_ore", () -> new BlockItem(ModBlock.COSMIC_ORE.get(), new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_INGOT = ITEMS.register("cosmic_ingot", () -> new Item(new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_KURS = ITEMS.register("cosmic_kurs", () -> new Item(new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_DIPLOMA = ITEMS.register("cosmic_diploma", () -> new Item(new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_SWORD = ITEMS.register("cosmic_sword", () -> new SwordItem(ModTier.COSMIC_INGOT,8, -2.4F,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_AXE = ITEMS.register("cosmic_axe", () -> new AxeItem(ModTier.COSMIC_INGOT,10.0F, -3.1F,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_PICKAXE = ITEMS.register("cosmic_pickaxe", () -> new PickaxeItem(ModTier.COSMIC_INGOT,1, -2.8F,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_SHOVEL = ITEMS.register("cosmic_shovel", () -> new ShovelItem(ModTier.COSMIC_INGOT,1.5F, -3.0F,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_HELMET = ITEMS.register("cosmic_helmet", () -> new ModArmorItem(ModArmor.COSMIC, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_CHESTPLATE = ITEMS.register("cosmic_chestplate", () -> new ArmorItem(ModArmor.COSMIC, EquipmentSlot.CHEST,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_BOOTS = ITEMS.register("cosmic_boots", () -> new ArmorItem(ModArmor.COSMIC, EquipmentSlot.FEET,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));
    public static final RegistryObject<Item> COSMIC_LEGGINGS = ITEMS.register("cosmic_leggings", () -> new ArmorItem(ModArmor.COSMIC, EquipmentSlot.LEGS,new Item.Properties().tab(ModCreativeTab.XEROC_TAB)));


}
