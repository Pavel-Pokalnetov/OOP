package HomeWorks.hw7;

import java.net.Socket;

public interface Internet {
    void connect();
    void disconnect();
    void getIpByURL();
    void openSocket(Socket s);
    Socket getSocket();
}
