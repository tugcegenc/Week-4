public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList1 = new MyList<>();
        System.out.println("Default Capacity: " + myList1.getCapacity()); // Çıktı: Default Capacity: 10

        MyList<String> myList2 = new MyList<>(20);
        System.out.println("Custom Capacity: " + myList2.getCapacity()); // Çıktı: Custom Capacity: 20

        myList1.add(5);
        myList1.add(10);
        myList1.add(15);

        System.out.println("Size of myList1: " + myList1.size()); // Çıktı: Size of myList1: 3
        System.out.println("Capacity of myList1: " + myList1.getCapacity()); // Çıktı: Capacity of myList1: 10

        for (int i = 0; i < 15; i++) {
            myList1.add(i);
        }

        System.out.println("Size of myList1 after adding elements: " + myList1.size()); // Çıktı: Size of myList1 after adding elements: 18
        System.out.println("Capacity of myList1 after adding elements: " + myList1.getCapacity()); // Çıktı: Capacity of myList1 after adding elements: 20 (artmış olabilir)
    }
}
