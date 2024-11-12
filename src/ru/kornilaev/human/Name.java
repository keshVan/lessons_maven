package ru.kornilaev.human;

public class Name {
    private String lastName;
    final private String firstName;
    private String patronymic;

    public Name(String firstName) {
        this(firstName, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Name(String firstName, String lastName, String patronymic) {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("name cannot be null or empty");
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Name(Name n) {
        this(n.firstName, n.lastName, n.patronymic);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String toString() {
        String out = "";

        if (lastName != null)
            out += lastName + " ";
        if (firstName != null)
            out += firstName + " ";
        if (patronymic != null)
            out += patronymic + " ";

        return  out.trim();
    }
}
