package top.baimoqilin.BaimoMenu;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.util.List;

public class BaimoMenu extends PluginBase implements Listener {

    private Config config;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.config = this.getConfig();
        this.getServer().getPluginManager().registerEvents(new BaimoMenuListener(this), this);
    }

    public List<?> getItems(String worldName) {
        return this.config.getList("worlds." + worldName + ".items");
    }

    public boolean isEnabled(String worldName) {
        return this.config.getBoolean("worlds." + worldName + ".enabled");
    }

}
