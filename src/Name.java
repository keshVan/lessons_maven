public class Name {
    public String lastName;
    public String firstName;
    public String patronymic;

    public String toString() {
        String res = "";
        String[] el = {lastName, firstName, patronymic};
        boolean flag = false;

        for (int i = 0; i < 3; i++) {
            if (el[i] != null && flag) {
                res += " " + el[i];
            }
            else if (el[i] != null) {
                res += el[i];
                flag = true;
            }
        }

        return res;
    }
}
