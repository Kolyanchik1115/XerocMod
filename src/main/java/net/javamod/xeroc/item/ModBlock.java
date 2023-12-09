package net.javamod.xeroc.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.javamod.xeroc.Xeroc.MOD_ID;

public class ModBlock {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> COSMIC_ORE = BLOCKS.register("cosmic_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2F, 8.0F)));
//    public static final RegistryObject<Block> COSMIC_PORTAL = BLOCKS.register("xeroc_portal", ModPortalBlock::new);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
