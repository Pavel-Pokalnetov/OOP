package HomeWorks.hw1.task2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int i = 1;

    public static void main(String[] args) {
        stepDelimiter("Кошка, человеку и шкаф.");
        demo1();

        stepDelimiter("Дядя Фёдор, пес и кот.");
        demo2();

        stepDelimiter("Компараторы");

        ArrayList<BaseCreature> animals = new ArrayList<>();
        animals.add(new Cat("Мурка",Sex.woman,1));
        animals.add(new Cat("Муся",Sex.woman,3));
        animals.add(new Cat("Дуся",Sex.woman,2));
        animals.add(new Cat("Степа",Sex.man,7));
        animals.add(new Cat("Васька",Sex.man,5));
        animals.add(new Cat("Бася",Sex.man,2));
        System.out.println("базовый список: "+animals);
        Collections.sort(animals,new FromNameComparator());
        System.out.println("Сортировка по имени: "+animals);
        Collections.sort(animals);
        System.out.println("Сортировка по возрасту: "+animals);

    }

    private static void demo2() {
        // работа equals()
        BaseCreature cat = new Cat("Матроскин", Sex.woman, 1);
        BaseCreature dog = new Dog("Шарик", Sex.man, 5);
        Human man = new Human("дядя Фёдор", Sex.man, 6);
        Bird galchenok = new Bird("Галчонок", Sex.man, 1);

        man.call(cat);
        man.call(dog);
        cat.call(dog);
        dog.call(man);
        man.feed_to(cat, 10);
        man.feed_to(dog, 10);
        cat.call(galchenok);
        galchenok.call(cat);
    }

    private static void demo1() {
        Human man = new Human("Олег", Sex.man, 25);
        BaseCreature cat = new Cat("Мурка", Sex.woman, 2);
        Item item1 = new Item("Чашка");
        Item item2 = new Item("Корм");
        Item item3 = new Item("Яблоко");
        Wardrobe wardrobe = new Wardrobe("шкаф в кухне", 5);
        // демонстрация этого винегрета

        man.openWardbobe(wardrobe);//открыли дверь в шкаф
        stepDelimiter();
        man.call(cat);//позвать кошку
        stepDelimiter();
        man.feed_to(cat, 10);//покормить кошку
        stepDelimiter();
        man.pet(cat);//приласкать кошку
        stepDelimiter();
        man.setItemInWardrobe(wardrobe, item1, 1);//положить чашку в шкаф
        stepDelimiter();
        man.setItemInWardrobe(wardrobe, item2, 4);//положить корм в шкаф
        stepDelimiter();
        man.viewInWardrobe(wardrobe); //посмотрели предметы в шкафу
        stepDelimiter();
        man.setItemInWardrobe(wardrobe, item2, 4);//положить корм в шкаф
        stepDelimiter();
        item1 = man.getItemInWardrobe(wardrobe, 4);//вынуть чашку из шкафа
        System.out.println(item1.getName());
        stepDelimiter();
        item2 = man.getItemInWardrobe(wardrobe, 1);//вынуть корм из шкафа
        System.out.println(item2.getName());
        stepDelimiter();
        man.setItemInWardrobe(wardrobe, item3, 1);
        stepDelimiter();
        man.closeWardbobe(wardrobe);//закрыли дверь шкафа
        stepDelimiter();
        man.viewInWardrobe(wardrobe); //посмотрели предметы в шкафу
        stepDelimiter();
        man.openWardbobe(wardrobe); //открыли дверь
        stepDelimiter();
        man.viewInWardrobe(wardrobe); //посмотрели предметы в шкафу
    }

    private static void stepDelimiter() {
        System.out.println(" - - - - - - - - - - - - ");
    }

    static void stepDelimiter(String s) {
        System.out.println(" ----- " + s + " -----");
    }
}
