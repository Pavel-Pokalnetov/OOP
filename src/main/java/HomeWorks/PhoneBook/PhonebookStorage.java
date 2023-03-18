package HomeWorks.PhoneBook;

import java.util.ArrayList;
import java.util.HashSet;


public class PhonebookStorage {
    HashSet<Record> poolRecord;

    public PhonebookStorage() {
        clear();
    }

    /**
     * Получить все записи из хранилища
     *
     * @return ArrayList<Record>
     */
    public ArrayList<Record> getAll() {
        return new ArrayList<>(poolRecord);
    }

    /**
     * Добавление записи в хранилище
     *
     * @param record - добавляемая запись
     */
    public void addRecord(Record record) {
        poolRecord.add(record);
    }

    /**
     * Очистка хранилища (удаление всех записей)
     */
    public void clear() {
        poolRecord = new HashSet<>();
    }

    /**
     * Удаление записи
     *
     * @param r - удаляемая запись
     */
    public void delRecord(Record r) {
        poolRecord.remove(r);
    }

    /**
     * Замена записи (для целей редактирования)
     *
     * @param oldRecord - исходная запись
     * @param newRecord - измененная запись
     */
    public void replaceRecord(Record oldRecord, Record newRecord) {
        delRecord(oldRecord);
        addRecord(newRecord);
    }

    /**
     * Получить размер списка
     */
    public int size() {
        if (poolRecord == null) {
            return 0;
        }
        return poolRecord.size();
    }

    public void setPoolRecords(HashSet<Record> data) {
        poolRecord = data;
    }
}
