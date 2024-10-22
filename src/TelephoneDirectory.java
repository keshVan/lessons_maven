import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private List<String[]> telephones = new ArrayList<>();

    public List<String[]> getTelephones() {
        return new ArrayList<>(telephones);
    }

    public void setTelephones(List<String[]> telephones) {
        this.telephones = telephones;
    }

    public String addTelephone(String number, String name) {
        for(int i = 0; i < telephones.size(); i++) {
            if (telephones.get(i)[1] == name) {
                String oldNumber = telephones.get(i)[0];
                telephones.get(i)[0] = number;
                return oldNumber;
            }
        }
        telephones.add(new String[] {number, name});
    }w
}
