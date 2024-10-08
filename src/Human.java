public class Human {
    Name name;
    int height;
    Human father;

    public Human(String name, int height) {
        this(name, height, null);
    }

    public Human(String name, int height, Human father) {
        this(new Name(name), height, father);
    }

    public Human(Name name, int height) {
        this(name, height, null);
    }

    public Human(Name name, int height, Human father) {
        this.name = name;
        if (father != null) {
            if(name.lastName == null && father.name.lastName != null) name.lastName = father.name.lastName;
            if(name.patronymic == null)  name.patronymic = formatPatronymic(father.name.firstName);
        }
        this.height = height;
    }

    private String formatPatronymic(String name) {
        if (name == "Лев") return "Львович";
        if (name.charAt(name.length()-1) == 'й') return name.substring(0, name.length()-1) + "евич";
        return name + "ович";
    }

    public String toString() {
        return name + ", рост: " + height;
    }

}
