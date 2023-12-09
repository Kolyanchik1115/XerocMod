//package net.javamod.xeroc.item.custom;
//
//import net.javamod.xeroc.item.ModBlock;
//import net.javamod.xeroc.util.ModTags;
//import net.javamod.xeroc.world.dimension.ModDimension;
//import net.javamod.xeroc.world.dimension.portal.ModTeleporter;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.Rotation;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.EnumProperty;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.common.util.ITeleporter;
//import net.minecraftforge.event.level.BlockEvent;
//import net.minecraftforge.eventbus.api.Cancelable;
//
//import javax.annotation.Nullable;
//
//public class ModPortalBlock extends Block {
//    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
//    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
//    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
//
//    public ModPortalBlock() {
//        super(Properties.of()
//                .strength(-1F)
//                .noCollission()
//                .lightLevel((state) -> 10)
//                .noLootTable()
//        );
//        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
//        switch (state.getValue(AXIS)) {
//            case Z:
//                return Z_AABB;
//            case X:
//            default:
//                return X_AABB;
//        }
//    }
//
//    public boolean trySpawnPortal(LevelAccessor worldIn, BlockPos pos) {
//        ModPortalBlock.Size KJPortalBlock$size = this.isPortal(worldIn, pos);
//        if (KJPortalBlock$size != null && !onTrySpawnPortal(worldIn, pos, KJPortalBlock$size)) {
//            KJPortalBlock$size.placePortalBlocks();
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean onTrySpawnPortal(LevelAccessor world, BlockPos pos, ModPortalBlock.Size size) {
//        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
//    }
//
//    @Cancelable
//    public static class PortalSpawnEvent extends BlockEvent {
//        private final ModPortalBlock.Size size;
//
//        public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, ModPortalBlock.Size size) {
//            super(world, pos, state);
//            this.size = size;
//        }
//
//        public ModPortalBlock.Size getPortalSize() {
//            return size;
//        }
//    }
//
//    @Nullable
//    public ModPortalBlock.Size isPortal(LevelAccessor worldIn, BlockPos pos) {
//        ModPortalBlock.Size KJPortalBlock$size = new Size(worldIn, pos, Direction.Axis.X);
//        if (KJPortalBlock$size.isValid() && KJPortalBlock$size.portalBlockCount == 0) {
//            return KJPortalBlock$size;
//        } else {
//            ModPortalBlock.Size KaupenPortalBlock$size1 = new Size(worldIn, pos, Direction.Axis.Z);
//            return KaupenPortalBlock$size1.isValid() && KaupenPortalBlock$size1.portalBlockCount == 0 ? KaupenPortalBlock$size1 : null;
//        }
//    }
//
//    @Override
//    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
//        Direction.Axis direction$axis = facing.getAxis();
//        Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
//        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
//        return !flag && facingState.getBlock() != this && !(new Size(worldIn, currentPos, direction$axis1)).validatePortal() ?
//                Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//    }
//
//    @Override
//    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity) {
//        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
//            if (entity.isOnPortalCooldown()) {
//                entity.setPortalCooldown();
//            } else {
//                if (!entity.level().isClientSide && !pos.equals(entity.portalEntrancePos)) {
//                    entity.portalEntrancePos = pos.immutable();
//                }
//                Level entityWorld = entity.level();
//                if (entityWorld != null) {
//                    MinecraftServer minecraftserver = entityWorld.getServer();
//                    ResourceKey<Level> destination = entity.level().dimension() == ModDimension.XEROC_KEY
//                            ? Level.OVERWORLD : ModDimension.XEROC_KEY;
//                    if (minecraftserver != null) {
//                        ServerLevel destinationWorld = minecraftserver.getLevel(destination);
//                        if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
//                            entity.level().getProfiler().push("xeroc_portal");
//                            entity.setPortalCooldown();
//                            entity.changeDimension(destinationWorld, (ITeleporter) new ModTeleporter(destinationWorld));
//                            entity.level().getProfiler().pop();
//                        }
//                    }
//
//                }
//
//            }
//        }
//    }
//
//    @OnlyIn(Dist.CLIENT)
//
//
//    @Override
//    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
//        return ItemStack.EMPTY;
//    }
//
//    @Override
//    public BlockState rotate(BlockState state, Rotation rot) {
//        switch (rot) {
//            case COUNTERCLOCKWISE_90:
//            case CLOCKWISE_90:
//                switch (state.getValue(AXIS)) {
//                    case Z:
//                        return state.setValue(AXIS, Direction.Axis.X);
//                    case X:
//                        return state.setValue(AXIS, Direction.Axis.Z);
//                    default:
//                        return state;
//                }
//            default:
//                return state;
//        }
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(AXIS);
//    }
//
//    public static class Size {
//        private final LevelAccessor level;
//        private final Direction.Axis axis;
//        private final Direction rightDir;
//        private final Direction leftDir;
//        private int portalBlockCount;
//        @Nullable
//        private BlockPos bottomLeft;
//        private int height;
//        private int width;
//
//        public Size(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
//            this.level = level;
//            this.axis = axis;
//            if (axis == Direction.Axis.X) {
//                this.leftDir = Direction.EAST;
//                this.rightDir = Direction.WEST;
//            } else {
//                this.leftDir = Direction.NORTH;
//                this.rightDir = Direction.SOUTH;
//            }
//
//            for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(level.getBlockState(pos.below())); pos = pos.below()) {
//            }
//
//            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
//            if (i >= 0) {
//                this.bottomLeft = pos.relative(this.leftDir, i);
//                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
//                if (this.width < 2 || this.width > 21) {
//                    this.bottomLeft = null;
//                    this.width = 0;
//                }
//            }
//
//            if (this.bottomLeft != null) {
//                this.height = this.calculatePortalHeight();
//            }
//
//        }
//
//        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
//            int i;
//            for (i = 0; i < 22; ++i) {
//                BlockPos blockpos = pos.relative(directionIn, i);
//                if (!this.canConnect(this.level.getBlockState(blockpos)) ||
//                        !(this.level.getBlockState(blockpos.below()).is(ModTags.Blocks.PORTAL_FRAME_BLOCK))) {
//                    break;
//                }
//            }
//
//            BlockPos framePos = pos.relative(directionIn, i);
//            return this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCK) ? i : 0;
//        }
//
//        public int getHeight() {
//            return this.height;
//        }
//
//        public int getWidth() {
//            return this.width;
//        }
//
//        protected int calculatePortalHeight() {
//            label56:
//            for (this.height = 0; this.height < 21; ++this.height) {
//                for (int i = 0; i < this.width; ++i) {
//                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
//                    BlockState blockstate = this.level.getBlockState(blockpos);
//                    if (!this.canConnect(blockstate)) {
//                        break label56;
//                    }
//
//                    Block block = blockstate.getBlock();
//                    if (block == ModBlock.COSMIC_PORTAL.get()) {
//                        ++this.portalBlockCount;
//                    }
//
//                    if (i == 0) {
//                        BlockPos framePos = blockpos.relative(this.leftDir);
//                        if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCK))) {
//                            break label56;
//                        }
//                    } else if (i == this.width - 1) {
//                        BlockPos framePos = blockpos.relative(this.rightDir);
//                        if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCK))) {
//                            break label56;
//                        }
//                    }
//                }
//            }
//
//            for (int j = 0; j < this.width; ++j) {
//                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
//                if (!(this.level.getBlockState(framePos).is(ModTags.Blocks.PORTAL_FRAME_BLOCK))) {
//                    this.height = 0;
//                    break;
//                }
//            }
//
//            if (this.height <= 21 && this.height >= 3) {
//                return this.height;
//            } else {
//                this.bottomLeft = null;
//                this.width = 0;
//                this.height = 0;
//                return 0;
//            }
//        }
//
//        protected boolean canConnect(BlockState pos) {
//            Block block = pos.getBlock();
//            return pos.isAir() || block == ModBlock.COSMIC_PORTAL.get();
//        }
//
//        public boolean isValid() {
//            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
//        }
//
//        public void placePortalBlocks() {
//            for (int i = 0; i < this.width; ++i) {
//                BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);
//
//                for (int j = 0; j < this.height; ++j) {
//                    this.level.setBlock(blockpos.above(j), ModBlock.COSMIC_PORTAL.get().defaultBlockState().setValue(ModPortalBlock.AXIS, this.axis), 18);
//                }
//            }
//
//        }
//
//        private boolean isPortalCountValidForSize() {
//            return this.portalBlockCount >= this.width * this.height;
//        }
//
//        public boolean validatePortal() {
//            return this.isValid() && this.isPortalCountValidForSize();
//        }
//    }
//}