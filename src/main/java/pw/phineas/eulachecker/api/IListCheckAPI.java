package pw.phineas.eulachecker.api;

/**
 * Created by Phineas (phineas.pw) on 05/05/2016.
 */
public interface IListCheckAPI {

    /**
     * Returns true/false if a server is EULA Blacklisted
     * @param ip
     * @return
     */
    public boolean isServerBlocked(String ip);

}