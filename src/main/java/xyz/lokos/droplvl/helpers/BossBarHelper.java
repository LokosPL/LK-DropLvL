package xyz.lokos.droplvl.helpers;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import xyz.lokos.droplvl.basic.Main;
import xyz.lokos.droplvl.user.User;

public class BossBarHelper {

    public static void sendBossBar(User user, String text, BarColor color) {
        BossBar bossBar = Bukkit.createBossBar(ColorHelper.colored(text), color, BarStyle.SOLID);
        bossBar.addPlayer(user.getPlayer());
        bossBar.setProgress(1);
        AtomicDouble showBossBarTime = new AtomicDouble(1);
        int taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            if (showBossBarTime.getAndSet(showBossBarTime.get() - 0.1) <= 0) {
                bossBar.removePlayer(user.getPlayer());
                Bukkit.getServer().getScheduler().cancelTask(user.getTaskBossBarID().get(0));
                user.getTaskBossBarID().remove(0);
                return;
            }
            if (showBossBarTime.get() >= 0)
                bossBar.setProgress(showBossBarTime.get());
        }, 0, 1);
        user.getTaskBossBarID().add(taskID);
    }
    
}
