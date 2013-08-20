package ironSentinel;


import ironSentinel.block.ModBlocks;
import ironSentinel.entity.EntitySentinel;
import ironSentinel.lib.Reference;
import ironSentinel.render.RenderIronSentinel;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
    @SidedProxy(clientSide="ironSentinel.ClientProxy", serverSide="Iron Sentinel.IS_common.ironSentinel.ServerProxy")
   public static ServerProxy proxy;
    @PreInit
    public void preInit (FMLPreInitializationEvent event) {
        
    }
    
    @Init
    public void load(FMLInitializationEvent event){
        ModBlocks.init();
        
        EntityRegistry.registerModEntity(ironSentinel.entity.EntitySentinel.class, "Iron Sentinel", 1, this, 80, 3, true);
        LanguageRegistry.instance().addStringLocalization("entity.EntitySentinel", "Iron Sentinel");
        RenderingRegistry.registerEntityRenderingHandler(EntitySentinel.class, new RenderIronSentinel());
        
        
       
        //ModLoader.registerEntityID(EntitySentinel.class, "Sentinel", Reference.SENTINEL_ENTITY_DEFAULT);
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        
    }
    
    
}
