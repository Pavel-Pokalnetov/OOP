package HomeWorks.PhoneBook;

import java.util.List;

public interface View {
    <R> void printAll(List<R> records);

    <R> void printAllwithDescription(List<R> records, String description);

    void print();
    <T> void print(T text);
    <T> void println(T text);


}
