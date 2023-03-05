package HomeWorks.hw1.task2_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Human man = new Human("Олег",Sex.man,25);
        Cat cat = new Cat("Мурка",Sex.woman,2);
        Item item1 = new Item("Чашка");
        Item item2 = new Item("Корм");
        Wardrobe wdrob = new Wardrobe(new ArrayList<Item>(),10,"шкаф в гостинной");
        man.openWardbobe(wdrob);//открыли дверь в шкаф
        man.call_cat(cat);
        man.feed_to_cat(cat,10);
        man.pet_a_cat(cat);
        man.setItemInWardrobe(wdrob,item1);
        man.setItemInWardrobe(wdrob,item2);
        man.getItemInWardrobe(wdrob,2);
        man.getItemInWardrobe(wdrob,0);
        man.getItemInWardrobe(wdrob,0);



    }
}
