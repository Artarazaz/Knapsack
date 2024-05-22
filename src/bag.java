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
        int[] weightArr = new int[items];
        for (int i = 0; i < items; i++) {
            System.out.println("Please enter items no. " + (i + 1));
            itemsArr[i] = scanner.next();
        }

        for (int i = 0; i < items; i++) {
            System.out.println("Please enter a value and weight for " + itemsArr[i]);
            valueArr[i] = scanner.nextInt();
            weightArr[i] = scanner.nextInt();
        }
        double[] valueToWeight = new double[items];
        for (int i = 0; i < valueArr.length; i++) {
            valueToWeight[i] = (double) valueArr[i] / weightArr[i];
        }
        for (int j = 0; j < valueArr.length; j++) {
            for (int i = 0; i < valueArr.length - 1; i++) {
                if (valueToWeight[i] < valueToWeight[i + 1]) {
                    int saver = valueArr[i];
                    valueArr[i] = valueArr[i + 1];
                    valueArr[i + 1] = saver;
                    int saver2 = weightArr[i];
                    weightArr[i] = weightArr[i + 1];
                    weightArr[i + 1] = saver2;
                    double saver1 = valueToWeight[i];
                    valueToWeight[i] = valueToWeight[i + 1];
                    valueToWeight[i + 1] = saver1;
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
            if (bagSize >= weightArr[i]) {
                itemsCounter++;
                bagSize = bagSize - weightArr[i];
                if (!chosenItem.contains(itemsArr[i])) {
                    chosenItem.add(itemsArr[i]);
                }
            }
            if (bagSize < weightArr[i]) {
                if (itemsCounter != 0) {
                    chosenItemCounter.add(itemsCounter);
                }
                i++;
                itemsCounter = 0;
            }
            if (i == weightArr.length) {
                break;
            }
        }
        System.out.println("The perfect number of items for fill the bag with");
        System.out.println("highest value and lowest weight:");
        for (int j = 0; j < chosenItem.size(); j++) {
            System.out.println("   " + chosenItemCounter.get(j)
                    + " of " + chosenItem.get(j));
        }
    }
}