package ironSentinel;


import ironSentinel.block.ModBlocks;
import ironSentinel.entity.EntitySentinel;
import ironSentinel.gui.GuiHandler;
import ironSentinel.lib.Reference;
import ironSentinel.render.RenderIronSentinel;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
      modid = Reference.MOD_ID,
      name = Reference.MOD_NAME, 
      version = Reference.VERSION)

@NetworkMod(
            clientSideRequired = true, 
            serverSideRequired = true )

public class IronSentinel {

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="ironSentinel.ClientProxy", serverSide="ironSentinel.CommonProxy")
   public static ClientProxy proxy;
    
    @Instance(Reference.MOD_ID)
    public static IronSentinel instance;
    
   
    
    @EventHandler
    public void load(FMLInitializationEvent event){
        
        proxy.initRenderers();
        proxy.initSounds();
        
     // Register the GUI Handler
        //NetworkRegistry.instance().registerGuiHandler(this, this.proxy);
        //instance = this;
        
       new GuiHandler(); 
        
        
     //Registers the Mod Blocks for the game (See ModBlocks class)
        ModBlocks.init();
        ModBlocks.registerBlocks();
        ModBlocks.addNames();
        ModBlocks.registerTileEntities();
        
      //stuff for the Sentinel Entity rendering and registering in the game
        EntityRegistry.registerModEntity(ironSentinel.entity.EntitySentinel.class, "Iron Sentinel", 1, this, 80, 3, true);
        LanguageRegistry.instance().addStringLocalization("entity.EntitySentinel", "Iron Sentinel");
        RenderingRegistry.registerEntityRenderingHandler(EntitySentinel.class, new RenderIronSentinel());
        
        
       
        
    }
    
   
}
