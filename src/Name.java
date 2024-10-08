public class Name {
    String lastName;
    String firstName;
    String patronymic;

    public Name(String firstName) {
        this(firstName, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Name(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
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
