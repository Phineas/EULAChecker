package pw.phineas.eulachecker;

import org.bukkit.plugin.java.JavaPlugin;
import pw.phineas.eulachecker.api.ListCheckAPI;
import pw.phineas.eulachecker.commands.EULACheckCommand;

import java.io.IOException;

/**
 * Created by Phineas (phineas.pw) on 04/05/2016.
 */
public class EULAChecker extends JavaPlugin {

    private static EULAChecker instance = null;
    public static EULAChecker getInstance() { return instance; }

    private static ListCheckAPI eulaChecker = null;
    public static ListCheckAPI getEULACheckerAPI() { return eulaChecker; }

    public void onEnable() {
        instance = this;

        getCommand("eulacheck").setExecutor(new EULACheckCommand());

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
