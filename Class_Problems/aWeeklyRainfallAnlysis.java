
import java.util.Scanner;

public class aWeeklyRainfallAnlysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;
        int dryDays = 0;

        int wettestDay = 0;

        // Read rainfall for 7 days
        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
        }

        // Calculate total, dry days and wettest day
        for (int i = 0; i < 7; i++) {

            total += rainfall[i];

            if (rainfall[i] == 0) {
                dryDays++;
            }

            if (rainfall[i] > rainfall[wettestDay]) {
                wettestDay = i;
            }
        }

        double average = total / 7.0;

        // Display daily rainfall
        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rainfall[i] + " ");
        }

        System.out.println();

        System.out.println("Total Rainfall: " + total + " mm");

        System.out.printf("Average Rainfall: %.2f mm%n", average);

        System.out.println("Wettest Day: Day " +
            (wettestDay + 1) + " (" +
            rainfall[wettestDay] + " mm)");

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
