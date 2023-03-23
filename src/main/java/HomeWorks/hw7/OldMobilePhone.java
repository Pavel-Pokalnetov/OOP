package HomeWorks.hw7;

import java.awt.*;

// умеем звонить, слать СМС, и фоткать c камеры.
public class OldMobilePhone extends Phone implements SMSSender<SMSContentText>, RearCamera, Scheduler {

    /**
     * Голосовые звонки
     */
    @Override
    public void call() {
    }
    // -- методы камер ----------------------------------------------
    @Override
    public void smsSend(SMSContentText message) {
    }

    @Override
    public Image getPhotoFromRearCam() {
        //деваем фото и возвращаем Image
        // или null
        return null;
    }
    //  ---  методы планировщика -------------------------------------

    @Override
    public void alert() {
    }

    @Override
    public void addTask() {
    }

    @Override
    public void delTask() {
    }

    @Override
    public Task[] getTask() {
        return new Task[0];
    }

    /**
     *
     */
    @Override
    public void setFocus() {

    }
}