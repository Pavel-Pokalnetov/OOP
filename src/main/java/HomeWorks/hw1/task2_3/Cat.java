package HomeWorks.hw1.task2_3;

import java.util.Random;

public class Cat extends Item {
    private enum Stage {
        sleep,//спит
        fun, //веселится(играет)
        angry, //злится
        hungry,//голодная
        walks
    }

    private Sex sex;
    private int age;
    private int safety; //сытость 0-100%
    private int mood;
    private Stage stage;

    /**
     * @param name - кличка
     * @param sex  - пол
     * @param age  - возраст
     */
    public Cat(String name, Sex sex, int age) {
        super(name);
        this.sex = sex;
        this.age = age;
        this.safety = 70; //начальная сытость
        this.mood = 80; //начальное настроение
        this.stage = Stage.sleep;
    }

    /**
     * обмен веществ
     * уменьшение сытости и изменение настроения
     */
    public void metabolizm() {
        this.mood = Math.min(this.mood, 100);
        if (this.mood > 50) {
            if (new Random().nextBoolean()) {
                this.stage = Stage.fun;
            } else {
                this.stage = Stage.sleep;
            }
        }
        this.safety -= 20;
        if (this.safety < 20) {
            this.stage = Stage.hungry;
            speak("Мяу! Мяяяяяяяууууууу!");
        }
        if (this.safety <= 0) {
            this.safety = 0;
            speak("м... я.... у.....");
        }

    }

    /**
     * принять ласку
     */
    public void accessCaress() {
        if (this.stage == Stage.angry) {
            this.mood -= 20;
            System.out.println("Кошка разозлилась и вас оцарапала!");
        }
        if (this.safety > 40) {
            this.stage = Stage.fun;
            speak("Мур-Мур-Мур");
            this.mood+=40;
        } else {
            this.stage = Stage.angry;
            speak("Кошка злится! ШШШШШШШ!!!! Ррррр!");
            this.mood *= 0.7;
        }
        this.metabolizm();
        viewParamCat();
    }

    public void speak() {
        System.out.println("Мяу!");
    }

    public void speak(String voice) {
        System.out.println(voice);
    }


    public void eat(Integer meal) {
        this.safety += meal;
        if (this.safety > 100) {
            this.safety = 100;
            this.stage = Stage.fun;
            this.mood = 100;
        } else {
            this.safety *= 1 + (meal / this.safety);
            this.mood+=70*(meal/this.safety);
            this.mood = Math.min(this.mood, 100);
        }speak("Мурррр!!!!");
        viewParamCat();
    }

    /**
     * Ответ на зов
     */
    public void reply() {
        if (this.stage == Stage.angry) {
            return;//злая кошка не отзывается
        } else if (this.stage == Stage.sleep) {
            this.stage = Stage.walks;
        }
        speak();
        this.metabolizm();
        viewParamCat();
    }

    public void viewParamCat() {
        System.out.printf("%s --> сытость[%d] настроение[%d] состояние[%s]\n", this.getName(), this.safety, this.mood, this.stage);
    }

}
