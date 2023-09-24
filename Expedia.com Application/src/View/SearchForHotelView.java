package View;

import Model.HotelSpec;
import Utils.Date;
import Utils.Printer;
import Utils.ScannerProvider;

public class SearchForHotelView {
    public static HotelSpec getHotelSpec(){
        Date fromDate = getFromDate();
        Date toDate = getToDate();
        String city = getCity();
        String country = getCountry();
        int noOfAdults = getNumberOfAdults();
        int noOfChildren = getNumberOfChildren();
        return new HotelSpec(fromDate, toDate, city, country, noOfAdults, noOfChildren);
    }
    private static Date getFromDate() {
        System.out.println("Enter From Date (dd-mm-yy): ");
        String fromDate = Printer.getDateInput();
        return new Date(fromDate);
    }
    private static Date getToDate() {
        System.out.println("Enter To Date (dd-mm-yy): ");
        String fromDate = Printer.getDateInput();
        return new Date(fromDate);
    }
    private static String getCity() {
        System.out.println("Enter City: ");
        return ScannerProvider.scanner.nextLine();
    }
    private static String getCountry() {
        System.out.println("Enter Country: ");
        return ScannerProvider.scanner.nextLine();
    }
    private static int getNumberOfAdults() {
        System.out.println("Enter number of Adults: ");
        return ScannerProvider.scanner.nextInt();
    }

    private static int getNumberOfChildren() {
        System.out.println("Enter number of Children: ");
        return ScannerProvider.scanner.nextInt();
    }
    public static void displaySuccessMessage() {
        System.out.println("Hotel Added successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
