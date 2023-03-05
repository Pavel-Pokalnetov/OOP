package HomeWorks.hw1.task2_3;


import java.util.ArrayList;

/**
 * Класс шкафа
 */
public class Wardrobe {
    String description; //описание шкафа
    private ArrayList<Item> storage; //хранилище вещей
    private int storageMax; //максимальное число вещей в хранилище шкафа
    private boolean isOpenDoors;//состояние двери

    /**
     * @param storage - внутр хранилище предметов
     * @param storageMaxDimm - размер шкафа(максимальное число хранимых предметов)
     * @param name - имя шкафа или примечание
     */
    public Wardrobe(ArrayList<Item> storage, int storageMaxDimm, String name ){
        this.storage = storage;
        this.storageMax = storageMaxDimm;
        this.isOpenDoors = false;
        this.description = name;
    }

    /**
     * открываем двери
     *
     * @return
     */
    public boolean openDoor() {
        if (isOpenDoors) return false;
        isOpenDoors = true;
        return true;
    }

    /**
     * закрываем двери
     *
     * @return
     */
    public boolean closeDoor() {
        if (!isOpenDoors) return false;
        isOpenDoors = false;
        return true;
    }

    /**
     * получить предмет из щ=шкафа
     * @param index - место предмета
     * @return - предмет или null(если предмет не получен)
     */
    public Item getItem(int index) {
        if (!isOpenDoors) return null;
        if (index > storage.size() - 1) return null;
        Item obj = storage.get(index);
        storage.remove(index);
        return obj;
    }

    /**
     * поместить предмет в шкаф
     * @param obj - предмет
     * @return - результат true/false
     */
    public boolean setItem(Item obj) {
        if (!isOpenDoors) return false;
        if (storage.size() == storageMax) return false;
        storage.add(obj);
        return true;
    }
}
