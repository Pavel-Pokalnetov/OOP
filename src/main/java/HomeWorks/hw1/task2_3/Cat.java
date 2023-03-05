package HomeWorks.hw1.task2_3;

import java.util.Random;

public class Cat extends Item {
    enum Stage {
        sleep,//спит
        fun, //веселится(играет)
        angry, //злится
        hungry,//голодная
        walks
    }

    Sex sex;
    int age;
    int safety; //сытость 0-100%
    int mood;
    Stage stage;

    /**
     * обмен веществ
     * уменьшение сытости
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
            System.out.println("м... я.... у.....");
        }

    }

    /**
     * @param name - кличка
     * @param sex  - пол
     * @param age  - возраст
     */
    public Cat(String name, Sex sex, int age) {
        super(name);
        this.sex = sex;
        this.age = age;
        this.safety = 50; //начальная сытость
        this.mood = 60; //начальное настроение
        this.stage = Stage.sleep;
    }

    public void accessCaress() { //принять ласку
        if (this.stage == Stage.angry) {
            this.mood = 0;
            System.out.println("Кошка разозлилась и вас оцарапала!");
        }
        if (this.safety > 50) {
            this.stage = Stage.fun;
            speak("Мур-Мур-Мур");
        } else {
            this.stage = Stage.angry;
            speak("Кошка злится! ШШШШШШШ!!!! Ррррр!");
            this.mood *= 0.5;
        }
        this.metabolizm();
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
            speak("Мурррр!!!!");
        } else {
            this.mood *= 1 + (meal / this.safety);
            this.mood = Math.min(this.mood, 100);
        }
        this.metabolizm();
    }

    public void reply() {
        if (this.stage == Stage.angry) {
            return;//злая кошка не отзывается
        } else if (this.stage == Stage.sleep) {
            this.stage = Stage.walks;
        }
        speak();
        this.metabolizm();
    }

    ;

}
