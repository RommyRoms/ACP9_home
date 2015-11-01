package bashComandEmulator;


import java.util.Scanner;

public class ScannerTools {
    public static String keyboardString(String message) {
        System.out.print(message + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
