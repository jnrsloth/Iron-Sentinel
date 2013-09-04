package ironSentinel.block;

import ironSentinel.lib.BlockIds;
import ironSentinel.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
/*this seems to be just a place to reference blocks, a hub for referencing if you will*/
public class ModBlocks {

    /* Mod block instances */
    public static Block sentrymarker;
    public static Block redpumpkin;

    public static void init() {

        sentrymarker = new BlockSentrymarker(BlockIds.SENTRYMARKER_DEFAULT);
        redpumpkin = new BlockRedPumpkin(BlockIds.REDPUMPKIN_DEFAULT, false);
            }   
        
        public static void registerBlocks() {
            GameRegistry.registerBlock(sentrymarker, Strings.SENTRYMARKER_NAME);
            GameRegistry.registerBlock(redpumpkin, Strings.REDPUMPKIN_NAME);
            }

            public static void addNames() {
            LanguageRegistry.addName(sentrymarker,Strings.SENTRYMARKER_NAME);
            LanguageRegistry.addName(redpumpkin, Strings.REDPUMPKIN_NAME);
            }
            
        
        //initBlockRecipes();

    }

    //private static void initBlockRecipes() {      
    //}

