package org.game.util;

import java.util.Scanner;

/**
 * This class provides a singleton instance of Scanner.
 */
public class ScannerSingleton {
    private static Scanner scanner;

    private ScannerSingleton() {
    }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
