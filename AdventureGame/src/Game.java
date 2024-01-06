import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);

    public void start() {

        System.out.println("Macera Oyununa Hoşgeldiniz! ");
        System.out.println("---------------------------");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName().toUpperCase() + " macera oyununa hoşgeldiniz.");
        player.selectChar();


        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("Bölgeler ");
            System.out.println("1 - Güvenli Ev--> Düşmandan arındırılmış bölgedir. Burası sizin için güvenlidir. ");
            System.out.println("2 - Mağaza    --> Silah veya Zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara    --> Mağaraya gir, dikkatli ol canavar çıkabilir. ");
            System.out.println("4 - Orman     --> Ormana gir, dikkatli ol canavar çıkabilir. ");
            System.out.println("5 - Nehir     --> Nehire gir, dikkatli ol canavar çıkabilir. ");
            System.out.println("6 - Maden     --> Madene gir, dikkatli ol canavar çıkabilir. ");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz:");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz.");
            }
            if (player.getInventory().isCaveAward() && player.getInventory().isForestAward()
                    && player.getInventory().isRiverAward() && player.getInventory().isMineAward()) {
                System.out.println("TEBRİKLER OYUNU KAZANDINIZ !");
                break;
            } else if (!location.onLocation()) {
                System.out.println("OYUN BİTTİ...");
                break;
            }
        }
    }
}