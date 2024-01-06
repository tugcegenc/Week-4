public class Inventory {
    Weapon weapon;
    Armor armor;
    String award;

    private boolean mineAward;
    private boolean forestAward;
    private boolean caveAward;
    private boolean riverAward;

    public boolean isMineAward() {
        return mineAward;
    }

    public void setMineAward(boolean mineAward) {
        this.mineAward = mineAward;
    }

    public boolean isForestAward() {
        return forestAward;
    }

    public void setForestAward(boolean forestAward) {
        this.forestAward = forestAward;
    }

    public boolean isCaveAward() {
        return caveAward;
    }

    public void setCaveAward(boolean caveAward) {
        this.caveAward = caveAward;
    }

    public boolean isRiverAward() {
        return riverAward;
    }

    public void setRiverAward(boolean riverAward) {
        this.riverAward = riverAward;
    }

    public Inventory() {
        this.weapon = new Weapon("Yumruk", 0, 0, 0);
        this.armor = new Armor("Zırh yok", 0, 0, 0);

    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getAward() {

        return award;
    }

    public void setAward(String award) {

        this.award = award;
    }
}