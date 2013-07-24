package ironSentinel.block;

import ironSentinel.lib.BlockIds;
import ironSentinel.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
/*this seems to be just a place to reference blocks, a hub for referencing if you will*/
public class ModBlocks {

    /* Mod block instances */
    public static Block sentrymarker;
    public static Block redpumpkin;

    public static void init() {

        sentrymarker = new BlockSentrymarker(BlockIds.SENTRYMARKER_DEFAULT);
        redpumpkin = new BlockRedPumpkin(BlockIds.REDPUMPKIN_DEFAULT, false);
        
        GameRegistry.registerBlock(sentrymarker, Strings.SENTRYMARKER_NAME);
        GameRegistry.registerBlock(redpumpkin, Strings.SENTRYMARKER_NAME);

        //initBlockRecipes();

    }

    //private static void initBlockRecipes() {      
    //}
}
