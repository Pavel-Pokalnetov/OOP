package HomeWorks.hw1.task2_3;


/**
 * Класс шкафа
 */
public class Wardrobe extends BaseItem {
    private Item[] storage; //хранилище вещей
    private boolean isOpenDoors;//состояние двери

    /**
     * @param storageMaxDimm - размер шкафа(максимальное число хранимых предметов или полок)
     * @param name           - имя шкафа или примечание
     */
    public Wardrobe(String name, int storageMaxDimm) {

        this.storage = new Item[storageMaxDimm];
//        for (int i = 0; i < storageMaxDimm; i++) {
//            this.storage[i]=null;
//        }
        this.isOpenDoors = false;
        this.description = name;
        System.out.println("У нас новый \""+name+"\""+" на "+storageMaxDimm+" мест");
    }

    /**
     * открываем двери
     *
     * @return
     */
    public void openDoor() {
        isOpenDoors = true;
        System.out.printf("Двери %s открыли\n",description );
    }

    /**
     * закрываем двери
     *
     * @return
     */
    public void closeDoor() {
        isOpenDoors = false;
        System.out.printf("Двери %s закрыли\n",description );
    }

    /**
     * получить предмет из шкафа
     *
     * @param index - место предмета c 1 до
     * @return - предмет или null(если предмет не получен)
     */
    public Item getItem(int index) {
        index -= 1;
        if (!isOpenDoors) return null;
        if (index >= storage.length) return null;
        Item obj = storage[index];
        storage[index] = null;
        return obj;
    }

    /**
     * Поместить предмет в шкаф. Если полка уже занята то предмет не поместится
     *
     * @param obj - предмет
     * @return - результат true/false
     */
    public boolean setItem(Item obj, int index) {
        if (!isOpenDoors) return false;
        index -= 1;
        if (0 > index || this.storage.length <= index) return false;
        if (storage[index] != null) {
            System.out.println("полка занята");
            return false;
        } else {
            storage[index] = obj;
            return true;
        }
    }

    public void viewItems() {
        if (isOpenDoors) {
            System.out.println("в шкафу " + this.storage.length + " мест");
            StringBuilder forPrint = new StringBuilder();
            int count = 0;
            for (int i = 0; i < this.storage.length; i++) {
                if (this.storage[i] != null) {
                    count++;
                    forPrint.append (String.format("%5d  %s\n", i + 1,this.storage[i].getName()));
                    }else {
                    forPrint.append(String.format("%5d  %s\n", i + 1," --- "));
                }
            }
            System.out.println("занято " + count + " мест(а|о)");
            System.out.println(forPrint);
        } else {
            System.out.println("шкаф закрыт");
        }
    }
}
