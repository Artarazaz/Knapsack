import java.util.Arrays;
import java.util.Scanner;

public class bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your bag size: ");
        int bagSize = scanner.nextInt();
        System.out.println("How many items you want to add?");
        int items = scanner.nextInt();
        String [] itemsArr = new String[items];
        int[] valueArr = new int[items];
        for (int i = 0; i < items; i ++){
            System.out.println("Please enter your items no." + (i + 1));
            itemsArr [i] = scanner.next();
        }
        for (int i = 0; i < items; i ++){
            System.out.println("Please enter a value for " + itemsArr[i]);
            valueArr [i] = scanner.nextInt();
        }
    }
}
