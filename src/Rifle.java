public class Rifle extends Gun {
    private final int fireRate;

    public Rifle() {
        this(30, 30);
    }

    public Rifle(int ammo) {
        this(ammo, ammo / 2);
    }

    public Rifle(int ammo, int fireRate) {
        super(ammo);
        if (fireRate < 1)
            throw new IllegalArgumentException("fire rate must be greater than or equal to 1");
        this.fireRate = fireRate;
    }

    public void shoot(){
        for (int i = 0; i < fireRate; i++)
            super.shoot();
    }

    public void shootNthSecs(int n){
        for (int i = 0; i < n; i++)
            shoot();
    }
}
