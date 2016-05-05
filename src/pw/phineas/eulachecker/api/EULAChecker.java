package pw.phineas.eulachecker.api;

import pw.phineas.eulachecker.utils.BlocklistChecker;
import pw.phineas.eulachecker.utils.HashConverter;

/**
 * Created by Phineas (phineas.pw) on 05/05/2016.
 */
public class EULAChecker implements IEULAChecker {

    public boolean isServerBlocked(String ip) {
        String blockList;

        String hashedIP = HashConverter.convertToSHA(ip);

        try {
            blockList = BlocklistChecker.getBlockList("https://sessionserver.mojang.com/blockedservers");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return blockList.contains(hashedIP);
    }
}
