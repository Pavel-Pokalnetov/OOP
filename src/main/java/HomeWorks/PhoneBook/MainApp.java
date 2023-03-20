package HomeWorks.PhoneBook;

public class MainApp {
    public static void main(String[] args) {
        View vw = new ConsoleView(); //класс для диалога с пользователем
        Dialog dl = new Dialog(vw); //класс для вывода информации
        PhonebookStorage st = new PhonebookStorage();
        startLoad(st); //стартовая загрузка справочника
        new Controller(st, vw, dl).run();
    }

    /**
     * Стартовая загрузка справочника для разработки и отладки
     */
    private static void startLoad(PhonebookStorage st) {
        st.addRecord(new Record("Админ 1", "101"));
        st.addRecord(new Record("Админ 1", "101"));//проверка на исключение дублей
        st.addRecord(new Record("Модератор", "200", "+79008001222", "12-231"));
        st.addRecord(new Record("Менеджер по связям с клиентами", "210"));
        st.addRecord(new Record("Директор", "111"));
    }


}
