import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your bag size: ");
        int bagSize = scanner.nextInt();
        System.out.println("How many items do you have?");
        int items = scanner.nextInt();
        String[] itemsArr = new String[items];
        int[] valueArr = new int[items];
        for (int i = 0; i < items; i++) {
            System.out.println("Please enter items no. " + (i + 1));
            itemsArr[i] = scanner.next();
        }
        scanner.nextLine();
        for (int i = 0; i < items; i++) {
            System.out.println("Please enter a value for " + itemsArr[i]);
            valueArr[i] = scanner.nextInt();
        }
        for (int j = 0; j < valueArr.length - 1; j++) {
            for (int i = 0; i < valueArr.length - 1; i++) {
                if (valueArr[i] < valueArr[i + 1]) {
                    int saver = valueArr[i];
                    valueArr[i] = valueArr[i + 1];
                    valueArr[i + 1] = saver;
                    String string = itemsArr[i];
                    itemsArr[i] = itemsArr[i + 1];
                    itemsArr[i + 1] = string;
                }
            }
        }

        int i = 0;
        int itemsCounter = 0;
        List<String> chosenItem = new ArrayList<>();
        List<Integer> chosenItemCounter = new ArrayList<>();
        while (bagSize != 0) {
            if (bagSize >= valueArr[i]) {
                itemsCounter++;
                bagSize = bagSize - valueArr[i];
                if (!chosenItem.contains(itemsArr[i])) {
                    chosenItem.add(itemsArr[i]);
                }
            }
            if (bagSize < valueArr[i]) {
                if (itemsCounter != 0) {
                    chosenItemCounter.add(itemsCounter);
                }
                i++;
                itemsCounter = 0;
            }
            if (i == valueArr.length) {
                break;
            }
        }
        System.out.println("The perfect number of items for fill the bag with highest value:");
        for (int j = 0; j < chosenItem.size(); j++){
            System.out.println("   " + chosenItemCounter.get(j) + " of " + chosenItem.get(j));
        }
    }
}
