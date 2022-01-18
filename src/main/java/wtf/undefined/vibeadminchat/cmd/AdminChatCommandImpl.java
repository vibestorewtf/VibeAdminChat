package wtf.undefined.vibeadminchat.cmd;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wtf.undefined.vibeadminchat.VibeAdminChat;

import java.util.Objects;

public class AdminChatCommandImpl implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("vibeadminchat.execute")) {
            if(args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(VibeAdminChat.getInstance().cfg.getString("usage"))));
            } else if (args.length > 0) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }
                String msg = builder.toString();
                for(Player ps : Bukkit.getOnlinePlayers()) {
                    if (ps.hasPermission("vibeadminchat.view")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(VibeAdminChat.getInstance().cfg.getString("adminchat-message").replace("{MSG}", msg).replace("{ADMIN}", p.getName()))));
                    }
                }
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(VibeAdminChat.getInstance().cfg.getString("permission-error"))));
        }
        return false;
    }
}
