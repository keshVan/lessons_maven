public class Operation {
    private String type;
    private int value;

    public Operation(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (type) {
            case "Снятие":
                return "Снято " + value + "руб.";
            case "Пополнение":
                return "Пополнено на " + value +  "руб.";
            case "Открытие":
                return "Счет открыт";
        }
        return "";
    }
}