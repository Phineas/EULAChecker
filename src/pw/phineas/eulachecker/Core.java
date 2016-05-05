package pw.phineas.eulachecker;

import org.bukkit.plugin.java.JavaPlugin;
import pw.phineas.eulachecker.api.EULAChecker;
import pw.phineas.eulachecker.commands.EULACheck;

import java.io.IOException;

/**
 * Created by Phineas (phineas.pw) on 04/05/2016.
 */
public class Core extends JavaPlugin {

    private static Core instance = null;
    public static Core getInstance() { return instance; }

    private static EULAChecker eulaChecker = null;
    public static EULAChecker getEULACheckerAPI() { return eulaChecker; }

    public void onEnable() {
        getCommand("eulacheck").setExecutor(new EULACheck());

        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            getLogger().info("Failed to connect to MCStats! ;-;");
        }
    }

    public void onDisable() {

    }

}
