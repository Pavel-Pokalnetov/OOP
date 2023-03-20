package HomeWorks.PhoneBook;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Import extends ImportExport {
    public Import(PhonebookStorage pb, String filename, View view) {
        super(pb, filename,view);
    }

    public boolean loadPhonebook() {
        String fileName = filename + ".phbk";
        if (validateFilename(fileName)) return false;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ImportExportData data = (ImportExportData) objectInputStream.readObject();
            pb.setPoolRecords(data.getData());
            return true;
        } catch (Exception e) {
            view.println("Ошибка чтения файла.\n" + Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
}
