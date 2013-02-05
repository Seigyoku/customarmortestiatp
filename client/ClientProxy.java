package mod.customarmortestiatp.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mod.customarmortestiatp.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
        	MinecraftForgeClient.preloadTexture(cat_png);
        	MinecraftForgeClient.preloadTexture(test_1_png);
        	MinecraftForgeClient.preloadTexture(test_2_png);
        	MinecraftForgeClient.preloadTexture(testalt_1_png);
        	MinecraftForgeClient.preloadTexture(testalt_2_png);
    }  
}
