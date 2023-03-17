package HomeWorks.PhoneBook;

import java.util.ArrayList;
import java.util.HashSet;


public class PhonebookStorage {
    HashSet<Record> poolRecord;

    public PhonebookStorage() {
        poolRecord = new HashSet<>();
    }

    public ArrayList<Record> getAll() {
        return new ArrayList<>(poolRecord);
    }

    public void addRecord(Record record) {
        poolRecord.add(record);
    }
}
