package HomeWorks.PhoneBook;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class View {
    /** Вывод списка в нумерованном виде
     * @param records список записей
     */
    public void printAll(ArrayList<Record> records) {
        int i = 1;
        for (Record r : records) {
            System.out.printf("%4d %s\n",i++,r);
        }
    }
}
