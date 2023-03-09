package HomeWorks.hw1.task2_3;

public class Main {
    public static int i = 1;

    public static void main(String[] args) {

        Human man = new Human("Олег", Sex.man, 25);
        BaseCreature cat = new Cat("Мурка", Sex.woman, 2);
        Item item1 = new Item("Чашка");
        Item item2 = new Item("Корм");
        Item item3 = new Item("Яблоко");
        Wardrobe wardrobe = new Wardrobe("шкаф в кухне", 5);
        // демонстрация этого винегрета

        man.openWardbobe(wardrobe);//открыли дверь в шкаф
        stepDelimiter();
        man.call_cat(cat);//позвать кошку
        stepDelimiter();
        man.feed_to_cat(cat, 10);//покормить кошку
        stepDelimiter();
        man.pet_a_cat(cat);//приласкать кошку
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
        man.setItemInWardrobe(wardrobe, item3,1);
        stepDelimiter();
        man.closeWardbobe(wardrobe);//закрыли дверь шкафа
        stepDelimiter();
        man.viewInWardrobe(wardrobe); //посмотрели предметы в шкафу
        stepDelimiter();
        man.openWardbobe(wardrobe); //открыли дверь
        stepDelimiter();
        man.viewInWardrobe(wardrobe); //посмотрели предметы в шкафу

    }

    static void stepDelimiter(){
        System.out.println(" ----- ");
    }
}
