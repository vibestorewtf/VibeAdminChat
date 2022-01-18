package wtf.undefined.vibeadminchat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.undefined.vibeadminchat.cmd.AdminChatCommandImpl;

public final class VibeAdminChat extends JavaPlugin {
    public FileConfiguration cfg = this.getConfig();
    public static VibeAdminChat instance;
    @Override
    public void onEnable() {
        instance = this;
        getCommand("adminchat").setExecutor(new AdminChatCommandImpl());
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    public static VibeAdminChat getInstance() {
        return instance;
    }
    @Override
    public void onDisable() {

    }
}
