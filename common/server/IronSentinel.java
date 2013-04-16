package server;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Iron Sentinel", name="Iron Sentinel", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class IronSentinel {
    
    public final static Block GolemMarker = new BlockGolemMarker(500, 1, Material.plants)
        .setHardness(1.5F).setStepSound(Block.soundMetalFootstep)
        .setBlockName("Golem Marker").setCreativeTab(CreativeTabs.tabBlock);
      
    // The instance of your mod that Forge uses.
        @Instance("Iron Sentinel")
        public static IronSentinel instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="IS_common.client.ClientProxy", serverSide="IS_common.server.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
           //Golem marker block     
                LanguageRegistry.addName(GolemMarker, "Golem Marker");
                MinecraftForge.setBlockHarvestLevel(GolemMarker, "pickaxe", 0);
                GameRegistry.registerBlock(GolemMarker, "Golem Marker");
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}