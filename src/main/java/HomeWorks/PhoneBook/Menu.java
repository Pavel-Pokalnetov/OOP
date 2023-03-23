package HomeWorks.PhoneBook;

import HomeWorks.Scheduler.KeyScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Menu {
    static class MenuItem implements Runnable, Comparable {
        public String getLiter() {
            return liter;
        }

        public String getDescription() {
            return description;
        }

        private String liter;
        private String description;
        private Runnable function;

        public MenuItem(String c, String s, Runnable obj) {
            this.liter = c;
            this.description = s;
            this.function = obj;
        }

        public void run() {
            this.function.run();
        }

        @Override
        public String toString() {
            return String.format("%2s : %s\n", this.liter, this.description);
        }

        @Override
        public int compareTo(Object o) {
            return this.liter.compareTo(((MenuItem) o).liter);
        }
    }

    private HashSet<MenuItem> menuItems;
    private String stopLiter;
    private String stopDescription;
    private String menuName;
    private View view;

    public Menu(String name, View view) {
        clear(name);
        this.view = view;
    }

    public void clear(String name) {
        menuName = name;
        menuItems = new HashSet<>();
        addStop("Q", "Выход");
    }

    public void addStop(String l, String d) {
        this.stopLiter = l;
        this.stopDescription = d;
    }

    /**
     * @param c - Пункт меню
     * @param s - Описание пункта меню
     * @param obj - метод обработчик
     */
    public void add(String c, String s, Runnable obj) {
        menuItems.add(new MenuItem(c, s, obj));
    }

    public void run() {//запуск основного цикла меню
        String key;
        while (true) {
            this.print();
            key = KeyScanner.getText("  >:");
            if (key.equals(stopLiter)) return;//выход из меню
            for (MenuItem i : menuItems) {
                if (i.getLiter().equals(key)) {
                    view.print();
                    i.run();//запуск задачи из пункта меню
                    view.print("");
                }
            }
        }
    }

    private void print() { //вывод текста меню
        view.println(menuName);
        List<MenuItem> list = new ArrayList<>(menuItems);
        Collections.sort(list);
        for (MenuItem i : list) {
            System.out.print(i);
        }
        System.out.printf("%2s : %s\n", stopLiter, stopDescription);
    }
}
