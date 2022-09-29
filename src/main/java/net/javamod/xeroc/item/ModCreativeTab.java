package net.javamod.xeroc.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public  static final CreativeModeTab XEROC_TAB = new CreativeModeTab("xeroctab"){
        @Override
        public ItemStack makeIcon(){
            return  new ItemStack(ModItems.COSMIC_SWORD.get());
        }
    };
}

