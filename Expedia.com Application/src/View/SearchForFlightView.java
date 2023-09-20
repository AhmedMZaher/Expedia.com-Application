package View;

import Model.FlightSpec;
import Utils.Date;
import Utils.ScannerProvider;


public class SearchForFlightView {
    public static FlightSpec getFlightSpec() {
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


    public static void displaySuccessMessage() {
        System.out.println("Flight Added successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
