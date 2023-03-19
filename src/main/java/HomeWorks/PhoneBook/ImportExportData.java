package HomeWorks.PhoneBook;

import java.io.Serializable;
import java.util.HashSet;

public class ImportExportData implements Serializable {
    HashSet<Record> data;

    public HashSet<Record> getData() {
        return data;
    }

    public void setData(HashSet<Record> data) {
        this.data = data;
    }

    public ImportExportData(HashSet<Record> data) {
        setData(data);
    }
}
