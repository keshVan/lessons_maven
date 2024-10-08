public class Gun {
    int ammo;

    public Gun(){
        this(5);
    }

    public Gun(int ammo){
        this.ammo = ammo;
    }

    public void shoot(){
        if(ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        }
        else System.out.println("Клац!");
    }
}
