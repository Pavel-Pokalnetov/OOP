package HomeWorks.PhoneBook;

public class MainApp {
    public static void main(String[] args) {
        View vw = new View();
        PhonebookStorage st = new PhonebookStorage();
        new Controller(st,vw).run();
    }
}
