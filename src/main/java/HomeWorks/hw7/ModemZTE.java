package HomeWorks.hw7;

import java.net.Socket;

/**
 * Модем ZTE
 * может выходить в интернет, отправлять смс, но не может звонить
 */
public class ModemZTE extends BaseModem implements SMSSender<SMSContentText> {
    public ModemZTE() {
        this.model = "ZTE";
    }

    @Override
    public void smsSend(SMSContentText message) {
    }
}
