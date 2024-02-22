package team.teampotato.whousedrtpcommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.teampotato.whousedrtpcommand.config.JsonBean;
import team.teampotato.whousedrtpcommand.config.JsonConfigHandler;

public class WhoUsedRTPCommandMod {
    public static JsonBean loadedConfig = JsonConfigHandler.loadConfig();
    public static final String MOD_ID = "whousedrtpcommandmod";
    public static final String MOD_NAME = "WhoUsedRTPCommand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static void init() {
        JsonConfigHandler.init();
    }
}
