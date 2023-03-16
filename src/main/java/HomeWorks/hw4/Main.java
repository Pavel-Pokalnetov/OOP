package HomeWorks.hw4;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu("Главное меню");
        menu.addStop("0","Выход");
        menu.add("1","Вывод всех записей",(Runnable)() -> task1());
        menu.add("2","Вывод всех записей",(Runnable)() -> task2());
        menu.run();


    }

    public static void task1(){
        System.out.println("задача №1");
    }
    public static void task2(){
        System.out.println("задача №2");
    }


}
