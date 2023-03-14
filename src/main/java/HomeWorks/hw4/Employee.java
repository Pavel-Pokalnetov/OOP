package HomeWorks.hw4;

class Employee implements Comparable{
    String firsname;
    String lastname;
    String patronymic;

    String post;
    String phoneNumber;

    public Employee(String firsname, String lastname) {
        this.firsname = firsname;
        this.lastname = lastname;
        patronymic = "";
        post = "";
        phoneNumber = "";
    }

    public Employee(String firsname, String lastname, String patronymic) {
        this.firsname = firsname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        post = "";
        phoneNumber = "";
    }

    public Employee(String firsname, String lastname, String patronymic, String post, String phoneNumber) {
        this.firsname = firsname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.post = post;
        this.phoneNumber = phoneNumber;
    }

    public Employee(String firsname, String lastname, String patronymic, String post) {
        this.firsname = firsname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.post = post;
        phoneNumber = "";
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Object obj) {
        Employee o = (Employee)obj;
        StringBuilder name1 = new StringBuilder(this.firsname).append(this.lastname).append(this.patronymic);
        StringBuilder name2 = new StringBuilder(o.getFirsname()).append(o.getLastname()).append(o.getPatronymic());
        return name1.compareTo(name2);

    }
}
