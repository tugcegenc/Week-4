public class Weapon {
    private String name;
    private int price;
    private int id;
    private int damage;


    public Weapon(String name, int id, int damage, int price) {
        this.price = price;
        this.id = id;
        this.damage = damage;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponlist = new Weapon[3];
        weaponlist[0] = new Weapon("Tabanca", 1, 2, 25);
        weaponlist[1] = new Weapon("Kılıç  ", 2, 3, 35);
        weaponlist[2] = new Weapon("Tüfek  ", 3, 7, 45);
        return weaponlist;
    }

    public static Weapon weaponObjByıd(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }
}