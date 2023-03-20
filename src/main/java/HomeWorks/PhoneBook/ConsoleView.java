package HomeWorks.PhoneBook;

import java.util.List;

public class ConsoleView implements View{
    /**
     * Вывод нумерованного списка
     *
     * @param records (List<R>) список записей
     */
    @Override
    public <R> void printAll(List<R> records) {
        if (records == null || records.size() == 0) return;
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
    @Override
    public <R> void printAllwithDescription(List<R> records, String descripton) {
        if (!descripton.isBlank() || !descripton.isEmpty()) System.out.println(descripton);
        printAll(records);
    }

    @Override
    public void print() {
        System.out.println();
    }

    @Override
    public <T> void print(T text) {
        System.out.print(text);
    }

    @Override
    public <T> void println(T text) {
        System.out.println(text);
    }


}
