public class person {
    public String name;
    public String surname;
    public String email;

    public person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
