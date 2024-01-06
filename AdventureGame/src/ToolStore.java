import java.util.Scanner;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz. ");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int selectCase = scan.nextInt();

        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz değer, lütfen tekrar deneyiniz.");
            break;

        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz.");
                return true;
        }
        return true;

    }

    public void printWeapon() {
        System.out.println("-----Silahlar-----");
        for (Weapon w : Weapon.weapons()) {

            System.out.println(w.getId() + " - " + w.getName() + " => " + " Para: " + w.getPrice() + " Hasar: " + w.getDamage());

        }
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponId = scan.nextInt();
        while (selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, lütfen tekrar deneyiniz. ");
            //System.out.println("Bir üst menüden işleminize devam edebilirsiniz. ");
            onLocation();
            selectWeaponId = scan.nextInt();

        }
        Weapon selectedWeapon = Weapon.weaponObjByıd(selectWeaponId);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
            } else {
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                //System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmor() {
        System.out.println("-----Zırhlar-----");
        for (Armor a : Armor.armors()) {

            System.out.println(a.getId() + " - " + a.getName() + " => " + "Para: " + a.getPrice() + " Engelleme: " + a.getBlock());

        }
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorId = scan.nextInt();
        while (selectArmorId < 1 || selectArmorId > Weapon.weapons().length) {


            System.out.println("Geçersiz değer, lütfen tekrar deneyiniz. ");
            onLocation();

            selectArmorId = scan.nextInt();
            return;
        }
        Armor selectedArmor = Armor.armorObjByıd(selectArmorId);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
            } else {
                System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                // System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
