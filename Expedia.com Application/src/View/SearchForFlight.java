package View;

import Utils.Date;
import Utils.ScannerProvider;

public class SearchForFlight {
    public static String getFromCity(){
        System.out.println("Enter From: ");
        return ScannerProvider.scanner.nextLine();
    }
    public static Date getFromDate(){
        System.out.println("Enter From Date (dd-mm-yy): ");
        String fromDate;
        fromDate = ScannerProvider.scanner.nextLine();
        return new Date(fromDate);
    }
    public static String getToCity(){
        System.out.println("Enter To: ");
        return ScannerProvider.scanner.nextLine();
    }
    public static Date getToDate(){
        System.out.println("Enter To Date (dd-mm-yy): ");
        String fromDate;
        fromDate = ScannerProvider.scanner.nextLine();
        return new Date(fromDate);
    }
    public static int  getNumberOfAdults(){
        System.out.println("Enter number of Adults: ");
        return ScannerProvider.scanner.nextInt();
    }
    public static int  getNumberOfChildren(){
        System.out.println("Enter number of Children: ");
        return ScannerProvider.scanner.nextInt();
    }
}
