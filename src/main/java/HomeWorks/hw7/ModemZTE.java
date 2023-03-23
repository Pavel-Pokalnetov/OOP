package HomeWorks.hw7;

import java.net.Socket;

/**
 * Модем ZTE
 * может выходить в интернет, отправлять смс, но не может звонить
 */
public class ModemZTE extends BaseModem implements SMSSender<SMSContentText> {


    public ModemZTE(String model) {
        this.model = model;
        this.type = InterfaceType.usb;
    }

    @Override
    public void smsSend(SMSContentText message) {
    }
}
