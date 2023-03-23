package HomeWorks.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final PhonebookStorage phonebookStorage;
    private final View view;
    private final Dialog dialog;

    public Controller(PhonebookStorage st, View vw, Dialog dl) {
        phonebookStorage = st;
        view = vw;
        dialog = dl;
    }

    public void run() {
        Menu mainmenu = new Menu("Телефонный справочник.\nГлавное меню",new ConsoleView());
        mainmenu.addStop("0", "Завершить работу");
        mainmenu.add("1", "Вывод справочника", this::viewAllRecords);
        mainmenu.add("2", "Добавить запись", this::addRecord);
        mainmenu.add("3", "Изменить запись", this::editRecord);
        mainmenu.add("4", "Поиск", this::findRecords);
        mainmenu.add("5", "Удаление записи", this::removeRecord);
        mainmenu.add("6", "Сохранить/Загрузить", this::fileOperationMenu);
        mainmenu.run();
    }

    /**
     * Изменение записи в справочнике
     */
    private void editRecord() {
        ArrayList<Record> records = new ArrayList<>(phonebookStorage.getAll());
        if (records.size() == 0) {
            view.println("Нечего изменять");
            return;
        }
        view.printAllwithDescription(records,
                String.format("В справочнике %d записей", records.size()));
        String response;
        while (true) {
            response = dialog.getText("Выберите номер изменяемой записи (пусто для отмены): ");
            if (response.isEmpty() || response.isBlank()) return;
            try {
                Integer.parseInt(response);
                break;
            } catch (NumberFormatException e) {
                view.println("неверный ввод");
            }
        }
        int selectedRecordIndex = Integer.parseInt(response) - 1;
        if (selectedRecordIndex < 0 || selectedRecordIndex > records.size() - 1) {
            view.println("Нет такого номера");
            return;
        }
        Record oldRecord = records.get(selectedRecordIndex);
        System.out.printf("Изменяем запись\n\t%s\n", oldRecord);
        Record newRecord = manualInputRecord();
        phonebookStorage.replaceRecord(oldRecord, newRecord);
    }

    private void viewAllRecords() {
        view.printAllwithDescription(phonebookStorage.getAll(),
                String.format("В справочнике %d записей", phonebookStorage.getAll().size()));
    }

    private void addRecord() {
        view.println("Добавление записи");
        Record record = manualInputRecord();
        phonebookStorage.addRecord(record);
        view.println("Добавлена запись");
        view.println(record);
    }

    private Record manualInputRecord() {
        String name = dialog.getText("Имя контакта: ");
        Record record = new Record(name);
        int count = 1;
        view.println("Укажите номера контакта (пусто для завершения): ");
        while (true) {
            String number = dialog.getText("#" + count + ": ");
            if (number.isBlank()) break;
            record.addPhone(number);
            count++;
        }
        return record;
    }

    private void findRecords() {
        if (phonebookStorage.size() == 0) {
            view.println("Нечего изменять");
            return;
        }
        while (true) {
            view.println("Поиск ");
            String searchStr = dialog.getText("Что ищем?(пусто для выхода): ");
            if (searchStr.isBlank() || searchStr.isEmpty()) return;
            List<Record> result = phonebookStorage.getAll().stream().filter(x -> x.search(searchStr)).toList();
            if (result.size() > 0) {
                view.printAllwithDescription(result, String.format("Найдено %d записей", result.size()));
            } else {
                view.println("Ничего не найдено");
            }
        }
    }

    private void removeRecord() {
        ArrayList<Record> records = new ArrayList<>(phonebookStorage.getAll());
        view.printAllwithDescription(records,
                String.format("В справочнике %d записей", records.size()));
        String response;
        while (true) {
            response = dialog.getText("Выберите номер изменяемой записи (пусто для отмены): ");
            if (response.isEmpty() || response.isBlank()) return;
            try {
                Integer.parseInt(response);
                break;
            } catch (NumberFormatException e) {
                view.println("неверный ввод");
            }
        }
        int selectedRecordIndex = Integer.parseInt(response) - 1;
        if (selectedRecordIndex < 0 || selectedRecordIndex > records.size() - 1) {
            view.println("Нет такого номера");
            return;
        }
        phonebookStorage.delRecord(records.get(selectedRecordIndex));
    }

    private void fileOperationMenu() {
        Menu ioMenu = new Menu("Работа с файлами",view );
        ioMenu.addStop("0", "Назад");
        ioMenu.add("1", "Загрузить из *.phbk", this::loadRecords);
        ioMenu.add("2", "Сохранить в *.phbk", this::saveRecords);
        ioMenu.add("3", "Экспорт в CSV", this::export2CSV);
        ioMenu.add("4", "Экспорт в HTML", this::export2HTML);
        ioMenu.run();
    }

    private void loadRecords() {
        String filename = dialog.getText("Имя файла без расширения (пусто для отмены): ");
        if (filename.isBlank() || filename.isEmpty()) return;
        if (new Import(phonebookStorage, filename,view).loadPhonebook()) {
            view.println("Файл загружен успешно");
        }
    }

    private void saveRecords() {
        saveByFileType(FileType.phbk);
    }


    private void export2CSV() {
        saveByFileType(FileType.csv);
    }

    private void export2HTML() {
        saveByFileType(FileType.html);
    }

    private void saveByFileType(FileType fileType) {
        String filename = dialog.getText("Имя файла без расширения (пусто для отмены): ");
        if (filename.isBlank() || filename.isEmpty()) return;
        if (new Export(phonebookStorage, filename,view).savePhonebook(fileType)) {
            view.println("Файл записан успешно");
        }
    }
}
