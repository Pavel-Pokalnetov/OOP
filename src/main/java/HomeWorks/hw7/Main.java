package HomeWorks.hw7;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Phone samsungPhone = new SmartPhoneSomsung("Т1000","Android-20");
        BaseModem modemSimens = new MogemSimens("RS1221",InterfaceType.com);
        BaseModem modemZTE = new ModemZTE("1121");
        Phone dedaPhone = new OldMobilePhone();
        Phone desktopPhone = new OldPhone();

        modemZTE.connect();
        modemZTE.getIpByURL();
        modemZTE.openSocket(new Socket());
        ((ModemZTE) modemZTE).smsSend(new SMSContentText());

        modemSimens.connect();
        modemSimens.disconnect();

        dedaPhone.call();
        ((OldMobilePhone)dedaPhone).smsSend(new SMSContentText());
        desktopPhone.call();

        ((SmartPhone)samsungPhone).getPhotoFromFrontCam();
        ((SmartPhone)samsungPhone).smsSend(new SMSContentMedia());

    }}
