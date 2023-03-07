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
     * @param index - номер полки
     */
    public void setItemInWardrobe(Wardrobe obj,Item item,int index) {
        if (obj.setItem(item,index)) {
            System.out.println("Положили предмет "+ item.getName() + " на полку "+index+ " в " + obj.description);
        } else {
            System.out.println("Не удалось положить предмет "+item.getName() + " на полку "+index+" в " + obj.description);
        }
    }

    /**
     * @param obj   - шкаф
     * @param index - номер места в шкафу
     * @param item  - предмет
     */
    public Item getItemInWardrobe(Wardrobe obj, int index){
        Item tempItem = obj.getItem(index);
        if (tempItem==null){
            System.out.println("Предметов нет");
        }else{
            System.out.println("Получили предмет "+ tempItem.getName());
        }
        return tempItem;
    }

    /**
     * Посмотреть в шкаф
     */
    public void viewInWardrobe(Wardrobe obj){
        obj.viewItems();
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
