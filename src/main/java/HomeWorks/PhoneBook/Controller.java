package HomeWorks.PhoneBook;

public class Controller {
    private final PhonebookStorage phonebookStorage;
    private final View view;

    public Controller(PhonebookStorage st, View vw) {
        phonebookStorage = st;
        view = vw;
    }

    public void run() {
        Menu mainmenu = new Menu("Телефонный справочник.\nГлавное меню");
        mainmenu.addStop("0", "Завершить работу");
        mainmenu.add("1", "Вывод справочника", this::viewAllRecords);
        mainmenu.add("2", "Добавить запись", this::addRecord);
        mainmenu.add("3", "Изменить запись", this::editRecord);
        mainmenu.add("4", "Поиск", this::findRecords);
        mainmenu.add("5", "Удаление записи", this::removeRecord);
        mainmenu.add("6", "Сохранить/Загрузить", this::fileOperationMenu);
        mainmenu.run();
    }

    private void editRecord() {
    }

    private void viewAllRecords() {
        view.printAll(phonebookStorage.getAll());
    }

    private void addRecord() {
        System.out.println("Добавление записи");
        String name = KeyScanner.getText("Имя контакта: ");
        Record record = new Record(name);
        int count = 1;
        System.out.println("Укажите номера контакта (пусто для завершения");
        while (true) {
            String number  = KeyScanner.getText("#"+count+": ");
            if (number.isBlank()) break;
            record.addPhone(number);
            count++;
        }
        phonebookStorage.addRecord(record);
        System.out.println("Добавлена запись");
        System.out.println(record.toString());
    }

    private void findRecords() {
    }

    private void removeRecord() {
    }

    private void fileOperationMenu() {
        Menu ioMenu = new Menu("Работа с файлами");
        ioMenu.addStop("0", "Назад");
        ioMenu.add("1", "Импорт данных", this::importRecords);
        ioMenu.add("2", "Экспорт данных", this::exportRecords);
        ioMenu.run();
    }

    private void importRecords() {
    }

    private void exportRecords() {
    }


}
