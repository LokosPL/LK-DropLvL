package xyz.lokos.droplvl.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

@Setter
@Getter
@EqualsAndHashCode
public class User {

    private final Player player;
    private ArrayList<Integer> taskBossBarID;

    public User(Player player) {
        this.player = player;
        this.taskBossBarID = new ArrayList<>();
    }
}
