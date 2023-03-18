package HomeWorks.PhoneBook;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class View {
    /**
     * Вывод нумерованного списка
     *
     * @param records (List<R>) список записей
     */
    public <R> void printAll(List<R> records) {
        int i = 1;
        for (R r : records) {
            System.out.printf("%4d %s\n", i++, r);
        }
    }

    /**
     * Вывод нумерованного списка с предварительным текстом (описанием)
     *
     * @param records    - List<R> список записей
     * @param descripton - предварительный текст
     * @param <R>
     */
    public <R> void printAllwithDescription(List<R> records, String descripton) {
        if (!descripton.isBlank() || !descripton.isEmpty()) System.out.println(descripton);
        printAll(records);
    }

    ;
}
