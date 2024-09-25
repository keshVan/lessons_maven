public class Human {
    Name name;
    int height;
    Human father;
    String gender;

    public Human(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Human(Name name, int height, Human father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public Human(Name name, int height, Human father, String gender) {
        this.name = name;
        this.height = height;
        this.father = father;
        this.gender = gender;
    }

    public String toString() {
        if (name.lastName == null && father != null && father.name.lastName != null)
            switch (gender) {
                case "m":
                    name.lastName = father.name.lastName;
                    break;
                case "f":
                    name.lastName = father.name.lastName + "а";
                    break;
            }
        if (name.patronymic == null && father != null && father.name.firstName != null)
            switch (gender) {
                case "m":
                    name.patronymic = father.name.firstName + "ович";
                    break;
                case "f":
                    name.patronymic = father.name.firstName + "овна";
                    break;
            }

        return name + ", рост: " + height;
    }

}
