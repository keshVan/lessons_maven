public class Name {
    String lastName;
    String firstName;
    String patronymic;

    public Name(String firstName) {
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
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
