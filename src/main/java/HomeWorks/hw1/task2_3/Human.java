package HomeWorks.hw1.task2_3;

public class Human {

    String name;
    int age;
    Sex sex;

    public Human(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /** Положить пердмет в шкаф
     * @param obj - используемый шкаф
     */
    public void openWardbobe(Wardrobe obj) {
        if (obj.openDoor()) {
            System.out.println("Открыли " + obj.description);
        }else{
            System.out.println("Не смогли открыть " + obj.description);
        }
    }

    /** Закрыть шкаф
     * @param obj - используемый шкаф
     */
    public void closeWardbobe(Wardrobe obj) {
        if (obj.closeDoor()){
            System.out.println("Зыкрыли "+obj.description);
        }else{
            System.out.println("Не смогли закрыть "+obj.description);
        }
    }

    /** Положить предмет в шкаф
     * @param obj - шкаф
     * @param item - предмет
     */
    public void setItemInWardrobe(Wardrobe obj,Item item) {
        if (obj.setItem(item)) {
            System.out.println("Удалось положить предмет "+ item.getName());
        } else {
            System.out.println("Не удалось положить предмет "+item.getName());
        }
    }

    /**
     * @param obj - шкаф
     * @param index - номер места в шкафу
     * @param item - предмет
     */
    public Item getItemInWardrobe(Wardrobe obj, int index){
        Item temp = obj.getItem(index);
        if (temp==null){
            System.out.println("Предметов нет");
        }else{
            System.out.println("Получили предмет "+ temp.getName());
            return temp;
        }
        return null;
    }

    public void feed_to_cat(Cat cat, Integer meal){//кормим кошку
        cat.eat(meal);//кошка есть
        System.out.println("Кошка поела");
    }

    public void pet_a_cat(Cat cat){//ласкаем кошку
        cat.accessCaress(); //кошка принимает ласки
    }

    public void call_cat(Cat cat){//позвать кошку
        cat.reply();//кошка должна ответить
    }
}
