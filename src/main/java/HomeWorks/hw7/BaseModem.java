package HomeWorks.hw7;

import java.net.Socket;

/**
 * Класс базового модема
 */
public abstract class BaseModem implements Internet {
    String model;
    @Override
    public void connect() {

    }

    /**
     *
     */
    @Override
    public void disconnect() {

    }

    /**
     *
     */
    @Override
    public void getIpByURL() {

    }

    /**
     * @param s
     */
    @Override
    public void openSocket(Socket s) {

    }

    /**
     * @return
     */
    @Override
    public Socket getSocket() {
        return null;
    }
}
