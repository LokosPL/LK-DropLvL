package xyz.lokos.droplvl.data.variables;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class VariablesBlockLvl {

    private String messageBossBar;
    private BarColor colorBossBar;
    private String permission;
    private List<Material> block;
    private int lvl;

}
