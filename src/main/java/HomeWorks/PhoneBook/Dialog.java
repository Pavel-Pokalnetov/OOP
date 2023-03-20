package HomeWorks.PhoneBook;

import java.util.Scanner;

public class Dialog {
    private final Scanner scanner = new Scanner(System.in);
    private final View vw;

    public Dialog(View vw) {
        this.vw = vw;
    }

    public String getText() {
        return scanner.nextLine();
    }

    public String getText(String s) {
        vw.print(s);
        return getText();
    }
}
