public class Gun {
    private int ammo;

    public Gun(){
        this(5);
    }

    public Gun(int ammo){
        checkNegative(ammo);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        checkNegative(ammo);
        this.ammo = ammo;
    }

    private void checkNegative(int ammo) {
        if (ammo < 0)
            throw new IllegalArgumentException("ammo must be non-negative");
    }

    public void shoot(){
        if(ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        }
        else System.out.println("Клац!");
    }
}
