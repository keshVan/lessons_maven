public class Gunslinger {
    private String name;
    private Weapon weapon;

    public Gunslinger(String name) {
        this(name, null);
    }

    public Gunslinger(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null)
            weapon.shoot();
        else
            System.out.println("не могу участвовать в перестрелке");
    }
}
