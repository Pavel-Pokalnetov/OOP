package HomeWorks.PhoneBook;

public abstract class ImportExport {

    private PhonebookStorage pb;
    private String filename;

    public ImportExport(PhonebookStorage pb, String filename) {
        this.pb = pb;
        this.filename = filename;
    }

    boolean checkFileExist(String filename){
        return true;
    }

}
