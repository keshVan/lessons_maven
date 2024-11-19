package ru.kornilaev.weapons;

abstract class Weapon {
    protected int ammo;
    protected final int maxAmmo;

    public Weapon(int ammo, int maxAmmo) {
        checkNegative(ammo, maxAmmo);
        if (ammo > maxAmmo)
            ammo = maxAmmo;
        this.ammo = ammo;
        this.maxAmmo = maxAmmo;
    }

    abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public void setAmmo(int ammo) {
        checkNegative(ammo);
        this.ammo = ammo;
    }

    public int load(int ammo) {
        checkNegative(ammo);
        int extra = 0;
        int tmp = this.ammo + ammo;

        if (tmp >  maxAmmo) {
            extra = tmp - maxAmmo;
            tmp = maxAmmo;
        }

        this.ammo = tmp;
        return extra;
    }

    public int unload() {
        int tmp = ammo;
        ammo = 0;
        return tmp;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    private void checkNegative(int ammo, int maxAmmo) {
        if (ammo < 0 || maxAmmo < 0)
            throw new IllegalArgumentException("ammo must be non-negative");
    }

    private void checkNegative(int ammo) {
        checkNegative(ammo, ammo);
    }
}
