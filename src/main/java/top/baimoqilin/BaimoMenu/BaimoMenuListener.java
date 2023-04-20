package top.baimoqilin.BaimoMenu;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.item.Item;

import java.util.List;

public class BaimoMenuListener implements Listener {

    private final BaimoMenu plugin;

    public BaimoMenuListener(BaimoMenu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String worldName = player.getLevel().getName();
        if (this.plugin.isEnabled(worldName)) {
            this.addItemsToInventory(player, worldName);
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        String worldName = player.getLevel().getName();
        if (this.plugin.isEnabled(worldName)) {
            this.addItemsToInventory(player, worldName);
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Item item = event.getItem();
        if (item != null && item.hasCustomName()) {
            String worldName = player.getLevel().getName();
            List<?> items = this.plugin.getItems(worldName);
            for (Object itemObj : items) {
                if (itemObj instanceof Item) {
                    Item configItem = (Item) itemObj;
                    if (configItem.getCustomName().equals(item.getCustomName())) {
                        String command = this.plugin.getConfig().getString("worlds." + worldName + ".items." + items.indexOf(itemObj) + ".command");
                        player.getServer().dispatchCommand(player, command);
                        break;
                    }
                }
            }
        }
    }

    private void addItemsToInventory(Player player, String worldName) {
        player.getInventory().clearAll();
        List<?> items = this.plugin.getItems(worldName);
        for (Object itemObj : items) {
            if (itemObj instanceof Item) {
                Item item = (Item) itemObj;
                player.getInventory().addItem(item);
            }
        }
    }
}