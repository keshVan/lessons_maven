abstract class Bird {
    private String text;

    public Bird(String text) {
        this.text = text;
    }
    
    public void sing() {
        System.out.println(text);
    }
}
