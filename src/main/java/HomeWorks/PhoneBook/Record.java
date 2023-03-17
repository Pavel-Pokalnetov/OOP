package HomeWorks.PhoneBook;

import java.rmi.server.UID;
import java.util.*;

public class Record implements Comparable<Record> {
    private UID id;
    private String name;
    private HashSet<String> phones;

    public Record(String name, String phone) {
        this.name = name;
        addPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** Поиск текста в записи
     * @param searchStr - строка для поиска
     * @return - true если есть совпадения, иначе false
     */
    public boolean search(String searchStr) {
        if (searchStr == null || searchStr.isBlank()) return false;
        if (name.contains(searchStr)) return true;
        for (String p : phones) {
            if (p.contains(searchStr)) return true;
        }
        return false;
    }


    public void addPhone(String phone) {
        phones.add(phone);
    }

    public ArrayList<String> getPhones() {
        return new ArrayList<>(phones);
    }

    public void setPhones(HashSet<String> phones) {
        this.phones = phones;
    }


    public Record(String name) {
        this.name = name;
        this.phones = new HashSet<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append(" [");
        List<String> list = new ArrayList<String>(phones);
        Collections.sort(list);
        for (String i : list) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length()-1).append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(Record o) {
        return name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record record)) return false;
        return hashCode()==o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getPhones());
    }
}
