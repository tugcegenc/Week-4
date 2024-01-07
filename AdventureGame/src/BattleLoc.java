import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private int maxDamage;
    Scanner scan = new Scanner(System.in);

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public boolean isAwarded = false;

    @Override
    public boolean onLocation() {
        while (true) {
            if (
                    (this.getName().equals("Cave") && this.getPlayer().getInventory().isCaveAward()) ||
                            (this.getName().equals("Forest") && this.getPlayer().getInventory().isForestAward()) ||
                            (this.getName().equals("Riven") && this.getPlayer().getInventory().isRiverAward()) ||
                            (this.getName().equals("Mine") && this.getPlayer().getInventory().isMineAward())
            ) {
                System.out.println("Ödül aldığınız yere giremezsiniz!!");
                break;
            }
            System.out.println("Şuan buradasınız: " + this.getName());
            int obsNumber = randomObstacleNumber();
            System.out.println("Dikkatli olun! Burada " + obsNumber + " tane " + this.obstacle.getName() + " yaşıyor.");

            System.out.println("<S>avaş veya <K>aç");
            String selectCase = scan.nextLine().toUpperCase();
            if (selectCase.equals("S")) {
                if (combat(obsNumber)) {
                    if (this.getName().equals("Forest") && !this.getPlayer().getInventory().isForestAward()) {
                        this.getPlayer().getInventory().setForestAward(true);
                    } else if (this.getName().equals("Cave") && !this.getPlayer().getInventory().isCaveAward()) {
                        this.getPlayer().getInventory().setCaveAward(true);
                    } else if (this.getName().equals("River") && !this.getPlayer().getInventory().isRiverAward()) {
                        this.getPlayer().getInventory().setRiverAward(true);
                    } else if (this.getName().equals("Mine") && !this.getPlayer().getInventory().isMineAward()) {
                        this.getPlayer().getInventory().setMineAward(true);
                    } else {
                        System.out.println("Ödül aldığınız yere giremezsiniz!!");
                        break;
                    }
                    if (!isAwarded) {
                        System.out.println("----------------------------");
                        getPlayer().getInventory().setAward(this.getAward());
                        System.out.println("Toplam Para Ödülü: " + getObstacle().getAward()*obsNumber);
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                        System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());


                        isAwarded = true;

                    }
                    System.out.println(this.getName() + " tüm düşmanları yendiniz");
                    System.out.println("Bölge Tamamlandı.Ödülü Kazandınız: " + getAward());
                    return true;
                }
            } else if (selectCase.equals("K")) {
                System.out.println("Savaştan çıkış yapıldı");
                break;
            } else {
                System.out.println("Lütfen S veya K değerlerinden birini giriniz. ");
            }

        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz ! ");
            System.out.println("OYUN BİTTİ");
            return false;
        }
        return true;
    }


    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjHealth());
            System.out.println("SAVAŞ BAŞLIYOR!");
            System.out.println();
            playerStats();
            obstacleStats(i);
            boolean playerFirst = new Random().nextBoolean();

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerFirst) {
                    System.out.println("==> Oyuncunun Sırası <== ");
                    System.out.print("<V>ur veya <K>aç: ");
                    String selectCombat = scan.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("Siz vurdunuz! ");
                        getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    } else if (selectCombat.equals("K")) {
                        System.out.println("Savaştan kaçıldı.");
                        return false;
                    } else {
                        System.out.println("Geçersiz bir seçenek girdiniz.");
                    }
                } else {
                    System.out.println("==>" + i + ".Canavarın Sırası <==");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                }
                playerFirst = !playerFirst;
            }

            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz !");
                System.out.println("OYUN BİTTİ!");
                return false;
            } else if (this.getObstacle().getHealth() <= 0) {
                System.out.println(this.getName() + " düşmanı yendiniz");
                //System.out.println(this.getObstacle().getAward()*randomObstacleNumber() + " para kazandınız.");

                System.out.println(this.getObstacle().getItem());

            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        Player player = getPlayer();
        System.out.println(player.getName().toUpperCase() + " Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık: " + player.getHealth());
        System.out.println("Silah: " + player.getInventory().getWeapon().getName());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Zırh: " + player.getInventory().getArmor().getName());
        System.out.println("Bloklama: " + player.getInventory().getArmor().getBlock());
        System.out.println("Para: " + player.getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        Obstacle obstacle = getObstacle();
        System.out.println(i + "." + obstacle.getName() + " Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Para: " + obstacle.getAward());


        System.out.println();
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(getMaxObstacle()) + 1;
    }
}

