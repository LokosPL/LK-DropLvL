package xyz.lokos.droplvl.listeners;


import lombok.NonNull;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import xyz.lokos.droplvl.basic.Main;
import xyz.lokos.droplvl.helpers.BossBarHelper;
import xyz.lokos.droplvl.user.User;

public record PlayerBlockBreakListener(Plugin plugin) implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final @NonNull User user = new User(player);
        if (player.getGameMode().equals(GameMode.CREATIVE)) return;
        if (!player.hasPermission(Main.instance.getCustomConfig().getVariablesBlockLvl().getPermission()) && !player.isOp()) return;
        if (Main.instance.getCustomConfig().getVariablesBlockLvl().getBlock().stream().noneMatch(material -> event.getBlock().getType().equals(material))) return;
        player.giveExp(Main.instance.getCustomConfig().getVariablesBlockLvl().getLvl());
        BossBarHelper.sendBossBar(user, Main.instance.getCustomConfig().getVariablesBlockLvl().getMessageBossBar(), Main.instance.getCustomConfig().getVariablesBlockLvl().getColorBossBar());
    }
}
