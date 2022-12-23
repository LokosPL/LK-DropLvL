package xyz.lokos.droplvl.basic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.lokos.droplvl.data.Config;
import xyz.lokos.droplvl.listeners.PlayerBlockBreakListener;
import xyz.lokos.droplvl.registry.Registry;

@Getter
public class Main extends JavaPlugin {

    public static Main instance;

    private Gson gson;
    private Gson gsonWithoutStyle;
    private Config customConfig;

    @Override
    public void onEnable() {
        instance = this;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.gsonWithoutStyle = new GsonBuilder().create();

        this.customConfig = new Config().init(this.getDataFolder());

        new Registry(this).registerListener(
                new PlayerBlockBreakListener(this)
        );
    }
}
