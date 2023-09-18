package View;

import Model.FlightSpec;
import Utils.Date;
import Utils.ScannerProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchForFlightView {
    public static FlightSpec getFlightSpec(){
        Map properties = new HashMap();
        String fromCity = getFromCity();
        Date fromDate = getFromDate();
        String toCity = getToCity();
        Date toDate = getToDate();
        return new FlightSpec(fromDate, toDate, fromCity, toCity);
    }
    private static String getFromCity() {
        System.out.println("Enter From: ");
        return ScannerProvider.scanner.nextLine();
    }

    private static Date getFromDate() {
        System.out.println("Enter From Date (dd-mm-yy): ");
        String fromDate;
        fromDate = ScannerProvider.scanner.nextLine();
        return new Date(fromDate);
    }

    private static String getToCity() {
        System.out.println("Enter To: ");
        return ScannerProvider.scanner.nextLine();
    }

    private static Date getToDate() {
        System.out.println("Enter To Date (dd-mm-yy): ");
        String fromDate;
        fromDate = ScannerProvider.scanner.nextLine();
        return new Date(fromDate);
    }

    private static int getNumberOfAdults() {
        System.out.println("Enter number of Adults: ");
        return ScannerProvider.scanner.nextInt();
    }

    private static int getNumberOfChildren() {
        System.out.println("Enter number of Children: ");
        return ScannerProvider.scanner.nextInt();
    }
    // Function take user flight choice and if it's not valid return -1
    public static int getInputInRange(int min, int max){
        int input;

        try {
            System.out.print("Enter a number between " + min + " and " + max + ": ");
            input = Integer.parseInt(ScannerProvider.scanner.nextLine());

            if (input < min || input > max) {
                return -1;
            }
            return input;

        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static void displaySuccessMessage() {
        System.out.println("Flight Added successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
