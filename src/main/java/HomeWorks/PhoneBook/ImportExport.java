package HomeWorks.PhoneBook;

import java.nio.file.Paths;

public abstract class ImportExport {
    PhonebookStorage pb;
    String filename;
    ImportExportData data;

    public ImportExport(PhonebookStorage pb, String filename) {
        this.pb = pb;
        this.filename = filename;
        data = new ImportExportData(pb.poolRecord);
    }

    public boolean validateFilename(String fileName) {
        try {
            Paths.get(fileName);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
