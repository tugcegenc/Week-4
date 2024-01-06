import java.util.Random;

public class Snake extends Obstacle {
    private int damage;
    private static Random random = new Random();

    public Snake() {
        super(4, "Yılan", 3, 12, 0, "");
        this.damage = random.nextInt(4) + 3;
        awardPrize();
    }
    public int getDamage() {
        return this.damage;
    }
    public void awardPrize() {
        int randomItem = random.nextInt(100);
        int snakeAward = getAward();

        if (randomItem < 15) {
            int weaponItem = random.nextInt(100);
            if (weaponItem <= 20)
                setItem("Tüfek kazandınız!");
            else if (weaponItem <= 50)
                setItem("Kılıç kazandınız!");
            else
                setItem("Tabanca kazandınız!");
        } else if (randomItem < 30) {
            int armorItem = random.nextInt(100);
            if (armorItem <= 20)
                setItem("Ağır zırh kazandınız!");
            else if (armorItem <= 50)
                setItem("Orta zırh kazandınız!");
            else
                setItem("Hafif zırh kazandınız!");
        } else if (randomItem < 55) {
            int randomMoney = random.nextInt(100);
            if (randomMoney < 20)
                setAward(snakeAward + 10);
            else if (randomMoney < 50)
                setAward(snakeAward + 5);
            else
                setAward(snakeAward + 1);
           // setItem("Para kazandınız!");
        } else {
            setItem("Hiçbir şey kazanamadınız!");
        }
    }
}
