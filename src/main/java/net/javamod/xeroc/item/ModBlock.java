package net.javamod.xeroc.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.javamod.xeroc.Xeroc.MOD_ID;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> COSMIC_ORE = BLOCKS.register("cosmic_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(2F, 8.0F)));
}
