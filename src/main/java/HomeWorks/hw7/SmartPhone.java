package HomeWorks.hw7;

import java.awt.*;
import java.net.Socket;

public abstract class SmartPhone extends Phone implements SMSSender<SMSContent>,Internet,FrontCamera,RearCamera,Scheduler{
    protected String model;
    protected String os;
    /**
     * звоним
     */
    @Override
    public void call() {
    }

    /**
     * отпраляем смс, в.т.ч. и медиа смс (ММС)
     * @param message
     */
    @Override
    public void smsSend(SMSContent message) {

    }


    /** фото с фронтальной камеры
     * @return
     */
    @Override
    public Image getPhotoFromFrontCam() {
        return null;
    }

    /** фото с основной(тыловой) камеры
     * @return
     */
    @Override
    public Image getPhotoFromRearCam() {
        return null;
    }

    /**
     *  Фокусировка камеры
     */
    @Override
    public void setFocus() {

    }

    /**
     * событие планировщика
     */
    @Override
    public void alert() {

    }

    /**
     *
     */
    @Override
    public void addTask() {

    }

    /**
     *
     */
    @Override
    public void delTask() {

    }

    /**
     * @return
     */
    @Override
    public Task[] getTask() {
        return new Task[0];
    }

    /**
     *
     */
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
