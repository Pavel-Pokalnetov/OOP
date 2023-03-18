package HomeWorks.PhoneBook;

import java.util.ArrayList;
import java.util.List;

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
        mainmenu.add("1", "Вывод справочника", this::viewAllRecords);//ок
        mainmenu.add("2", "Добавить запись", this::addRecord);//ок
        mainmenu.add("3", "Изменить запись", this::editRecord);
        mainmenu.add("4", "Поиск", this::findRecords);//ок
        mainmenu.add("5", "Удаление записи", this::removeRecord);
        mainmenu.add("6", "Сохранить/Загрузить", this::fileOperationMenu);
        mainmenu.run();
    }

    /**
     * Изменение записи в справочнике
     */
    private void editRecord() {
        ArrayList<Record> records = new ArrayList<>(phonebookStorage.getAll());
        view.printAllwithDescription(records,
                String.format("В справочнике %d записей",records.size()));
        String response;
        while (true){
        response  = KeyScanner.getText("Выберите номер изменяемой записи (пусто для отмены): ");
        if (response.isEmpty() || response.isBlank())return;
        try {
            Integer.parseInt(response);
            break;
        } catch(NumberFormatException e){
            System.out.println("неверный ввод");
        }
        }
        Integer selectedRecordIndex = Integer.parseInt(response)-1;
        Record oldRecord = records.get(selectedRecordIndex);
        System.out.printf("Изменяем запись\n\t%s\n",oldRecord);
        Record newRecord = manualInputRecord();
        phonebookStorage.replaceRecord(oldRecord,newRecord);
    }

    private void viewAllRecords() {
        view.printAllwithDescription(phonebookStorage.getAll(),
                String.format("В справочнике %d записей",phonebookStorage.getAll().size()));
    }

    private void addRecord() {
        System.out.println("Добавление записи");
        Record record = manualInputRecord();
        phonebookStorage.addRecord(record);
        System.out.println("Добавлена запись");
        System.out.println(record.toString());
    }

    private static Record manualInputRecord() {
        String name = KeyScanner.getText("Имя контакта: ");
        Record record = new Record(name);
        int count = 1;
        System.out.println("Укажите номера контакта (пусто для завершения)");
        while (true) {
            String number  = KeyScanner.getText("#"+count+": ");
            if (number.isBlank()) break;
            record.addPhone(number);
            count++;
        }
        return record;
    }

    private void findRecords() {
        while (true) {
            System.out.println("Поиск ");
            String searchStr = KeyScanner.getText("Что ищем?(пусто для выхода): ");
            if(searchStr.isBlank()||searchStr.isEmpty())return;
            List<Record> result = phonebookStorage.getAll().stream().filter(x -> x.search(searchStr)).toList();
            if(result.size()>0){
                view.printAllwithDescription(result, String.format("Найдено %d записей",result.size()));
            }else {
                System.out.println("Ничего не найдено");
            }
        }
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
