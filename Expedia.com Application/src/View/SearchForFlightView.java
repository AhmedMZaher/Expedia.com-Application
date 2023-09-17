package View;

import Model.FlightSpec;
import Utils.Date;
import Utils.ScannerProvider;

import java.util.HashMap;
import java.util.Map;

public class SearchForFlightView {
    public static FlightSpec getFlightSpec(){
        Map properties = new HashMap();
        properties.put("fromCity", getFromCity());
        properties.put("fromDate", getFromDate());
        properties.put("toCity", getToCity());
        properties.put("toDate", getToDate());
        return new FlightSpec(properties);
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
}
