package HomeWorks.hw1.task2_3;

import java.util.ArrayList;

public class Main {
    public static int i = 1;

    public static void main(String[] args) {

        Human man = new Human("Олег", Sex.man, 25);
        Cat cat = new Cat("Мурка", Sex.woman, 2);
        Item item1 = new Item("Чашка");
        Item item2 = new Item("Корм");
        Wardrobe wdrob = new Wardrobe("шкаф в кухне", 5);
        // демонстрация этого винегрета

        man.openWardbobe(wdrob);//открыли дверь в шкаф

        man.call_cat(cat);//позвать кошку

        man.feed_to_cat(cat, 10);//покормить кошку

        man.pet_a_cat(cat);//приласкать кошку

        man.setItemInWardrobe(wdrob, item1, 1);//положить чашку в шкаф

        man.setItemInWardrobe(wdrob, item2, 4);//положить корм в шкаф

        man.viewInWardrobe(wdrob); //посмотрели предметы в шкафу

        man.setItemInWardrobe(wdrob, item2, 4);//положить корм в шкаф

        item1 = man.getItemInWardrobe(wdrob, 4);//вынуть чашку из шкафа
        System.out.println(item1.getName());

        item2 = man.getItemInWardrobe(wdrob, 1);//вынуть корм из шкафа
        System.out.println(item2.getName());

        man.setItemInWardrobe(wdrob, cat, 2);//положить кошку в шкаф

        man.closeWardbobe(wdrob);//закрыли дверь шкафа

        man.viewInWardrobe(wdrob); //посмотрели предметы в шкафу

        man.openWardbobe(wdrob); //открыли дверь

        man.viewInWardrobe(wdrob); //посмотрели предметы в шкафу

        item1 = man.getItemInWardrobe(wdrob, 2); //вытащили кошку
        System.out.println(item1.getName());

        man.viewInWardrobe(wdrob); //посмотрели предметы в шкафу
    }
}
