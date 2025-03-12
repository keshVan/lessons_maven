package ru.kornilaev.weapons;

public class Gun extends Weapon {

    public Gun() {
        this(5);
    }

    public Gun(int ammo) {
        this(ammo, ammo);
    }

    public Gun(int ammo, int maxAmmo) {
        super(ammo, maxAmmo);
    }

    public void shoot(){
        if(getAmmo()) {
            System.out.println("Бах!");
        }
        else System.out.println("Клац!");
    }

}
