package HomeWorks.PhoneBook;

import java.util.Scanner;

public class KeyScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getText() {
        return scanner.nextLine();
    }

    public static String getText(String s) {
        System.out.print(s);
        return getText();
    }
}
