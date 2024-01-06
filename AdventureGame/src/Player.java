
import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private int orjHealth;
    private Scanner scan = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health <= 0) {
            health = 0; // Sağlık sıfırdan küçük veya sıfıra eşitse, sağlığı sıfıra ayarla
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public void selectChar() {
        GameChar[] charlist = {new Samurai(), new Archer(), new Knight()};
        System.out.println("------------------------------------------------------------");
        for (GameChar gameChar : charlist) {
            System.out.println("ID: " + gameChar.getId() + "\t" +
                    "Karakter: " + gameChar.getName() + "\t" +
                    "Hasar: " + gameChar.getDamage() + "\t" +
                    "Sağlık: " + gameChar.getHealthy() + "\t" +
                    "Para: " + gameChar.getMoney());
        }

        System.out.println("-------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz: ");
        int selectChar = scan.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Lütfen geçerli bir sayı giriniz");
        }
    }
    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealthy());
        this.setOrjHealth(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println("==========");
        System.out.println(
                "Silahınız: " + this.getInventory().getWeapon().getName() + " , Hasarınız: " + this.getTotalDamage() +
                        " , Zırhınız:  " + this.getInventory().getArmor().getName() +
                        " , Engelleme: " + this.getInventory().getArmor().getBlock() + " , Sağlık: " + this.getHealth() +
                        " , Para: " + this.getMoney());
        System.out.println("==========");
    }
}