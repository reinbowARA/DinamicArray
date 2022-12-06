//import java.util.Scanner;

public class TestVector {
    public static void main(String[] args) {
        var vector = new MyVector<>();

        vector.add(1);
        vector.add("Здесь строка");
        vector.add(-1);
        vector.add(1.2);

        vector.get(0);
        vector.get(1);
        vector.get(3);

        System.out.print("Всего элиментов в массиве: ");
        System.out.println(vector.size());

        vector.remove(3);

        vector.get(3);
        vector.add(5);

        System.out.println();
        vector.getArray();

        System.out.println();
        vector.addIndex(100, 4);
        System.out.println();
        vector.getArray();
        vector.removeEndElements();
        System.out.println();
        vector.getArray();
        System.out.println();
        System.out.println(vector.size());
        vector.removeAll();
        System.out.println(vector.size());
    }
}
