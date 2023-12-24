package net.javamod.xeroc.datagen;

import net.javamod.xeroc.Xeroc;
import net.javamod.xeroc.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Xeroc.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.COSMIC_ORE);

        logBlock(((RotatedPillarBlock) ModBlock.COSMIC_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlock.COSMIC_WOOD.get()), blockTexture(ModBlock.COSMIC_LOG.get()), blockTexture(ModBlock.COSMIC_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlock.STRIPPED_COSMIC_LOG.get()), blockTexture(ModBlock.STRIPPED_COSMIC_LOG.get()),
                new ResourceLocation(Xeroc.MOD_ID, "block/stripped_cosmic_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlock.STRIPPED_COSMIC_WOOD.get()), blockTexture(ModBlock.STRIPPED_COSMIC_LOG.get()),
                blockTexture(ModBlock.STRIPPED_COSMIC_LOG.get()));

        blockItem(ModBlock.COSMIC_LOG);
        blockItem(ModBlock.COSMIC_WOOD);
        blockItem(ModBlock.STRIPPED_COSMIC_LOG);
        blockItem(ModBlock.STRIPPED_COSMIC_WOOD);

        blockWithItem(ModBlock.COSMIC_PLANKS);

        leavesBlock(ModBlock.COSMIC_LEAVES);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Xeroc.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}