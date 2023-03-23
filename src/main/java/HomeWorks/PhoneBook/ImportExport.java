package HomeWorks.PhoneBook;

import java.nio.file.Paths;

public abstract class ImportExport {
    PhonebookStorage pb;
    String filename;
    ImportExportData data;
    View view;

    public ImportExport(PhonebookStorage pb, String filename,View view) {
        this.pb = pb;
        this.filename = filename;
        data = new ImportExportData(pb.poolRecord);
        this.view = view;
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
