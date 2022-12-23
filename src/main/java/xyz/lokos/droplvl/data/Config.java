package xyz.lokos.droplvl.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import xyz.lokos.droplvl.basic.Main;
import xyz.lokos.droplvl.data.variables.VariablesBlockLvl;

import java.io.*;
import java.util.Arrays;

@Data
@EqualsAndHashCode
public class Config {

    public static Config instance;

    private VariablesBlockLvl variablesBlockLvl = new VariablesBlockLvl(
            "&7Zdobywasz expa: &a",
            BarColor.GREEN,
            "lk.permission.lvl",
            Arrays.asList(Material.STONE, Material.DIAMOND, Material.DIORITE, Material.ANDESITE),
            1
    );

    public Config init(File directory) {
        instance = this;
        try {
            if (!directory.exists())
                directory.mkdir();
            final File configFile = new File(directory, "config.json");
            if (!configFile.exists()) {
                String json = Main.instance.getGson().toJson(instance);
                FileWriter writer = new FileWriter(configFile);
                writer.write(json);
                writer.close();
                return instance;
            }
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            instance = Main.instance.getGson().fromJson(reader, Config.class);
        } catch (IOException ignored) {
        }
        return instance;
    }
}
