package HomeWorks.PhoneBook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;

public class Export extends ImportExport {
    public Export(PhonebookStorage pb, String filename) {
        super(pb, filename);
    }

    public boolean savePhonebook(FileType fileType) {
        switch (fileType) {
            case csv -> {
                return saveToCSV();
            }
            case html -> {
                return saveToHTML();
            }
            case phbk -> {
                return saveToPhbk();
            }
        }
        return false;
    }

    private boolean saveToCSV() {
        String fileName = filename + ".csv";
        if (validateFilename(fileName)) return false;
        StringBuilder content = new StringBuilder();
        Collections.sort(pb.getAll());
        for (Record r : pb.getAll()) {
            content.append(r.getName()).append(',');
            for (String p : r.getPhones()) {
                content.append(p).append(',');
            }
            content.deleteCharAt(content.length() - 1);
            content.append("\n");
        }
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(content.toString().getBytes());
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных\n" + Arrays.toString(e.getStackTrace()));
//            e.printStackTrace();
            return false;
        }
    }

    private boolean saveToHTML() {
        String fileName = filename + ".html";
        if (validateFilename(fileName)) return false;
        String templateHeader = """
                <HTML>
                <HEAD>
                <TITLE>Телефонный справочник</TITLE>
                </HEAD>
                <body>
                <p>Телефонный справочник.</p>
                <table style="border-collapse: collapse;" border="1">
                <tbody>
                <tr><td>Имя</td><td>Телефоны</td></tr>
                """;
        String templateContent = "<tr><td>%s</td><td><ul>%s</ul></td></tr>\n";
        String templatePoneList = "<li>%s</li>";
        String templateFooter = "</tbody>\n</table>\n</body>\n</HTML>\n";
        StringBuilder contentHTML = new StringBuilder(templateHeader);
        for (Record r : pb.getAll()) {
            StringBuilder phones = new StringBuilder();
            for (String p : r.getPhones()) {
                phones.append(String.format(templatePoneList, p));
            }
            contentHTML.append(String.format(templateContent, r.getName(), phones));
        }
        contentHTML.append(templateFooter);
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(contentHTML.toString().getBytes());
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных\n" + Arrays.toString(e.getStackTrace()));
//            e.printStackTrace();
            return false;
        }
    }

    private boolean saveToPhbk() {
        //создаем 2 потока для сериализации объекта и сохранения его в файл
        String fileName = filename + ".phbk";
        if (validateFilename(fileName)) return false;
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) { //https://javarush.com/quests/lectures/questsyntaxpro.level15.lecture00
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); //https://javarush.com/groups/posts/2022-serializacija-i-deserializacija-v-java
            // сохраняем данные
            objectOutputStream.writeObject(data);
            //закрываем поток и освобождаем ресурсы
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных\n" + Arrays.toString(e.getStackTrace()));
//            e.printStackTrace();
            return false;
        }
        return true;
    }


}
