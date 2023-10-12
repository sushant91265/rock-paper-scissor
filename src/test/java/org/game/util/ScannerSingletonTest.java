package org.game.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ScannerSingletonTest {
    private InputStream originalSystemIn;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
        String input = "Test Input";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testGetScanner() {
        Scanner scanner1 = ScannerSingleton.getScanner();
        Scanner scanner2 = ScannerSingleton.getScanner();

        assertNotNull(scanner1);
        assertNotNull(scanner2);
        assertEquals(scanner1, scanner2);
    }

    @Test
    public void testReinitializeScanner() {
        ScannerSingleton.getScanner();
        ScannerSingleton.closeScanner();

        String newInput = "New Input";
        ByteArrayInputStream newInputStream = new ByteArrayInputStream(newInput.getBytes());
        System.setIn(newInputStream);

        Scanner scanner = ScannerSingleton.getScanner();

        assertNotNull(scanner);
        assertEquals("New Input", scanner.nextLine());
    }

    @Test
    public void testCloseScanner() {
        Scanner scanner = ScannerSingleton.getScanner();
        ScannerSingleton.closeScanner();

        assertThrows(IllegalStateException.class, () -> scanner.nextLine());
    }
}