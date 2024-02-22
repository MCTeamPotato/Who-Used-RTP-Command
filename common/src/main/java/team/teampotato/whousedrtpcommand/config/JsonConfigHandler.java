package team.teampotato.whousedrtpcommand.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import team.teampotato.whousedrtpcommand.WhoUsedRTPCommandMod;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonConfigHandler {

    private static final String CONFIG_PATH = "config" + File.separator;

    public static void init() {
        // 创建 config 文件夹
        File configFolder = new File(CONFIG_PATH);
        if (!configFolder.exists()) {
            boolean mkdirs = configFolder.mkdirs();
            WhoUsedRTPCommandMod.LOGGER.info("Config Folder MkDirs: " + mkdirs);
        }

        // 如果配置文件不存在，创建默认配置
        File configFile = new File(CONFIG_PATH + WhoUsedRTPCommandMod.MOD_NAME + ".json");
        if (!configFile.exists()) {
            JsonBean defaultConfig = new JsonBean();
            saveConfig(defaultConfig);
        }
    }

    public static void saveConfig(JsonBean config) {
        File configFile = new File(CONFIG_PATH + WhoUsedRTPCommandMod.MOD_NAME + ".json");

        try (FileWriter writer = new FileWriter(configFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonBean loadConfig() {
        File configFile = new File(CONFIG_PATH + WhoUsedRTPCommandMod.MOD_NAME + ".json");

        if (!configFile.exists()) {
            return new JsonBean(); // 如果文件不存在，返回一个新的配置对象
        }

        try (FileReader reader = new FileReader(configFile)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonBean();
        }
    }
}
