package HomeWorks.PhoneBook;

public class MainApp {
    public static void main(String[] args) {
        View vw = new View();
        PhonebookStorage st = new PhonebookStorage();
        startLoad(st);

        new Controller(st, vw).run();
    }

    /**
     * Стартовая загрузка справочника для разработки и отладки
     */
    private static void startLoad(PhonebookStorage st) {
        st.addRecord(new Record("Админ 1", "100"));
        st.addRecord(new Record("Админ 2", "101"));
        st.addRecord(new Record("Модератор", "200"));
        st.addRecord(new Record("Менеджер по связям с клиентами", "210"));
        st.addRecord(new Record("Директор", "111"));
    }


}
