package HomeWorks.hw1.task1;

import java.util.Calendar;

public class Person {
    private String fullName;
    private Sex sex;
    private String birthday;

    public Person(String fullName) {
        this(fullName, Sex.none, "-");
    }

    public Person(String fullName, String birthday) {
        this(fullName, Sex.none, birthday);

    }

    public Person(String fullName, Sex sex, String birthday) {
        this.fullName = fullName;
        this.sex = sex;
        this.birthday = birthday;
//        System.out.println(fullName+" "+fullName.hashCode());
    }

    public String getFullName() {
        return fullName;
    }


//    @Override
//    public int hashCode() {
//        StringBuilder temp = new StringBuilder();
//        temp.append(fullName.hashCode());
//        temp.append(sex.hashCode());
//        temp.append(birthday.hashCode());
//        return temp.hashCode();
//    }
}
